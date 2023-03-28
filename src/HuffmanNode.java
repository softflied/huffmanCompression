public class HuffmanNode {

    private Character character;
    private int frequency;
    private HuffmanNode right;
    private HuffmanNode left;

    public HuffmanNode(Character character) {
        this.setCharacter(character);
        this.setFrequency(1);
        this.setRight(null);
        this.setLeft(null);
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }
}