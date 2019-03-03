package com.hackerrank.ds.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxHourGlassSum {

	    // Complete the hourglassSum function below.
	    static int hourglassSum(int[][] arr) {
	        int maxSum=Integer.MIN_VALUE;
	        for(int i=0;i<arr.length-2;i++){
	            for(int j=0;j<arr[i].length-2;j++){
	                int sum=0;
	                for(int k=j;k<=j+2;k++)sum+=arr[i][k];
	                sum+=arr[i+1][j+1];
	                for(int k=j;k<=j+2;k++)sum+=arr[i+2][k];
	                if(sum>=maxSum) maxSum = sum;
	        }
	    }
	    return maxSum;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int[][] arr = new int[6][6];

	        for (int i = 0; i < 6; i++) {
	            String[] arrRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 6; j++) {
	                int arrItem = Integer.parseInt(arrRowItems[j]);
	                arr[i][j] = arrItem;
	            }
	        }

	        int result = hourglassSum(arr);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	}
