import java.util.Scanner;

public class CheckersGame {
    public static void main(String[] args) {
        CheckersBitboard game = new CheckersBitboard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Checkers Game - Bitboard Representation");
        game.printBoard();

        while (!game.checkGameOver()) {
            System.out.println("Player 1, enter your move (from, to):");
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            if (game.isLegalMove(1, from, to)) {
                game.movePiece(1, from, to);
                game.printBoard();
            } else {
                System.out.println("Invalid move.");
            }

            if (game.checkGameOver()) break;

            System.out.println("Player 2, enter your move (from, to):");
            from = scanner.nextInt();
            to = scanner.nextInt();
            if (game.isLegalMove(2, from, to)) {
                game.movePiece(2, from, to);
                game.printBoard();
            } else {
                System.out.println("Invalid move.");
            }
        }

        System.out.println("Game over!");
    }
}
