package five_projects;
import java.io.*;
import java.util.*;

public class SixNumbers {

    static String fileName = "numbers.txt";
    static int[] nums = new int[49];
    static String path = "C:\\Users\\g7met\\Downloads\\numbers.txt";
    static String out = "C:\\Users\\g7met\\Downloads\\out1.txt";

    public static int[] readNums(String file) {

        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextInt()) {
                ctr++;
                s.nextInt();
            }
            int[] nums = new int[ctr];
            Scanner s1 = new Scanner(f);
            for (int i = 0; i < nums.length; i++)
                nums[i] = s1.nextInt();

            return nums;
        } catch (Exception e) {
            return null;
        }

    }


    private static int[][] splitArray(int[] array, int numParts) {
        if (array.length % numParts != 0) {
            throw new IllegalArgumentException("Array length must be divisible by the number of parts.");
        }

        int partSize = array.length / numParts;
        int[][] result = new int[numParts][partSize];

        for (int i = 0; i < numParts; i++) {
            System.arraycopy(array, i * partSize, result[i], 0, partSize);
        }

        return result;
    }

    private static void writeNumbersToFile(int[] numbers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int number : numbers) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
            System.out.println("Numbers written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        nums = readNums(path);
        if (nums.length < 6 || nums.length > 49) {
            System.out.println("Σφάλμα: Το αρχείο πρέπει να περιέχει από 6 έως 49 αριθμούς.");
        } else {
            System.out.println("Έγκυροι αριθμοί:");
        }


        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length);

        int[][] splitArrays = splitArray(nums, 8);
        for (int i = 0; i < splitArrays.length; i++) {
            System.out.println("Array " + (i + 1) + ":");
            for (int num : splitArrays[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
            writeNumbersToFile(splitArrays[i], out);
            System.out.println(isEven(splitArrays[i]));
            System.out.println(isOdd(splitArrays[i]));
            System.out.println(isConsecutive(splitArrays[i]));
            System.out.println(threeEndings(splitArrays[i]));
            System.out.println(sameDecade(splitArrays[i]));

        }

    }

    private static boolean isEven(int arr[]) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
            if (count > 4) break;
        }
        return count<=4;
    }

    private static boolean isOdd(int arr[]) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            }
            if (count > 4) break;
        }
        return count<=4;

    }

    private static boolean isConsecutive(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i + 1] + 1) {
                count++;
            }
            if (count > 2) break;
        }
        return count<=2;
    }

    private static boolean threeEndings(int[] arr) {
        int count = 0;
        List<Integer> arrlist = new ArrayList<Integer>();
        for (int num : arr) {
          int endingDigit = num%10;
          arrlist.add(endingDigit);
        }
        Set set = new HashSet();
        //List list2 = new ArrayList<>();

        for (int i = 0; i < arrlist.size(); i++) {

            if (set.contains(arrlist.get(i))) {
                count++;
            } else {
                set.add(arrlist.get(i));
            }
        }

        return count<=3;
    }




    private static boolean sameDecade(int arr[]) {
        int count = 0;
        List<Integer> arrlist = new ArrayList<Integer>();
        for (int num : arr) {
            if (num>=10){
            int dekada = num/10;
            arrlist.add(dekada);
        }
        Set set = new HashSet();
        //List list2 = new ArrayList<>();

        for (int i = 0; i < arrlist.size(); i++) {

            if (set.contains(arrlist.get(i))) {
                count++;
            } else {
                set.add(arrlist.get(i));
            }
        }
    }
        return count<=3;
    }
    }




