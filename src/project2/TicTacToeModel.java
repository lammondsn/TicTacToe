package project2;


public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int size;       /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String symbol;
        
        private Mark(String s) { symbol = s; }
        
        @Override
        public String toString() { return symbol; }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String symbol;
        
        private Result(String s) { symbol = s; }
        
        @Override
        public String toString() { return symbol; }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_SIZE);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int size) {
        
        // SUPPLY YOUR CODE FOR THE EMPTY SECTIONS AS COMMENTED BELOW
        
        /* Initialize size; set X to go first */
        
        this.size = size;
        xTurn = true;
        // SUPPLY YOUR CODE HERE
        
        /* Create board (size x size) as a 2D array of Mark objects */
        
        board = new Mark[size][size];
        for (int i = 0; i < board.length; i++) {
        
            for (int j = 0; j < board.length; j++)
            {
                board[i][j] = Mark.EMPTY;
            }
        }           
        /* Initialize board by filling every square with empty marks */
              
        // SUPPLY YOUR CODE HERE
        
    }
	
    public boolean makeMark(int row, int col) {

        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // SUPPLY YOUR CODE HERE
        
        if (isValidSquare(row, col) == false) {
            return false;
        }
        else if (isSquareMarked(row, col) == true) {
            return false;
        }
        else {
            if (xTurn == true) {
                board[row][col] = Mark.X;
                xTurn = false;
            }
            else if (xTurn == false) {
                board[row][col] = Mark.O;
                xTurn = true;
            }
            return true;
        }
        
        
        
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified row and col are within bounds */
        return -1 < row && (row < size) && (-1 < col) && col < size;
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        // SUPPLY YOUR CODE HERE
        return board[row][col] != Mark.EMPTY; // remove this later!
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // SUPPLY YOUR CODE HERE
        return board[row][col];
        
        
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        if (isMarkWin(Mark.X) == true) {
            return Result.X;            
    }
        else if (isMarkWin(Mark.O) == true) {
            return Result.O;
        }
        
        else if (isTie() == true) {
            return Result.TIE;
        }
        else {
            return Result.NONE;
        }
        // SUPPLY YOUR CODE HERE
                
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the mark specified in the
           argument is the winner */
        
        // SUPPLY YOUR CODE HERE
        // Checking for row based win
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c] != mark) {
                    break;
                }
                else if (board.length - 1 == c) {
                    return true;
                        
                }
            }
        }
        for (int c = 0; c < size; c++) {
            for (int r = 0; r < size; r++) {
                if (board[r][c] !=mark) {
                    break;
                }
                else if (board.length - 1 == r) {
                    return true;
                }
            }
        }
         
            for (int j = 0; j < size; j++) {
                if (board[j][j] != mark) {
                    break;
                }
                else if (board.length - 1 == j) {
                    return true;
                }
            }
            for (int j = 0; j < size; j++) {
                if (board[j][size - 1 - j] != mark) {
                    break;
                }
                else if (board.length - 1 == j) {
                    return true;
                }
            }
        
        
        return false; // remove this later!
        
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // SUPPLY YOUR CODE HERE
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == Mark.EMPTY) {
                    return false; // remove this later!        
                }
            }
    }
           
        return true;
    }
    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        return getResult() != Result.NONE; 
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getSize() {
        
        /* Getter for size */
        
        return size;
        
    }
    
}
