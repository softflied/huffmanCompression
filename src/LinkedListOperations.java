public class LinkedListOperations {

    LinkedListNode head;

    public LinkedListOperations() {
        head = null;
    }

    public void add(HuffmanNode huffmanNode) {

        LinkedListNode newNode = new LinkedListNode(huffmanNode);

        if (comparison(huffmanNode.getCharacter())) {

            if (head == null) {
                head = newNode;
                head.setNext(null);
            } else {
                newNode.setNext(head);
                head = newNode;
            }
        }
    }

    public void add2(HuffmanNode huffmanNode) {

        LinkedListNode newNode = new LinkedListNode(huffmanNode);

        if (head == null) {
            head = newNode;
            head.setNext(null);
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void delete() {
        LinkedListNode temp;

        if (head != null) {

            temp = head;
            head = head.getNext();
            temp.setNext(null);
        }
    }

    private boolean comparison(Character character) {

        LinkedListNode walk = head;
        boolean control = true;

        while (walk != null) {

            if (walk.getHuffmanNode().getCharacter().equals(character)) {
                control = false;
                int box = walk.getHuffmanNode().getFrequency();
                walk.getHuffmanNode().setFrequency(box + 1);
            }

            walk = walk.getNext();
        }
        return control;
    }

    public void sortList() {
        LinkedListNode walk = head;
        LinkedListNode index = null;

        int tempInt;
        Character tempChar;
        HuffmanNode tempRight;
        HuffmanNode tempLeft;

        if (head == null) {
            System.out.println("Sıralanacak eleman bulunamadı...");
        } else {
            while (walk != null) {
                index = walk.getNext();

                while (index != null) {

                    if (walk.getHuffmanNode().getFrequency() > index.getHuffmanNode().getFrequency()) {


                        tempInt = walk.getHuffmanNode().getFrequency();
                        tempChar = walk.getHuffmanNode().getCharacter();
                        tempLeft = walk.getHuffmanNode().getLeft();
                        tempRight = walk.getHuffmanNode().getRight();

                        walk.getHuffmanNode().setFrequency(index.getHuffmanNode().getFrequency());
                        walk.getHuffmanNode().setCharacter(index.getHuffmanNode().getCharacter());
                        walk.getHuffmanNode().setLeft(index.getHuffmanNode().getLeft());
                        walk.getHuffmanNode().setRight(index.getHuffmanNode().getRight());

                        index.getHuffmanNode().setFrequency(tempInt);
                        index.getHuffmanNode().setCharacter(tempChar);
                        index.getHuffmanNode().setLeft(tempLeft);
                        index.getHuffmanNode().setRight(tempRight);
                    }

                    index = index.getNext();
                }

                walk = walk.getNext();
            }
        }
    }

    public void ToString() {

        LinkedListNode walk = head;

        while (walk != null) {

            System.out.println(walk.getHuffmanNode().getCharacter() + " : " + walk.getHuffmanNode().getFrequency());
            walk = walk.getNext();
        }
    }

    public int getSize() {
        LinkedListNode walk = head;
        int counter = 0;

        while (walk != null) {

            counter++;
            walk = walk.getNext();
        }

        return counter;
    }
}