class PrefixTree {
    TreeNode root;

    private class TreeNode {
        Map<Character, TreeNode> children;
        boolean isEndOfWord;

        TreeNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }


    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TreeNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        for (char ch : prefix.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        return true;
    }
}
