package ru.edu.hse;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class TextReader {

    /**
     * Get all lines from the file
     * @return Array with lines
     */
    public ArrayList<String> getAllLines(String path){
        ArrayList<String> allLines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null){
                allLines.add(currentLine);
            }
        } catch (IOException e) {
            System.out.println("Error handling the file!");
            System.exit(-1);
        }
        return allLines;
    }
}
