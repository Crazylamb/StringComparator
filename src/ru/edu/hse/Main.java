package ru.edu.hse;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File htmlTemplateFile = new File("src/ru/edu/hse/template.html");
        String htmlString = null;
        try {
            htmlString = FileUtils.readFileToString(htmlTemplateFile);
        } catch (IOException e) {
            System.out.println("Can't read the file");
            System.exit(-1);
        }
        String title = "Compared Text";
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        TextReader textReader = new TextReader();
        ArrayList<String> first = textReader.getAllLines(getPath());
        ArrayList<String> second = textReader.getAllLines(getPath());
        String body = textAnalyzer.compareFirstToSecond(first,second);
        String right = textAnalyzer.compareSecondToFirst(first,second);
        htmlString = htmlString.replace("$title", title);
        htmlString = htmlString.replace("$leftside", body);
        htmlString = htmlString.replace("$rightside", right);
        File newHtmlFile = new File("src/ru/edu/hse/result.html");
        try {
            FileUtils.writeStringToFile(newHtmlFile, htmlString);
        } catch (IOException e) {
            System.out.println("Can't make the file");
            System.exit(-1);
        }
    }

    static String getPath(){
        System.out.println("Enter the path to the file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        return path;
    }
}
