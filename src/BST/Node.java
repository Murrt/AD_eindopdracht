package BST;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

    T value;
    Node<T> leftChild;
    Node<T> rightChild;

    Node(T value) {
        this.value = value;
    }

    public String toString() {
        return " " + value;
    }

    @Override
    public int compareTo(Node<T> otherNode) {
        return value.compareTo(otherNode.value);
    }
}
