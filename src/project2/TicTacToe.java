package project2;

import javax.swing.*;

public class TicTacToe {

    public static final int DEFAULT_SIZE = 3;

    public static void main(String[] args) {
        
        // SUPPLY YOUR CODE FOR THE EMPTY SECTIONS AS COMMENTED BELOW
        
        /* Set initial size of game board to the default (which is 3 x 3) */

        int size = DEFAULT_SIZE;
        
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        }
            
        
        /* If a different size is provided as a command-line argument, use 
           this size instead of the default */

        // SUPPLY YOUR CODE HERE
        
        /* Create Controller */

        TicTacToeController controller = new TicTacToeController(size);
        
        /* Start GUI */

        JFrame win = new JFrame("Tic-Tac-Toe");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        win.add(controller.getView());
        win.pack();
        win.setVisible(true);
        
    }
    
}