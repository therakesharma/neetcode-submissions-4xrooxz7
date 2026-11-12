/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
	Map<Node, Node> clone;
    public Node cloneGraph(Node node) {
    	clone = new HashMap<>();
        dfs(node);
        return clone.get(node);
    }
    
    public void dfs(Node node) {
    	if (node == null || clone.get(node) != null) {
    		return;
    	}
    	Node curr = new Node(node.val);
    	clone.put(node, curr);
    	for (Node n : node.neighbors) {
    		dfs(n);
    		curr.neighbors.add(clone.get(n));
    	}
    } 
}