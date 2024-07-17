/*Katie Bernard
 * 9/26/22
 * LifeSimulation.java
 */
import java.util.Scanner;  // Import the Scanner class
public class LifeSimulation {
    public static void main(String[]args){
    
        Scanner rows = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many rows should the landscape have?");
        String r = rows.nextLine();  // Read user input
        int rowsInt = Integer.parseInt(r); //Parse into int

        Scanner columns = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many columns should the landscape have?");
        String c = columns.nextLine();  // Read user input
        int columnsInt = Integer.parseInt(c); //Parse into int

        Scanner times = new Scanner(System.in);  // Create a Scanner object
        System.out.println("How many times should we advance the simulation?");
        String t = times.nextLine();  // Read user input
        int timesInt = Integer.parseInt(t); //Parse into int

        Scanner chance = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What should be the percent of cells starting alive? (Type as a decimal)");
        String ch = chance.nextLine();  // Read user input
        double chanceDouble=Double.parseDouble(ch);  


        Landscape l = new Landscape(rowsInt, columnsInt, chanceDouble);
        LandscapeDisplay display = new LandscapeDisplay(l,30);

        for(int i = 0; i<timesInt; i++){
            l.advance();
            display.repaint();
            try{
                Thread.sleep( 250 );
            }
            catch (InterruptedException e){
                //i=0;
                System.out.println("Exception Thrown");
            }
            
        }
    }
}