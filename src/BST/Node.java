package BT;

public class Node<T> {

    T value;
    Node<T> leftChild;
    Node<T> rightChild;

    Node(T value) {
        this.value = value;
    }

    public String toString() {
        return " " + value;
    }
}
