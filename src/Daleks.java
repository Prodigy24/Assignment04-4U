/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coulh9904
 */
public class Daleks {
    //Instance variables
    private int theRow;
    private int theCol;
    //THIS SHOULD(N'T) BE PUBLIC?!?!?
    private boolean Crash;
    
    /**
     * The Constructor to create a new Dalek
     * @param theRow - The Dalek's row.
     * @param theCol - The Dalek's column.
     * @param Crashed - The Boolean that will tell you if the Dalek is operating or not. Crashed will equal true if the Dalek has crashed.
     */
    public Daleks(int theRow, int theCol){
        this.theRow = theRow;
        this.theCol = theCol;
        Crash = false;
    }
    /**
     * This method runs the Dalek's movement. It advanced the Daleks towards the Doctor (WHO).
     * @param WHO - WHO is the Doctor. The Doctor is the input.
     */
    public void AdvanceTowards(Doctor WHO){ //Doctor doc
        int DocRow = WHO.GetRow();
        int DocCol = WHO.GetCol();
        
        if(DocCol < theCol){
            theCol = theCol - 1;
        } else if(DocCol == theCol){
            
        } else {
            theCol = theCol + 1;
        }
        if(DocRow < theRow){
            theRow = theRow - 1;
        } else if(DocRow == theRow){
            
        } else {
            theRow = theRow + 1;
        }
        //If the Dalek is at the same square as the doctor, they have collided. The game is finished. 
        if(theCol == DocCol && theRow == DocRow){
            Crash = true;
        }
    }
    /**
     * The method called to get the Dalek's row number.
     * @return the Dalek's present row
     */
    public int GetRow(){
        return this.theRow;
    }
    /**
     * The method called to get the Dalek's column number.
     * @return the Dalek's present column
     */
    public int GetCol(){
        return this.theCol;
    }
    /**
     * If the Dalek has crashed, the crash Boolean will reflect that with a true.
     * @return the Dalek's crash status
     */
    public boolean IsCrashed(){
        return Crash;
    }
    /**
     * The method to check if a Dalek has collided with another Dalek.
     * @param D0 is just the generic Dalek input, seeing as all Daleks will run through this method.
     */
    public void Crashed(Daleks D0){
        if(D0.GetCol() == this.theCol && D0.GetRow() == this.GetRow()){
            Crash = true;
            D0.Crash = true;                   
        }
    }
}
//DONE.
