class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        //create a treeMap sorted on position
        TreeMap<Integer, Robot> map = new TreeMap();
        for(int i=0; i < n; i++){
            map.put(positions[i], new Robot(i+1, healths[i], directions.charAt(i)));
        }

        // collision occurs when robots moves in opposite directions
        // only when L comes after R

        Stack<Robot> stack = new Stack();
        Robot incomingRobot = null;
        Iterator<Map.Entry<Integer, Robot>> iterator = map.entrySet().iterator();
        while(incomingRobot != null || iterator.hasNext()){
            if(incomingRobot == null){
                incomingRobot = iterator.next().getValue();
            }
            // collide if incoming is moving left with stack peek moving right
            if(!stack.isEmpty() && incomingRobot.direction == 'L' && stack.peek().direction == 'R'){
                // collision occurs - compare health of both the robots
                int healthIncomingRobot = incomingRobot.health;
                int healthStackRobot = stack.peek().health;

                if(healthIncomingRobot == healthStackRobot){
                    // kill both
                    stack.pop();
                    incomingRobot = null;
                }else if (healthIncomingRobot > healthStackRobot){
                    // incoming survives
                    stack.pop(); // stackRobot dies
                    incomingRobot.health -= 1;
                    // this robot may cause another collision, keep as is
                }else{
                    // stack robot survives, decrease health by 1
                    // moves in the same direction
                    Robot poppedRobot = stack.pop();
                    poppedRobot.health -= 1;
                    stack.push(poppedRobot);
                    incomingRobot = null; // incoming robot dies
                }
            }else{
                stack.push(incomingRobot);
                incomingRobot = null; //processed
            }
        }

        // robots on the stack are surviving robots
        List<Robot> res = new ArrayList();

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }

        // sort the robots based on position
        Collections.sort(res, (robot1, robot2) -> (robot1.robotName - robot2.robotName));

        return res.stream()
                .map(robot -> robot.health)
                .collect(Collectors.toList());
    }

    class Robot{
        int robotName;
        int health;
        char direction; 

        Robot(int robotName, int health, char direction){
            this.robotName = robotName;
            this.health = health;
            this.direction = direction;
        }
    }
}
