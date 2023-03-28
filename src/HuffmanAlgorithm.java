import java.util.HashMap;

public class HuffmanAlgorithm {

    LinkedListOperations operations = new LinkedListOperations();//huffmanNode ları tutmak için
    WriterFile writerFile = new WriterFile();

    HashMap<Character, String> hashMap = new HashMap<>();

    public static int TOTAL_SIZE = 0;
    HuffmanNode root;

    public HuffmanAlgorithm() {
        root = null;
    }

    public void addToLinkedList(String text) {

        for (int i = 0; i < text.length(); i++) {

            HuffmanNode node = new HuffmanNode(text.charAt(i));
            operations.add(node);
        }
        TOTAL_SIZE = operations.getSize();
    }

    public void sort() {
        operations.sortList();
    }

    public void createTree() {

        while (operations.getSize() != 1) {

            HuffmanNode box01 = operations.head.getHuffmanNode();
            HuffmanNode box02 = operations.head.getNext().getHuffmanNode();

            HuffmanNode newBox = new HuffmanNode('*');
            newBox.setFrequency((box01.getFrequency() + box02.getFrequency()));

            operations.delete();
            operations.delete();

            newBox.setLeft(box01);
            newBox.setRight(box02);

            root = newBox;
            operations.add2(newBox);
            operations.sortList();
        }
    }

    public void createHashMap(HuffmanNode root, String str) {

        if (root.getLeft() == null && root.getRight() == null) {

            //System.out.println(root.getCharacter() + "   |  " + str);
            hashMap.put(root.getCharacter(), str);
            return;
        }
        createHashMap(root.getLeft(), (str + "0"));
        createHashMap(root.getRight(), (str + "1"));
    }

    public void createHuffmanCodeText(String text) {

        String huffmanText = "";

        for (int i = 0; i < text.length(); i++) {

            String value = hashMap.get(text.charAt(i));
            huffmanText += value;
        }

        writerFile.writeStringValues(huffmanText, "huffmanAlgorithmCode.txt");
        writerFile.writeHuffmanAlgorithm(hashMap, "huffmanAlgorithm.txt");
    }

    public void writeFromHuffmanCodeToTxt(String text, HashMap<String, Character> hashMap) {

        String line = "";
        String mainText = "";
        for (int i = 0; i < text.length(); i++) {

            line += String.valueOf(text.charAt(i));

            if (hashMap.containsKey(line) && hashMap.get(line) != '\\') {

                mainText += hashMap.get(line);
                line = "";
            } else if (hashMap.containsKey(line)) {
                mainText += "\n";
                line = "";
            }

            writerFile.writeStringValues(mainText, "newHuffmanText.txt");
        }
    }
}