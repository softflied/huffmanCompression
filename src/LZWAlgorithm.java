import java.util.HashMap;

public class LZWAlgorithm {

    WriterFile writerFile = new WriterFile();
    HashMap<String, Integer> lzwHashmap = new HashMap<>();//sözlüklerri tutmak için


    public void createDictionary(String str) {

        int counter = 1;
        String temp = "";

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            temp = String.valueOf(c);
            if (c == '\n') {

            }

            if (!lzwHashmap.containsKey(temp)) {
                lzwHashmap.put(temp, counter);
                counter++;
            }
        }
    }

    public String addToDictionary(String str) {

        String newStr = "";
        String output = "";
        String temp = "";

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            temp = String.valueOf(c);
            if (c == '\n') {
                temp = "\\n";
            }

            if (lzwHashmap.containsKey((newStr + temp))) {

                newStr = newStr + temp;

            } else {

                output += String.valueOf(lzwHashmap.get(newStr)) + "-";
                int box = lzwHashmap.size() + 1;


                lzwHashmap.put((newStr + temp), box);

                newStr = temp;
            }
        }

        return output;
    }

    public void writeLZWAlgorithm(String output) {
        writerFile.writeStringValues(output, "lzwAlgorithmCode.txt");
        writerFile.writeLZWAlgorithm(lzwHashmap, "lzwAlgorithm.txt");
    }

    public void writeFromLZWCodeToTxt(String text, HashMap<Integer, String> hashMap) {

        String line = "";
        String mainText = "";

        for (int i = 0; i < text.length(); i++) {


            if (text.charAt(i) != '-') {
                line += String.valueOf(text.charAt(i));
            } else {
                mainText += hashMap.get(Integer.parseInt(line));
                line = "";
            }

        }
        writerFile.writeStringValues(mainText, "newLZWText.txt");
    }
}