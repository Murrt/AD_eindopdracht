package BT;

public class Node {

    int key;
    Node leftChild;
    Node rightChild;

    Node(int key) {
        this.key = key;
    }

    public String toString() {
        return " " + key;
    }
}
