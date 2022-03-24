import java.util.*;

public class MedianQuickSort {
    public static void quicksort(int[] list, int low, int high) {
        if (low < high) {
        int mid = partition(list,low,high);
        quicksort(list, low, mid-1);
        quicksort(list, mid+1, high);
        }
    }

    public static int partition(int[] list, int low, int high) {
        // The pivot point is the first item in the subarray
        int first = list[low];
        int last = list[list.length - 1];
        int mid = list[high / 2]; 
        int[] sortingArr = { first, mid, last };
        Arrays.sort(sortingArr);
        
        int pivot = sortingArr[1];
        // Loop through the array. Move items up or down the array so that they
        // are in the proper spot with regards to the pivot point.
        do {
            // can we find a number smaller than the pivot point? keep
            // moving the ‘‘high’’ marker down the array until we find
            // this, or until high=low
            while (low < high && list[high] >= pivot) {
            high--;
            }
        
            if (low < high) {
                // found a smaller number; swap it into position
                list[low] = list[high];
                // now look for a number larger than the pivot point
                while (low < high && list[low] <= pivot) {
                    low++;
                }
            
                if (low < high) {
                // found one! move it into position
                list[high] = list[low];
                }
            }
        } 
        
        while (low < high);
            // move the pivot back into the array and return its index
            list[low] = pivot;
            return low;
    }

    public static void main(String[] args) {
        // Intialise an array 
        int arrSize = 16;
        int[] arr = new int[arrSize];
        Random rand = new Random();
        int n = arr.length - 1;
        
        // Randomise elements in the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        System.out.println("\n\n unsorted array: ");
		System.out.println(Arrays.toString(arr));
        
        quicksort(arr, 0, n);

        System.out.println("\n\n sorted array: ");
		System.out.println(Arrays.toString(arr));
    }
}