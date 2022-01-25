import lib.Matrix;

import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Matrix matrix = new Matrix();
        matrix.readMatrix("a.txt");
        matrix.resetSolution();
        matrix.solve();
        matrix.displayStat();
    }
}
