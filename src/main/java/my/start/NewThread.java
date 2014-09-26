package my.start;

public class NewThread implements Runnable {
	private String name;
	Thread t;
	
	NewThread(){
		t = new Thread (this,"DemoThreads");
		System.out.println("Generated thread: "+t);
		t.start();
	}
	
	NewThread(String threadName){
		name =threadName;
		t = new Thread (this,name);
		System.out.println("Thread created "+t);
		t.start();
	}
	
	public void run() {
		for(int i =5; i > 0; i--){
			System.out.println(t+" ---; "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("thread "+t+ " finish");
		}

}
