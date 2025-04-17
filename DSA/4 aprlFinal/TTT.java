import java.util.Scanner;

public class TTT {
    public static void main(String[] args) {
        System.out.println("Play Tic Tac Toe game");
        System.out.println("Your move is O and my move is X");
        playGame();
    }

    public static void playGame() {
        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        int turns = 0;
        while (turns < 9) {
            printBoard(board);
            playerMove(board);
            turns++;
            if (checkWinner(board, 'o')) {
                printBoard(board);
                System.out.println("You win!");
                return;
            }

            if (turns == 9) break;

            systemMove(board);
            turns++;
            if (checkWinner(board, 'x')) {
                printBoard(board);
                System.out.println("System wins!");
                return;
            }
        }

        printBoard(board);
        System.out.println("Game Draw!");
    }

    public static void printBoard(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
    
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < rows; i++) {
            // Print row content
            for (int j = 0; j < cols; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
    
            // Print horizontal separator
            for (int j = 0; j < cols; j++) {
                System.out.print("----");
            }
            System.out.println("-");
        }
        System.out.println();
    }
    

    public static void playerMove(char[][] board) {
        Scanner sc = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.print("Enter row (1-3): ");
            row = sc.nextInt();
            System.out.print("Enter column (1-3): ");
            col = sc.nextInt();

            if (isValidMove(board, row, col)) {
                board[row - 1][col - 1] = 'o';
                break;
            } else {
                System.out.println("Invalid move Try again.");
            }
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 1 || row > 3 || col < 1 || col > 3) return false;
        return board[row - 1][col - 1] == '-';
    }

    public static void systemMove(char[][] board) {
        //  try to win
        if (tryToWinOrBlock(board, 'x')) return;
        // try to block player mov
        if (tryToWinOrBlock(board, 'o')) return;
        // take center if empty
        if (board[1][1] == '-') {
            board[1][1] = 'x';
            return;
        }
        // look any corner
        int[][] corners = {{0,0},{0,2},{2,0},{2,2}};
        for (int[] c : corners) {
            if (board[c[0]][c[1]] == '-') {
                board[c[0]][c[1]] = 'x';
                return;
            }
        }
        //  take any midel1 1 ofside
        int[][] sides = {{0,1},{1,0},{1,2},{2,1}};
        for (int[] s : sides) {
            if (board[s[0]][s[1]] == '-') {
                board[s[0]][s[1]] = 'x';
                return;
            }
        }
    }

    public static boolean tryToWinOrBlock(char[][] board, char player) {
        // Try rows and columns
        for (int i = 0; i < 3; i++) {
            // Check row
            if (countChar(board[i][0], board[i][1], board[i][2], player) == 2) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        board[i][j] = 'x';
                        return true;
                    }
                }
            }
            // Check column
            if (countChar(board[0][i], board[1][i], board[2][i], player) == 2) {
                for (int j = 0; j < 3; j++) {
                    if (board[j][i] == '-') {
                        board[j][i] = 'x';
                        return true;
                    }
                }
            }
        }

        // Check diagonals
        if (countChar(board[0][0], board[1][1], board[2][2], player) == 2) {
            if (board[0][0] == '-') { board[0][0] = 'x'; return true; }
            if (board[1][1] == '-') { board[1][1] = 'x'; return true; }
            if (board[2][2] == '-') { board[2][2] = 'x'; return true; }
        }

        if (countChar(board[0][2], board[1][1], board[2][0], player) == 2) {
            if (board[0][2] == '-') { board[0][2] = 'x'; return true; }
            if (board[1][1] == '-') { board[1][1] = 'x'; return true; }
            if (board[2][0] == '-') { board[2][0] = 'x'; return true; }
        }

        return false;
    }

    public static int countChar(char a, char b, char c, char player) {
        int count = 0;
        if (a == player) count++;
        if (b == player) count++;
        if (c == player) count++;
        return count;
    }

    public static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            // Check row
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            // Check column
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;
        return false;
    }
}
