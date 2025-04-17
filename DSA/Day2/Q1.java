import java.util.ArrayList;

class Q1 {
    public static void main(String[] args) {
        int[][] sudoku = {
                { 5, 3, 0, 6, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 9, 6, 0, 5, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 1, 6, 0, 2, 0, 0, 4, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 3, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 0, 9 }
        };
        System.out.println(checkCol(sudoku));

    }

    public static boolean isValidSudoku(int[][] sudoku) {
        //store strting index of 3 by 3 grid
        ArrayList<int[]> list = fetchStartingIndexOf3By3(sudoku);
        for (int i = 0; i < list.size(); i++) {
            int strI = list.get(i)[0];
            int strJ = list.get(i)[1];
            System.out.println("i = " + strI + " j = " + strJ);

            if (!checkRepetin3By3(strI, strJ, sudoku)) {
                return false;

            }
        }
        //check row and col
        if(!checkRow(sudoku) || !checkCol(sudoku)){
            return false;
        }
        return true;
    }

    public static boolean checkRow( int[][] sudoku) {

             // check row
             for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int term = sudoku[i][j];
                    for (int k = 0; k < 9; k++) {
                        if (j == k) {
                            continue;
                        }
    
                        System.out.println(sudoku[i][k] + " == " + term);
                        if (sudoku[i][k] == term && term != 0) {
                            return false;
                        }
                    }
    
                }
    
            }
            return true;

    }


    public static boolean checkCol( int[][] sudoku) {

          // check col
          for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int term = sudoku[j][i];
                for (int k = 0; k < 9; k++) {
                    if (j == k) {
                        continue;
                    }

                    System.out.println(sudoku[k][i] + " == " + term);
                    if (sudoku[k][i] == term && term != 0) {
                        return false;
                    }
                }

            }

        }
            return true;

    }
    

    public static boolean checkRepetin3By3(int startI, int startJ, int[][] sudoku) {
        for (int i = startI; i < startI + 3; i++) {
            for (int j = startJ; j < startJ + 3; j++) {
                int term = sudoku[i][j];
                for (int k = startI; k < startI + 3; k++) {
                    for (int l = startJ; l < startJ + 3; l++) {

                        if (i == k && j == l) {

                            continue;

                        }

                        if (term == sudoku[k][l] && sudoku[i][j] != 0) {
                            System.out.println(sudoku[i][j] + "==" + sudoku[k][l]);

                            System.out.println("i = " + i + " j = " + j);
                            System.out.println("k = " + k + " L = " + l);
                            return false;

                        }

                    }
                }

            }

        }
        return true;

    }
    
    public static ArrayList<int[]> fetchStartingIndexOf3By3(int[][] sudoku){
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <= 6; i+=3) {
            for (int j = 0; j <= 6; j+=3) {
                System.out.print(sudoku[i][j] + " ");
                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = j;
                list.add(arr);
                
            }
            
            System.out.println();
        }
        
        return list;
        
    } 
}