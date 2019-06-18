package com.codecool.filepartreader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        filePartReader.setup("src/main/resources/text.txt",1 , 1);
        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
        System.out.println(fileWordAnalyzer.getWordsContainingSubstring("o"));
        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
    }
}