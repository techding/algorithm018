//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 111 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


import java.util.Stack;

class Solution {
//    public List<Integer> preorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        helper(root, list);
//        return list;
//    }
//
//    private void helper(Node node, List<Integer> list) {
//        if (node != null) {
//            list.add(node.val);
//            for (Node child : node.children) {
//                helper(child, list);
//            }
//        }
//        return;
//    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        Node p = root;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            list.add(p.val);
            for (int i = p.children.size() - 1; i >= 0; i--) {
                stack.push(p.children.get(i));
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
