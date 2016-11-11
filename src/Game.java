
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author coulh9904
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creates Gameboard

        Board DoctorWho = new Board(12, 12);
        
        //Generate 4 random intigers, which will serve as the initial positions.
        int Row = (int) (Math.random() * 12);
        int Col = (int) (Math.random() * 12);
        int RandSpawn =  (int) (Math.random() * 12);
        int RandSpawn2 =  (int) (Math.random() * 12);
        
        //Instead of allowing the game to start with the possibility of the Dalek's/Doctor being in a crashed state, I decided to just ensure they won't start in the same place. These while loops will do that.
        while(RandSpawn2 == RandSpawn){
            RandSpawn =  (int) (Math.random() * 12);
        }
        while(RandSpawn2 == Col || Col == RandSpawn){
            Col =  (int) (Math.random() * 12);
        }
        
        //Set the Doctor's position as the frist two integers, and place his GREEN peg at said start location
        Doctor WHO = new Doctor(Row, Col);
        DoctorWho.putPeg(Color.GREEN, WHO.GetRow(), WHO.GetCol());
        
        //Using the same 4 randoms to generate their positons - because why not, then placing a peg at their positions
        Daleks D1 = new Daleks(RandSpawn, RandSpawn2);
        Daleks D2 = new Daleks(RandSpawn2, RandSpawn);
        Daleks D3 = new Daleks(Col, RandSpawn2);
        DoctorWho.putPeg(Color.BLACK, D1.GetRow(), D1.GetCol());
        DoctorWho.putPeg(Color.BLACK, D2.GetRow(), D2.GetCol());
        DoctorWho.putPeg(Color.BLACK, D3.GetRow(), D3.GetCol());
        
        //Print a message on the board
        DoctorWho.displayMessage("Please click board to move.");

        while (true) {
            //Update peg colours based on the Dalek's crash status - if they be dead they be red.
            if(D1.IsCrashed() == true){
                DoctorWho.putPeg(Color.RED, D1.GetRow(), D1.GetCol());
            }
            if(D2.IsCrashed() == true){
                DoctorWho.putPeg(Color.RED, D2.GetRow(), D2.GetCol());
            }
            if(D3.IsCrashed() == true){
                DoctorWho.putPeg(Color.RED, D3.GetRow(), D3.GetCol());
            }
            //Receive the user's click location.
            Coordinate Click = DoctorWho.getClick();
            //Remove all the pegs at everything's previous positon
            DoctorWho.removePeg(WHO.GetRow(), WHO.GetCol());
            DoctorWho.removePeg(D1.GetRow(), D1.GetCol());
            DoctorWho.removePeg(D2.GetRow(), D2.GetCol());
            DoctorWho.removePeg(D3.GetRow(), D3.GetCol());
            //Save the click's row and column.
            Row = Click.getRow();
            Col = Click.getCol();
            //Move the Doctor accordingly.
            WHO.Move(Row, Col);
            //Update the Doctor's peg with his location
            DoctorWho.putPeg(Color.GREEN, WHO.GetRow(), WHO.GetCol());
            
            //Assuming a Dalek isn't crashed, run through it's steps. Same drill for all 3 Daleks.
            if (D1.IsCrashed() == false) {
                D1.AdvanceTowards(WHO);
                D1.IsCrashed();
                D1.Crashed(D2);
                D1.Crashed(D3);
                //Assuming the crash tests checked out, update the Dalek's location w/ a black Peg. 
                DoctorWho.putPeg(Color.BLACK, D1.GetRow(), D1.GetCol());
            } 
            if (D2.IsCrashed() == false) {
                D2.AdvanceTowards(WHO);
                D2.IsCrashed();
                D2.Crashed(D1);
                D2.Crashed(D3);
                DoctorWho.putPeg(Color.BLACK, D2.GetRow(), D2.GetCol());
            } 
            if (D3.IsCrashed() == false) {
                D3.AdvanceTowards(WHO);
                D3.IsCrashed();
                D3.Crashed(D1);
                D3.Crashed(D2);
                DoctorWho.putPeg(Color.BLACK, D3.GetRow(), D3.GetCol());
            } 
            
            if(WHO.GetRow() == D1.GetRow() && WHO.GetCol() == D1.GetCol() || WHO.GetRow() == D2.GetRow() && WHO.GetCol() == D2.GetCol() || WHO.GetRow() == D3.GetRow() && WHO.GetCol() == D3.GetCol()){
               DoctorWho.displayMessage("You lose! You have been detonated."); 
               //To finalize peg colours on Daleks. If their crashed their pegs must finish red.
               if(D1.IsCrashed() == true){
                   DoctorWho.putPeg(Color.RED, D1.GetRow(), D1.GetCol());
               }
               if(D2.IsCrashed() == true){
                   DoctorWho.putPeg(Color.RED, D2.GetRow(), D2.GetCol());
               }
               if(D3.IsCrashed() == true){
                   DoctorWho.putPeg(Color.RED, D3.GetRow(), D3.GetCol());
               }
               //Since the doctor is dead in this loop, a yellow peg must be put at his final position regardless.
               DoctorWho.putPeg(Color.YELLOW, WHO.GetRow(), WHO.GetCol());
               break;
            }
            if(D1.IsCrashed() == true && D2.IsCrashed() == true && D3.IsCrashed() == true){
                DoctorWho.displayMessage("You win! All Daleks have been detonated.");
                DoctorWho.putPeg(Color.RED, D2.GetRow(), D2.GetCol());
                break;
            }
        }
        
        
        
    }
}
