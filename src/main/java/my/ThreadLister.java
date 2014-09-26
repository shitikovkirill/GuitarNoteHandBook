package my;

import java.awt.BorderLayout;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ThreadLister {
	public static void listAllThreads(PrintWriter out){
		ThreadGroup current_thread_group;
		ThreadGroup root_thread_group;
		ThreadGroup parent;
		
		current_thread_group = Thread.currentThread().
				getThreadGroup();
		
		root_thread_group = current_thread_group;
		parent =root_thread_group.getParent();
		while(parent != null){
			root_thread_group = parent;
			parent=parent.getParent();
			
			printGroupInfo(out, root_thread_group, "");
		}
		
	}
	
	private static void printGroupInfo(PrintWriter out,
			ThreadGroup g, String indent) {
		// TODO Auto-generated method stub
		if(g==null) return;
		int num_thread =g.activeCount();
		int num_group = g.activeGroupCount();
		
		Thread [] threads = new Thread[num_thread];
		ThreadGroup [] groups = new ThreadGroup[num_group];
		
		g.enumerate(threads, false);
		g.enumerate(groups , false);
		
		out.println(indent+" Группа потоков исполнения: "+g.getName()+
				" Наивысший приоритет: "+ g.getMaxPriority()+
				(g.isDaemon()?"Демон":""));
		for(int i =0; i<num_thread; i++)
			printThreadInfo(out, threads[i], indent+" ");
	}

	private static void printThreadInfo(PrintWriter out, Thread t,
			String ident) {
		// TODO Auto-generated method stub
		if(t==null)return;
		out.println(ident+"  "+t.getName()+"   "+t.getPriority()+
				(t.isDaemon()?" Демон ":"")+
				(t.isAlive()?"": " Не активен"));
	}

	public static void main(String arg[]){
		JFrame frame = new JFrame("ThreadLIster Demo");
		JTextArea textarea = new JTextArea();
		frame.getContentPane().add(new JScrollPane(textarea),
				BorderLayout.CENTER);
		
		frame.setSize(500,400);
		frame.setVisible(true);
		
		StringWriter sout = new StringWriter();
		PrintWriter out = new PrintWriter(sout);
		ThreadLister.listAllThreads(out);
		
		out.close();
		String treadListing = sout.toString();
		
		textarea.setText(treadListing);
	}
}
