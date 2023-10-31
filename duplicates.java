import java.util.*;
public class duplicates {
  
    public static void removeDuplicates(int arr[], int num)
    {
        Set<Integer> hash_set = new HashSet<Integer>();
        for (int i = 0; i<num; i++) {
            hash_set.add(arr[i]);
        }  
        System.out.print(hash_set);
        
    }
    public static void main(String[] args)
    {
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        int num = arr.length;
        removeDuplicates(arr, num);
    }
}
