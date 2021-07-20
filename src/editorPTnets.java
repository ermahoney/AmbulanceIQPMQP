import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.imageio.ImageIO;

public class editorPTnets {
	
	private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    
    public editorPTnets(){
        JFrame f = new JFrame("P/T nets");
        f.setSize(800, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.gray);
        f.add(new TestPane());
        f.setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setBounds(5, 50, 760, 400);
        p.setBackground(Color.white);
        f.add(p);
        p.setVisible(true);


        b1 = new JButton("");
        b1.setBounds(5, 5, 40, 40);
        b1.setVisible(true);
        b1.setIcon(new 
ImageIcon("C:\\Users\\Toshiba\\Desktop\\Java\\Icons\\new.png"));
        f.add(b1);
        
        b2 = new JButton("");
        b2.setBounds(50, 5, 40, 40);
        b2.setIcon(new 
ImageIcon("C:\\Users\\Toshiba\\Desktop\\Java\\Icons\\open.png"));
        b2.setVisible(true);
        f.add(b2);

        f.setVisible(true);

}
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new editorPTnets();
        System.out.println("Hello, world");

    }
}
