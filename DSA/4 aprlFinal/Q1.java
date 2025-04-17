import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        System.out.println("play Tic ta to game");
        System.out.println("your move is O and my move is x");

        playGame();
    }

    public static void playGame() {
        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        printBoard(board);
        playerMove(board);
        printBoard(board);
        systemMove(board);
        printBoard(board);

        printBoard(board);
        playerMove(board);
        printBoard(board);
        systemMove(board);
        printBoard(board);

        printBoard(board);
        playerMove(board);
        printBoard(board);
        systemMove(board);
        printBoard(board);

        printBoard(board);
        playerMove(board);
        printBoard(board);
        systemMove(board);
        printBoard(board);
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("  " + board[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    public static void playerMove(char[][] board) {
        System.out.println("your move you have to enter row and col (1 based indexing eg row = 3 , col = 1)");

        int row = 0;
        int col = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("enter row = ");
        row = sc.nextInt();

        System.out.println("enter col = ");
        col = sc.nextInt();

        if (isPlaverMoveValid(board, row, col)) {
            board[row - 1][col - 1] = 'o';
        }
    }

    public static boolean isPlaverMoveValid(char[][] board, int row, int col) {
        if (row > 3 || row < 1 || col > 3 || col < 1) {
            System.out.println("invalid move");
            return false;
        }

        row--;
        col--;

        if (board[row][col] != '-') {
            System.out.println("postion is already occupied");
            playerMove(board);
            return false;
        }

        return true;
    }

    public static void systemMove(char[][] board) {
        if (board[1][1] == '-') {
            board[1][1] = 'x';
        } else {
            int bestRow = findMaximumFillRowByUser(board);
            int bestCol = findMaximumFillColByUser(board);
            int bestDia = checkDiagonaly(board);

            boolean isFill = true;

            if (bestRow > bestCol) {
                isFill = isSpaceOnParticulrRowColOrDiaAndInsert(board, bestRow, 'r', 0);
            } else {
                isFill = isSpaceOnParticulrRowColOrDiaAndInsert(board, bestCol, 'c', 0);
            }

            if (!isFill) {
                isFill = isSpaceOnParticulrRowColOrDiaAndInsert(board, bestDia, 'd', bestDia);
            }

            if (!isFill) {
                handelLastCase(board);
            }
        }
    }

    public static int findMaximumFillRowByUser(char[][] board) {
        int maxFillRowCountByUser = 0;
        int maxRowIndex = 0;

        for (int i = 0; i < 3; i++) {
            int curRowCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'o') {
                    curRowCount++;
                }
            }
            if (curRowCount > maxFillRowCountByUser) {
                maxFillRowCountByUser = curRowCount;
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }

    public static int findMaximumFillColByUser(char[][] board) {
        int maxFillColCountByUser = 0;
        int maxColIndex = 0;

        for (int i = 0; i < 3; i++) {
            int curColCount = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'o') {
                    curColCount++;
                }
            }
            if (curColCount > maxFillColCountByUser) {
                maxFillColCountByUser = curColCount;
                maxColIndex = i;
            }
        }
        return maxColIndex;
    }

    public static int checkDiagonaly(char[][] board) {
        int leftDiagonlCount = 0;
        int rightDiagonlCount = 0;

        for (int i = 0; i < 3; i++) {
            if (board[i][i] == 'o') {
                leftDiagonlCount++;
            }
            if (board[i][2 - i] == 'o') {
                rightDiagonlCount++;
            }
        }

        if (leftDiagonlCount > rightDiagonlCount) {
            return -1; // left
        }
        return 1; // right
    }

    public static boolean isSpaceOnParticulrRowColOrDiaAndInsert(char[][] board, int position, char ch, int bestDia) {
        if (ch == 'r') {
            for (int i = 0; i < 3; i++) {
                if (board[position][i] == '-') {
                    board[position][i] = 'x';
                    return true;
                }
            }
        } else if (ch == 'c') {
            for (int i = 0; i < 3; i++) {
                if (board[i][position] == '-') {
                    board[i][position] = 'x';
                    return true;
                }
            }
        } else if (ch == 'd') {
            if (bestDia == 1) {
                // right diagonal
                for (int i = 0; i < 3; i++) {
                    int j = 2 - i;
                    if (board[i][j] == '-') {
                        board[i][j] = 'x';
                        return true;
                    }
                }
            } else if (bestDia == -1) {
                // left diagonal
                for (int i = 0; i < 3; i++) {
                    if (board[i][i] == '-') {
                        board[i][i] = 'x';
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void handelLastCase(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'x';
                    return;
                }
            }
        }
    }
}
