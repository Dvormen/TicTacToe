import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;
/**
 * This class solves everything about 5x5 difficulty
 */
public class Difficulty2 implements ActionListener {
    JPanel title = new JPanel();
    JFrame frame = new JFrame();
    Random r1 = new Random();
    boolean p1turn;
    JLabel txt = new JLabel();
    JPanel button = new JPanel();
    JButton[][] buttons = new JButton[5][5];
    private boolean win = false;
    private int tie = 0;
    /**
     * This method does all the visuals and creates the buttons
     */
    Difficulty2() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        txt.setBackground(Color.BLUE);
        txt.setForeground(Color.RED);
        txt.setFont(new Font("Comic sans",Font.BOLD,80));
        txt.setHorizontalAlignment(JLabel.CENTER);
        txt.setText("TicTacToe");
        txt.setOpaque(true);
        title.setLayout(new BorderLayout());
        title.setBounds(0,0,900,150);
        button.setLayout(new GridLayout(5,5));
        button.setBackground(Color.MAGENTA);
        for(int i = 0; i < 5;i++) {
        for(int a = 0; a < 5;a++) {
            buttons[i][a] = new JButton();
            button.add(buttons[i][a]);
            buttons[i][a].setFont(new Font("Comic sans",Font.BOLD,130));
            buttons[i][a].setFocusable(false);
            buttons[i][a].addActionListener(this);
        }
        }
        title.add(txt);
        frame.add(title,BorderLayout.NORTH);
        frame.add(button);
        turn1D2();
    }
    /**
     * This method checks if there is a space in the given box and, if so, inserts the character of the player who did so
     * @param e pressing the button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 5; i++) {
        for(int a = 0; a < 5; a++) {
            if(e.getSource()== buttons[i][a]){
                if(p1turn) {
                    if(Objects.equals(buttons[i][a].getText(), "")){
                        buttons[i][a].setForeground(Color.RED);
                        buttons[i][a].setText("x");
                        p1turn = false;
                        txt.setText("P2 turn");
                        winCheckD2();
                    }
                }
                else{
                    if(Objects.equals(buttons[i][a].getText(), "")){
                        buttons[i][a].setForeground(Color.GREEN);
                        buttons[i][a].setText("o");
                        p1turn = true;
                        txt.setText("P1 turn");
                        winCheckD2();
                    }
                }
            }
        }
        }
    }
    /**
     * This method sets who is playing and changes the text to let players know who is playing and displays the name of the game
     */
    public void turn1D2(){
        try{
            Thread.sleep(1500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(r1.nextInt(2) == 0){
            p1turn = true;
            txt.setText("P1 Turn");
        }
        else {
            p1turn = false;
            txt.setText("P2 Turn");
        }
    }
    /**
     * This method checks all possibilities in a 4x4 square and then moves the control square around the board until it passes all winning combinations, or declares a tie when players have no moves left
     */
    public void winCheckD2(){
        for(int i = 0; i<4;i++){
            int a = 0;
            int b = 0;
            if(i == 1){
                a = 1;
            } else if (i == 2) {
                b = 1;
            } else if (i == 3) {
                a = 1;
                b = 1;
            }
            if(Objects.equals(buttons[a][b].getText(), "x") &&
                Objects.equals(buttons[a][1 + b].getText(), "x") &&
                Objects.equals(buttons[a][2 + b].getText(), "x") &&
                Objects.equals(buttons[a][3 + b].getText(), "x")) {
                win = true;
                p1Wins(a,b,a,1 + b,a,2 + b,a,3 + b); //1
        }
        if(Objects.equals(buttons[1 + a][b].getText(), "x") &&
                Objects.equals(buttons[1 + a][1 + b].getText(), "x") &&
                Objects.equals(buttons[1 + a][2 + b].getText(), "x") &&
                Objects.equals(buttons[1 + a][3 + b].getText(), "x") ){
            win = true;
            p1Wins(1 + a,b,1 + a,1 + b,1 + a,2 + b,1 + a,3 + b); //2
        }
        if(Objects.equals(buttons[2 + a][b].getText(), "x") &&
                Objects.equals(buttons[2 + a][1 + b].getText(), "x") &&
                Objects.equals(buttons[2 + a][2 + b].getText(), "x") &&
                Objects.equals(buttons[2 + a][3 + b].getText(), "x")) {
            win = true;
            p1Wins(2 + a,b,2 + a,1 + b,2 + a,2 + b,2 + a,3 + b); //3
        }
        if(Objects.equals(buttons[3 + a][b].getText(), "x") &&
                Objects.equals(buttons[3 + a][1 + b].getText(), "x") &&
                Objects.equals(buttons[3 + a][2 + b].getText(), "x") &&
                Objects.equals(buttons[3 + a][3 + b].getText(), "x") ){
            win = true;
            p1Wins(3 + a,b,3 + a,1 + b,3 + a,2 + b,3 + a,3 + b); //4
        }
        if(Objects.equals(buttons[a][b].getText(), "x") &&
                Objects.equals(buttons[1 + a][b].getText(), "x") &&
                Objects.equals(buttons[2 + a][b].getText(), "x") &&
                Objects.equals(buttons[3 + a][b].getText(), "x") ){
            win = true;
            p1Wins(a,b,1 + a,b,2 + a,b,3 + a,b); //5
        }
        if(Objects.equals(buttons[a][1 + b].getText(), "x") &&
                Objects.equals(buttons[1 + a][1 + b].getText(), "x") &&
                Objects.equals(buttons[2 + a][1 + b].getText(), "x") &&
                Objects.equals(buttons[3 + a][1 + b].getText(), "x")) {
            win = true;
            p1Wins(a,1 + b,1 + a,1 + b,2 + a,1 + b,3 + a,1 + b); //6
        }
        if(Objects.equals(buttons[a][2 + b].getText(), "x") &&
                Objects.equals(buttons[1 + a][2 + b].getText(), "x") &&
                Objects.equals(buttons[2 + a][2 + b].getText(), "x") &&
                Objects.equals(buttons[3 + a][2 + b].getText(), "x") ){
            win = true;
            p1Wins(a,2 + b,1 + a,2 + b,2 + a,2 + b,3 + a,2 + b); //7
        }
        if(Objects.equals(buttons[a][3 + b].getText(), "x") &&
                Objects.equals(buttons[1 + a][3 + b].getText(), "x") &&
                Objects.equals(buttons[2 + a][3 + b].getText(), "x") &&
                Objects.equals(buttons[3 + a][3 + b].getText(), "x") ){
            win = true;
            p1Wins(a,3 + b,1 + a,3 + b,2 + a,3 + b,3 + a,3 + b); //8
        }
        if(Objects.equals(buttons[a][b].getText(), "x") &&
                Objects.equals(buttons[1 + a][1 + b].getText(), "x") &&
                Objects.equals(buttons[2 + a][2 + b].getText(), "x") &&
                Objects.equals(buttons[3 + a][3 + b].getText(), "x") ){
            win = true;
            p1Wins(a,b,1 + a,1 + b,2 + a,2 + b,3 + a,3 + b); //9
        }
        if(Objects.equals(buttons[a][3 + b].getText(), "x") &&
                Objects.equals(buttons[1 + a][2 + b].getText(), "x") &&
                Objects.equals(buttons[2 + a][1 + b].getText(), "x") &&
                Objects.equals(buttons[3 + a][b].getText(), "x") ){
            win = true;
            p2Wins(a,3 + b,1 + a,2 + b,2 + a,1 + b,3 + a,b); //10
        }
        if(Objects.equals(buttons[a][b].getText(), "o") &&
                Objects.equals(buttons[a][1 + b].getText(), "o") &&
                Objects.equals(buttons[a][2 + b].getText(), "o") &&
                Objects.equals(buttons[a][3 + b].getText(), "o") ){
            win = true;
            p2Wins(a,b,a,1 + b,a,2 + b,a,3 + b); //1
        }
        if(Objects.equals(buttons[1 + a][b].getText(), "o") &&
                Objects.equals(buttons[1 + a][1 + b].getText(), "o") &&
                Objects.equals(buttons[1 + a][2 + b].getText(), "o") &&
                Objects.equals(buttons[1 + a][3 + b].getText(), "o") ){
            win = true;
            p2Wins(1 + a,b,1 + a,1 + b,1 + a,2 + b,1 + a,3 + b); //2
        }
        if(Objects.equals(buttons[2 + a][b].getText(), "o") &&
                Objects.equals(buttons[2 + a][1 + b].getText(), "o") &&
                Objects.equals(buttons[2 + a][2 + b].getText(), "o") &&
                Objects.equals(buttons[2 + a][3 + b].getText(), "o") ){
            win = true;
            p2Wins(2 + a,b,2 + a,1 + b,2 + a,2 + b,2 + a,3 + b); //3
        }
        if(Objects.equals(buttons[3 + a][b].getText(), "o") &&
                Objects.equals(buttons[3 + a][1 + b].getText(), "o") &&
                Objects.equals(buttons[3 + a][2 + b].getText(), "o") &&
                Objects.equals(buttons[3 + a][3 + b].getText(), "o") ){
            win = true;
            p2Wins(3 + a,b,3 + a,1 + b,3 + a,2 + b,3 + a,3 + b); //4
        }
        if(Objects.equals(buttons[a][b].getText(), "o") &&
                Objects.equals(buttons[1 + a][b].getText(), "o") &&
                Objects.equals(buttons[2 + a][b].getText(), "o") &&
                Objects.equals(buttons[3 + a][b].getText(), "o") ){
            win = true;
            p2Wins(a,b,1 + a,b,2 + a,b,3 + a,b); //5
        }
        if(Objects.equals(buttons[a][1 + b].getText(), "o") &&
                Objects.equals(buttons[1 + a][1 + b].getText(), "o") &&
                Objects.equals(buttons[2 + a][1 + b].getText(), "o") &&
                Objects.equals(buttons[3 + a][1 + b].getText(), "o") ){
            win = true;
            p2Wins(a,1 + b,1 + a,1 + b,2 + a,1 + b,3 + a,1 + b);
        }
        if(Objects.equals(buttons[a][2 + b].getText(), "o") &&
                Objects.equals(buttons[1 + a][2 + b].getText(), "o") &&
                Objects.equals(buttons[2 + a][2 + b].getText(), "o") &&
                Objects.equals(buttons[3 + a][2 + b].getText(), "o") ){
            win = true;
            p2Wins(a,2 + b,1 + a,2 + b,2 + a,2 + b,3 + a,2 + b);
        }
        if(Objects.equals(buttons[a][3 + b].getText(), "o") &&
                Objects.equals(buttons[1 + a][3 + b].getText(), "o") &&
                Objects.equals(buttons[2 + a][3 + b].getText(), "o") &&
                Objects.equals(buttons[3 + a][3 + b].getText(), "o") ){
            win = true;
            p2Wins(a,3 + b,1 + a,3 + b,2 + a,3 + b,3 + a,3 + b);
        }
        if(Objects.equals(buttons[a][b].getText(), "o") &&
                Objects.equals(buttons[1 + a][1 + b].getText(), "o") &&
                Objects.equals(buttons[2 + a][2 + b].getText(), "o") &&
                Objects.equals(buttons[3 + a][3 + b].getText(), "o") ){
            win = true;
            p2Wins(a,b,1 + a,1 + b,2 + a,2 + b,3 + a,3 + b);
        }
        if(Objects.equals(buttons[a][3 + b].getText(), "o") &&
                Objects.equals(buttons[1 + a][2 + b].getText(), "o") &&
                Objects.equals(buttons[2 + a][1 + b].getText(), "o") &&
                Objects.equals(buttons[3 + a][b].getText(), "o") ){
            win = true;
            p2Wins(a,3 + b,1 + a,2 + b,2 + a,1 + b,3 + a,b);
        }
        }
        tie++;
        if(tie == 25 && !win){
            for(int j=0;j<5;j++) {
                for(int t=0;t<5;t++) {
                    buttons[j][t].setEnabled(false);
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
     * @param g /input value of the coordinates of the button to be changed
     * @param h /input value of the coordinates of the button to be changed
     */
    public void p2Wins(int a,int b,int c,int d,int e,int f,int g,int h) {
        buttons[a][b].setBackground(Color.pink);
        buttons[c][d].setBackground(Color.pink);
        buttons[e][f].setBackground(Color.pink);
        buttons[g][h].setBackground(Color.pink);
                for(int i=0;i<5;i++) {
                    for(int t=0;t<5;t++) {
                        buttons[i][t].setEnabled(false);
                    }
                }
        txt.setText("P2 wins!");
            }

    /**
     * This method will change the color of the buttons that have met the win condition, and make it impossible for players to continue playing (because someone has won)
     * @param a  /input value of the coordinates of the button to be changed
     * @param b /input value of the coordinates of the button to be changed
     * @param c /input value of the coordinates of the button to be changed
     * @param d /input value of the coordinates of the button to be changed
     * @param e /input value of the coordinates of the button to be changed
     * @param f /input value of the coordinates of the button to be changed
     * @param g /input value of the coordinates of the button to be changed
     * @param h /input value of the coordinates of the button to be changed
     */
    public void p1Wins(int a,int b,int c,int d,int e,int f,int g,int h) {
        buttons[a][b].setBackground(Color.pink);
        buttons[c][d].setBackground(Color.pink);
        buttons[e][f].setBackground(Color.pink);
        buttons[g][h].setBackground(Color.pink);
        for(int i=0;i<5;i++) {
            for(int t=0;t<5;t++) {
                buttons[i][t].setEnabled(false);
            }
        }
        txt.setText("P1 wins!");
    }
}