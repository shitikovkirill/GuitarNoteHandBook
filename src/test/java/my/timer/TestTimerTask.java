package my.timer;

import org.junit.Test;

public class TestTimerTask {
	@Test
	public void m(){
	final TimerTask t1 = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("boom");
		}
		
	};
	final TimerTask t2 = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("\tBOOM");
		}
		
	};
	final TimerTask t3 = new TimerTask(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			t1.cancel();
			t2.cancel();
		}
		
	};
	
	final Timer timer = new Timer();
	timer.schedule(t1,0,500);
	
	timer.schedule(t2,2000,2000);
	
	timer.schedule(t3,5000);
	
	timer.scheduleAtFixedRate(new TimerTask(){
		public int times = 5;
		public void run(){
			System.out.println(times--);
			if(times==0){timer.cancel();}
		}
	},5000,5000);
	}
}
