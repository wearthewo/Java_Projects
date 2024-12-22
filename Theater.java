package five_projects;

import java.util.Arrays;
import java.util.Scanner;

public class Theater {
    private static boolean arr [][] = new boolean[30][12] ;


    private static void book(int row, int col) {
        //arr [row][col] = true;
        for (boolean[] r : arr) {
            for (boolean i : r) {
                arr[row][col] = true;
            }
        }
    }

    private static void cancelBook(int row, int col) {

        for (boolean[] r : arr) {
            for (boolean i : r) {
                arr[row][col] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int row,col;
        do{
            System.out.println("Please select one of the following");
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a booked seat");
            System.out.println("3. Exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Επέλεξε σειρά (0-29) και στήλη (0-11) που θες να κλείσεις");
                    row = in.nextInt();
                    col = in.nextInt();
                    book(row,col);
                    System.out.println(Arrays.deepToString(arr));
                    break;
                case 2:
                    System.out.println("Επέλεξε σειρά (0-29) και στήλη (0-11) που θες να ακυρώσεις");
                    row = in.nextInt();
                    col = in.nextInt();
                    cancelBook(row,col);
                    System.out.println(Arrays.deepToString(arr));
                    break;
                case 3:
                    System.out.println("ΈΞΟΔΟΣ");
            }
        }while(choice!=3);

    }

}
