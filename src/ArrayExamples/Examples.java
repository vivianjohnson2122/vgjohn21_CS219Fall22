package ArrayExamples;

import java.util.Arrays;
import java.util.Random;

public class Examples {

    public static void main(String[] args){

        int [] nums = {4, 1, 0, 9, 2};
        int [] grades = new int[10]; // allocate space for ten grades
        String [] names = {"Harry", "Hermione", "Ron", "Draco"};

        // testing indexOf function
        System.out.println(indexOf(names, "Ron") == 2);
        System.out.println(indexOf(names, "Mark") == -1);
        System.out.println(indexOf(names, "Draco") == 3);


        // testing max function
        System.out.println(max(nums) == 9);

        // testing reverse function
        System.out.println(Arrays.equals(reverse(nums), new int[] {2, 9, 0, 1, 4}));

        System.out.println(nums[2]); // prints the third number (0)
        // System.out.println(nums[-1]); // index out of range error

        fillRandom(grades);
        System.out.println(Arrays.toString(grades));
        printArray(grades);
        printArray2(grades);

        int z = 33;
        f(z); // when z is passed to x, a copy is made
        System.out.println(z);

        System.out.println(sum(grades) == 48);
        System.out.println(sum2(grades) == 48);
        System.out.println(sum3(grades) == 48);

        System.out.println(average(grades) == 4.8);
        System.out.println(median(grades) == 4.5);
    }

    public static void f(int x){
        x = 7;
    }

    // function to fill an array of intergers
    // with random values between 1 and 10 inclusive
    public static void fillRandom(int [] arr){
        Random rng = new Random();
        rng.setSeed(10);
        for(int i = 0; i < arr.length; i++){
            arr[i] = rng.nextInt(1, 11);
        }
    }

    public static void printArray(int [] arr){
        System.out.print('[');
        for(int i = 0; i < arr.length - 1; i++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[arr.length - 1]);
        System.out.println(']');
    }

    public static void printArray2(int [] arr){
        System.out.print('[');

        // enhanced for each loop
        for(int v : arr) // for each value v in the array arr
            System.out.print(v + ", ");
        System.out.println(']');
    }
    public static int sum(int [] arr){
        int total = 0;
        for(int v : arr)
            total += v;
        return total;
    }

    public static int sum2(int [] arr){
        int total = 0;
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
        }
        return total;
    }

    public static int sum3(int [] arr){
        int total = 0;
        int i = 0; // using it as the index

        while(i < arr.length){
            total += arr[i++]; // prints then increments i in the same line
        }
        return total;
    }

    // write a function that returns the average of an array of integers
    public static double average(int [] arr){
        double total = sum(arr);
        return total / arr.length;
        // or can do: return (double) sum(arr) / arr.length;
    }

    public static double median(int [] arr){
        Arrays.sort(arr);
        int mid = 0;
        if(arr.length % 2 == 0){
            int pos1 = arr[(arr.length / 2) - 1];
            int pos2 = arr[arr.length / 2];
            return (pos1 + pos2) / 2.0;
        } else
            return arr[arr.length / 2];

    }

    // searches through and finds the max value in the array - returns max value
    // final because don't want THIS METHOD to change the values in the array
    public static int max(final int [] arr){
        int current_max = arr[0];
        // int current_max = Integer.MIN_VALUE; --> would need to change loop to start at 0
        for(int i = 1; i < arr.length; i++){
            if(current_max < arr[i])
                current_max = arr[i];
        }
        return current_max;
    }

    // reverse the values in the array
    public static int[] reverse(int[] arr){
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[(arr.length - 1) - i];
            arr[(arr.length - 1) - i] = temp;
        }
        return arr;
    }

    // return the index of the item in arr
    // if not found, return -1
    public static int indexOf(final String[] arr, String item){
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

}
