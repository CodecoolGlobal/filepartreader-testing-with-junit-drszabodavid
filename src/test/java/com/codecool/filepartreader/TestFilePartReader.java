package com.codecool.filepartreader;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TestFilePartReader {

    static FilePartReader filePartReader = new FilePartReader();
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);


    @Test
    public void TestSetup() throws IOException {
        filePartReader.setup("src/test/resources/Iliad.txt", 2, 2);
        assertEquals("countless ills upon the Achaeans. Many a brave soul did it send", filePartReader.readLines());
    }

    @Test
    public void TestRead() throws IOException {
        filePartReader.setup("src/test/resources/Iliad.txt", 1, 6);
        assertEquals("Sing, O goddess, the anger of Achilles son of Peleus, that brought\n" +
                "countless ills upon the Achaeans. Many a brave soul did it send\n" +
                "hurrying down to Hades, and many a hero did it yield a prey to dogs and\n" +
                "vultures, for so were the counsels of Jove fulfilled from the day on\n" +
                "which the son of Atreus, king of men, and great Achilles, first fell\n" +
                "out with one another.", filePartReader.read());
    }

    @Test
    public void TestReadLines() throws IOException {
        filePartReader.setup("src/test/resources/Iliad.txt", 1, 5);
        assertEquals("Sing, O goddess, the anger of Achilles son of Peleus, that brought\n" +
                "countless ills upon the Achaeans. Many a brave soul did it send\n" +
                "hurrying down to Hades, and many a hero did it yield a prey to dogs and\n" +
                "vultures, for so were the counsels of Jove fulfilled from the day on\n" +
                "which the son of Atreus, king of men, and great Achilles, first fell", filePartReader.readLines());
    }

    @Test
    void TestCleanList() throws IOException {
        filePartReader.setup("src/test/resources/test.txt", 1,1);
        assertEquals("[David]", fileWordAnalyzer.getCleanList().toString());
    }

    @Test
    void TestGetWordsOrderedAlphabetically(){}

    @Test
    void TestGetWordsContainingSubstring(){}

    @Test
    void TestGetStringsWhichPalindromes(){}







}
