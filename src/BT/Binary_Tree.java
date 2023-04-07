package BT;

public class Binary_Tree {

    public Node root;

    public void addNode(int key) {

        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;

                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {

                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    public String toStringPreorder(Node focusNode) {
        long startTime = System.currentTimeMillis();

        String s = "";
        if (focusNode == null) {
            return "";
        }

        s += focusNode.toString();
        s += toStringPreorder(focusNode.leftChild);
        s += toStringPreorder(focusNode.rightChild);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return s + " Time completion in: " + elapsedTime + " miliseconds.";
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public String toStringInorder(Node focusNode) {
        long startTime = System.currentTimeMillis();

        String s = "";
        if (focusNode == null) {
            return "";
        }

        s += toStringInorder(focusNode.leftChild);
        s += focusNode.toString();
        s += toStringInorder(focusNode.rightChild);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return s + " Time completion in: " + elapsedTime + " miliseconds.";
    }

    public void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public String toStringPostOrder(Node focusNode) {
        long startTime = System.currentTimeMillis();

        String result = "";
        if (focusNode == null) {
            return "";
        } else {
            result += toStringPostOrder(focusNode.leftChild);
            result += toStringPostOrder(focusNode.rightChild);
            result += focusNode.toString(); 
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return result + " Time completion in: " + elapsedTime + " miliseconds.";
    }

    public String findNode(int key) {

        long startTime = System.currentTimeMillis();
        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                System.out.println("Node niet gevonden.");
                return "Node niet gevonden.";
            }
        }
        System.out.println("Node gevonden.");
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime);
        return focusNode.toString() + " Time completion in: " + elapsedTime + " miliseconds.";
    }

    public String removeNode(int key) {
        long startTime = System.currentTimeMillis();

        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (focusNode.key != key) {
            parent = focusNode;
            if (key < focusNode.key) {
                isLeftChild = true;
                focusNode = focusNode.leftChild;
            } else {
                isLeftChild = false;
                focusNode = focusNode.rightChild;
            }
            // Focus Node kan niet gevonden worden.
            if (focusNode == null) {
                System.out.println("FocusNode kon niet gevonden worden.");
                return "FocusNode kon niet gevonden worden.";
            }
        }
        // Focus Node heeft geen children.
        if (focusNode.leftChild == null && focusNode.rightChild == null) {

            if (focusNode == root) {

                root = null;

            } else if (isLeftChild) {

                parent.leftChild = null;

            } else {

                parent.rightChild = null;

            }
        }
        // Focus Node heeft geen right child.
        else if (focusNode.rightChild == null) {

            if (focusNode == root) {

                root = focusNode.leftChild;

            } else if (isLeftChild) {

                parent.leftChild = focusNode.leftChild;

            } else {

                parent.rightChild = focusNode.leftChild;

            }
        }
        // Focus Node heeft geen left child.
        else if (focusNode.leftChild == null) {

            if (focusNode == root) {

                root = focusNode.rightChild;

            } else if (isLeftChild) {

                parent.leftChild = focusNode.rightChild;

            } else {

                parent.rightChild = parent.leftChild;

            }
        }
        // Focus Node heeft twee children
        else {

            Node replacement = getReplacementNode(focusNode);

            if (focusNode == root) {

                root = replacement;

            } else if (isLeftChild) {

                parent.leftChild = replacement;

            } else {

                parent.rightChild = replacement;

            }

            replacement.leftChild = focusNode.leftChild;

        }

        System.out.println("Node verwijderd.");

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        return "Node verwijderd. Time completion in: " + elapsedTime + " miliseconds.";
    }

    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.leftChild;
        }

        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }

        return replacement;

    }
}