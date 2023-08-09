
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SaverLoader {

    private static String saveSudoku(int[][] board){
        String filename = getFilename();

        try{PrintWriter outputWriter = new PrintWriter(filename);


            for (int[] ints : board) {
                for(int element : ints){
                    outputWriter.write(element + "\t"+ "");
                }
            }
            outputWriter.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return filename;
    }


    private static String getFilename(){
        String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
        System.out.println(fileName);
        return "saved_sudokus/" + fileName;
    }
    public static void savingInputUser(int[][] board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("do you want to save the sudoku? y/n");


        if(scanner.nextLine().equals("y")){
            //save file to disk
            File filename = new File(saveSudoku(board));
            System.out.println("sudoku saved to " + filename.getAbsolutePath());
        }
    }

    public static int[][] loadingInputUser(int GRID_SIZE){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter filename of sudoku");
        String inputPath = scanner.nextLine();

        return loadingSudoku(inputPath, GRID_SIZE);

    }

    private static int[][] loadingSudoku(String inputPath, int GRID_SIZE){

        //File filename = new File(inputPath);
        int[][] board = new int[GRID_SIZE][GRID_SIZE];

        try{
            Scanner scanner = new Scanner(new File(inputPath));

            for(int row=0; row< GRID_SIZE; row++){
                for(int column=0; column<GRID_SIZE; column++){
                    board[row][column] = scanner.nextInt();
                }
            }

            return board;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
