public class LinkedListNode {
    private HuffmanNode huffmanNode;
    private LinkedListNode next;

    public LinkedListNode(HuffmanNode huffmanNode) {
        this.setHuffmanNode(huffmanNode);
        this.setNext(null);
    }

    public HuffmanNode getHuffmanNode() {
        return huffmanNode;
    }

    public void setHuffmanNode(HuffmanNode huffmanNode) {
        this.huffmanNode = huffmanNode;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }
}