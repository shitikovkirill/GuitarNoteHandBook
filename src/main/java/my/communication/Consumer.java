package my.communication;

public class Consumer implements Runnable {
Q q;
Consumer(Q q){
	this.q=q;
	new Thread (this, "Consumer").start();;
}
	public void run() {
		// TODO Auto-generated method stub
			while(true){
				q.get();
			}
	}

}