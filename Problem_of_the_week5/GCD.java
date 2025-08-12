/* class Solution {
    public int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        return gcd(min,max);
    }
    //time complexity of this code is O(n) basically
} */

import java.util.*;

public class Main {
    // Function to compute GCD of two numbers using Euclidean algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to compute GCD of an array
    public static int findGCD(int[] arr, int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) {
                return 1; 
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findGCD(arr, n));
    }
}
// the time complexity of this is O(n log m ) where n is the size of an array and m is the largest number


