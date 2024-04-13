import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * This class solves everything about 3x3 difficulty
 */
public class Difficulty1 implements ActionListener{
    JPanel title = new JPanel();
    JFrame frame = new JFrame();
    Random r1 = new Random();
    private boolean p1turn;
    JLabel txt = new JLabel();
    JPanel button = new JPanel();
    JButton[][] buttons = new JButton[3][3];
    private int tie = 0;
    private boolean win = false;

    /**
     * This method does all the visuals and creates the buttons
     */
    Difficulty1(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        txt.setBackground(Color.magenta);
        txt.setForeground(Color.CYAN);
        txt.setFont(new Font("Raven",Font.BOLD,80));
        txt.setHorizontalAlignment(JLabel.CENTER);
        txt.setText("TicTacToe");
        txt.setOpaque(true);
        title.setLayout(new BorderLayout());
        title.setBounds(800,800,900,150);
        button.setLayout(new GridLayout(3,3));
        button.setBackground(Color.green);
        for(int i = 0 ;i < 3;i++){
            for(int a = 0 ;a < 3;a++){
            buttons[i][a] = new JButton();
            button.add(buttons[i][a]);
            buttons[i][a].setFont(new Font("Urgot",Font.BOLD,130));
            buttons[i][a].setFocusable(false);
            buttons[i][a].addActionListener(this);
            }
        }
        title.add(txt);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button);
        turn1();
    }

    /**
     * This method checks if there is a space in the given box and, if so, inserts the character of the player who did so
     * @param e pressing the button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<3;i++) {
            for(int a=0;a<3;a++) {
            if(e.getSource()==buttons[i][a]) {
                if(p1turn) {
                    if(Objects.equals(buttons[i][a].getText(), "")) {
                        buttons[i][a].setForeground(Color.magenta);
                        buttons[i][a].setText("x");
                        p1turn=false;
                        txt.setText("P1 turn");
                        wincheck();
                    }
                }
                else {
                    if(Objects.equals(buttons[i][a].getText(), "")) {
                        buttons[i][a].setForeground(Color.blue);
                        buttons[i][a].setText("o");
                        p1turn=true;
                        txt.setText("P2 turn");
                        wincheck();
                    }
                }
            }
        }
        }
    }

    /**
     * This method sets who is playing and changes the text to let players know who is playing and displays the name of the game
     */
    public void turn1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(r1.nextInt(2)==0) {
            p1turn=true;
            txt.setText("P2 turn");
        }
        else {
            p1turn=false;
            txt.setText("P1 turn");
        }
    }

    /**
     *This method checks all winning possibilities, or declares a draw when players have no moves left
     */
    public void wincheck() {
        if(     (Objects.equals(buttons[0][0].getText(), "x")) &&
                (Objects.equals(buttons[0][1].getText(), "x")) &&
                (Objects.equals(buttons[0][2].getText(), "x"))){
            win = true;
            p1Wins(0,0,0,1,0,2);
        }
        if(     (Objects.equals(buttons[1][0].getText(), "x")) &&
                (Objects.equals(buttons[1][1].getText(), "x")) &&
                (Objects.equals(buttons[1][2].getText(), "x"))) {
            win = true;
            p1Wins(1,0,1,1,1,2);
        }
        if(     (Objects.equals(buttons[2][0].getText(), "x")) &&
                (Objects.equals(buttons[2][1].getText(), "x")) &&
                (Objects.equals(buttons[2][2].getText(), "x"))) {
            win = true;
            p1Wins(2,0,2,1,2,2);
        }
        if(     (Objects.equals(buttons[0][0].getText(), "x")) &&
                (Objects.equals(buttons[1][0].getText(), "x")) &&
                (Objects.equals(buttons[2][0].getText(), "x"))) {
            win = true;
            p1Wins(0,0,1,0,2,0);
        }
        if(     (Objects.equals(buttons[0][1].getText(), "x")) &&
                (Objects.equals(buttons[1][1].getText(), "x")) &&
                (Objects.equals(buttons[2][1].getText(), "x"))) {
            win = true;
            p1Wins(0,1,1,1,2,1);
        }
        if(     (Objects.equals(buttons[0][2].getText(), "x")) &&
                (Objects.equals(buttons[1][2].getText(), "x")) &&
                (Objects.equals(buttons[2][2].getText(), "x"))) {
            win = true;
            p1Wins(0,2,1,2,2,2);
        }
        if(     (Objects.equals(buttons[0][0].getText(), "x")) &&
                (Objects.equals(buttons[1][1].getText(), "x")) &&
                (Objects.equals(buttons[2][2].getText(), "x"))) {
            win = true;
            p1Wins(0,0,1,1,2,2);
        }
        if(     (Objects.equals(buttons[0][2].getText(), "x")) &&
                (Objects.equals(buttons[1][1].getText(), "x")) &&
                (Objects.equals(buttons[2][0].getText(), "x"))) {
            win = true;
            p1Wins(0,2,1,1,2,0);
        }
        if(     (Objects.equals(buttons[0][0].getText(), "o")) &&
                (Objects.equals(buttons[0][1].getText(), "o")) &&
                (Objects.equals(buttons[0][2].getText(), "o"))) {
            win = true;
            p2Wins(0,0,0,1,0,2);
        }
        if(     (Objects.equals(buttons[1][0].getText(), "o")) &&
                (Objects.equals(buttons[1][1].getText(), "o")) &&
                (Objects.equals(buttons[1][2].getText(), "o"))) {
            win = true;
            p2Wins(1,0,1,1,1,2);
        }
        if(     (Objects.equals(buttons[2][0].getText(), "o")) &&
                (Objects.equals(buttons[2][1].getText(), "o")) &&
                (Objects.equals(buttons[2][2].getText(), "o"))) {
            win = true;
            p2Wins(2,0,2,1,2,2);
        }
        if(     (Objects.equals(buttons[0][0].getText(), "o")) &&
                (Objects.equals(buttons[1][0].getText(), "o")) &&
                (Objects.equals(buttons[2][0].getText(), "o"))) {
            win = true;
            p2Wins(0,0,1,0,2,0);
        }
        if(     (Objects.equals(buttons[0][1].getText(), "o")) &&
                (Objects.equals(buttons[1][1].getText(), "o")) &&
                (Objects.equals(buttons[2][1].getText(), "o"))) {
            win = true;
            p2Wins(0,1,1,1,2,1);
        }
        if(     (Objects.equals(buttons[0][2].getText(), "o")) &&
                (Objects.equals(buttons[1][2].getText(), "o")) &&
                (Objects.equals(buttons[2][2].getText(), "o"))) {
            win = true;
            p2Wins(0,2,1,2,2,2);
        }
        if(     (Objects.equals(buttons[0][0].getText(), "o")) &&
                (Objects.equals(buttons[1][1].getText(), "o")) &&
                (Objects.equals(buttons[2][2].getText(), "o"))) {
            win = true;
            p2Wins(0,0,1,1,2,2);
        }
        if(     (Objects.equals(buttons[0][2].getText(), "o")) &&
                (Objects.equals(buttons[1][1].getText(), "o")) &&
                (Objects.equals(buttons[2][0].getText(), "o"))) {
            win = true;
            p2Wins(0,2,1,1,2,0);
        }
        tie++;
        if(tie == 9 && !win){
            for(int i=0;i<3;i++) {
                for(int t=0;t<3;t++) {
                    buttons[i][t].setEnabled(false);
                }
            }
            txt.setText("Tie!");
        }
    }

    /**
     * This method will change the color of the buttons that have met the win condition, and make it impossible for players to continue playing (because someone has won)
     * @param a /input value of the coordinates of the button to be changed
     * @param b /input value of the coordinates of the button to be changed
     * @param c /input value of the coordinates of the button to be changed
     * @param d /input value of the coordinates of the button to be changed
     * @param e /input value of the coordinates of the button to be changed
     * @param f /input value of the coordinates of the button to be changed
     */
    public void p1Wins(int a,int b,int c,int d,int e, int f) {
        buttons[a][b].setBackground(Color.pink);
        buttons[c][d].setBackground(Color.pink);
        buttons[e][f].setBackground(Color.pink);
        for(int i=0;i<3;i++) {
        for(int t=0;t<3;t++) {
            buttons[i][t].setEnabled(false);
        }
        }
        txt.setText("P2 wins!");
    }

    /**
     * This method will change the color of the buttons that have met the win condition, and make it impossible for players to continue playing (because someone has won)
     * @param  a /input value of the coordinates of the button to be changed
     * @param  b /input value of the coordinates of the button to be changed
     * @param  c /input value of the coordinates of the button to be changed
     * @param  d /input value of the coordinates of the button to be changed
     * @param  e /input value of the coordinates of the button to be changed
     * @param  f /input value of the coordinates of the button to be changed
     */
    public void p2Wins(int a, int b, int c, int d, int e, int f) {
        buttons[a][b].setBackground(Color.pink);
        buttons[c][d].setBackground(Color.pink);
        buttons[e][f].setBackground(Color.pink);
        for(int i=0;i<3;i++) {
        for(int t=0;t<3;t++) {
            buttons[i][t].setEnabled(false);
        }
        }
        txt.setText("P1 wins!");
    }
}