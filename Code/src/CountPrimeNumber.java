
public class CountPrimeNumber {
	public static boolean isPrime(int num){
		int top = (int) (Math.sqrt(num));
		for(int i = 2; i <= top; i++){
			if(num % i == 0){
				//System.out.println(num + " " + i);
				return false;
			}
		}
		return true;
	}
	
	//This exceeds time limit
	public static int countPrimeI(int n){
		if(n <= 3){
			return n;
		}
		
		int count = 3;
		for(int i = 4; i<= n; i++){
			if(isPrime(i)){
				count++;
			}
		}
		return count;
	}
	
	//This
	public static int countPrime(int n){
		if(n <= 2){
			return 0;
		}
		
		boolean[] primes = new boolean[n];
		for(int i = 0; i < n; i++){
			primes[i] = true;
		}
		
		for(int i = 0; i <= Math.sqrt(n - 1); i++){
			if(primes[i]){
				for(int j = i+i; j < n; j += i){
					primes[j] = false;
				}
			}
		}
		int count = 0;
		for(int i = 0; i < n; i++){
			if(primes[i]){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		int n = 60;
		int res = countPrimeI(n);
		System.out.println(res);
		
	}
}
