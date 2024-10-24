class Solution {
/* 
// Represent matrix as string. Moves allowed as follows: 

0 1 2
3 4 5 --> 0 can go to indices {1, 3}

1 0 2
3 4 5 --> 0 can go to index of {0,2,4}

1 2 0
3 4 5 --> 0 can go to {1, 5}

1 2 3
0 4 5 --> 0 can go to {0,4}

1 2 3
4 0 5 --> 0 can go to {1, 3, 5}

1 2 3
4 5 0 --> 0 can go to {2, 4}
*/

// we want to do bfs , generate diferent states and check if it equals "123450"
// it would give min steps

// we transformed this problem in a graph 
// we hop from one state to another state using the operations allowed for that state
// finally finding target
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String input = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }
        input = sb.toString();

        Set<String> visited = new HashSet();
        int[][] stateToOperationsMappings = new int[][]{{ 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 }};

        Queue<String> queue = new LinkedList<String>();
        queue.offer(input);
        //mark visited
        visited.add(input);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                String polled = queue.poll();
                if(polled.equals(target)){
                    return level;
                }

                // go to next state, apply operation which are valid for this state
                int zeroIndex = polled.indexOf('0');
                for(int idx: stateToOperationsMappings[zeroIndex]){
                    String nextState = swap(polled, idx, zeroIndex);
                     if (visited.contains(nextState)) {
                        continue;
                    }
                    visited.add(nextState);
                    queue.offer(nextState);
                }
            }
            level++;
        }  
        return -1;      
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
