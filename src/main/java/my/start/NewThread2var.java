package my.start;

public class NewThread2var extends Thread{
NewThread2var(){
	super("Demo2");
	System.out.println("Generated thread: " +this);
	start();
}

public void run() {
	for(int i =5; i > 0; i--){
		System.out.println("Child "+i);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("thread "+this+ " finish");
	}
	
}
}
