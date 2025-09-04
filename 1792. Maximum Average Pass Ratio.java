class Solution {
    // Approach: idea is put the extra student in the class where the impact is maximum i.e. max gain in average pass ratio
    // pre-compute the gains for each class if extra student is added and choose the one with max gain
    // do this iteratively until all extra students are placed 
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // precompute gains for each class
        int n = classes.length;

        PriorityQueue<Wrapper> maxHeap = new PriorityQueue<Wrapper>((a, b) -> Double.compare(b.pGain, a.pGain));
        for(int i=0; i < n; i++){
            double gain = calculateGain(classes[i]);
            //maxHeap.offer(new Wrapper(gain, new int[]{classes[i][0], classes[i][1]}));
            maxHeap.offer(new Wrapper(gain, classes[i]));
        }

        while(extraStudents-- > 0){
            // put this extra student in the potential max gain and rebalance
            Wrapper polled = maxHeap.poll();
            polled.cls[0] = polled.cls[0] + 1;
            polled.cls[1] = polled.cls[1] + 1;

            polled.pGain = calculateGain(polled.cls);

            // put this back in heap
            maxHeap.offer(polled);
        }


        // loop over heap, calculate average and return 
        double total = 0.0;
        while(!maxHeap.isEmpty()){
            Wrapper polled = maxHeap.poll();
            double ratio = ((double) polled.cls[0]) / polled.cls[1];
            total += ratio;
        }

        return total/n;
    }


    class Wrapper{
        double pGain; // potential gain
        int[] cls; // {pass, total}

        Wrapper(){}
        Wrapper(double gain, int[] cls){
            this.pGain = gain;
            this.cls = cls;
        }
    }

    double calculateGain(int[] cls){
        double newRatio = ((double) (cls[0] + 1)) / (cls[1] + 1);
        double ratio = ((double) cls[0]) / cls[1];

        return newRatio - ratio;
    }
}
