package ru.edu.hse;

import static java.lang.Integer.max;

public class LCSOperator {

    /**
     * Algorithm to return the LCS matrix
     */
    private int[][] getLCSArray(String x, String y){
        int[][] arr = new int[x.length()+1][y.length() + 1];
        for (int i = 0; i < x.length() + 1; i++)
        {
            for (int j = 0; j < y.length() + 1; j++)
            {
                arr[i][j] = 0;
            }
        }
        for (int i = 1; i < x.length()+1; i++)
        {
            for (int j = 1; j < y.length() + 1; j++)
            {
                if (x.charAt(i-1) == y.charAt(j - 1))
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                else
                    arr[i][j] = max(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr;
    }

    /**
     * Get the value from the LCS matrix and convert it to the string
     */
    public String getLCS(String x, String y) {
        int[][] arr = getLCSArray(x, y);
        String lcs = "";
        int x_i = x.length() - 1;
        int y_i = y.length() - 1;
        while (x_i >= 0 && y_i >= 0) {
            if (x.charAt(x_i) == y.charAt(y_i)) {
                lcs+=x.charAt(x_i);
                x_i--;
                y_i--;
            }
            else if (x_i != 0 && y_i!=0 && arr[x_i - 1][y_i] > arr[x_i][y_i - 1]) {
                x_i -= 1;
            }
            else
                y_i -= 1;
        }
        lcs = new StringBuilder(lcs).reverse().toString();
        return lcs;
    }
}
