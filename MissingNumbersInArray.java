import java.util.Arrays;

public class MissingNumbersInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 9}; // Example input array with missing numbers
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);

        findAndPrintMissingNumbers(arr, min, max);
    }

    public static void findAndPrintMissingNumbers(int[] arr, int min, int max) {
        boolean[] isPresent = new boolean[max - min + 1];

        for (int num : arr) {
            isPresent[num - min] = true;
        }

        System.out.println("Missing Numbers:");

        for (int i = 0; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                int missingNum = min + i;
                System.out.println(missingNum);
            }
        }
    }
}
