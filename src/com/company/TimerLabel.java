package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerLabel extends JLabel {

    private Integer timePassed;
    private Timer timer;
    // Add in your code for 'format' and 'remainingTime'.
    // Note that the first time that 'getText' is called, it's called from the constructor
    // if the superclass, so your own class is not fully initialized at this point.
    // Hence the 'if (format != null)' check

    public TimerLabel() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timePassed += 1000;
                repaint();
            }
        });
    }

    public String getRemainingTime() {
        if (timePassed == null) {
            timePassed = 0;
        }

        int hours = this.timePassed / 3600000 % 60;
        int minutes = this.timePassed / 60000 % 60;
        int seconds = this.timePassed / 1000 % 60;

        return String.format("Timer: %02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public String getText() {
        //System.out.println(getRemainingTime());
        return getRemainingTime();
    }


    void startTimer() {
        timer.start();
    }

    void stopTimer() {
        timer.stop();
    }

    public Timer getTimer() {
        return timer;
    }

    void resetTimer() {
        timer.stop();
        timePassed = 0;
        repaint();
    }
}