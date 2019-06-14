import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }


    private ArrayList<String> getCleanList() throws IOException {
        String toUse = filePartReader.readLines();
        ArrayList<String> wordArrayList = new ArrayList<>();
        ArrayList<String> cleanWordList = new ArrayList<>();
        Collections.addAll(wordArrayList, toUse.trim().split("\\s+"));
        for (String word : wordArrayList) {
            word = word.replaceAll("[^a-zA-Z0-9!@.,]", "");
            cleanWordList.add(word);
        }
        return cleanWordList;
    }

    public List getWordsOrderedAlphabetically() throws IOException {
        ArrayList<String> cleanWordList;
        cleanWordList = getCleanList();
        cleanWordList.sort(String::compareToIgnoreCase);
        return cleanWordList;
    }

    public List getWordsContainingSubstring(String subString) throws IOException {
        ArrayList<String> cleanWordList = getCleanList();
        ArrayList<String> wordsContainingSubstring = new ArrayList<>();
        for (String word : cleanWordList) {
            if (word.contains(subString)){
                wordsContainingSubstring.add(word);
            }
        }
        return wordsContainingSubstring;
    }

    public List getStringsWhichPalindromes () throws IOException {
        ArrayList<String> cleanWordList = getCleanList();
        ArrayList<String> palindromeList = new ArrayList<>();
        for (String word : cleanWordList) {
            if (word.equals(new StringBuilder(word).reverse().toString()) && word.length() > 1){
                palindromeList.add(word);
            }
        }
        return palindromeList;
    }


}
