package my.stop;

public class SuspendResume {
public static void main(String args[]){
	NewThread ob1 = new NewThread("Один");
	NewThread ob2 = new NewThread("Два");
	try{
		Thread.sleep(1000);
		ob1.mySuspend();
		System.out.println ("Приостановка потока Один");
		Thread.sleep(1000);
		ob1.myResume();
		System.out.println ("Возобновление потока Один");
		ob2.mySuspend();
		System.out.println("Приостановка потока Два");
		Thread.sleep(1000);
		ob2.myResume();
		System.out.println ("Возобновление потока Два");
	} catch (InterruptedException e){
		
	}
	
	System.out.println("Ogidanie zaversheniya potoka");
	try {
		ob1.t.join();
		ob2.t.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Glavniy potok zavershon");
}
}
