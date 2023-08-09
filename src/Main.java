import java.util.Objects;
import java.util.Scanner;



public class Main {




    private static final int GRID_SIZE = 9;
    private static String mode = "S"; // mode S = solve given sudoku, mode G = generate sudoku

    public static void main(String[] args) {

        chooseMode();

        if(Objects.equals(mode, "S") || Objects.equals(mode, "s")){

            int[][] board = SaverLoader.loadingInputUser(GRID_SIZE);

            if(SudokuSolver.solveBoard(board)){

                System.out.println("Solved the sudoku!");
                printBoard(board);
            }
            else{
                System.out.println("Can't solve the sudoku!");
            }
        }
        else{

            System.out.println("generating sudoku...");
            int[][] generatedBoard = SudokuGenerator.generateBoard();
            System.out.println("sudoku generated:");
            printBoard(generatedBoard);

            SaverLoader.savingInputUser(generatedBoard);




        }


    }


    private static void printBoard(int[][] board) {
        for(int row = 0; row < GRID_SIZE; row++){
            if(row%3 == 0 && row!=0){
                System.out.println("-----------");
            }
            for(int column = 0; column < GRID_SIZE; column++){
                if(column%3 == 0 && column!=0){
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    private static void chooseMode(){
        System.out.println("Default mode: " + mode);
        System.out.println("Choose mode: Solve (S) or Generate (G)");
        Scanner scanner = new Scanner(System.in);
        mode = scanner.nextLine();
        System.out.println("Chosen mode: " + mode);
    }
}
