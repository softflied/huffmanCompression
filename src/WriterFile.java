import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

public class WriterFile {

    public WriterFile() {

    }

    public void writeStringValues(String str, String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            System.out.println(fileName + " dosyasına veri yazılırken sıkıntı çıktı...");
        }
    }

    public void writeHuffmanAlgorithm(HashMap<Character, String> hashMap, String fileName) {//sadece huffman agacını yazmak için

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (Character i : hashMap.keySet()) {

                if (i.equals('\n')) {
                    writer.write("\\n:" + hashMap.get(i));
                } else {
                    writer.write(i + ":" + hashMap.get(i));
                }
                writer.newLine();
            }
            writer.close();

        } catch (Exception e) {
            System.out.println(fileName + " dosyasına veri yazılırken sıkıntı çıktı...");
        }
    }

    public void writeLZWAlgorithm(HashMap<String, Integer> hashMap, String fileName) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (String i : hashMap.keySet()) {

                if (i.equals("\n")) {
                    writer.write("\\n:" + hashMap.get(i));
                } else {
                    writer.write(i + ":" + hashMap.get(i));
                }
                writer.newLine();
            }
            writer.close();

        } catch (Exception e) {
            System.out.println(fileName + " dosyasına veri yazılırken sıkıntı çıktı...");
        }
    }

    /*public void write(String str, HashMap<Character, String> hashMap, String fileName) {//hem huffman agacını hem de huffman ile oluşmuş metni aynı dosyanın içine yazmak için
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            hashMap.forEach((key, value) -> {
                try {
                    writer.write(key + " " + value);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.newLine();
            writer.write(str);
            writer.close();
        } catch (Exception e) {
            System.out.println(fileName + ".txt dosyasına veri yazılırken sıkıntı çıktı.");
        }
    }*/
}