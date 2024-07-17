/*
How to run:     java -ea LandscapeTests
*/

import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10, .25);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 2: testing reset()
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10, .25);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);
            l1.reset();
            l2.reset();
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in reset";
            assert l2 != null : "Error in reset";
            
        }

        // case 3: testing getRows()
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10, .25);

            // verify
            System.out.println(l1.getRows() + " = 2");
            System.out.println(l2.getRows() + " = 10");

            // test
            assert l1 != null : "Error in reset";
            assert l2 != null : "Error in reset";
        }

        // case 4: testing getCols()
        {
           // set up
           Landscape l1 = new Landscape(2, 4);
           Landscape l2 = new Landscape(10, 10, .25);

           // verify
           System.out.println(l1.getCols() + " = 4");
           System.out.println(l2.getCols() + " = 10");

           // test
           assert l1 != null : "Error in reset";
           assert l2 != null : "Error in reset";
        }

        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10, .25);

            // verify
            System.out.println(l1.getCell(1,3) );
            System.out.println(l2.getCell(8,9) );

            // test
            assert l1 != null : "Error in reset";
            assert l2 != null : "Error in reset";

        }

        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10, .25);

            // verify
            System.out.println(l1.getNeighbors(1,3));
            System.out.println(l2.getNeighbors(2,7) );

            // test
            assert l1 != null : "Error in reset";
            assert l2 != null : "Error in reset";

        }

        // case 7: testing advance()
        {
           // set up
           Landscape l1 = new Landscape(2, 4);
           Landscape l2 = new Landscape(10, 10, .25);

           // verify
           System.out.println(l1);
           System.out.println(l2);
           l1.advance();
           l2.advance();
           System.out.println(l1);
           System.out.println(l2);

           // test
           assert l1 != null : "Error in reset";
           assert l2 != null : "Error in reset";

        }

    }


    public static void main(String[] args) {

        landscapeTests();
    }
}