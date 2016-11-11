
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author coulh9904
 */
public class Doctor {
    //Instance Variables
    private int Row;
    private int Col;

    /**
     * The Constructor to create a new Doctor
     * @param Row - This will represent the Doctor's previous row position
     * @param Col - This represents the Doctor's previous column position
     */
    public Doctor(int Row, int Col) {
        this.Row = Row;
        this.Col = Col;
    }
    /**
     * The move sequence for the Doctor
     * @param NewRow - Represents the Doctor's current row position
     * @param NewCol - Represents the Doctor's current column position
     */
    public void Move(int NewRow, int NewCol) {

        while (true) {
            if (NewRow == this.Row + 1 || NewRow == this.Row - 1 || NewRow == this.Row) {
                if (NewCol == this.Col + 1 || NewCol == this.Col - 1 || NewCol == this.Col) {
                    break;
                }
            }
            NewCol = (int) (Math.random() * 11);
            NewRow = (int) (Math.random() * 11);
            break;
        }
        this.Row = NewRow;
        this.Col = NewCol;
    }
    /**
     * The method one calls to get the Doctor's row
     * @return the Doctor's row
     */
    public int GetRow() {
        return this.Row;
    }
    /**
     * The method one calls to get the Doctor's column
     * @return the Doctor's column
     */
    public int GetCol() {
        return this.Col;
    }
}
