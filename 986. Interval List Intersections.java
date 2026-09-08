class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;

        List<int[]> res = new ArrayList();

        int i = 0, j = 0;

        while (i < m && j < n) { // then only we can find intersection
            // start point should be max and end should be min for intersection
            int[] firstListEle = firstList[i];
            int[] secondListEle = secondList[j];

            int newStart = Math.max(firstListEle[0], secondListEle[0]);

            int newEnd = -1;
            if (firstListEle[1] > secondListEle[1]) {
                // second list end is smaller, so we choose it and move j
                newEnd = secondListEle[1];
                j++;
            } else {
                newEnd = firstListEle[1];
                i++;
            }

            // should we create interval?
            if(newEnd >= newStart)
                res.add(new int[]{newStart, newEnd});
        }
        return res.toArray(int[][]::new);
    }
}
