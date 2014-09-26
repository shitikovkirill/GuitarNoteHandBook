package my.priority;

public class HiLoPrimer {

	public static void main (String args[]){
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi = new Clicker(Thread.NORM_PRIORITY+2);
		Clicker lo = new Clicker(Thread.NORM_PRIORITY-2);
		
		hi.start();
		lo.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hi.stop();
		lo.stop();
		try {
			hi.t.join();
			lo.t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" low priority threads "+lo.click);
		System.out.println(" hie priority threads "+hi.click);
	}
}
