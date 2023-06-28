package BT;

public class Binary_Search_Tree<T extends Comparable<T>> {

    public Node<T> root;

    public void addNode(T value) {

        Node newNode = new Node(value);

        // Check of key de root is
        if (root == null) {
            root = newNode;
        } else {

            // Kijk vanaf de root als je de tree gaat traversen.
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;

                if (value < focusNode.value) {
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
        String s = "";
        if (focusNode == null) {
            return "";
        }

        s += focusNode.toString();
        s += toStringPreorder(focusNode.leftChild);
        s += toStringPreorder(focusNode.rightChild);


        return s;
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public String toStringInorder(Node focusNode) {

        String s = "";
        if (focusNode == null) {
            return "";
        }

        s += toStringInorder(focusNode.leftChild);
        s += focusNode.toString();
        s += toStringInorder(focusNode.rightChild);

        return s;
    }

    public void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public String toStringPostOrder(Node focusNode) {

        String result = "";
        if (focusNode == null) {
            return "";
        } else {
            result += toStringPostOrder(focusNode.leftChild);
            result += toStringPostOrder(focusNode.rightChild);
            result += focusNode.toString(); 
        }
        return result;
    }

    public String findNode(T value) {

        Node focusNode = root;

        while (focusNode.value != value) {
            if (value < focusNode.value) {
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
        return focusNode.toString() + " gevonden.";
    }

    public String removeNode(T value) {
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        while (focusNode.value != value) {
            parent = focusNode;
            if (value < focusNode.value) {
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
        return focusNode + " verwijderd.";
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