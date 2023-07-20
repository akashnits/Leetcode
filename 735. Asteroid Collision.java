class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        List<Integer> res = new ArrayList();
        List<Integer> negativeAsteroidsList = new ArrayList();

        for(int asteroid: asteroids){
            stack.push(asteroid);
        }

        while(!stack.isEmpty()){
            int asteroid = stack.pop();
            // asteroid moving in +ve direction
            if(asteroid > 0){
                // while the nextAsteroid is moving in -ve direction, they will collide
                int nextAsteroid =0;
                Iterator<Integer> itr = negativeAsteroidsList.iterator();
                boolean isAsteroidDestroyed = false;

                    while(itr.hasNext()){
                        nextAsteroid = itr.next();
                        if( Math.abs(nextAsteroid) == asteroid){
                            // collide and destroys itself along with asteroid
                            isAsteroidDestroyed = true;
                            itr.remove();
                            break;
                        } else if(Math.abs(nextAsteroid) < asteroid){
                            // collide and destroys itself, and continue the loop
                            itr.remove();
                        } else{
                            // destorys the asteroid
                            isAsteroidDestroyed = true;
                            break;
                        }
                    }

                    if(!isAsteroidDestroyed){
                        res.add(0,asteroid);
                    }

                } else{
                    negativeAsteroidsList.add(0, asteroid);
                }
            }

            // check if there's any negative asteroids
            if(negativeAsteroidsList.size() > 0){
                res.addAll(0, negativeAsteroidsList);
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
