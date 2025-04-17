public class Q1 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 12, 34, 56, 78, 90, 23, 45, 67, 1 },
                { 89, 21, 32, 54, 76, 98, 10, 11, 2 },
                { 22, 33, 44, 55, 66, 77, 88, 99, 3 },
                { 90, 10, 11, 12, 13, 14, 15, 16, 4 },
                { 17, 18, 19, 20, 21, 22, 23, 24, 5 },
                { 25, 26, 27, 28, 29, 30, 31, 32, 6 },
                { 33, 34, 35, 36, 37, 38, 39, 40, 7 }
        };

        printClockWise(matrix, 0, 0, matrix.length, matrix[0].length);
        System.out.println();
        System.out.println("anti");
        System.out.println();
        printAntiClockwise(matrix, 0, 0, matrix.length, matrix[0].length);
    }

    public static void printClockWise(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {

        if (startRow >= endRow || startCol >= endCol)
            return;

        //  l to r
        for (int i = startCol; i < endCol; i++) {
            System.out.print(matrix[startRow][i] + " ");
        }
        startRow++;

        //  top to down
        for (int i = startRow; i < endRow; i++) {
            System.out.print(matrix[i][endCol - 1] + " ");
        }
        endCol--;

        //  r to l
        if (startRow < endRow) {
            for (int i = endCol - 1; i >= startCol; i--) {
                System.out.print(matrix[endRow - 1][i] + " ");
            }
            endRow--;
        }

        //  down to up
        if (startCol < endCol) {
            for (int i = endRow - 1; i >= startRow; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;
        }

        printClockWise(matrix, startRow, startCol, endRow, endCol);
    }

    public static void printAntiClockwise(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        if (startRow >= endRow || startCol >= endCol)
            return;

        //Left 
        for (int i = startCol; i >= 0; i--) {
            System.out.print(matrix[startRow][i] + " ");
        }
        startRow++;

        // Move Down 
        for (int i = startRow; i < endRow; i++) {
            System.out.print(matrix[i][0] + " ");
        }
        startCol++;

        //  Move Right 
        if (startRow < endRow) {
            for (int i = startCol; i < endCol; i++) {
                System.out.print(matrix[endRow - 1][i] + " ");
            }
            endRow--;
        }

        //  Up 
        if (startCol < endCol) {
            for (int i = endRow - 1; i >= startRow; i--) {
                System.out.print(matrix[i][endCol - 1] + " ");
            }
            endCol--;
        }

       
        printAntiClockwise(matrix, startRow, startCol, endRow, endCol);
    }
    
    }
    
    
