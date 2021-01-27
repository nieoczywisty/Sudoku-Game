package com.company;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.Stream;

public class SudokuView extends JFrame {

    private JFrame frame;
    private JTextField[][] grid = new JTextField[9][9];
    private JTextField lastFocusedTextField;
    private JPanel mainPanel = new JPanel();
    private JPanel helpPanel = new JPanel();
    private JPanel gridPanel = new JPanel();
    private JPanel flowPanel = new JPanel();
    private JPanel btmFlowPanel = new JPanel();
    private JPanel[][] minisquarePanels;
    private Map<JTextField, Point> mapFieldToCoordinates = new HashMap<>();
    private Font FONT = new Font("Verdana", Font.CENTER_BASELINE, 20);
    private JPanel timerPanel = new JPanel();
    private JButton clearbtn = new JButton("Clear");
    private ArrayList<JButton> btnlist = new ArrayList<>();
    private JMenu game;
    private JMenu help;
    private JMenu about;
    private JMenuBar menuBar;
    private JMenuItem newGame;
    private JToggleButton btnTimer = new JToggleButton("Start");
    private JButton finishBtn = new JButton("Finish Game");
    private JButton checkSudokuBtn = new JButton("Check Sudoku");
    private JButton clearGridBtn = new JButton("Clear Grid");
    private JButton backToMain;
    private JLabel lblTimer = new JLabel();
    private TimerLabel timerLabel = new TimerLabel();

    public SudokuView() {

        mainPanel.setBackground(Color.decode("#e6e6e6"));
        helpPanel.setBackground(Color.black);
        gridPanel.setBackground(Color.decode("#e6e6e6"));
        flowPanel.setBackground(Color.decode("#e6e6e6"));
        btmFlowPanel.setBackground(Color.decode("#12126d"));
        timerPanel.setBackground(Color.decode("#e6e6e6"));


        //List of inputButtons
        for (int i = 0; i <= 8; i++) {
            btnlist.add(new JButton(String.valueOf(i + 1)));
        }


        //Create and set up the window.
        frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //JPanel alignment
        mainPanel.setLayout(new BorderLayout(50, 5));
        gridPanel.setLayout(new GridLayout(9, 9));
        flowPanel.setLayout(new FlowLayout());
        btmFlowPanel.setLayout(new FlowLayout());
        helpPanel.setLayout(new BorderLayout(30, 30));

        //frame.add(helpPanel);
        backToMain = new JButton("Back");
        backToMain.setPreferredSize(new Dimension(50, 50));
        helpPanel.add(new JLabel(" "), BorderLayout.WEST);
        helpPanel.add(new JLabel(" "), BorderLayout.EAST);
        String text = "<html>Sudoku is played on a grid of 9 x 9 spaces. " +
                "Within the rows and columns are 9 “squares” (made up of 3 x 3 spaces). " +
                "Each row, column and square (9 spaces each) needs to be filled out with the numbers 1-9, " +
                "without repeating any numbers within the row, column or square.</html>";
        JLabel helpLbl = new JLabel(text);
        helpLbl.setForeground(Color.WHITE);
        helpPanel.add(helpLbl, BorderLayout.CENTER);

        helpPanel.add(backToMain, BorderLayout.SOUTH);


        frame.add(mainPanel);
        mainPanel.add(gridPanel, BorderLayout.WEST);
        mainPanel.add(flowPanel, BorderLayout.NORTH);
        mainPanel.add(btmFlowPanel, BorderLayout.SOUTH);

        //Display the window.
        frame.setVisible(true);

        //Create the menu bar.
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.decode("#12126d"));
        menuBar.setPreferredSize(new Dimension(200, 20));
        //Create menu
        game = new JMenu("Game");
        game.setForeground(Color.WHITE);
        help = new JMenu("Help");
        help.setForeground(Color.WHITE);
        about = new JMenu("About");
        about.setForeground(Color.WHITE);
        //Create menu item
        newGame = new JMenuItem("New Game");

        //Set Menu to menubar
        menuBar.add(game);
        menuBar.add(help);
        menuBar.add(about);
        //Set menu item
        game.add(newGame);



        //generate Jtextfields in base grid
        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                JTextField field = new JTextField();
                field.setHorizontalAlignment(JTextField.CENTER);
                mapFieldToCoordinates.put(field, new Point(x, y));
                grid[y][x] = field;
            }
        }
        //disable keyboard input for fields in array
//        Arrays.stream(grid)
//                .flatMap(Stream::of).forEach(jTextField -> setForeground(Color.WHITE));
        Arrays.stream(grid)
                .flatMap(Stream::of).forEach(jTextField -> jTextField.setEditable(false));

        //set up border and textfield size
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        Dimension fieldDimension = new Dimension(60, 30);

        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                JTextField field = grid[y][x];
                field.setBorder(border);
                field.setFont(FONT);
                field.setPreferredSize(fieldDimension);

            }
        }
        //set inner borders 3x3
        int minisquareDimension = (int) Math.sqrt(9);
        gridPanel.setLayout(new GridLayout(minisquareDimension, minisquareDimension));

        this.minisquarePanels = new JPanel[minisquareDimension][minisquareDimension];

        Border minisquareBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        for (int y = 0; y < minisquareDimension; ++y) {
            for (int x = 0; x < minisquareDimension; ++x) {
                JPanel minipanel = new JPanel();
                minipanel.setLayout(new GridLayout(minisquareDimension,
                        minisquareDimension));
                minipanel.setBorder(minisquareBorder);
                minisquarePanels[y][x] = minipanel;
                gridPanel.add(minipanel);
            }
        }

        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                int minisquareX = x / minisquareDimension;
                int minisquareY = y / minisquareDimension;

                minisquarePanels[minisquareY][minisquareX].add(grid[y][x]);
            }
        }

        gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));


        timerLabel.setFont(FONT);
        timerLabel.setBorder(BorderFactory.createBevelBorder(1));

        //Set elements to jframe
        frame.setJMenuBar(menuBar);
        for (JButton btn : btnlist)
            flowPanel.add(btn);
        flowPanel.add(clearbtn);

        mainPanel.add(timerPanel, BorderLayout.EAST);

        timerPanel.add(timerLabel);

        btnTimer.setEnabled(false);
        btmFlowPanel.add(btnTimer);
        btmFlowPanel.add(finishBtn);
        btmFlowPanel.add(checkSudokuBtn);
        btmFlowPanel.add(clearGridBtn);

        btnlist.stream().forEach(JButton -> JButton.setEnabled(false));

        lastFocusedTextField = grid[0][0];
        lastFocusedTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

        Arrays.stream(grid)
                .flatMap(Stream::of).forEach(jTextField -> jTextField.setBackground(Color.decode("#e6e6e6")));
        Arrays.stream(grid)
                .flatMap(Stream::of)
                .forEach(jTextField -> jTextField.addMouseListener(new MouseAdapter() {
                                                                       @Override
                                                                       public void mousePressed(MouseEvent e) {
                                                                           if (jTextField != lastFocusedTextField ) {
                                                                               lastFocusedTextField.setBorder(jTextField.getBorder());

                                                                           }
                                                                           lastFocusedTextField = jTextField;
                                                                           jTextField.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                                                                       }
                                                                   }
                ));
    }

    public ArrayList<JButton> getBtnlist() {
        return btnlist;
    }

    public JButton getClearbtn() {
        return clearbtn;
    }

    public JTextField getLastFocusedTextField() {
        return lastFocusedTextField;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JMenu getHelp() {
        return help;
    }

    public JMenu getAbout() {
        return about;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getHelpPanel() {
        return helpPanel;
    }

    public JToggleButton getBtnTimer() {
        return btnTimer;
    }

    public JButton getBackToMain() {
        return backToMain;
    }

    public JTextField[][] getGrid() {
        return grid;
    }

    public JMenuItem getNewGame() {
        return newGame;
    }

    public Map<JTextField, Point> getMapFieldToCoordinates() {
        return mapFieldToCoordinates;
    }

    public TimerLabel getTimerLabel() {
        return timerLabel;
    }

    public JButton getFinishBtn() {
        return finishBtn;
    }

    public JButton getCheckSudokuBtn() {
        return checkSudokuBtn;
    }

    public JButton getClearGridBtn() {
        return clearGridBtn;
    }
}


