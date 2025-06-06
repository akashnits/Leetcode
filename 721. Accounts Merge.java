class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // how can we use DSU to solve this ?
        DSU dsu = new DSU(accounts.size());
        // we want to club emails belonging to different account under one account
        // we first want to do union of account based on common email

        // use a map to identify common emails ?
        // create a mapping from email to accounts ?
        Map<String, List<Integer>> map = new HashMap();

        // loop over accounts 
        for (int a = 0; a < accounts.size(); a++) {
            List<String> acc = accounts.get(a);  // fixed from accounts.get(0)
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                // check if this email belongs to an account already 
                if (map.containsKey(email)) {
                    // this email is common to multiple accounts
                    // we need to merge this account with other accounts
                    // extract previous accounts
                    List<Integer> prevAccounts = map.get(email);
                    // we can use any of the account for union as they belong to the same group
                    dsu.union(a, prevAccounts.get(0));
                    prevAccounts.add(a); // update list to track all related accounts
                } else {
                    // put this account in to the map against the email
                    List<Integer> newList = new ArrayList<>();
                    newList.add(a);
                    map.put(email, newList);
                }
            }
        }

        // now, we have the accounts grouped together
        // we want to know the oldest ancestor account for each account in the list given
        // loop over the given accounts again and find its ancestor

        Map<Integer, Set<String>> resMap = new HashMap(); // accountId -> unique emails 
        for (int a = 0; a < accounts.size(); a++) {
            List<String> currentAccount = accounts.get(a);
            int ancestorAccountIdx = dsu.find(a);
            // add this account in the result along with emails

            // check if ancestorAccount is already added to the map
            resMap.putIfAbsent(ancestorAccountIdx, new HashSet<>());

            Set<String> emailSet = resMap.get(ancestorAccountIdx);
            // loop over currentAccount emails and add if not there
            for (int i = 1; i < currentAccount.size(); i++) {
                String currAccountEmail = currentAccount.get(i);
                emailSet.add(currAccountEmail);
            }
        }

        List<List<String>> res = new ArrayList();
        for (Map.Entry<Integer, Set<String>> entry : resMap.entrySet()) {
            int accountIdx = entry.getKey();
            Set<String> ownerEmails = entry.getValue();

            String ownerName = accounts.get(accountIdx).get(0);
            List<String> emails = new ArrayList<>(ownerEmails);
            Collections.sort(emails);

            emails.add(0, ownerName); // prepend name
            res.add(emails);
        }
        return res;
    }

    class DSU {
        int[] parent; // index of the account
        int[] rank;

        DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            // initially all accounts are separate and it's own parent
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // find the oldest ancestor - returns the account idx
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // union two accounts given their indices
        void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }

            if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else {
                // same rank ?
                parent[parentX] = parentY;
                rank[parentY]++;
            }
        }
    }
}
