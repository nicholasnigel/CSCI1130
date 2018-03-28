package reversi;

import javax.swing.JFrame;

/**
 * Reversi board game
 * Student Name: Nigel Nicholas
 * Student ID  : 1155088791
 * Declaration statement
 * 
 * @author pffung
 */
public class Reversi {

    public static final int BLACK = -1;
    public static final int WHITE = +1;
    public static final int EMPTY =  0;
    
    public final int FLIP  = -1;
    
    private ReversiPanel gameBoard;

    // each piece can be:
    //  0: empty/ unoccupied/ out of bound
    // +1: white
    // -1: black
    private int[][] pieces;
    
    // currentPlayer:
    // +1: white
    // -1: black
    private int currentPlayer;

    /*
     * Default constructor initializing a new board in this student app
     */
    public Reversi() {
        JFrame window;
        window = new JFrame("Reversi");
        gameBoard = new ReversiPanel(this);
        window.add(gameBoard);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 700);
        window.setVisible(true);

        // a 8x8 board of pieces[1-8][1-8] surrounded by a boundary of 10x10 
        pieces = new int[10][10];
        pieces[4][4] = WHITE;
        pieces[4][5] = BLACK;
        pieces[5][4] = BLACK;
        pieces[5][5] = WHITE;

        currentPlayer = BLACK;  // black plays first
        
        gameBoard.updateStatus(pieces, currentPlayer);
    }

    /*
     * setupDebugBoard for testing end game condition
     */
    private void setupDebugBoardEndGame()
    {
        // TEMPORARY testing case
        for (int row = 1; row <= 8; row++)
            for (int col = 1; col <= 8; col++)
                pieces[row][col] = BLACK;
        pieces[5][8] = WHITE;
        pieces[6][8] = EMPTY;
        pieces[7][8] = EMPTY;
        pieces[8][8] = EMPTY;

        
        currentPlayer = BLACK;  // black plays first
        
        gameBoard.updateStatus(pieces, currentPlayer);
    }

    private void setupTryFullBoard()
    {
        //TESTING CASE TO SEE IF END GAME FOR FULL IS ACTIVATED
        
        for(int row=1; row<=8 ;row++)
            for(int col=1; col<=8; col++)
                pieces[row][col] = WHITE;
        
        pieces[1][1] = BLACK;
        pieces[8][1] = BLACK;
        pieces[1][8] = BLACK;
        pieces[8][8] = EMPTY;
        gameBoard.updateStatus(pieces, currentPlayer);
    }
    
    /*
     * setupDebugBoard for testing mid game condition
     */
    private void setupDebugBoardMidGame()
    {
        // TEMPORARY testing case
        int row, col;
        
        for (row = 1; row <= 8; row++)
            for (col = 1; col <= 8; col++)
                pieces[row][col] = EMPTY;
        
        // setup a star pattern demonstration
        row = 3;
        col = 4;
        for (int y_dir = -1; y_dir <= +1; y_dir++)
            for (int x_dir = -1; x_dir <= +1; x_dir++)
            {
                try {
                    int move;
                    for (move = 1; move <= 2; move++)
                        pieces[row+y_dir*move][col+x_dir*move] = WHITE;
                    pieces[row+y_dir*move][col+x_dir*move] = BLACK;
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    // we hit the boundary of the board, so stop and do nothing
                }
            }
        pieces[row][col] = EMPTY;

        // restore fence of 10x10 EMPTY cells
        for (row = 1; row <= 8; row++)
            pieces[row][0] = pieces[row][9] = EMPTY;
        for (col = 1; col <= 8; col++)
            pieces[0][col] = pieces[9][col] = EMPTY;

        currentPlayer = BLACK;  // black plays first
        
        gameBoard.updateStatus(pieces, currentPlayer);
    }
    
    
    /*
        3 functions starting here : to check verticals, horizontal and diagonal
     */
    
    private Boolean Vertical(int row, int col)
            {
                if(pieces[row-1][col] == (-1*currentPlayer)) //if the piece on top is opposite
                {
                    for(int i=row-1; i>=1; i--)
                    {
                        if(pieces[i][col]== EMPTY)
                            break;
                        else if(pieces[i][col]==currentPlayer)
                            return true;
                    }
                }
                if(pieces[row+1][col] == (-1*currentPlayer))    //if the piece on bottom is opposite
                {
                    for(int i= row+1; i<=8; i++)
                    {
                        if(pieces[i][col] == EMPTY)
                            break;
                        else if(pieces[i][col]==currentPlayer)
                            return true;
                    }
                }
                return false;
              
                
                
            }
    
    private Boolean Horizontal(int row, int col)
    {
        //check left and right , which is col-1 and col+1   , but all in the same row
        
        if(pieces[row][col-1] == (-1*currentPlayer)) //if the piece on left is opposite
                {
                    for(int i=col-1; i>=1; i--)
                    {
                        if(pieces[row][i]== EMPTY)
                            break;
                        else if(pieces[row][i]==currentPlayer)
                            return true;
                    }
                }
                if(pieces[row][col+1] == (-1*currentPlayer))    //if the piece on right is opposite
                {
                    for(int i= col+1; i<=8; i++)
                    {
                        if(pieces[row][i] == EMPTY)
                            break;
                        else if(pieces[row][i]==currentPlayer)
                            return true;
                    }
                }
                return false;
    }
    
    private Boolean Diagonal(int row, int col)
            
    {
        //this function detects the validity of putting a piece in the board
        //the checking is to the 4 sides
        /*
         * South-East = [row+1][col+1]
         * North-East = [row-1][col+1]
         * North-West = [row-1][col-1]
         * South-West = [row+1][col-1]
        */
          //South-East 
        if(pieces[row+1][col+1] == (-1*currentPlayer))
        {
            int i=row+1;
            int j=col+1;
            while( i<=8 && j<=8)//row +1 until <=8 and col+1 <= 8
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                    return true;
                
                i++;
                j++;
            }
            
        }
        //North-East
        if(pieces[row-1][col+1] == (-1*currentPlayer))
        {
            int i=row-1;
            int j=col+1;
            while( i>=1 && j<=8)
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                    return true;
                
                i--;
                j++;
            }
            
        }
        
        //North-West
        if(pieces[row-1][col-1] == (-1*currentPlayer))
        {
            int i=row-1;
            int j=col-1;
            while( i>=1 && j>=1)
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                    return true;
                
                i--;
                j--;
            }
            
        }
        
        //South-West
        if(pieces[row+1][col-1] == (-1*currentPlayer))
        {
            int i=row+1;
            int j=col-1;
            while( i<=8 && j>=1)
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                    return true;
                
                i++;
                j--;
            }
            
        }
        
        return false;
        
         
    }
    
    //flipping anything on the vertical according to the given row and column ( up, down)
   private void flipVertical(int row, int col)
   {
       Boolean over=false;
                   if(pieces[row-1][col] == (-1*currentPlayer)) //if the piece on top is opposite
                {
                    for(int i=row-1; i>=1; i--)
                    {
                        if(pieces[i][col]== EMPTY)
                            break;
                        else if(pieces[i][col]==currentPlayer){
                         //if it meets the same its own color, then from the [row][col] to [i][col] is currentplayer
                        
                         for(int j =row-1 ; j>=i; j--)
                             pieces[j][col]=currentPlayer;
                         over=true;
                        }
                        if(over)
                            break;
                        
                    }
                }
                over=false;
                if(pieces[row+1][col] == (-1*currentPlayer))    //if the piece on bottom is opposite
                {
                    for(int i= row+1; i<=8; i++)
                    {
                        if(pieces[i][col] == EMPTY)
                            break;
                        else if(pieces[i][col]==currentPlayer)
                        {
                            for(int j=row+1; j<=i; j++)
                                pieces[j][col]=currentPlayer;
                            over=true;
                        }
                            if(over)
                                break;
                    }
                }
   }
   
   //flipping anything on the horizontal according to the validity (left, right)
   private void flipHorizontal(int row, int col)
   {
       Boolean over= false;
       
       if(pieces[row][col-1] == (-1*currentPlayer)) //if the piece on left is opposite
                {
                    for(int i=col-1; i>=1; i--)
                    {
                        if(pieces[row][i]== EMPTY)
                            break;
                        else if(pieces[row][i]==currentPlayer)
                        {
                           for(int j=col-1 ; j>=i ; j--)
                               pieces[row][j]=currentPlayer;
                         over=true;  
                        }
                        if(over)
                            break;
                    }
                }
                
       over=false;
       if(pieces[row][col+1] == (-1*currentPlayer))    //if the piece on right is opposite
                {
                    for(int i= col+1; i<=8; i++)
                    {
                        if(pieces[row][i] == EMPTY)
                            break;
                        else if(pieces[row][i]==currentPlayer)
                        {
                            for(int j=col+1 ; j<=i ; j++)
                                pieces[row][j]=currentPlayer;
                          over= true;  
                        } 
                        if(over)
                            break;
                    }
                }
   }
   
   //flipping anything on the diagonal ( SE. NE. SW, NW)
   private void flipDiagonal( int row, int col)
   {
       Boolean over= false; 
       //South-East 
        if(pieces[row+1][col+1] == (-1*currentPlayer))
        {
            int i=row+1;
            int j=col+1;
            while( i<=8 && j<=8)//row +1 until <=8 and col+1 <= 8
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                {
                    //loop from pieces[row][col] to pieces[i][j] turns into the same color
                    int x=row+1; 
                    int y=col+1;
                    
                    while(x<=i && y<=j)
                    {
                    pieces[x][y] = currentPlayer;
                    x++;
                    y++;
                    }
                    over=true;
                }
                   if(over)
                       break;
                
                i++;
                j++;
            }
            
        }
        //North-East
        over=false;
        if(pieces[row-1][col+1] == (-1*currentPlayer))
        {
            int i=row-1;
            int j=col+1;
            while( i>=1 && j<=8)
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                {
                    int x=row-1; 
                    int y=col+1;
                    
                    while(x>=i && y<=j)
                    {
                    pieces[x][y] = currentPlayer;
                    x--;
                    y++;
                    }
                    over=true;
                }
                    if(over)
                        break;
                
                i--;
                j++;
            }
            
        }
        over=false;
        //North-West
        if(pieces[row-1][col-1] == (-1*currentPlayer))
        {
            int i=row-1;
            int j=col-1;
            while( i>=1 && j>=1)
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                {
                    int x=row-1; 
                    int y=col-1;
                    
                    while(x>=i && y>=j)
                    {
                    pieces[x][y] = currentPlayer;
                    x--;
                    y--;
                    }
                    over=true;
                }
                if(over)
                    break;
                
                i--;
                j--;
            }
            
        }
        
        //South-West
        over=false;
        if(pieces[row+1][col-1] == (-1*currentPlayer))
        {
            int i=row+1;
            int j=col-1;
            while( i<=8 && j>=1)
            {
                if(pieces[i][j]==EMPTY)
                    break;
                else if(pieces[i][j]==currentPlayer)
                    
                {
                    int x=row+1; 
                    int y=col-1;
                    
                    while(x<=i && y>=j)
                    {
                    pieces[x][y] = currentPlayer;
                    x++;
                    y--;
                    }
                    over=true;
                }
               if(over)
                   break;
                i++;
                j--;
            }
            
        }
   }
    
   private Boolean CheckValid()
   {
       /*
        The checking should be done row by row and column by column and use the function
        Boolean.... from above to check every single block's availability.
        */
       Boolean valid1, valid2, valid3;
       for(int i=1; i<=8 ;i++) 
       {
           for(int j=1; j<=8; j++)
           {
               valid1 = Horizontal(i,j);
               valid2 = Vertical(i,j);
               valid3 = Diagonal(i,j);
               
               if(valid1 || valid2 || valid3)
                   return true;
           }
           
       }
       return false;
       
   }
   
   private Boolean isFull()
   {
      for(int i =1; i<=8; i++)
      {
          for(int j=1; j<=8; j++)
          {
              //if it meets any empty cell then immediately return false
             if(pieces[i][j]==EMPTY)
                 return false;
          }
      }
      return true;
   }
    
    /*
     * Callback method will be invoked to handle user click
     */
    public void userClicked(int row, int col)
    {
        // sample statements
        //pieces[row][col] = currentPlayer;
        
        /*
         * Check first whether the input is valid
         * valid is if when you place it, it should make a flip vertically, horizontally, or  diagonally.
            It should be next to a opposite color tile and on any of the arrangement, and it should meet another "same color" along the way
            If either of the one you place is valid, then you may put it, 
            So we can make 3 functions to check this condition. The 3 functions may just be a boolean variable to show true or false
            Changing the color of existing block is also invalid
        */
        
        if(pieces[row][col]!=EMPTY)
            gameBoard.addText("Invalid move");
        
        else{
        
        boolean validVertical,validHorizontal,validDiagonal;
        validVertical = Vertical(row,col);
        validHorizontal = Horizontal(row,col);
        validDiagonal = Diagonal(row,col);
                
        if(!validVertical && !validHorizontal && !validDiagonal){    
            //if any of the vertical, horizontal and diagonal is invalid print the error message but dont switch player
            gameBoard.addText("Invalid move");
        }
        
        else if(validVertical || validHorizontal || validDiagonal){
            //if any of the vertial, horizontal, or diagonal pieces are valid, then you can put it there
            pieces[row][col] = currentPlayer;
        
            if(validVertical)   //vertical flipping
            flipVertical(row, col);
        
        if(validHorizontal) //horizontal flipping
            flipHorizontal(row,col);
        
        if(validDiagonal)   //diagonal flipping
            flipDiagonal(row,col);
        
        
        currentPlayer = FLIP * currentPlayer;
            }
        
        /*
         * now this stage will update the board game status, detecting any changes in the board
         * and flip the boards where it is valid if any of the validVertical, validHorizontal, and validDiagonal is true
         *
         *Then using the validX boolean variables, we can then flip 
        */
        }
        
        
        
        
        
        //currentPlayer = FLIP * currentPlayer;   //change player by multiplying it by -1. 
        /*
            After inputting the changes to the board, we then see if there should be any valid move by scanning through the whole board. 
            If there are no more move then forced pass. If forcedpass=2 then game ended.
        */
        
        gameBoard.updateStatus(pieces, currentPlayer);
        
        /*
         * after updating the status and the player has shifted, we check if this currentplayer 
         * can put its color anywhere in the board. This is done by scanning the whole board
         * row by row and column by column for any space.
         * If there is none then type forced pass and change player. Then we should check again 
         * with this current player. If double forced pass happens then -> END GAME.
         * However, if the next player can put a valid chip again, then just continue the code.
         */
        
        Boolean forcedpass1,forcedpass2;
        
        forcedpass1= CheckValid();
        
        if(!forcedpass1)
        {
            gameBoard.addText("Forced Pass");
            currentPlayer = FLIP * currentPlayer;
            gameBoard.updateStatus(pieces,currentPlayer);
            forcedpass2 = CheckValid();
            if(!forcedpass2){
                gameBoard.addText("Double Forced Pass");
                gameBoard.addText("End game!");
            }
        }
        
        if(isFull())
            gameBoard.addText("End game!");
        
        /*
         Another feature of the end game is if, the whole board has been filled
         so we would need to make another condition of end game.
         */
                // forced pass happened
                // gameBoard.addText("Forced Pass");
                    // double pass happened
                    // gameBoard.addText("Double Forced Pass");
                    // gameBoard.addText("End game!");
            // gameBoard.addText("Invalid move");
    }

    public static void main(String[] args) {
        Reversi game = new Reversi();
        
        // comment or remove the following statements for real game play
       // game.setupDebugBoardEndGame();
        //game.setupDebugBoardMidGame();
        //game.setupTryFullBoard();
    }
}
