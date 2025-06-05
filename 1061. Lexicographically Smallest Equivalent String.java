//Lexicographically Smallest Equivalent String
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // create set of all alphaets see in s1, s2 and baseStr
        Set<Character> set = new HashSet();
        for(int i=0; i < s1.length(); i++){
            set.add(s1.charAt(i));
            set.add(s2.charAt(i));
        }

        for(char b: baseStr.toCharArray()){
            set.add(b);
        }
    
        DSU dsu = new DSU(set);

        // use the equivalency information and group chars together
        int len = s1.length();
        for(int i=0; i < len; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(dsu.find(c1) != dsu.find(c2)){
                dsu.union(c1, c2);
            }
        }

        StringBuilder res = new StringBuilder();
        // we now have the chars grouped, use their parent to return the smallest string
        for(char c: baseStr.toCharArray()){
            res.append(dsu.find(c)+"");
        }
        return res.toString();
    }

    class DSU {
        char[] parent;

        // constructor- fill parent array
        DSU(Set<Character> charSet){
            // only lowercase letters
            int n = charSet.size();
            parent = new char[26];
            //each char is it's parent
            for(char c: charSet){
                parent[c-'a'] = c;
            }
        }

        // find the parent - going back to ancestors (i.e. the first parent)
        char find(char c){
            if(parent[c-'a'] == c){
                return c;
            }

            return parent[c-'a'] = find(parent[c-'a']);
        }

        void union(char c1, char c2){
            // first find the parent
            char parentC1 = find(c1);
            char parentC2 = find(c2);

            // compare them
            if(parentC1 == parentC2){
                return;
            }

            // update as per char order - smallest frst
            if(parentC1 < parentC2){
                // make parentC1 the parent
                parent[parentC2-'a'] = parentC1;
            }else {
                parent[parentC1-'a'] = parentC2;
            }
            return;
        }
    }
}

