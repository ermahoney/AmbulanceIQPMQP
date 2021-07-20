
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImageTest implements ActionListener{
	
	private int count = 0;
//	private int I;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	
	public ImageTest() {
		
		frame = new JFrame(); 
		ImageIcon icon = new ImageIcon("C:\\Users\\bsnap\\OneDrive\\Documents\\Summer2021\\IQP\\AfghanistanMap.jpg");
//		JButton button = new JButton("Click me");
//		button.addActionListener(this);
		
		label = new JLabel(icon);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(1, 1, 10, 1));
		//panel.setBorder(BorderFactory.createEmptyBorder(413, 767, 413, 767));
		panel.setLayout(new GridLayout(0, 1));
//		panel.add(button);
//		panel.addMouseListener(new ImageTest());
//		panel.addMouseListener(1);
		panel.add(label);
		
		final JTextField text = new JTextField();;
	    frame.add(text,BorderLayout.SOUTH);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.addMouseListener(new MouseListener() {
	        public void mousePressed(MouseEvent me) { }
	        public void mouseReleased(MouseEvent me) { }
	        public void mouseEntered(MouseEvent me) { }
	        public void mouseExited(MouseEvent me) { }
	        public void mouseClicked(MouseEvent me) { 
	          int x = me.getX();
	          int y = me.getY();
	          text.setText("X:" + x + " Y:" + y); 
	        }
	    });
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Interactive Afghanistan Map");
		frame.pack();
		frame.setVisible(true);

	}
	public static void main(String[] args) {
		new ImageTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;		
		label.setText("Number of clicks: " + count);
	}
	public void mouseClicked(MouseEvent me) {
	    int screenX = me.getXOnScreen();
	    int screenY = me.getYOnScreen();
	    System.out.println("screen(X,Y) = " + screenX + "," + screenY);
	  }
}
