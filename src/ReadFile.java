import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;

public class ReadFile {

    HashMap<String, Character> huffmanHashMap = new HashMap<>();//bir txt dosyasından huffman olarak kodlamış olduğum key-value değerleri almak için
    HashMap<Integer, String> lzwHashMap = new HashMap<>();//bir txt dosyasından lzw olarak kodlamış olduğum key-value değerleri almak için

    public ReadFile() {

    }

    public String readerFromMainFile(String fileName) {
        String str = "";

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                str += line + "\n";
            }

        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }

        return str;
    }

    public HashMap<String, Character> readerFromHuffmanAlgorithm(String fileName) {

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                String[] arraySplit = line.split(":");
                char value = arraySplit[0].charAt(0);
                String key = arraySplit[1];

                huffmanHashMap.put(key, value);
            }
        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }

        return huffmanHashMap;
    }

    public HashMap<Integer, String> readerFromLZWAlgorithmCode(String fileName) {

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {

                String[] arraySplit = line.split(":");
                int key = Integer.parseInt(arraySplit[1]);
                String value = arraySplit[0];

                lzwHashMap.put(key, value);
            }

        } catch (Exception e) {
            System.out.println(fileName + " dosyası okunurken hata çıktı...");
        }

        return lzwHashMap;
    }

    /*public String readerFromMixFile(String fileName) {
        String str = "";
        int counter = 0;

        try {
            String line = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            while ((line = bufferedReader.readLine()) != null) {

                if (line.equals("")) {
                    counter++;
                }

                if (counter >= 1) {

                    str += line;

                } else {
                    String[] arraySplit = line.split(" ");
                    char value;
                    String key;

                    if (arraySplit[0].equals("")) {
                        value = ' ';
                        key = arraySplit[2];
                    } else {
                        value = arraySplit[0].charAt(0);
                        key = arraySplit[1];
                    }

                    huffmanHashMap.put(key, value);
                }
            }
        } catch (Exception e) {
            System.out.println("Huffman Text dosyası okunurken hata çıktı...");
        }

        return str;
    }

    public HashMap<String, Character> createHashMapForFixFile() {
        return huffmanHashMap;
    }*/
}