/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chapter6;

/**
 *
 * @author HP
 */
// Fig. 6.12: DrawSmileyTest.java
import javax.swing.JFrame;

public class DrawSmileyTest {

    public static void main(String[] args) {
        DrawSmiley panel = new DrawSmiley();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
