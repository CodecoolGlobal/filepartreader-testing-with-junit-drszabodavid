package com.codecool.filepartreader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
    }

    void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("Not valid line numbers");
        this.filePath = filePath;
        this.fromLine = fromLine - 1;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        String fullText = "";
        for (int i = 0; i < Files.readAllLines(Paths.get(filePath)).size(); i++) {
            String lineToReturn = Files.readAllLines(Paths.get(filePath)).get(i);
            if (i == Files.readAllLines(Paths.get(filePath)).size()-1){
                return fullText += lineToReturn;
            }
            fullText += lineToReturn + "\n";
        }
        return fullText;
    }

    String readLines() throws IOException {
        String fullText = read();
        String toReturn = "";
        String[] lines = fullText.split("\n");
        for (int i = fromLine; i < toLine; i++) {
            if (i == toLine-1){
                return toReturn += lines[i];
            }
            toReturn += lines[i] + ("\n");
        }
        return toReturn;
        }
}



