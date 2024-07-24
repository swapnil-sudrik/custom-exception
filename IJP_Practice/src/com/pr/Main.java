package com.pr;

public class Main {

	
	public static void check(int age) throws Custom {
		if (age<=18) {
			throw new Custom("age is not valid");
		}else {
			System.out.println("valid age");
		}
	}
	
	public static void main(String[] args) {
		try {
			check(10);
		} catch (Custom e) {
			System.out.println(e.getMessage());
		}
	}
	
}
