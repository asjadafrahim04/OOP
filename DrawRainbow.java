/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class DrawRainbow extends JPanel
{
    private final static Color VIOLET = new Color(128, 0, 128);
    private final static Color INDIGO = new Color(75, 0, 130);

    private Color[] colors =
            { Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
                    Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED };

    // This field will store the user's selection
    private int userSelection;

    public DrawRainbow()
    {
        setBackground(Color.WHITE);

        // Ask the user for input when the panel is created
        String input = JOptionPane.showInputDialog(null,
                "Enter which rainbow to display (1 = Top, 2 = Bottom, 3 = Left, 4 = Right):");

        // Parse input, set default to 0 (none) if invalid
        try {
            userSelection = Integer.parseInt(input);
            if (userSelection < 1 || userSelection > 4) {
                userSelection = 0; // invalid input
            }
        } catch (NumberFormatException e) {
            userSelection = 0; // invalid input
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int radius = 20;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Draw based on the user's input
        switch (userSelection) {
            case 1:
                // Top rainbow
                drawRainbow(g, centerX, 10, radius, 180, 180);
                break;
            case 2:
                // Bottom rainbow
                drawRainbow(g, centerX, getHeight() - 10, radius, 0, 180);
                break;
            case 3:
                // Left rainbow
                drawRainbow(g, 10, centerY, radius, 90, -180);
                break;
            case 4:
                // Right rainbow
                drawRainbow(g, getWidth() - 10, centerY, radius, 270, -180);
                break;
            default:
                // If input is invalid, don't draw anything
                g.drawString("Invalid input! Please enter a number between 1 and 4.", centerX - 100, centerY);
                break;
        }
    }

    private void drawRainbow(Graphics g, int centerX, int centerY, int radius, int startAngle, int arcAngle) {
        // Draw each arc for the rainbow with specified start and arc angles
        for (int counter = colors.length; counter > 0; counter--) {
            g.setColor(colors[counter - 1]);
            g.fillArc(centerX - counter * radius,
                    centerY - counter * radius,
                    counter * radius * 2, counter * radius * 2, startAngle, arcAngle);
        }
    }
}