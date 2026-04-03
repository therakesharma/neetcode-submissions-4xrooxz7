class Solution {

    public String encode(List<String> strs) {
        String encodedStr = "";
        for (String str : strs) {
            int len = str.length();
            encodedStr += (len + "#" + str);
        }
        return encodedStr;
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;
        StringBuilder number = new StringBuilder();
        while (i < str.length()) {
            try {
                char ch = str.charAt(i);
                if (Character.isDigit(ch)) {
                    number.append(ch);
                    if (str.charAt(i+1) == '#') {
                        int num = Integer.parseInt(number.toString());
                        String word = str.substring(i+2, i+2+num);
                        decodedList.add(word);
                        number.setLength(0);
                        i += (num + 1);
                    }
                    i++;
                }
            } catch (NumberFormatException e) {
                i++;
            }
        }
        return decodedList;
    }
}
