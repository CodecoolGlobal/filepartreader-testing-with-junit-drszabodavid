import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        filePartReader.setup("src/text.txt",1 , 22);
        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
        System.out.println(fileWordAnalyzer.getWordsContainingSubstring("met"));
        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
    }
}