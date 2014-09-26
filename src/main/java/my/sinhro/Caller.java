package my.sinhro;

public class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;
	public Caller (Callme targ, String s){
		target=targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		// Metod 2
		synchronized (target){
			target.call(msg);
		}
	}
}
