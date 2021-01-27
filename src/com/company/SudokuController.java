package com.company;

import javax.swing.*;
import javax.swing.border.StrokeBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

public class SudokuController {
    private SudokuView view;
    private SudokuModel model = new SudokuModel();
    int[][] solvedModel = new int[9][9]; //TODO tutaj jest błąd przy sprawdzaniu
    int[][] modelGame = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}};


    public SudokuController(SudokuView view, SudokuModel model) {
        this.view = view;
        this.model = model;
        initView();
    }

    public void initView() {
        view.getTimerLabel().setText("Timer: 00:00:00");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solvedModel[i][j] = model.getLevel()[i][j];
            }
        }
        printSudoku();

    }

    public void initController() {
        view.getBtnlist().get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("1");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 1;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("2");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 2;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("3");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 3;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("4");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 4;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("5");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 5;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("6");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 6;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(6).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("7");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 7;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(7).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("8");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 8;
                        printSudoku();
                    }
                }
            }
        });
        view.getBtnlist().get(8).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField() == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Select box first");
                } else {
                    if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                        view.getLastFocusedTextField().setText("9");
                        Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                        modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 9;
                        printSudoku();
                    }
                }
            }
        });
        view.getClearbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getLastFocusedTextField().getBackground() != Color.WHITE) {
                    view.getLastFocusedTextField().setText(" ");
                    Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                    modelGame[(int) coordinates.getY()][(int) coordinates.getX()] = 0;
                    printSudoku();
                }
            }
        });


        view.getAbout().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(view.getFrame(), "Sudoku by nieoczywisty");
            }

        });
        view.getHelp().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view.getFrame().add(view.getHelpPanel());
                view.getMainPanel().setVisible(false);
                view.getHelpPanel().setVisible(true);
            }
        });

        view.getBackToMain().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getHelpPanel().setVisible(false);
                view.getMainPanel().setVisible(true);
            }
        });
        view.getNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Arrays.stream(view.getGrid())
                        .flatMap(Stream::of).forEach(jTextField -> jTextField.setVisible(true));
                loadGameFields();
                view.getBtnTimer().setEnabled(true);
            }
        });
//        view.getLastFocusedTextField().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //view.getBtnlist().stream().forEach(jButton -> jButton.setEnabled(false));model.getPossibleNum(modelGame).stream().filter(Boolean::booleanValue.equals(true));
//                for(int i = 0 ; i < view.getBtnlist().size() ; i++){
//                    if(model.getPossibleNum(modelGame).get(i).equals(true)){
//                        view.getBtnlist().get(i).setEnabled(false);
//                    }
//                }
//            }
//        });
        //////////////////////////// no prawie działa.
        view.getBtnTimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getBtnTimer().isSelected()) {
                    view.getBtnTimer().setText("Stop");
                    Arrays.stream(view.getGrid())
                            .flatMap(Stream::of).filter(jTextField -> jTextField.isForegroundSet()).forEach(jTextField -> jTextField.setForeground(Color.BLACK));
                    Arrays.stream(view.getGrid())
                            .flatMap(Stream::of).forEach(jTextField -> jTextField.setVisible(true));
                    view.getTimerLabel().startTimer();
                } else {
                    view.getBtnTimer().setText("Start");
                    Arrays.stream(view.getGrid())
                            .flatMap(Stream::of).filter(jTextField -> jTextField.isForegroundSet()).forEach(jTextField -> jTextField.setForeground(Color.WHITE));
                    Arrays.stream(view.getGrid())
                            .flatMap(Stream::of).forEach(jTextField -> jTextField.setVisible(false));
                    view.getTimerLabel().stopTimer();
                }
            }
        });

        view.getLastFocusedTextField().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Point coordinates = view.getMapFieldToCoordinates().get(view.getLastFocusedTextField());
                model.getSafeNumbers(modelGame,(int)coordinates.getX(),(int)coordinates.getY());
                for (int i = 0; i <= model.possibleNum.size() ; i++) {
                    if(model.possibleNum.get(i).equals(false)) {
                        view.getBtnlist().get(i).setEnabled(false);
                    }

                }
            }
        });

        view.getFinishBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.SolveSudoku(solvedModel, solvedModel.length);
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        int temp = solvedModel[i][j];
                        if (temp == 0) {
                            view.getGrid()[i][j].setText("");
                        } else {
                            view.getGrid()[i][j].setText(String.valueOf(temp));
                        }
                    }
                }
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        modelGame[i][j] = solvedModel[i][j];
                    }
                }
                //solvedModel = modelGame; //TODO niebiezpieczna, seksualna

            }
        });

        view.getCheckSudokuBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.SolveSudoku(solvedModel, solvedModel.length);
                boolean solved = false;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        int temp = modelGame[i][j];
                        if (modelGame[i][j] != solvedModel[i][j]) {
                            solved = false;
                            break;
                        } else {
                            solved = true;

                        }
                    }
                }
                if (solved) {
                    view.getTimerLabel().stopTimer();
                    JOptionPane.showMessageDialog(null, "Congrats. You beat the level");
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, you made a mistake");
                }
            }
        });

        view.getClearGridBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearGrid();
                Arrays.stream(view.getGrid())
                        .flatMap(Stream::of).filter(jTextField -> jTextField.isBackgroundSet()).forEach(jTextField -> jTextField.setBackground(Color.decode("#e6e6e6")));
                if(view.getBtnTimer().isSelected()) {
                    view.getBtnTimer().doClick();
                }
                view.getBtnTimer().setEnabled(false);
                Arrays.stream(view.getGrid())
                        .flatMap(Stream::of).forEach(jTextField -> jTextField.setVisible(true));
                view.getTimerLabel().resetTimer();
                view.getTimerLabel().setText("");
//                view.getTimerLabel().setText("DUPA");
//                System.out.println();
            }
        });

    }

    public void loadGameFields() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int temp = model.getLevel()[i][j];
                if (temp == 0) {
                    view.getGrid()[i][j].setText("");
                } else {
                    view.getGrid()[i][j].setBackground(Color.WHITE);
                    view.getGrid()[i][j].setForeground(Color.WHITE);
                    view.getGrid()[i][j].setText(String.valueOf(temp));
                    view.getGrid()[i][j].setVisible(true);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                modelGame[i][j] = model.getLevel()[i][j];
            }
        }
        view.getBtnlist().stream().forEach(JButton -> JButton.setEnabled(true));
        printSudoku();
    }

    private void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(modelGame[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void clearGrid() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                view.getGrid()[x][y].setText("");
                modelGame[x][y] = 0;

            }
        }
        view.getBtnlist().stream().forEach(JButton -> JButton.setEnabled(false));
        printSudoku();

    }

}


