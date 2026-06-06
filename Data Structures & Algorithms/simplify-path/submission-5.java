class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        StringBuilder str = new StringBuilder();
        path = path + "/";

        for (char ch : path.toCharArray()) {
            if (ch != '/') {
                str.append(ch);
            } else {
                String curr = str.toString();

                if (curr.isEmpty()) {
                    continue;
                }

                if (curr.equals("..")) {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!curr.equals(".")) {
                    stack.push(curr);
                }

                str = new StringBuilder();
            }
        }

        return "/" + String.join("/", stack);
    }
}