package se.edument.test.thread;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import se.edument.thread.concurrent.ThreadLock;

public class TestThreadLock {
	private ThreadLock<Integer> lockPage = new ThreadLock<Integer>();
	Map<Integer, Integer> counters =  new HashMap<Integer, Integer>();
	//ConcurrentHashMap<K, V>
	Integer limit = 2;
	
	@Test
	public void testLock() throws InterruptedException{
		new Thread(new MyRunnable(2)).start();
		new Thread(new MyRunnable(2)).start();
		new Thread(new MyRunnable(2)).start();
		new Thread(new MyRunnable(2)).start();
		new Thread(new MyRunnable(2)).start();
		Thread.sleep(5000L);
	}
	
	
	public void lockPage(Integer lock){
		System.out.println("---> acquire lock for "+lock);
		lockPage.acquire(lock);
		System.out.println("lock acquired for "+lock);
		
		
		try{
			if(counters.get(lock)==null)
				counters.put(lock, 0);
			
			System.out.println("counter: "+counters.get(lock)+" - limit ("+limit+")");
				while(counters.get(lock)>limit){
			
				System.err.println("Limit reached for lock = "+lock);
				try {
					synchronized (counters){
						counters.wait();
					}
				} catch (InterruptedException e) {
					System.err.println("InterruptedException for pageId: "+lock+" "+e.getLocalizedMessage());
				}
			}
			Integer count = counters.get(lock);
			if(count==null)
				System.err.println("Counter null for lock = "+lock);
			count = count + 1;
			counters.put(lock, count);
			
		}finally{
			lockPage.release(lock);
		}
	}
	
	private class MyRunnable implements Runnable{

		private Integer lock;
		
		public MyRunnable(Integer lock){
			this.lock = lock;
		}
		
		@Override
		public void run() {
			lockPage(lock);
			
		}
		
	}
	
}  // end class TestThreadLock