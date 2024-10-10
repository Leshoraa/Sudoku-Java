import java.util.Random;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[9][9]; // Initialize the Sudoku board
        int[][] solution = new int[9][9]; // Initialize the solution board
        fillBoard(board); // Fill the board with a valid Sudoku puzzle
        copyBoard(board, solution); // Copy the board to the solution
        solveSudoku(solution); // Solve the Sudoku to get the solution
        printBoard(board); // Print the initial Sudoku board

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Solve by yourself? (y/n): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("y")) {
            playSudoku(board, solution); // Allow the user to play Sudoku
        } else {
            System.out.println("\nSolution:");
            printBoard(solution); // Print the solution if the user chooses not to play
        }
    }

    // Fill the board with a valid Sudoku puzzle
    private static void fillBoard(int[][] board) {
        Random rand = new Random();
        fillDiagonalSubgrids(board, rand); // Fill the diagonal subgrids
        solveSudoku(board); // Solve the board to ensure it's valid
        removeNumbers(board); // Remove numbers to create the puzzle
    }
    
    // Fill the diagonal subgrids with random numbers
    private static void fillDiagonalSubgrids(int[][] board, Random rand) {
        for (int i = 0; i < 9; i += 3) {
            fillSubgrid(board, i, i, rand); // Fill each 3x3 subgrid
        }
    }

    // Fill a 3x3 subgrid with random numbers
    private static void fillSubgrid(int[][] board, int row, int col, Random rand) {
        boolean[] used = new boolean[10]; // Track used numbers
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = rand.nextInt(9) + 1; // Generate a random number between 1 and 9
                } while (used[num] || !isSafe(board, row + i, col + j, num)); // Ensure the number is not used and is safe
                board[row + i][col + j] = num; // Place the number in the subgrid
                used[num] = true; // Mark the number as used
            }
        }
    }

    // Remove numbers from the board to create the puzzle
    private static void removeNumbers(int[][] board) {
        Random rand = new Random();
        int cellsToRemove = 40; // Number of cells to remove
        while (cellsToRemove > 0) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0; // Remove the number
                cellsToRemove--;
            }
        }
    }

    // Print the Sudoku board
    private static void printBoard(int[][] board) {
        System.out.print("     ");
        for (char c = 'A'; c <= 'I'; c++) {
            System.out.print(c + " ");
            if ((c - 'A' + 1) % 3 == 0 && c != 'I') {
                System.out.print("  ");
            }
        }
        System.out.println();
        
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                printSeparator(); // Print a separator line
            }
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                if (board[i][j] == 0) {
                    System.out.print(". "); // Print a dot for empty cells
                } else {
                    System.out.print(board[i][j] + " "); // Print the number
                }
            }
            System.out.println("|");
        }
        printSeparator(); // Print the final separator line
    }

    // Print a separator line
    private static void printSeparator() {
        System.out.print("    ");
        for (int k = 0; k < 23; k++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Solve the Sudoku puzzle
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Check if it's safe to place a number in the cell
    private static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num || board[row - row % 3 + x / 3][col - col % 3 + x % 3] == num) {
                return false;
            }
        }
        return true;
    }

    // Allow the user to play Sudoku
    private static void playSudoku(int[][] board, int[][] solution) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nInput coordinate and number (ex: A1 5): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (input.equalsIgnoreCase("bot")) {
                System.out.println("\nSolution:\n");
                printBoard(solution); // Print the solution if the user inputs "bot"
                break;
            }
            if (input.matches("[A-I][1-9] [1-9]")) {
                char colChar = input.charAt(0);
                int row = Character.getNumericValue(input.charAt(1)) - 1;
                int col = colChar - 'A';
                int num = Character.getNumericValue(input.charAt(3));
                if (solution[row][col] == num) {
                    System.out.println();
                    board[row][col] = num; // Place the number if it's correct
                } else {
                    System.out.println("\nWrong number. Try again.\n");
                }
                printBoard(board); // Print the board after each input
            } else {
                System.out.println("Invalid input. Format should be (ex: A1 5).");
            }
        }
    }

    // Copy the board to another board
    private static void copyBoard(int[][] source, int[][] destination) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                destination[i][j] = source[i][j];
            }
        }
    }
}
