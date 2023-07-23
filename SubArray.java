import java.util.*;

public class subArray {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int[] arr = new int[sc.nextInt()];
        
            for (int i = 0; i < arr.length; i++)
                arr[i] = sc.nextInt();
        
            System.out.println(getCount(0, arr));
        }
    }
    public static int getCount(int start, int[] arr){
        if(start >= arr.length) return 0;
        
        int negCount = 0;
        int lastIndex = arr.length;
        
        while(start < lastIndex)
            if(Arrays.stream(Arrays.copyOfRange(arr, start, lastIndex--)).sum() < 0) 
                negCount++;
        
        return negCount + getCount(start+1, arr);
    }
}