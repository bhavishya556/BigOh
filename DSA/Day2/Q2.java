import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        char[][] board = {
            {'*', '*', 'E', 'Q', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', 'K', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', '*', '*'}
        };
        

   
        char king = 'K';
       

      boolean flag =  isKingSafe(board);

      System.out.println(flag);
     

    }

    public static boolean isKingSafe(char[][] board){
        int[] kingPosition =  findPlayerPostion(board, 'K');
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                char player = board[i][j];

                if(player == 'E'){
                    int ElephantI = i;
                    int ElephantJ = j;
                    
                   if(isElephantAttackToKing(board,ElephantI,ElephantJ,kingPosition)){
                    return false;

                   }
                }
                
                if(player == 'C'){
                    int CamelI = i;
                    int CamelJ = j;
                    // System.out.println("Camel attack "+ isCamelAttackToKing(board,CamelI,CamelJ,kingPosition));
                    if(isCamelAttackToKing(board,CamelI,CamelJ,kingPosition)){
                        return false;
    
                       }
                }

                if(player == 'Q'){
                    int CamelI = i;
                    int CamelJ = j;
                    // System.out.println("Queen attack "+ isCamelAttackToKing(board,CamelI,CamelJ,kingPosition));
                    if(isQueenAttackToKing(board,CamelI,CamelJ,kingPosition)){
                        return false;
    
                       }
                }



            }

        }+




        return true;

    }
    
    public static boolean isElephantAttackToKing(char[][] board,int ElephantI, int ElephantJ,int[]kingPosition){



        int kingRow= kingPosition[0];
        int kingCol= kingPosition[1];

        if(ElephantI == kingRow){
            return true;
        }
        if(ElephantJ == kingCol){
            return true;
        }


        return false;

    }

    public static boolean isCamelAttackToKing(char[][] board,int camelI, int camelJ ,int[]kingPosition){

        int kingI= kingPosition[0];
        int kingJ= kingPosition[1];

        // left up
        int tempCamelI = camelI;
        int tempCamelj = camelJ;
        while(tempCamelI<8 && tempCamelj <8){

            if(tempCamelI==kingI && tempCamelj == kingJ){
                return true;
            }
            tempCamelI++;
            tempCamelj++;


        }
        //right up
        tempCamelI = camelI;
        tempCamelj = camelJ;
        while(tempCamelI>0 && tempCamelj < 8){

            if(tempCamelI==kingI && tempCamelj == kingJ){
                return true;
            }
            tempCamelI--;
            tempCamelj++;


        }
        //left down
        tempCamelI = camelI;
        tempCamelj = camelJ;
        while(tempCamelI>0 && tempCamelj <8){

            if(tempCamelI==kingI && tempCamelj == kingJ){
                return true;
            }
            tempCamelI--;
            tempCamelj++;


        }
        //right down
        tempCamelI = camelI;
        tempCamelj = camelJ;
        while(tempCamelI>0 && tempCamelj >0){

            if(tempCamelI==kingI && tempCamelj == kingJ){
                return true;
            }
            tempCamelI--;
            tempCamelj--;


        }



        return false;

    }

    public static boolean isQueenAttackToKing(char[][] board,int QueenI, int QueenJ ,int[]kingPosition){

       if(isCamelAttackToKing(board,QueenI,QueenJ,kingPosition) || isElephantAttackToKing(board,QueenI,QueenJ,kingPosition)){
        return true;
        
       }

        

        return false;
    }

    
    public static int[] findPlayerPostion(char[][] board , char ch){
        int[] playerIndex = new int [2];

        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){


                if(board[i][j]==ch){
                    playerIndex[0] = i;
                    playerIndex[1] = j;
                    break;

                }

            }

        }

       

        return playerIndex;

    }


    
}
