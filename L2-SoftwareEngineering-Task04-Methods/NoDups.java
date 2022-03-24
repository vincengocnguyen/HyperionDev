import java.util.Arrays;

public class NoDups
{
    public static void main(String[] args) 
    {
        int[] arrayInput = {20,20,100,10,80,70,1,0,-1,2,10,15,300,7,6,2,18,19,21,9,0};

        System.out.println("Before: " + Arrays.toString(arrayInput));

        System.out.println("After: " + Arrays.toString(removeDups(arrayInput)));
    }

    public static int[] removeDups(int[] arr)
    {
        int length_unique = arr.length;

        int k, l;

        // Comparing each element with all other elements
        for (k = 0; k < length_unique; k++)
        {
            for (l = k + 1; l < length_unique; l++)
                if (arr[k] == arr[l])       // If two are found equal
                {
                    // Replace the duplicate elemtnwith the last unique element
                    arr[l] = arr[length_unique - 1];

                    length_unique--;

                    l--;
                }
        }

        int[] newArr = Arrays.copyOf(arr, length_unique);       // Copy only the unique elements to a new array

        return newArr;
    }


}