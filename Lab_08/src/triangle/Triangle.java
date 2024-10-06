package triangle;

import resizable.ResizableImage;

import java.awt.*;
import java.awt.image.BufferedImage;

import static resizable.Debug.print;

public class Triangle implements ResizableImage {
    int drawTriangle = 0;

    /**
     * Change this method to implement the triangle!
     * @param size the outer bounds of the triangle
     * @return an Image containing the Triangle
     */
    private BufferedImage drawTriangle(Dimension size) {
        print("drawTriangle: " + ++drawTriangle + " size: " + size);
        BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gBuffer = (Graphics2D) bufferedImage.getGraphics();
        gBuffer.setColor(Color.black);

        // Calculate the vertices of the equilateral triangle
        int height = (int) (Math.sqrt(3) / 2 * size.width);
        int[] xPoints = {size.width / 2, 0, size.width};
        int[] yPoints = {0, height, height};

        // Draw the main equilateral triangle
        gBuffer.drawPolygon(xPoints, yPoints, 3);

        // Define colors for each recursion level
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.ORANGE};

        // Recursively draw smaller triangles
        drawSierpinski(gBuffer, xPoints, yPoints, 4, colors, 0);

        return bufferedImage;
    }

    private void drawSierpinski(Graphics2D g, int[] xPoints, int[] yPoints, int depth, Color[] colors, int level) {
        if (depth == 0) return;

        // Set the color for the current level
        g.setColor(colors[level % colors.length]);

        // Calculate midpoints of the triangle sides
        int[] midX = {
                (xPoints[0] + xPoints[1]) / 2,
                (xPoints[1] + xPoints[2]) / 2,
                (xPoints[2] + xPoints[0]) / 2
        };
        int[] midY = {
                (yPoints[0] + yPoints[1]) / 2,
                (yPoints[1] + yPoints[2]) / 2,
                (yPoints[2] + yPoints[0]) / 2
        };

        // Draw the inner triangle
        g.drawPolygon(midX, midY, 3);

        // Recursively draw the three outer triangles
        drawSierpinski(g, new int[]{xPoints[0], midX[0], midX[2]}, new int[]{yPoints[0], midY[0], midY[2]}, depth - 1, colors, level + 1);
        drawSierpinski(g, new int[]{midX[0], xPoints[1], midX[1]}, new int[]{midY[0], yPoints[1], midY[1]}, depth - 1, colors, level + 1);
        drawSierpinski(g, new int[]{midX[2], midX[1], xPoints[2]}, new int[]{midY[2], midY[1], yPoints[2]}, depth - 1, colors, level + 1);
    }

    BufferedImage bufferedImage;
    Dimension bufferedImageSize;

    @Override
    public Image getImage(Dimension triangleSize) {
        if (triangleSize.equals(bufferedImageSize))
            return bufferedImage;
        bufferedImage = drawTriangle(triangleSize);
        bufferedImageSize = triangleSize;
        return bufferedImage;
    }

    @Override
    public Image getResizeImage(Dimension size) {
        BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gBuffer = (Graphics2D) bufferedImage.getGraphics();
        gBuffer.setColor(Color.pink);
        int border = 2;
        gBuffer.drawRect(border, border, size.width - 2 * border, size.height - 2 * border);
        return bufferedImage;
    }
}
