import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HuffmanAlgorithm huffmanAlgorithm = new HuffmanAlgorithm();
        LZWAlgorithm lzwAlgorithm = new LZWAlgorithm();
        ReadFile readFile = new ReadFile();

        String mainText = readFile.readerFromMainFile("mainText.txt");//ana metin


        //huffman algorithm
        long huffmanStartTime = System.currentTimeMillis();
        huffmanAlgorithm.addToLinkedList(mainText);//main text nin içindeki verileri tek tek linkedList e ekledim
        huffmanAlgorithm.sort();//linkedList deki verileri frekanslarına göre sıraladım
        huffmanAlgorithm.createTree();//linkedList den bir ağaç yapısı oluşturdum
        huffmanAlgorithm.createHashMap(huffmanAlgorithm.root, "");//oluşturduğum ağaçtaki verileri hashMap e ekledim
        huffmanAlgorithm.createHuffmanCodeText(mainText);//oluşturduğum hashMap i kullanarak main text bulunan her bir karakteri huffman e göre başka bir String değerde tuttum
        long huffmanEndTime = System.currentTimeMillis();

        long huffmanEstimatedTime = huffmanEndTime - huffmanStartTime;
        double huffmanTotalTime = (double) huffmanEstimatedTime / 1000;

        //huffman için dosyadan veri çekerek okuma
        HashMap<String, Character> huffmanHashMap = new HashMap<>();
        String huffmanText = readFile.readerFromMainFile("huffmanAlgorithmCode.txt");//huffman codlu text dosyası
        huffmanHashMap = readFile.readerFromHuffmanAlgorithm("huffmanAlgorithm.txt");

        huffmanAlgorithm.writeFromHuffmanCodeToTxt(huffmanText, huffmanHashMap);


        //lzw algorithm
        long lzwStartTime = System.currentTimeMillis();
        String output;
        lzwAlgorithm.createDictionary(mainText);
        output = lzwAlgorithm.addToDictionary(mainText);
        lzwAlgorithm.writeLZWAlgorithm(output);
        long lzwEndTime = System.currentTimeMillis();

        long lzwEstimatedTime = lzwEndTime - lzwStartTime;
        double lzwTotalTime = (double) lzwEstimatedTime / 1000;

        //lzw için dosyadan veri çekme
        HashMap<Integer, String> lzwHashMap = new HashMap<>();
        String lzwText = readFile.readerFromMainFile("lzwAlgorithmCode.txt");
        lzwHashMap = readFile.readerFromLZWAlgorithmCode("lzwAlgorithm.txt");

        lzwAlgorithm.writeFromLZWCodeToTxt(lzwText, lzwHashMap);


        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Huffman Algorithm: " + huffmanTotalTime + " sn");
        System.out.println("LZW Algorithm: " + lzwTotalTime + " sn");
        System.out.println("--------------------------------------------------------------------------------------------");
    }
}