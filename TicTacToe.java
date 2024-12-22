package five_projects;

import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    static char [][] arr = new char[3][3];

    private static  char [][] createEmptyTable(char arr[][]){
        for (int i=0; i<arr.length; i++ ) {
            for (int j=0; j< arr.length; j++ ) {
                arr[i][j] = '-';
            }
        }
        return arr;
    }
    private static char [][] printBoard(char arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr;
    }

    private static  boolean isValid(char arr[][],int row, int col){
        return row >= 0 && row < 3 && col >= 0 && col < 3 && arr[row][col] == '-';

    }

    private static  boolean checkWinner(char arr[][], char player){
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((arr[i][0] == player && arr[i][1] == player && arr[i][2] == player) ||
                    (arr[0][i] == player && arr[1][i] == player && arr[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        if ((arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) ||
                (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player)) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createEmptyTable(arr);

        char currentPlayer = 'X';
        boolean gameWon = false;
        int moves = 0;
        System.out.println("Ας παίξουμε τρίλιζα!");

        while (moves < 9 && !gameWon) {
            printBoard(arr);
            System.out.println("Παίχτης " + currentPlayer + ", Δήλωσε την κίνησή σου σειρά και στήλη με επιλογές 0,1,2 . ");

            int row, col;
            while (true) {
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (isValid(arr,row, col)) {
                    break;
                } else {
                    System.out.println("Μη έγκυρη κίνηση. Προσπάθησε ξανά !");
                }
            }

            arr[row][col] =  currentPlayer;
            moves++;
            gameWon = checkWinner(arr,currentPlayer);

            if (gameWon) {
                printBoard(arr);
                System.out.println("Παίχτης " + currentPlayer + " κέρδισε!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? '0' : 'X';
        }

        if (!gameWon) {
            printBoard(arr);
            System.out.println("It's a tie!");
        }

    }
    }



