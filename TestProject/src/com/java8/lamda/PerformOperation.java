package com.java8.lamda;

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	// Write your code here
	public PerformOperation isOdd() {
		return (a) -> a % 2 == 0 ? false : true;
	}

	public PerformOperation isPrime() {	
		PerformOperation po = (a) -> {
			if (a <= 3) {
				return true;
			}
			if (a % 2 == 0) {
				return false;
			}
			for (int i = 3; i <= a / 2; i++) {
				if (a % i == 0) {
					return false;
				}
			}
			return true;
		};
		return po;
	}

}
