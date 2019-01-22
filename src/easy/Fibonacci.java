package easy;

public class Fibonacci {

	int fibonacci(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		
		return fibonacci(n-2)+fibonacci(n-1);
	}
	
	int fibonacciItr(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
	
		int f1 = 0;
		int f2 = 1;
		
		int f = 0;
		for(int i=2; i<=n; i++) {
			f=f1+f2;
			f1=f2;
			f2=f;
		}
		
		return f2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(new Fibonacci().fibonacci(10));
		System.out.println(new Fibonacci().fibonacciItr(10));
	}

}
