class Solution {
    public int minOperations(String[] logs) {
        int level  = 0; // main folder

        for(String log: logs){
            if(log.equals("./")){
                continue; // remain in same folder
            }else if(log.equals("../")){
                // go to prev if it exists
                if(level > 0) level--;
            }else{
                // go to child folder
                level++;
            }
        }
        return level;
    }
}
