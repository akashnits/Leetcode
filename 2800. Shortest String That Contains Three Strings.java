class Solution {
    public String minimumString(String a, String b, String c) {

        // getCommonString can return 
        // null - do nothing
        // empty - add the whole string
        // something - append  remaining 
        String[] strArr = new String[6];
        strArr[0] = merge(a,b,c);
        strArr[1] = merge(a,c,b);
        strArr[2] = merge(b,a,c);
        strArr[3] = merge(b,c,a);
        strArr[4] = merge(c,a,b);
        strArr[5] = merge(c,b,a);

        // find string with min length, if same length find lexo min
        String res = strArr[0];
        for(String str: strArr){
            if(str.length() == res.length()){
                if(str.compareTo(res) < 0) res = str;
            }else {
                if(str.length() < res.length()){
                    res = str;
                }
            }
        }

        return res;
    }


    String merge(String a, String b, String c){
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        String common1  = getCommonString(a, b);
        String res1= performAddition(a, b, common1, sb);
        String common2  = getCommonString(res1, c); 
        String res2 = performAddition(res1, c, common2, sb);

        return res2;
    }

    String performAddition(String s1, String s2, String common, StringBuilder sb){
        if( common != null && common.length() >= 0){
            int commonLen = common.length();
            int len = s2.length();
            sb.append(s2.substring(commonLen, len));
        }
        return sb.toString();
    }



    String getCommonString(String s1, String s2){
        // case1: whole of s2 is contained in s1
        if(s1.contains(s2)){
            return null;
        }
        
        StringBuilder commomSb = new StringBuilder();

        // case 2: compare substring of s2 with substring of s1
        // lets check the length of both the strings
        int len1 = s1.length();
        int len2 = s2.length();

        int subLength = len1 >= len2 ?len2 -1 : len1;
        while(subLength > 0){
            if(s2.substring(0, subLength).equals(s1.substring(len1- subLength, len1))){
                commomSb.append(s2.substring(0, subLength));
                break;
            }
            subLength--;
        }

        return commomSb.toString();
    }
}
