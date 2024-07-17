/*Katie Bernard
 * 9/26/22
 * Landscape.java
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {

    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        landscape = new Cell[rows][columns];
        Cell freshcell = new Cell(false);
        initialChance = 0;
        for(int r = 0; r<rows; r++){
            for (int c = 0; c<columns; c++){
                landscape[r][c] = freshcell;
            }
        }
       // reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        initialChance = chance;
        Random rand = new Random();
        for(int r = 0; r<rows; r++){
            for (int c = 0; c<columns; c++){
                landscape[r][c] = new Cell(rand.nextDouble() < chance);
                //System.out.print(landscape[r][c]+ " ");
            }
        }
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        landscape = new Cell[landscape.length][landscape[0].length];
        Random rand = new Random();
        for(int r = 0; r<landscape.length; r++){
            for (int c = 0; c<landscape[r].length; c++){
                landscape[r][c] = new Cell(rand.nextDouble() < initialChance);
            }
        }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String toReturn = "";
        for(int r = 0; r < landscape.length; r++){
            for (int c = 0; c<landscape[r].length; c++){
                toReturn += landscape[r][c] + " ";
            }
            toReturn += "\n";
        } return toReturn;
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        Cell newcell = new Cell();

        for(int r = row-1; r <= row+1; r++){
            for(int c = col-1; c <= col+1; c++){
                if(r >= 0 && r < landscape.length && c >= 0 && c < landscape[r].length && !(r == row && c==col)){
                    neighbors.add(landscape[r][c]);
                }
            }
        }
        return neighbors;
    }

    /**
     * Advances the current Landscape by one step. 
     */
    public void advance() {
        Cell[][] tempGrid = new Cell[landscape.length][landscape[0].length];
        //copying landscape over to tempGrid
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++){
                tempGrid[x][y] = landscape[x][y];
            }
        }
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++){
                ArrayList<Cell> neighbors = getNeighbors(x,y);
                tempGrid[x][y].updateState(neighbors);
            }
        }
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++){
                landscape[x][y] = tempGrid[x][y];
            }
        }

    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public static void main(String[] args) {
        // Landscape l = new Landscape(4,5, .25);
        // System.out.println(l.getRows());
        // System.out.println(l.getCols());
        // System.out.println(l.getCell(2,3));
        // System.out.println(l);
        // System.out.println(l.getNeighbors(2,3));

    }
}