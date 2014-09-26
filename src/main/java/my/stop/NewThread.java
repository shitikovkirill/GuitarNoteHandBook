package my.stop;

public class NewThread implements Runnable{
	String name;
	Thread t;
	boolean suspendFlag;

	NewThread(String threadname){
		name = threadname;
		t = new Thread(this, name);
		System.out.println("Новый поток: "+t);
		suspendFlag = false;
		t.start();
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i = 15; i>0; i--){
				System.out.println(name+ ": "+i);
					Thread.sleep(200);
					synchronized(this){
						while(suspendFlag){
							wait();
						}
					}
					}
					
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
	}
	synchronized void mySuspend(){
		suspendFlag = true;
	}
	synchronized void myResume(){
		suspendFlag = false;
		notify();
	}
		
}
