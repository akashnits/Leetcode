class Solution {
    public boolean checkIfExist(int[] arr) {
        return method2(arr);
    }


    // brute force - O(n ^ 2)
    boolean method1(int[] arr){
        int n = arr.length;
        for(int i=0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]){
                    return true;
                }
            }
        }
        return false;
    }

    // using hashtable to keep track of seen values
    boolean method2(int[] arr){
        int n = arr.length;
        HashSet<Integer> seen = new HashSet();

        for(int i=0; i < n; i++){
            int valDoubled = 2 * arr[i];
            int valHalved = arr[i] / 2;

            if(seen.contains(valDoubled) || (arr[i] % 2 == 0 && seen.contains(valHalved))){
                return true;
            }
            seen.add(arr[i]);
        }
        return false;
    }
}
