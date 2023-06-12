class Solution {

    Map<Integer, List<Integer>> mapManagerReportee;
    int res=-1;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        // create a map of manager to reportee 
        mapManagerReportee = new HashMap();
        for(int reporteeId=0; reporteeId< manager.length; reporteeId++){
            int managerId = manager[reporteeId];
            if(managerId == -1){
                continue;
            }

            if(mapManagerReportee.get(managerId) == null){
                mapManagerReportee.put(managerId, new ArrayList());
            }

            List<Integer> reporteeList = mapManagerReportee.get(managerId);
            reporteeList.add(reporteeId);
        }

        //need to build n-ary tree
        TreeNode root = buildNAryTree(headID, getReportees(headID), informTime);

        // traverse the n-ary tree and figure out time to inform all employees
        dfs(root, informTime[headID]);
        return res;
    }

    public TreeNode buildNAryTree(int id, List<Integer> reportees, int[] informTime){
        TreeNode root = new TreeNode(id, informTime[id]);

        if(reportees != null){
            // keep constructing
            if(root.reporteeNodes == null){
                root.reporteeNodes = new ArrayList();
            }
            for(int reportee: reportees){
            TreeNode childNode =  buildNAryTree(reportee, getReportees(reportee), informTime);
            root.reporteeNodes.add(childNode);
            }
        }

        return root;
    }

    public List<Integer> getReportees(int managerId){
        return mapManagerReportee.get(managerId);
    }

    public void dfs(TreeNode node, int newsReachingTime){
        if(node == null)
            return;

        res = Math.max(newsReachingTime, res);

        if(node.reporteeNodes != null){
            for(TreeNode child: node.reporteeNodes){
                dfs(child, newsReachingTime + (child.infoTime));
            }
        } 
    }


    private class TreeNode{
        int id;
        int infoTime;
        List<TreeNode> reporteeNodes;

        public TreeNode(int id, int infoTime){
            this.id = id;
            this.infoTime = infoTime;
        }

    }

}
