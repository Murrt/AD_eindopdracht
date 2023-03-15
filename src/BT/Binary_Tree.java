package BT;

public class Binary_Tree {

    Node root;

    private Node addNode (Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addNode(current.left, value);
        } else if (value > current.value) {
            current.right = addNode(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void addToTree(int value) {
        root = addNode(root, value);
    }

    public Binary_Tree createBinaryTree() {
        Binary_Tree bt = new Binary_Tree();

        bt.addToTree(6);
        bt.addToTree(4);
        bt.addToTree(8);
        bt.addToTree(3);
        bt.addToTree(5);
        bt.addToTree(7);
        bt.addToTree(9);

        return bt;
    }

}
