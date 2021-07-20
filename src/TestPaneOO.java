import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TestPaneOO extends JPanel {

        private BufferedImage image;
        private Point drawPoint;

        public TestPaneOO() {
            try {
                image = ImageIO.read(getClass().getResource("C:\\Users\\bsnap\\OneDrive\\Documents\\Summer2021\\IQP\\PinFieldHospital.jpg"));
                addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        drawPoint = new Point(e.getPoint());
                        repaint();
                    }

                });
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
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