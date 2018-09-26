package com.utility;

public class MaoP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arry[] = { 1, 3, 5, 8, 9, 7, 2, 4, 6 };
		for (int i = 0; i < arry.length-1; i++) {
			for (int j = 0; j < arry.length-1-i; j++) {
				if (arry[j] > arry[j + 1]) {
					int tep = arry[j];
					arry[j] = arry[j + 1];
					arry[j + 1] = tep;
				}
			}
		}
		for (int num : arry) {
			System.out.println("num:" + num);
		}
		
		
		System.out.println(arry.length-1);
	}
}