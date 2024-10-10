## Sudoku Generator and Solver

This repository contains a Java-based Sudoku generator and solver. The program generates a valid Sudoku puzzle, allows users to solve it interactively, and provides the solution upon request.

### Features
- Generates a valid Sudoku puzzle.
- Interactive user input for solving the puzzle.
- Provides the solution when requested.
- Ensures no duplicate numbers in rows, columns, or subgrids.

### How to Use
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Leshoraa/Sudoku-java.git
   cd Sudoku-java
   ```

2. **Compile the Java program:**
   ```bash
   javac Sudoku.java
   ```

3. **Run the program:**
   ```bash
   java Sudoku
   ```

4. **Follow the prompts:**
   - The program will display the generated Sudoku puzzle.
   - You can choose to solve the puzzle yourself or see the solution.
   - If you choose to solve it yourself, input coordinates and numbers in the format `A1 5`.
   - To see the solution at any time, input `bot`.

### Example
```
    A B C   D E F   G H I 
    -----------------------
 1 | 3 . . | . . 4 | 6 . 8 |
 2 | 2 . . | 1 . . | . . 5 |
 3 | 8 . . | 9 5 3 | . 2 4 |
    -----------------------
 4 | 1 5 . | . . 7 | 9 4 . |
 5 | . 2 3 | 8 6 . | . 1 . |
 6 | . . 9 | . 4 1 | 2 8 3 |
    -----------------------
 7 | 5 . 2 | . . 8 | . . . |
 8 | 9 . . | 7 1 . | . 3 . |
 9 | . . 1 | . 3 2 | 4 5 . |
    -----------------------

Solve by yourself? (y/n): y

Input coordinate and number (ex: A1 5): A1 3
Input coordinate and number (ex: A1 5): bot

Solution:
    A B C   D E F   G H I 
    -----------------------
 1 | 3 1 5 | 6 7 4 | 6 9 8 |
 2 | 2 6 4 | 1 8 9 | 7 3 5 |
 3 | 8 9 7 | 9 5 3 | 1 2 4 |
    -----------------------
 4 | 1 5 8 | 2 3 7 | 9 4 6 |
 5 | 4 2 3 | 8 6 5 | 7 1 9 |
 6 | 7 6 9 | 4 4 1 | 2 8 3 |
    -----------------------
 7 | 5 3 2 | 4 9 8 | 6 7 1 |
 8 | 9 8 6 | 7 1 2 | 5 3 2 |
 9 | 6 4 1 | 5 3 2 | 4 5 7 |
    -----------------------
```

### License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
