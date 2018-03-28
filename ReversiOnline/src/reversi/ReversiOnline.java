package reversi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * ReversiOnline is an extension to Reversi
 * 
 * Student Name:
 * Student ID  :
 * Date        :
 * 
 * Declaration Statement on Academic Honesty
 * 
 * @author pffung
 */
public class ReversiOnline extends Reversi {
    
    public static final String saveGameFilename = "reversi.txt";
    protected PrintStream gameFileStream;
    
    /*
     * Default constructor initializing a new board in this student app
     */
    public ReversiOnline() {
        // invoke default constructor of the super-class
        super();
        
        // ask user for Initial Reversi Game Board URL
        String address = "http://www.cse.cuhk.edu.hk/~pffung/reversi2.txt";
        while (true) {
            gameBoard.addText("Waiting for game board URL...");

            address = JOptionPane.showInputDialog("Initial Reversi Game Board URL", address);

            if (address == null) 
            {
                gameBoard.addText("Cancelled loading game board");
                break;
            }

            gameBoard.addText("Trying to load board from " + address);

            if (loadGameBoard(address))
            {
                gameBoard.addText("Game board loaded");

                gameBoard.updateStatus(pieces, currentPlayer);

                // sanity check to see if the initial game has ended!
                // the following method is available in super-class
                passAndEndGameCheck();
                break;
            }
            else
                gameBoard.addText("Failed to load game board");
        }
        
        
        // Student's work here

        // create the gameFileStream using the default saveGameFilename
        // if it fails, copy System.out to gameFileStream
        try{
        gameFileStream = new PrintStream(saveGameFilename);
        }
        catch(IOException e)
        {
          //  gameBoard.addText("gameFileStream not found");
            gameFileStream = System.out;
        }



        
        // save the initial game board
        saveGameBoard(gameFileStream);
    }
    
    /*
     * Callback method will be invoked to handle user click
     * Add new feature: save the new valid move and the updated game board to file
     *
     * Overriden: to add save game feature on each valid move
     *
     * Student's work here
     */
    @Override
    public void userClicked(int row, int col)
    {
        // the following method is available in super-class
        if (conquerCheck(row, col, true))
        {
            pieces[row][col] = currentPlayer;
            currentPlayer = FLIP * currentPlayer;
            gameBoard.updateStatus(pieces, currentPlayer);

            /* Student's work here */
            
            String aLineToWriteTo_gameFileStream = "Move (" + row + ", " + col + ")";

            // write the above line to gameFileStream
            // and save game board to gameFileStream
            
            gameFileStream.println(aLineToWriteTo_gameFileStream);
            saveGameBoard(gameFileStream);
            
            
            
            
            
            
            // the following method is available in super-class
            passAndEndGameCheck();
        }
        else
            gameBoard.addText("Invalid move");
    }
    

    /*
     * Load and store a game board from the given URL address to pieces[][]
     * Student's work here
     */
    protected boolean loadGameBoard(String address)
    {
// Students have not yet completed this method, DEBUG mode: return false
    //boolean DEBUG = true;
    //if (DEBUG) return false;
    
    //opening the address so first use Class Scanner:
        Scanner webReader;
    
        
    
    
        if (address == null)
        {
            gameBoard.addText("address=null");
            return false;
        
        }
        
       
    
        int[][] config;
        config = new int[10][10];
        
        
        int player = '?';
        int i,j; //counter for the loop to read
        
        try {
            
           
           webReader = new Scanner(new URL(address).openStream());
            
            
        }
        catch (Exception e)
        {
            gameBoard.addText("HEY THERE IT'S HERE");
            return false;
            
        }
           
           for(i=1; i<=8; i++)
            {
                String Line = webReader.nextLine();
                
                for(j=1; j<=8; j++)
                {
                    if(Line.charAt(j-1)=='B')
                        config[i][j]=BLACK;
                    if(Line.charAt(j-1)=='W')
                        config[i][j]=WHITE;
                    if(Line.charAt(j-1)=='.')
                        config[i][j]=EMPTY;
                    
                }
            }
            
            //Deciding the last player should be the last line, so we separate it from the loop
            
            String BlackPlayer = "Player:B";
            String WhitePlayer = "Player:W";
            //the 2 string variable above is to be compared by string and see who's the player
            
            String turn= webReader.nextLine();
            if(turn.equals(BlackPlayer))
                player=BLACK;   //black's turn
            
            if(turn.equals(WhitePlayer))
                player=WHITE;   //white's turn
       
            
            
          

            pieces = config;
            currentPlayer = player;
            
            return true;
    }
    
    /*
     * Save a game board
     * Student's work here
     */
    protected void saveGameBoard(PrintStream outputStream)
    {
        //here it should first save the initial game configuration
        
        //for everytime this function is called, you should print all the content of the board, 
        //and also the player, since move(.., ..) is already printed from the function userClicked();
        
        //detect row by row, and denote BLACK as b, WHITE as w, and EMPTY as .
        
        
        for(int i=1; i<=8 ; i++)
        {
            
            
            for(int j=1 ;j<=8 ;j++)
            {
                if(pieces[i][j]==BLACK)//if black then add char 'B'
                    gameFileStream.print("B");
                
                if(pieces[i][j]==WHITE)
                    gameFileStream.print("W");
                
                if(pieces[i][j] == EMPTY)
                    gameFileStream.print(".");
            }
            gameFileStream.println(" ");
            
        }

        //now you need to detect whose turn is it
        if(currentPlayer == WHITE)
            gameFileStream.println("Player:W");
        
        if(currentPlayer == BLACK)
            gameFileStream.println("Player:B");













    }
            
    /* New application starts here */
    public static void main(String[] args) {
        Reversi game = new ReversiOnline();
    }

}
