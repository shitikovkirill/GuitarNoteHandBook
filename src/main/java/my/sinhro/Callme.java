package my.sinhro;

public class Callme {
	//Удали synchronized чтобы увидеть как работает без синхронизации
	synchronized void call (String msg){
	System.out.println("[" +msg);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("]");
	}

}
