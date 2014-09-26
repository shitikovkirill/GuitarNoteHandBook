package my.start;

public class ThreadDemo {
	static NewThread nt;
	static NewThread nt2;
	
public static void main (String args[]){
	nt = new NewThread();
	new NewThread2var();
	nt2= new NewThread("Hello");
	
	for(int i =5; i > 0; i--){
		System.out.println("ThreadPerent "+i);
	}
	System.out.println("waiting for completion threads");
	try {
		nt.t.join();
		nt2.t.join();
		
		System.out.println("threads "+ nt.t+" started : " +nt.t.isAlive());
		System.out.println("threads "+ nt2.t+" started : " +nt2.t.isAlive());
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
