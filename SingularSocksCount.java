import java.util.HashMap;
import java.util.Map;

public class SingularSocksCount {
    public static void main(String[] args) {
        int[] sockPairsArray = {10, 20, 20, 10, 10, 30, 50, 10, 20}; // Example input array with sock pair IDs

        int singularSocksCount = findSingularSocksCount(sockPairsArray);
        System.out.println("Count of Singular Socks: " + singularSocksCount);
    }

    public static int findSingularSocksCount(int[] arr) {
        Map<Integer, Integer> sockPairsCountMap = new HashMap<>();

        // Count occurrences of each sock pair ID
        for (int num : arr) {
            sockPairsCountMap.put(num, sockPairsCountMap.getOrDefault(num, 0) + 1);
        }

        int singularSocksCount = 0;
        // Count the number of singular socks
        for (int count : sockPairsCountMap.values()) {
            if (count == 1) {
                singularSocksCount++;
            }
        }

        return singularSocksCount;
    }
}
