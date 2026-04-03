class Solution {
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                list.add(Character.toLowerCase(ch));
            }
        }
        boolean result = true;
        int i = 0, j = list.size() - 1;
        while ( i < j) {
            if (list.get(i) != list.get(j)) {
                result = false;
            }
            i++;
            j--;
        }
        return result;
    }
}
