package my;
public class ThreadDemo extends Thread {
	public void run() {
	 for (int i = 0; i<5; i++) {
		 compute();
	 }
	 
	}
	
	public static void main (String arg[]){
		ThreadDemo thread1 = new ThreadDemo();
		Thread thread2 = new Thread (new Runnable(){
			public void run() {
				for (int i = 0; i<5; i++) {
					compute();
				}
			}
		});
		thread1.setPriority(1);
		thread2.setPriority(2);
		
		thread1.start();
		thread2.start();
		
		for (int i = 0; i<3; i++) compute();
		
		try{
			thread1.join();
			thread2.join();
		} catch (InterruptedException e){
			
		}
		}
		
		static ThreadLocal numcalls = new ThreadLocal();
		
		static synchronized void compute (){
		Integer n = (Integer) numcalls.get();
		System.out.println(n);
		if(n==null)	n=new Integer(1);
		else n = new Integer(n.intValue()+1);
		
		numcalls.set(n);
		
		System.out.println(Thread.currentThread().getName()+ " " + n);
		
		for(int i = 0; i<1000; i++){
			try{
				Thread.sleep((int)Math.random()*100+1);
			} catch (InterruptedException e) {
			}
		}
		Thread.yield();
}
}
