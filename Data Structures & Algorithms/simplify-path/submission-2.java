class Solution {
    public String simplifyPath(String path) {
        String [] pathArr = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String p : pathArr) {
            if (p.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else if (!p.isEmpty() && !p.equals(".")) {
                stack.push(p);
            }
        }

        return "/" + String.join("/", stack);
        
    }
}