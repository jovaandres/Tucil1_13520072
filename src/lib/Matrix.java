package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Matrix {
    final int maxRow = 50;
    final int maxCol = 50;
    final int maxWord = 50;
    public int nRow, nCol, nWord;
    public String[][] Matrix = new String[maxRow][maxCol];
    public String[][] Solution = new String[maxRow][maxCol];
    public String[] Words = new String[maxWord];

    public void readMatrix(String filename) {
        try {
            // Read puzzle
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("../test/" + filename));
            int i, j, k;
            i = 0;
            while (!(line = reader.readLine()).isEmpty()) {
                j = 0;
                for (String value : line.split(" ")) {
                    this.Matrix[i][j] = value;
                    j += 1;
                }
                i += 1;
                this.nCol = j;
            }
            this.nRow = i;

            // Read solutions
            k = 0;
            while ((line = reader.readLine()) != null) {
                this.Words[k] = line;
                k += 1;
            }
            this.nWord = k;

            reader.close();
        } catch (IOException e) {
            System.out.println("Error occurred, " + e.getMessage());
        }
    }

    public void resetSolution()
    {
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                this.Solution[i][j] = "-";
            }
        }
    }

    public void displaySolutions()
    {
        System.out.println();
        System.out.println("Solution");
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                System.out.print(this.Solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkUp(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (row + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[row - i][col], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[row - i][col] = this.Matrix[row - i][col];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void checkDown(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (this.nRow - row + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[i + row][col], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[i + row][col] = this.Matrix[i + row][col];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void checkRight(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (this.nCol - col + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[row][col + i], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[row][col + i] = this.Matrix[row][col + i];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void checkLeft(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (col + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[row][col - i], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[row][col - i] = this.Matrix[row][col - i];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void checkUpRight(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (row + 1 >= currentWord.length() && this.nCol - col + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[row - i][col + i], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[row - i][col + i] = this.Matrix[row - i][col + i];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void checkUpLeft(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (row + 1 >= currentWord.length() && col + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[row - i][col - i], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[row - i][col - i] = this.Matrix[row - i][col - i];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void checkDownRight(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (this.nRow - row + 1 >= currentWord.length() && this.nCol - col + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[row + i][col + i], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[row + i][col + i] = this.Matrix[row + i][col + i];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void checkDownLeft(int num, int row, int col) {
        String currentWord = this.Words[num];
        boolean match = true;
        int i = 0;
        if (this.nRow - row + 1 >= currentWord.length() && col + 1 >= currentWord.length()) {
            while (match && i < currentWord.length()) {
                if (!Objects.equals(this.Matrix[row + i][col - i], currentWord.substring(i, i + 1))) {
                    match = false;
                } else {
                    this.Solution[row + i][col - i] = this.Matrix[row + i][col - i];
                    i += 1;
                }
            }

            if (match) {
                displaySolutions();
            } else {
                resetSolution();
            }
        }
    }

    public void solve() {
        int N = this.nWord;
        int i, j, nRow, nCol;
        for (i = 0; i < N; i++) {
            j = 0;
            String currentWord = this.Words[i];
            char currentChar = currentWord.charAt(j);
            resetSolution();

            for (nRow = 0; nRow < this.nRow; nRow++) {
                for (nCol = 0; nCol < this.nCol; nCol++) {
                    if (Objects.equals(this.Matrix[nRow][nCol], String.valueOf(currentChar))) {
                        checkUp(i, nRow, nCol);
                        checkDown(i, nRow, nCol);
                        checkRight(i, nRow, nCol);
                        checkLeft(i, nRow, nCol);
                        checkUpRight(i, nRow, nCol);
                        checkUpLeft(i, nRow, nCol);
                        checkDownRight(i, nRow, nCol);
                        checkDownLeft(i, nRow, nCol);
                    }
                }
            }
        }
    }
}
