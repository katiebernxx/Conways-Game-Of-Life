/*Katie Bernard
 * 9/26/22
 * Cell.java
 */
import java.util.ArrayList;

public class Cell {
    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        alive = status;
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        if( alive == true){
            return true;}
        else {return false;}
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        int deads = 0;
        int alives = 0;
        for(int i = 0; i<neighbors.size(); i++){ //For loop keeps track of amts of alive and dead neighbors
            Cell index = neighbors.get(i);
            if(index.getAlive() == false){
                deads ++;
            }
            if(index.getAlive() == true){
                alives ++;
            }
        }
        if(alive == true){
            if((alives==2)||(alives == 3)){
                alive = true; //if 2 or 3 live neighbors, cell stays alive
            }
            else{ alive = false;} //otherwise, it dies
        }
        else{
            if(alives == 3){
                alive = true; //If dead but has 3 live neighbors, it becomes alive
            }
            else{ alive = false;} //otherwise, it stays dead
        }
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if(alive == true){return "1";}
        else { return "0";}
    }

    public static void main (String[]args){
        Cell c = new Cell(true);
        c.setAlive(false);
        System.out.println(c.getAlive());
        System.out.println(c);
    }
}