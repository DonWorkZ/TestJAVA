package com.slh.test;

import java.util.ArrayList;
import java.util.List;
public class Tester {
	static int n,k;
	static List<String> ll = new ArrayList<>();
	public static void main(String[] args) {
		int limit = 9;
		printDiamond(1, limit, false);
		
		printAllCombination(3);
		
	}

	/**
	 * Prints all combination for n numbers of cards throw
	 * @param n
	 */
	public static void printAllCombination(int n) {
		for(int i =0; i<= n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int c = 0; c<n;c++) {
				if(c < n-i) {
					sb.append("C");
				}
				else {
					sb.append("S");
				}
			}
			String str = sb.toString();
			permute(str, 0, str.length()-1);
		}
		
	}

	/**
	 * gives all combination for particular set of combination
	 * @param str
	 * @param l
	 * @param r
	 */
	private static void permute(String str, int l, int r) 
    { 
		if(!ll.contains(str)) {
			System.out.println(str);
    		ll.add(str);
		}
        if (l == r) 
        	if(ll.size()>0) {
        		if( !ll.contains(str)) {
            		System.out.println(str);
            		ll.add(str);
            	}
        	}
        	else {
        		ll.add(str);
        	}
        else { 
            for (int i = l; i <= r; i++) { 
                str = swap(str, l, i); 
                permute(str, l + 1, r); 
                str = swap(str, l, i); 
            } 
        } 
    }

	/**
	 * swaps the element to generating various combination
	 * @param a
	 * @param i
	 * @param j
	 * @return
	 */
	public static String swap(String a, int i, int j)
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }

	/**
	 * prints diamond for given number 
	 * @param n
	 * @param limit
	 * @param reverse
	 */
	public static void printDiamond(int n, int limit, boolean reverse) {
		int mid = (limit +1)/2;
		
		int space = (limit - n)/2;
		for(int i=0;i<limit;i++) {
			if(i < space || i > (space + n -1)) {
				System.out.print("  ");
			}
			else {
				System.out.print("* ");
			}
		}
		System.out.println("\n");
		
		if(reverse && n ==1) {
			return;
		}
		if(n == limit) {
			reverse = true;
		}
		if(reverse) {
			printDiamond(n-2, limit, reverse);
		}
		else {
			printDiamond(n+2, limit, reverse);
		}
		
	}
	
}
 