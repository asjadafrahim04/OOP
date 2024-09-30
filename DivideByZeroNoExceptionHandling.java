/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CH11;

/**
 *
 * @author admin
 */
//Fig. 11.2 : DivideByZeroNoExceptionHandling
import java.util.Scanner;
public class DivideByZeroNoExceptionHandling
 {
 public static int quotient(int numerator, int denominator)
{
    return numerator / denominator;
}
 public static void main(String[] args)
 {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Please enter an integer numerator: ");
 int numerator = scanner.nextInt();
 System.out.print("Please enter an integer denominator: ");
int denominator = scanner.nextInt();
int result = quotient(numerator, denominator);
System.out.printf("%nResult: %d / %d = %d%n", numerator, denominator, result);
 }
 }