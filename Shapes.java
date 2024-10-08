/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chapter5;

/**
 *
 * @author HP
 */
// Fig. 5.27: Shapes.java
import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel {

    private int choice;

    public Shapes(int userChoice) {
        choice = userChoice;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            switch (choice) {
                case 1:
                    g.drawRect(10 + i * 10, 10 + i * 10,
                            50 + i * 10, 50 + i * 10);
                    break;
                case 2:
                    g.drawOval(10 + i * 10, 10 + i * 10,
                            50 + i * 10, 50 + i * 10);
                    break;
            }
        }
    }
}