import java.util.*;
public class PrimeFinder implements Runnable {
	
	private int start;
	private int end;
	private List<Integer> prims;
	
	public PrimeFinder(int startNum , int endNum) {
		start = startNum;
		end = endNum;
		prims = new ArrayList<Integer>();
	}
	
	public List<Integer> getPrimelist() {
		return prims;
	}
	
	public Boolean isPrime(int n) {
		if(n == 1) return true;
		for(int i = 2 ; i < n ; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = start ; i <= end ; i++) {
			if(isPrime(i)) {
				prims.add(i);
			}
		}
	}

}
