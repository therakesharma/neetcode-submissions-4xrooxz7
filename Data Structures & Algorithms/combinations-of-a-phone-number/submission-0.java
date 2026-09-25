class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        backtrack(digits, new StringBuilder(), 0);
        return res;
    }

    public void backtrack(String digits, StringBuilder str, int index) {
        if (digits.isEmpty()) {
            return;
        }
        if (str.length() == digits.length()) {
            res.add(str.toString());
            return;
        }
        if (index >= digits.length()) {
            return;
        }

        for (char ch : map.get(digits.charAt(index))) {
            str.append(ch);
            backtrack(digits, str, index + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
