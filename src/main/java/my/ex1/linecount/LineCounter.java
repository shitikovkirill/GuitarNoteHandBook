package my.ex1.linecount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter implements Runnable{
	
	BufferedReader in;
	Printer print;
	
	public LineCounter(File filename ,Printer p){
		print = p;
		try {
			in = new BufferedReader( new FileReader( filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run() {
		// TODO Auto-generated method stub
		getText();
		
	}
	
	public void getText(){
StringBuffer s = new StringBuffer();
		
		String line;
		int lineCount = 0;
		try {
			while((line =in.readLine())!=null){
				s.append(line+"\n");
				lineCount++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print.print(lineCount, s.toString());
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
