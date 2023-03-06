package  com.Mygame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;




public class MyGame extends JFrame implements ActionListener {

    JLabel heading, clockLable;
    Font font = new Font("", Font.BOLD, 40);
    JPanel mainPanel;
    JButton[] btns = new JButton[9];

    int gameChances[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int activePlayer = 0;
    int wps[][] = {
            {0, 1, 2},
            {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}
    };
    int winner = 2;

    MyGame() {
        setTitle("My Tic Tac Toe Game...");
        setSize(550, 550);
        ImageIcon icon = new ImageIcon("src/img/logo.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        createGUI();
        setVisible(true);
    }

    private void createGUI() {
        this.getContentPane().setBackground(Color.decode("#2196f3"));
        this.setLayout(new BorderLayout());
        // north heading.....
        heading = new JLabel("Tic Tac Toe");
        heading.setFont(font);
        heading.setForeground(Color.white);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(heading, BorderLayout.NORTH);

        // creating object ...
        clockLable = new JLabel("Rishabh");
        clockLable.setFont(font);
        clockLable.setForeground(Color.white);
        clockLable.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(clockLable, BorderLayout.SOUTH);

//        Thread t = new Thread(){
//            public void run(){
//                try {
//                    while(true){
//
//
//                        String datetime = new Date().toLocaleString();
//                         clockLable.setText(datetime);
//
//                         Thread.sleep(1000);
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        };
        //  t.start();

        // panel section...

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton();
            btn.setFont(font);
            btn.setBackground(Color.yellow);
            mainPanel.add(btn);
            btns[i - 1] = btn;
            btn.addActionListener(this);
            btn.setName(String.valueOf(i - 1));
        }
        this.add(mainPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentButton = (JButton) e.getSource();

        String nameStr = currentButton.getName();
        int name = Integer.parseInt(nameStr.trim());
        ImageIcon i1 = new ImageIcon("src/img/o.jpg");
        Image x = i1.getImage();
        Image n1 = x.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon("src/img/x.jpg");
        Image x2 = i2.getImage();
        Image n2 = x2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        if (gameChances[name] == 2) {
            if (activePlayer == 1) {
                currentButton.setIcon(new ImageIcon(n1));
                gameChances[name] = activePlayer;
                activePlayer = 0;
            } else {
                currentButton.setIcon(new ImageIcon(n2));
                gameChances[name] = activePlayer;
                activePlayer = 1;
            }
            for (int[] temp : wps) {
                if ((gameChances[temp[0]] == gameChances[temp[1]]) && (gameChances[temp[1]] == gameChances[temp[2]]) && (gameChances[temp[2]] != 2)) {
                    winner = gameChances[temp[0]];
                    JOptionPane.showMessageDialog(null, "Player " + winner + " has won the game..");
                    break;
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "already fill");
        }

    }

    public static void main(String[] args) {
        MyGame  game = new MyGame();

    }
}



