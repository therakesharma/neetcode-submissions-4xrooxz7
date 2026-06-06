class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String str : path.split("/")) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        return "/" +  String.join("/", stack);
    }
}