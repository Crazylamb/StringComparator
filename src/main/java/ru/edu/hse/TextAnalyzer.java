package ru.edu.hse;

import java.util.ArrayList;

public class TextAnalyzer {

    /**
     * Analyze the first text, compared to the second
     * In the first text lines can be either deleted, modified or same as in the second
     * @return String to put in the html file
     */
    public String compareFirstToSecond(ArrayList<String> firstFile, ArrayList<String> secondFile){
        StringBuilder sb = new StringBuilder();
        LCSOperator lcsOperator = new LCSOperator();
        int currentIndex = 0;
        int j = 0;
        for (int i = 0; i < firstFile.size(); i++) {
            for (j = currentIndex; j < secondFile.size(); j++) {
                if (lcsOperator.getLCS(firstFile.get(i), secondFile.get(j)).length() == firstFile.get(i).length() ){
                    sb.append("<p>" + firstFile.get(i) + "</p>");
                    currentIndex = j;
                    break;
                }
                else if (lcsOperator.getLCS(firstFile.get(i), secondFile.get(j)).length() > (firstFile.get(i).length() / 2)){
                    sb.append("<p blockquote style=\"color: blue\">" + firstFile.get(i) + "</p>");
                    currentIndex = j;
                    break;
                }
            }
            if (j == secondFile.size() && currentIndex != j){
                sb.append("<p blockquote style=\"color: red\">" + firstFile.get(i) + "</p>");
            }
        }
        sb.append("</p>");
        return sb.toString();
    }

    /**
     * Analyze the second text, compared to the first
     * In the second text lines can be either added, modified or same as in the first
     * @return String to put in the html file
     */
    public String compareSecondToFirst(ArrayList<String> firstFile, ArrayList<String> secondFile){
        StringBuilder sb = new StringBuilder();
        LCSOperator lcsOperator = new LCSOperator();
        int currentIndex = 0;
        int j = 0;
        for (int i = 0; i < secondFile.size(); i++) {
            for (j = currentIndex; j < firstFile.size(); j++) {
                if (lcsOperator.getLCS(firstFile.get(j), secondFile.get(i)).length() == secondFile.get(i).length() ){
                    sb.append("<p>" + secondFile.get(i) + "</p>");
                    currentIndex = j;
                    break;
                }
                else if (lcsOperator.getLCS(firstFile.get(j), secondFile.get(i)).length() > (secondFile.get(i).length() / 2)){
                    sb.append("<p blockquote style=\"color: blue\">" + secondFile.get(i) + "</p>");
                    currentIndex = j;
                    break;
                }
            }
            if (j == firstFile.size() && currentIndex != j){
                sb.append("<p blockquote style=\"color: green\">" + secondFile.get(i) + "</p>");
            }
        }
        sb.append("</p>");
        return sb.toString();
    }
}
