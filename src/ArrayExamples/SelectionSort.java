package ArrayExamples;


import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        // testing smallestLoc()
        System.out.println(smallestLoc(0, new int[] {4, 1, 9, -1, 6}) == 3);
        System.out.println(smallestLoc(4, new int[] {4, 1, 9, -1, 6}) == 4);

        // testing sort()
        int [] aoi = {4, 1, 9, 2, -1, 6};
        System.out.println(Arrays.toString(sort(aoi)));

        // testing isOrdered()
        System.out.println(isOrdered(sort(aoi)));
    }


    //Return the index of the smallest item in the array
    public static int smallestLoc(int start, int[] aoi){
        int currentMin = aoi[start];
        int position = start;

        for(int i = start + 1; i < aoi.length; i++){
            if(aoi[i] < currentMin){
                currentMin = aoi[i];
                position = i;
            }
        }
        return position;
    }

    // Doing a selection sort (ordering smallest to largest)
    public static int[] sort(int[] aoi){

        for(int i = 0; i < aoi.length; i++){
            int j = smallestLoc(i, aoi);
            int temp = aoi[i];
            aoi[i] = aoi[j];
            aoi[j] = temp;
        }
        return aoi;
    }

    // Return true if aoi is in ascending order, false if otherwise
    public static boolean isOrdered(int[] aoi){
        boolean inOrder = true;
        for(int i = 0; i < aoi.length - 1; i++){
            if(aoi[i] < aoi[i + 1]){
                inOrder = true;
            } else
                inOrder = false;
        }
        return inOrder;
    }
}
