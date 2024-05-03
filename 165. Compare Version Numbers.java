class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");

        int i = 0, j = 0;
        while (i < version1Arr.length || j < version2Arr.length) {
            int v1 = i < version1Arr.length ? Integer.parseInt(version1Arr[i]) : 0;
            int v2 = j < version2Arr.length ? Integer.parseInt(version2Arr[j]) : 0;

            if (v1 < v2) return -1;
            if (v1 > v2) return 1;

            i++;
            j++;
        }
        return 0;
    }
}
