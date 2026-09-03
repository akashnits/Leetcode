class Solution {

    class Pair {
        TreeNode node;
        long label;

        Pair(TreeNode node, long label) {
            this.node = node;
            this.label = label;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int ans = 0;

        while (!q.isEmpty()) {

            int n = q.size();
            long first = q.peek().label;
            long last = first;

            for (int i = 0; i < n; i++) {

                Pair p = q.poll();
                last = p.label;

                if (p.node.left != null)
                    q.offer(new Pair(p.node.left, 2 * p.label + 1));

                if (p.node.right != null)
                    q.offer(new Pair(p.node.right, 2 * p.label + 2));
            }

            ans = Math.max(ans, (int)(last - first + 1));
        }

        return ans;
    }
}
