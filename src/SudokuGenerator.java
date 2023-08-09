import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class SudokuGenerator{

    public static int GRID_SIZE = 9;


    public static void setGridSize(int gridSize) {
        GRID_SIZE = gridSize;
    }



    private static int[][] generateSudokuProposal() {
        int[][] board = new int[GRID_SIZE][GRID_SIZE];
        //Integer[] numbersArray = new Integer[GRID_SIZE];

            for (int i = 0; i < (GRID_SIZE % 3); i++) {
                List<Integer> numbers = IntStream.range(1, GRID_SIZE).boxed().collect(Collectors.toList());
                Collections.shuffle(numbers);

                //numbers.toArray(numbersArray);

                for (int row = (i * 3); row < ((i * 3) + 3); row++) {
                    for (int column = (i * 3); column < ((i * 3) + 3); column++) {
                        board[row][column] = numbers.get(0);
                        numbers.remove(0);
                    }
                }



        }


    return board;
    }

    public static int[][] generateBoard(){
        boolean solvable = false;
        int[][] board = new int[GRID_SIZE][GRID_SIZE];

        while(!solvable){
             board = generateSudokuProposal();

            if(SudokuSolver.solveBoard(board)){
                solvable = true;
            }
        }

        Random rd = new Random();
        for(int row=0; row < GRID_SIZE; row++){
            for(int column=0; column < GRID_SIZE; column++){
                if(rd.nextBoolean()){
                    board[row][column] = 0;
                }
            }
        }
        return board;
    }


}
