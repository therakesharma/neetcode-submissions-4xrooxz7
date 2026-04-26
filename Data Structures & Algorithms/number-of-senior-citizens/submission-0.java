class Solution {
    public int countSeniors(String[] details) {
        int sum = 0;
        for (String detail : details) {
            char [] chars = new char[]{ detail.charAt(11), detail.charAt(12) };
            String str = new String(chars);
            if (Integer.parseInt(str) > 60) {
                sum += 1;
            }
        }
        return sum;
    }
}