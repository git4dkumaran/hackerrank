package com.test.first.FirstTest;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/mini-max-sum?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=90-day-campaign
/**
 * Input Format
 * 
 * A single line of five space-separated integers.
 * 
 * Constraints
 * 
 * Each integer is in the inclusive range . Output Format
 * 
 * Print two space-separated long integers denoting the respective minimum and
 * maximum values that can be calculated by summing exactly four of the five
 * integers. (The output can be greater than 32 bit integer.)
 * 
 * Sample Input
 * 
 * 1 2 3 4 5 Sample Output
 * 
 * 10 14 Explanation
 * 
 * Our initial numbers are , , , , and . We can calculate the following sums
 * using four of the five integers:
 * 
 * If we sum everything except , our sum is . If we sum everything except , our
 * sum is . If we sum everything except , our sum is . If we sum everything
 * except , our sum is . If we sum everything except , our sum is . As you can
 * see, the minimal sum is and the maximal sum is . Thus, we print these minimal
 * and maximal sums as two space-separated integers on a new line.
 * 
 * Hints: Beware of integer overflow! Use 64-bit Integer.
 *
 */
public class MiniMinMax {

	private Long findMin(Long[] input) {
		Long min = input[0];
		for (int i = 1; i < input.length; i++) {
			if (min > input[i]) {
				min = input[i];
			}
		}
		return min;
	}

	private Long findMax(Long[] input) {
		Long max = input[0];
		for (int i = 1; i < input.length; i++) {
			if (max < input[i]) {
				max = input[i];
			}
		}
		return max;
	}

	private Long doSum(Long[] input) {
		Long sum = 0l;
		for (int i = 0; i < input.length ; i++) {
			sum += input[i];
		}
		return sum;
	}

	private Long[] doSumWithoutIndexValue(Long[] input) {
		Long sum = doSum(input);

		Long[] result = new Long[input.length];

		for (int i = 0; i < input.length ; i++) {
			result[i] = sum - input[i];
		}

		return result;
	}

	public void findMiniMax(Long[] input) {

		Long[] sumResult = doSumWithoutIndexValue(input);

		System.out.println(findMin(sumResult) + "   " + findMax(sumResult));

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Long[] input = new Long[5];
		for (int i = 0; i < 5; i++) {
			input[i] = in.nextLong();
		}
		in.close();
		
		MiniMinMax mmm = new MiniMinMax();
		mmm.findMiniMax(input);

	}

}
