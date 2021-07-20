import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class TestPane extends JPanel {

        Image image;
        private Point drawPoint;

        public TestPane() {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            image = 
toolkit.getImage("C:\\Users\\Toshiba\\Desktop\\Java\\Icons\\p.png");

            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    drawPoint = new Point(e.getPoint());
                    repaint();
                }

        });
    }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (drawPoint != null) {
                g2d.drawImage(image, drawPoint.x, drawPoint.y, this);
            }
            g2d.dispose();
        }

}



