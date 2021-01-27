package com.company;

public class Level {

    private int[][] levelOne = { { 0, 0, 6, 7, 0, 3, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 6, 7, 0 },
            { 0, 0, 0, 0, 6, 5, 1, 0, 9 }, { 0, 7, 2, 5, 0, 4, 8, 9, 0 }, { 8, 0, 0, 0, 0, 0, 0, 0, 6 },
            { 0, 9, 3, 2, 0, 6, 7, 4, 0 }, { 5, 0, 8, 4, 7, 0, 0, 0, 0 }, { 0, 2, 9, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 6, 0, 9, 4, 0, 0 } };

    public Level() {
    }

    public int[][] getLevelOne() {
        return levelOne;
    }
}
