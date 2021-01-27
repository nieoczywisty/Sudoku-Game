package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class SudokuModel {

    private int[][] level = new int[][]{
            {0, 0, 6, 7, 0, 3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 6, 7, 0},
            {0, 0, 0, 0, 6, 5, 1, 0, 9},
            {0, 7, 2, 5, 0, 4, 8, 9, 0},
            {8, 0, 0, 0, 0, 0, 0, 0, 6},
            {0, 9, 3, 2, 0, 6, 7, 4, 0},
            {5, 0, 8, 4, 7, 0, 0, 0, 0},
            {0, 2, 9, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 0, 9, 4, 0, 0}};


    ArrayList<Boolean> possibleNum = new ArrayList<>(9);

    public SudokuModel() {
    }

    public int[][] getLevel() {
        return level;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    int[][] matrix = new int[][]
            {
                    {3, 0, 6, 5, 0, 8, 4, 0, 0},
                    {5, 2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0, 5, 0, 0, 9, 0, 6, 0, 0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7, 4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}
            };

//
//            if(SolveSuduko(matrix, 9)){
//                for (int i = 0; i < 9; i++) {
//                    for (int j = 0; j < 9; j++) {
//                        System.out.print(matrix[i][j]);
//                    }
//                    System.out.println();
//                }
//            }
//

    protected boolean SolveSudoku(int[][] matrix, int n) {
        int rowIndex = -1;
        int columnIndex = -1;
        int i = 0;
        int j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
            if (rowIndex != -1) {
                break;
            }

        }
        if (i == n && j == n) {
            return true;
        } else {
            for (int value = 1; value < 10; value++) {
                if (IsSafe(matrix, value, rowIndex, columnIndex)) {
                    matrix[rowIndex][columnIndex] = value;
                    if (!SolveSudoku(matrix, n)) {
                        matrix[rowIndex][columnIndex] = 0;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private boolean IsSafe(int[][] matrix, int value, int rowIndex, int columnIndex) {
        //row check
        for (int j = 0; j < 9; j++) {
            if (matrix[rowIndex][j] == value) {
                return false;
            }
        }
        //column check
        for (int i = 0; i < 9; i++) {
            if (matrix[i][columnIndex] == value) {
                return false;
            }
        }
        //submatrix check
        int baseRowIndex = rowIndex - (rowIndex % 3);
        int baseColumnIndex = columnIndex - (columnIndex % 3);
        for (int i = baseRowIndex; i < baseRowIndex + 3; i++) {
            for (int j = baseColumnIndex; j < baseColumnIndex + 3; j++) {
                if (matrix[i][j] == value) {
                    return false;
                }

            }
        }
        return true;
    }

    protected void getSafeNumbers(int[][] matrix, int x, int y) {
        for (int value = 1; value < 10; value++) {
            if (IsSafe(matrix, value, x, y)) {
                possibleNum.set(value, true);

            }
        }
    }

    protected ArrayList<Boolean> getPossibleNum() {
        return possibleNum;
    }
}
