class WordDictionary {
    TreeNode root;

    private class TreeNode {
        Map<Character, TreeNode> child;
        boolean isEndOfWord = false;

        TreeNode() {
            child = new HashMap<>();
            isEndOfWord = false;
        }

    }

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.child.containsKey(ch)) {
                curr.child.put(ch, new TreeNode());
            }
            curr = curr.child.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    public boolean dfs(TreeNode node, int index, String word) {
        TreeNode curr = node;
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (char ch: curr.child.keySet()) {
                    if (dfs(curr.child.get(ch), i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!curr.child.containsKey(word.charAt(i))) {
                    return false;
                }
                curr = curr.child.get(word.charAt(i));
            }
        }
        return curr.isEndOfWord;
    }
}
