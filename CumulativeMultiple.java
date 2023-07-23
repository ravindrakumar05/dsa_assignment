import java.util.Scanner;

public class CumulativeMultiple {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                throw new IllegalArgumentException("Array size must be a positive integer.");
            }

            int[] arr = new int[size];
            System.out.println("Enter " + size + " integers:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            int cumulativeMultiple = 1;
            for (int num : arr) {
                cumulativeMultiple *= num;
            }

            System.out.println("Cumulative Multiple: " + cumulativeMultiple);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
