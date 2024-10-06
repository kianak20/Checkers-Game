public class CheckersBitboard {

    private int player1Board;  // Player 1 pieces (lower half)
    private int player2Board;  // Player 2 pieces (upper half)

    // Initialize the board with pieces in the starting positions
    public CheckersBitboard() {
        // Player 1 starts in the lower half
        player1Board = 0x00000FFF; // Binary: 0000 0000 0000 0000 0000 1111 1111 1111
        // Player 2 starts in the upper half
        player2Board = 0xFFF00000; // Binary: 1111 1111 1111 0000 0000 0000 0000 0000
    }

    // Print the current state of the board
    public void printBoard() {
        System.out.println("Current Checkerboard:");
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int position = row * 4 + (col / 2);  // Each row has 4 positions

                // Determine which piece is at this position
                char symbol = '.';
                if ((player1Board & (1 << position)) != 0) {
                    symbol = 'X';  // Player 1 piece
                } else if ((player2Board & (1 << position)) != 0) {
                    symbol = 'O';  // Player 2 piece
                }

                // Print the symbol only in playable squares
                if ((row % 2 == 0 && col % 2 == 1) || (row % 2 == 1 && col % 2 == 0)) {
                    System.out.print(symbol + " ");
                } else {
                    System.out.print("  ");  // Non-playable square
                }
            }
            System.out.println();  // Move to the next row
        }
    }

    // Move a piece from one position to another for the given player
    public void movePiece(int player, int fromPosition, int toPosition) {
        if (player == 1) {
            // Clear the bit at the old position and set the bit at the new position
            player1Board = BitManipulationUtility.clearBit(player1Board, fromPosition);
            player1Board = BitManipulationUtility.setBit(player1Board, toPosition);
        } else if (player == 2) {
            player2Board = BitManipulationUtility.clearBit(player2Board, fromPosition);
            player2Board = BitManipulationUtility.setBit(player2Board, toPosition);
        } else {
            throw new IllegalArgumentException("Invalid player number.");
        }
    }

    // Check if a move is legal
    public boolean isLegalMove(int player, int fromPosition, int toPosition) {
        if (fromPosition < 0 || fromPosition > 31 || toPosition < 0 || toPosition > 31) {
            return false;  // Out of bounds
        }

        int targetBit = (player == 1) ? BitManipulationUtility.getBit(player2Board, toPosition) : BitManipulationUtility.getBit(player1Board, toPosition);
        return targetBit == 0;  // Ensure the destination is empty
    }

    // Capture a piece
    public void capturePiece(int player, int position) {
        if (player == 1) {
            player2Board = BitManipulationUtility.clearBit(player2Board, position);
        } else if (player == 2) {
            player1Board = BitManipulationUtility.clearBit(player1Board, position);
        } else {
            throw new IllegalArgumentException("Invalid player number.");
        }
    }

    // Check for game over
    public boolean checkGameOver() {
        return player1Board == 0 || player2Board == 0;
    }
}


