package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        //SwingUtilities.invokeLater(SudokuView::new);
        SudokuView v = new SudokuView();
        SudokuModel m = new SudokuModel();
        SudokuController c = new SudokuController(v,m);
        c.initController();

    }
}
