import lib.PuzzleSolver;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename;

        PuzzleSolver puzzleSolver = new PuzzleSolver();
        System.out.print("Puzzle text file: ");
        filename = scanner.nextLine();
        puzzleSolver.readMatrix(filename);
        if (puzzleSolver.fileExist) {
            puzzleSolver.resetSolution();
            puzzleSolver.solve();
            puzzleSolver.displayStat();
        }
    }
}
