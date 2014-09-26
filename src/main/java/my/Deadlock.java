package my;

public class Deadlock {

	public static void main (String [] args){
		final Object resourse1 = "resourse1";
		final Object resourse2 = "resourse2";
		
		Thread t1 = new Thread (){
			public void run(){
				synchronized (resourse1){
					System.out.println("Поток исполнения 1 захвачен resourse1");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				synchronized(resourse2){
					System.out.println("Поток исполнения 1 захвачен resourse2");
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				synchronized (resourse2){
					System.out.println("Поток исполнения 2 захвачен resourse2");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				synchronized(resourse1){
					System.out.println("Поток исполнения 2 захвачен resourse1");
				}
			}
		};
		t1.start();
		t2.start();
	}
}
