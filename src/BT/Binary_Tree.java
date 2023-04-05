package BT;

public class Binary_Tree {

    public Node root;

    public String print_nodes() {
        List<String> strings = new LinkedList<>();
        ListNode node = head;
        // loop door alle nodes
        for (int i = 1; i <= nodeCount; i++) {
            System.out.println(node.data);
            strings.add(Integer.toString(node.data));
            node = node.next;
        }

        String message = String.join(",", strings);
        return message;
    }


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

    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightChild);
        }
    }

    public void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftChild);
            preOrderTraversal(focusNode.rightChild);
        }
    }

    public void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);
            postOrderTraversal(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public Node findNode(int key) {

        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        System.out.println(focusNode);
        return focusNode;
    }

    public boolean removeNode(int key) {
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
                return false;

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
        }
        return true;
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