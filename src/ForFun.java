public class ForFun {
    public int[] productExceptSelf(int[] nums) {

        int x = 1;
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int c = nums[i];
            output[i] = x;
            x *= c;
        }

        x = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            int c = nums[i];
            output[i] *= x;
            x *= c;
        }
        return output;
    }

    public boolean checkValidString(String s) {
        int o = 0, w = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case '(': o++; break;
                case ')': o--; break;
                case '*': w++; break;
            }

            if(o < 0) {
                w--;
                o++;
                if(w < 0)
                    return false;
            }
        }
        if(o > 0) {
            if(o - w > 0)
                return false;
        }
        else if(o < 0) {
            if(o + w < 0)
                return false;
        }

        return true;
    }
}
