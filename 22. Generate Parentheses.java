class Solution {
    // # closed used <= # open used
    // # closed rem > # open rem.
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        generate(n, n, "");
        return res;
    }

    void generate(int on, int cl, String op){

        if(on == 0 && cl == 0){
            res.add(op);
            return;
        }

        // we must maintain cl rem > op rem 
        // case 1: open rem. and close rem. equal
        if(on > 0 && on == cl){ 
            // pick open for sure
            generate(on-1, cl, op + "(");
        }

        // case 2: close rem. > open rem.
        if(cl > on){
            // we may pick open or close - doesn't matter really
            if(on > 0){
                generate(on-1, cl, op + "(");
            }
            if(cl > 0){
                generate(on, cl-1, op + ")");
            }
        }

    }
}
