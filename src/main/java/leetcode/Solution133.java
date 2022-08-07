package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution133 {

    private static class Node {
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

    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return clone(node);
    }

    private Node clone(Node node) {
        if (hashMap.containsKey(node)) return hashMap.get(node);
        Node nNode = new Node(node.val);
        hashMap.put(node, nNode);
        for (Node nei: node.neighbors) {
            nNode.neighbors.add(clone(nei));
        }
        return nNode;
    }

}
