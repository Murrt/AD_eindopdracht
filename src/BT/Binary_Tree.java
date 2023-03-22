package BT;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree {

    Node root;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;
                if (value < focusNode.value) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left =newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void preOrderTraversal (Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.value + " ");
            preOrderTraversal(focusNode.left);
            preOrderTraversal(focusNode.right);
        }
    }

    public void inOrderTraversal (Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.left);
            System.out.println(focusNode.value + " ");
            inOrderTraversal(focusNode.right);
        }
    }

    public void postOrderTraversal (Node focusnode) {
        if (focusnode != null) {
            postOrderTraversal(focusnode.left);
            postOrderTraversal(focusnode.right);
            System.out.println(focusnode.value + " ");
        }
    }

    public void levelOrderTraversal() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.println(tempNode.value + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    private boolean containsValueHelper(Node node, Object target) {
        if (node == null) {
            return false;
        }
        if (equals(target)) {
            return true;
        }
        if (containsValueHelper(node.left, target)) {
            return true;
        }
        if (containsValueHelper(node.right, target)) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object target) {
        return containsValueHelper(root, target);
    }

    

    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        Binary_Tree tree_level = new Binary_Tree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is: ");
        tree_level.levelOrderTraversal();
    }
}
