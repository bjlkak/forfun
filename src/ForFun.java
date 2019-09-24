public class ForFun {

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(999998));
    }

//    private static int monotoneIncreasingDigits(int n) {
//        boolean mono = false;
//        while (!mono) {
//            int temp = n;
//            boolean check = true;
//            int prev = temp % 10;
//            temp = temp / 10;
//            while (temp > 0) {
//                int current = temp % 10;
//                temp = temp / 10;
//
//                if (current > prev) {
//                    n--;
//                    check = false;
//                    break;
//                }
//                prev = current;
//            }
//
//            if (check) {
//                mono = true;
//            }
//        }
//
//        return n;
//    }

    private static int monotoneIncreasingDigits(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        boolean nines = false;
        for(int i = 0; i < nums.length; i++) {
            if(nines) {
                nums[i] = '9';
            }
            else if (i < nums.length -1 && nums[i] > nums[i+1]) {
                nines = true;
                char t =(char)(nums[i] - 1);

                if(i > 0 && t < nums[i-1]) {
                    nums[i] = '9';
                    nums[i-1] = (char)(nums[i-1] - 1);

                    for (int j = i - 1; j > 0 ; j--) {
                        if(nums[j] < nums[j-1]) {
                            nums[j] = '9';
                            nums[j-1] = (char)(nums[j-1] - 1);
                        }
                    }
                }
                else {
                    nums[i] = t;
                }
            }
        }

        return Integer.parseInt(new String(nums));
    }
}
