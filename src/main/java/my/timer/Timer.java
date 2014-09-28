package my.timer;

import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

public class Timer {

	TreeSet tasks = new TreeSet(new TimerTaskComparator());
	TimerThread timer;
	
	public Timer(){
		this(false);
	}
	
	public Timer(boolean isDaemon){
		timer = new TimerThread(isDaemon);
		timer.start();
	}
	public void cancel(){
		synchronized(tasks){
			timer.pleaseStop();
			tasks.clear();
			tasks.notify();
		}
	}
	
	public void schedule(TimerTask task, long delay){
		task.schedule(System.currentTimeMillis()+delay,0, false);
		schedule(task);
	}
	public void schedule(TimerTask task, Date time){
		task.schedule(time.getTime(),0 ,false);
		schedule(task);
	}
	public void schedule(TimerTask task, Date firstTime , long period){
		task.schedule(firstTime.getTime(),period ,false);
		schedule(task);
	}
	public void schedule(TimerTask task, long delay, long period) {
		task.schedule(System.currentTimeMillis() + delay, period, false);
		schedule(task);
	}
	public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
		task.schedule(System.currentTimeMillis() + delay, period, true);
		schedule(task);
	}
	public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
		task.schedule(firstTime.getTime(), period, true);
		schedule(task);
	}
	
	void schedule(TimerTask task){
		synchronized (tasks){
			
			tasks.add(task);
			tasks.notify();
		}
	}
//-------------------------------------------------------------------------------
	public class TimerTaskComparator implements Comparator{

		public int compare(Object a, Object b) {
			TimerTask t1 = (TimerTask)a;
			TimerTask t2 = (TimerTask)b;
			long diff = t1.nextTime - t2.nextTime;
			if(diff<0)return -1;
			else if(diff>0)return 1;
			else return 0;
		}
		public boolean equals(Object o){
			return this == o;
		}

	}
	
//----------------------------------------------------------------------------------	
	public class TimerThread extends Thread{
		volatile boolean stopped = false;
		public TimerThread (boolean isDaemon){
			setDaemon (isDaemon);
		}
		
		public void pleaseStop(){
			stopped=true;
		}
		
		public void run(){
			TimerTask readyToRun=null;
			
			while(!stopped){
				if(readyToRun != null){
					if(readyToRun.cancelled){
						readyToRun = null;
						continue;
					}
					readyToRun.run();
					
					if(readyToRun.reschedule())schedule(readyToRun);
					readyToRun = null;
					continue;
				}
				synchronized (tasks){
					long timeout;
					
					if (tasks.isEmpty()){
						timeout = 0;
					}
					else {
						TimerTask t = (TimerTask) tasks.first();
						
						timeout = t.nextTime - System.currentTimeMillis();
						 if (timeout <= 0){
							 readyToRun = t;
							 tasks.remove(t);
							 continue;
						 }
					}
					
					try {
						tasks.wait(timeout);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}	
	}

}
