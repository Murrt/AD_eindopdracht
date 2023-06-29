package BST;

public class Binary_Search_Tree<T extends Comparable<T>> {

    public Node<T> root;

    public void addNode(T value) {

        Node<T> newNode = new Node<>(value);

        // Check of key de root is
        if (root == null) {
            root = newNode;
        } else {

            // Kijk vanaf de root als je de tree gaat traversen.
            Node<T> focusNode = root;
            Node<T> parent;

            while (true) {
                parent = focusNode;

                if (value.compareTo(focusNode.value) < 0) {
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

    public void preOrderTraversal(Node<T> focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    public String toStringPreorder(Node<T> focusNode) {
        String s = "";
        if (focusNode == null) {
            return "";
        }

        s += focusNode.toString();
        s += toStringPreorder(focusNode.leftChild);
        s += toStringPreorder(focusNode.rightChild);

        return s;
    }

    public void inOrderTraversal(Node<T> focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public String toStringInorder(Node<T> focusNode) {

        String s = "";
        if (focusNode == null) {
            return "";
        }

        s += toStringInorder(focusNode.leftChild);
        s += focusNode.toString();
        s += toStringInorder(focusNode.rightChild);

        return s;
    }

    public void postOrderTraversal(Node<T> focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public String toStringPostOrder(Node<T> focusNode) {

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

        Node<T> focusNode = root;

        while (focusNode != value) {
            int comparison = value.compareTo(focusNode.value);

            if (comparison == 0) {
                System.out.println("Node gevonden.");
                return focusNode.toString() + " gevonden.";
            } else if (comparison < 0) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
        }

        System.out.println("Node niet gevonden.");
        return "Node niet gevonden.";
    }

    public String removeNode(T value) {
        Node<T> focusNode = root;
        Node<T> parent = root;

        boolean isLeftChild = true;

        while (focusNode != null && focusNode.value.compareTo(value) != 0) {
            parent = focusNode;
            if (value.compareTo(focusNode.value) < 0) {
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
            Node<T> replacement = getReplacementNode(focusNode);

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

    public Node<T> getReplacementNode(Node<T> replacedNode) {

        Node<T> replacementParent = replacedNode;
        Node<T> replacement = replacedNode;

        Node<T> focusNode = replacedNode.rightChild;

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