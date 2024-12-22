package five_projects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CharFrequency {
    static int[][] charTable = new int[128][2];
    static String fileName = "C:\\Users\\g7met\\Downloads\\java.txt";// Όνομα του αρχείου εισόδου

    public CharFrequency() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        // Αρχικοποίηση πίνακα
        for (int i = 0; i < 128; i++) {
            charTable[i][0] = i; // Αποθηκεύει τον ASCII κωδικό του χαρακτήρα
            charTable[i][1] = 0; // Μηδενίζει τη συχνότητα
        }
        System.out.println(Arrays.deepToString(charTable));


        try {
            try (FileReader reader = new FileReader(fileName)) {
                int ch;
                while ((ch = reader.read()) != -1) {
                    // Αγνόηση whitespaces
                    if (!Character.isWhitespace(ch) && ch < 128) {
                        charTable[ch][1]++; // Αυξάνει τη συχνότητα για τον χαρακτήρα
                    }
                }
                System.out.println(Arrays.deepToString(charTable));
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
                return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // Φιλτράρισμα χαρακτήρων που δεν εμφανίζονται
        int[][] filteredTable = Arrays.stream(charTable)
                .filter(entry -> entry[1] > 0)
                .toArray(int[][]::new);

        // Ταξινόμηση κατά χαρακτήρα (αυξουσα σειρά)
        Arrays.sort(filteredTable, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println("Statistics sorted by character:");
        for (int[] entry : filteredTable) {
            System.out.printf("Character: %c, Frequency: %d%n", entry[0], entry[1]);
        }

        // Ταξινόμηση κατά συχνότητα (φθίνουσα σειρά)
        Arrays.sort(filteredTable, (a, b) -> Integer.compare(b[1], a[1]));
        System.out.println("\nStatistics sorted by frequency:");
        for (int[] entry : filteredTable) {
            System.out.printf("Character: %c, Frequency: %d%n", entry[0], entry[1]);
        }
    }
}
