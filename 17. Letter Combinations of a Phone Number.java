class Solution {
    Map<Integer, String> map = new HashMap();
    List<String> res = new ArrayList();
    public List<String> letterCombinations(String digits) {

        // initliaze a map
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        generateLetterCombo(digits, 0, new StringBuilder());

        return res.contains("") ? new ArrayList() : res;
    }

    void generateLetterCombo(String digits, int p, StringBuilder op){

        if( digits.length() == p ){
            res.add(new String(op.toString()));
            return;
        }

        int digit = digits.charAt(p) - '0';
        String choices = map.get(digit);

        for(char c: choices.toCharArray()){
            // 2 -> abc
            // do something
            op.append(c);
            // recurse
            generateLetterCombo(digits, p+1, op);
            // undo
            op.deleteCharAt(op.length()-1);
        }
    }
}
