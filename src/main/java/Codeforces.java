package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Codeforces {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();

        while (times > 0) {
            int n = in.nextInt();

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                int val = in.nextInt();
                nums[i] = val;
            }
            Arrays.sort(nums);
            int maxSum = 0;
            for (int i = 1; i < n; i++) {
                maxSum += (nums[i] - nums[i-1]);
            }
            System.out.println(maxSum);
            times--;
        }
    }
}
