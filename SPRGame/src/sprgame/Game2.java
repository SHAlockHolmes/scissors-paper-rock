/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sprgame;

/**
 *
 * @author Cheryl Andrea
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game2 implements ActionListener
{
    JFrame start, m, fin;
    JButton s, f, reset;
    JLabel wol = new JLabel();
    JLabel Win_ctr = new JLabel("Wins: ");
    JLabel comp = new JLabel();    
    JLabel wins = new JLabel(); 
    JButton user[] = new JButton[3];
    
    Font font = new Font("Pixel Emulator", Font.PLAIN, 20);
    Font fonts = new Font("Pixel Emulator", Font.PLAIN, 14);
    
    Color c = new Color(255, 231, 214);
    Color b = new Color(234, 239, 210);
    
    static int userwins=0, compwins=0, ties=0;
    
    Icon scissors = new ImageIcon("C:\\CIA3_Java\\scissorspx.png");
    Icon paper = new ImageIcon("C:\\CIA3_Java\\paperpx.png");
    Icon rock = new ImageIcon("C:\\CIA3_Java\\rockpx.png");
    Icon rules = new ImageIcon("C:\\CIA3_Java\\Rulespx.png");
    Icon blank = new ImageIcon();
    
    Game2()
    {
        start = new JFrame("Start");
        m = new JFrame("Scissors-paper-rock");
        fin = new JFrame("Finish");
        
        start.setSize(415,550);
        start.setLocationRelativeTo(null);
        start.setLayout(null);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.getContentPane().setBackground(c);
        
        s = new JButton("Start Game");           
        s.setBounds(125, 400, 150, 50);
        s.setBackground(new Color(203, 192, 211));
        start.add(s);
        s.addActionListener(this);        
        
        JLabel rule = new JLabel(rules);
        rule.setBounds(25, 25, 350, 350);
        rule.setLayout(null);
        start.add(rule);
        start.setVisible(true);
        
        m.setSize(700,500);
        m.setLocationRelativeTo(null);
        m.setLayout(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.getContentPane().setBackground(c);
        
        fin.setSize(500, 300);
        fin.setLocationRelativeTo(null);
        fin.setLayout(null);
        fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fin.getContentPane().setBackground(c);
    }
    
    void spr()
    {
        int i, x=70, y=70;
        JLabel t1 = new JLabel("Your Moves: ");        
        JLabel t2 = new JLabel("Computer's Moves: ");
        t1.setBounds(70, 45, 200, 30);
        t2.setBounds(450, 45, 200, 30);
        t1.setFont(fonts);
        t2.setFont(fonts);
        m.add(t1);
        m.add(t2);
        
        user[0] = new JButton(scissors);
        user[1] = new JButton(paper);
        user[2] = new JButton(rock);
        for(i=0; i<3; i++)
        {            
            user[i].setBounds(x, y, 80, 150);
            user[i].setBackground(b);
            x=x+100;
            m.add(user[i]);
            user[i].addActionListener(this);
        }
        wol.setText(""); //wol is a label that shows if the user won or lost that round
        
        Win_ctr.setBounds(350,350,100,40);
        Win_ctr.setFont(font);        
        wins.setBounds(455,350,60,40);
        wins.setText(String.valueOf(userwins));
        wins.setFont(font);        
        m.add(Win_ctr);
        m.add(wins);
        
        f=new JButton("End Game");
        f.setBounds(185, 350, 100, 50);
        f.setBackground(new Color(203, 192, 211));
        m.add(f);
        f.addActionListener(this);
        
        reset=new JButton("Reset");
        reset.setBounds(70, 350, 100, 50);
        reset.setBackground(new Color(203, 192, 211));
        m.add(reset);
        reset.addActionListener(this);
        
        m.setVisible(true);
    }
    
    int computer() // computer's code
    {
        int r=0;
        comp.setIcon(blank);
        
        r=(int)((Math.random() * (3 - 0)) + 0);
        if(r==0)
            comp.setIcon(scissors);
        else if(r==1)
            comp.setIcon(paper);
        else if(r==2)
            comp.setIcon(rock);
        
        comp.setBounds(475, 70, 80, 150);        
        m.add(comp);
        m.setVisible(true);
        return r;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        int compres=0;
        if(e.getSource().equals(s))
        {
            start.setVisible(false);
            m.setVisible(true);
            spr();
        }
        else if(e.getSource().equals(user[0]))
        {
            compres=computer();
            WinOrLose(compres,0);
        }
        else if(e.getSource().equals(user[1]))
        {
            compres=computer();
            WinOrLose(compres,1);
        }
        else if(e.getSource().equals(user[2]))
        {
            compres=computer(); 
            WinOrLose(compres,2);
        }
        else if(e.getSource().equals(f))
        {
            m.setVisible(false);
            fin.setVisible(true);
            results();
        }
        else if(e.getSource().equals(reset))
        {
            userwins=0;
            compwins=0;
            ties=0;
            wins.setText("");
            wol.setText("");
            comp.setIcon(blank);
        }
            
    }
    
    void WinOrLose(int compres, int in)
    {
        //0 is scissors, 1 is paper, 2 is rock
        wol.setBounds(150, 200, 200, 100);
        wol.setFont(font);
        m.add(wol);
       
        if(in==0 && compres==1 )
        {
            wol.setText("You Win!");
            userwins++;
            wins.setText(String.valueOf(userwins));
        }
        else if(in==1 && compres==2)
        {
            wol.setText("You Win!");
            userwins++;
            wins.setText(String.valueOf(userwins));
        }
        else if(in==2 && compres==0)
        {
            wol.setText("You Win!");
            userwins++;
            wins.setText(String.valueOf(userwins));
        }
        else if (in==compres)
        {
            wol.setText("It's a tie");
            ties++;
        }
        else
        {
            wol.setText("You Lost");
            compwins++;
        }
    }
    
    void results()
    {
        JLabel l11, l12, l21, l22, l31, l32, l41, l42;        
        
        fin.setLayout(new GridLayout(4,2));    
        
        l11 = new JLabel("  User Wins");
        l12 = new JLabel(String.valueOf(userwins));        
        
        l21 = new JLabel("  Computer Wins");        
        l22 = new JLabel(String.valueOf(compwins));
      
        l31 = new JLabel("  Ties");        
        l32 = new JLabel(String.valueOf(ties));
        
        l41 = new JLabel("  Result of the match: ");        
        l42 = new JLabel();
        
        if(userwins>compwins)
           l42.setText("You win!!!");
        else if(compwins>userwins)
            l42.setText("Sorry!! You lost");
        else
            l42.setText("It's a tie.");
        
        l11.setFont(fonts); l12.setFont(fonts);
        l21.setFont(fonts); l22.setFont(fonts);
        l31.setFont(fonts); l32.setFont(fonts);
        l41.setFont(fonts); l42.setFont(fonts);
        
        fin.add(l11); fin.add(l12);
        fin.add(l21); fin.add(l22);
        fin.add(l31); fin.add(l32); 
        fin.add(l41); fin.add(l42);
    }
    public static void main(String args[])
    {
        Game2 g = new Game2();
    }
}
