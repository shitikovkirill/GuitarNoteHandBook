package my.communication;

public class PC {

	public static void main(String arg []){
		Q q= new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println();
	}
}
