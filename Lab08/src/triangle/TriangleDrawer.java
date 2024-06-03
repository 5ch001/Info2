package triangle;

import java.awt.*;
import javax.swing.*;

public class TriangleDrawer extends JPanel {
    // Vertex coordinates
    private final int[] xPoints;
    private final int[] yPoints;

    // Constructor accepting vertex coordinates
    public TriangleDrawer(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    // Overriding the paintComponent method to draw the triangle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawPolygon(xPoints, yPoints, 3);
    }

    // Main method to create the frame and display the triangle
    public static void main(String[] args) {
        // Define the coordinates of the triangle vertices
        int[] xPoints = {100, 150, 50};
        int[] yPoints = {50, 150, 150};

        JFrame frame = new JFrame("Draw Triangle");
        TriangleDrawer triangle = new TriangleDrawer(xPoints, yPoints);
        frame.add(triangle);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}