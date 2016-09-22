import java.util.*;
public class AssignmentOne {
	public List<Integer> lprimes(List<Integer[]> intervals) {
		List<Integer> res = new ArrayList<Integer>();
		List<PrimeFinder> list1 = new ArrayList<PrimeFinder>();
		List<Thread> list2 = new ArrayList<Thread>(); 
		if(intervals == null || intervals.size() == 0) {
			return res;
		}
		for(Integer[] interval : intervals) {
			PrimeFinder pf = new PrimeFinder(interval[0] , interval[1]);
			Thread t = new Thread(pf);
			t.start();
			list1.add(pf);
			list2.add(t);
		}
		
		for(int i = 0 ; i < list2.size(); i++) {
			Thread t = list2.get(i);
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 0 ; i < list1.size(); i++) {
			res.addAll(list1.get(i).getPrimelist());
		}
		return res;
	}
}
