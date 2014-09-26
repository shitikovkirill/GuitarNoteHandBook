package my.sinhro;

public class Synch {

	public static void main(String args[]){
		Callme target = new Callme();
		Caller ob1 = new Caller (target,"hello");
		Caller ob2 = new Caller (target,"in sinchronize ");
		Caller ob3 = new Caller (target,"world");
		
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
