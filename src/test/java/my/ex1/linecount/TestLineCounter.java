package my.ex1.linecount;

import java.io.File;

import org.junit.Test;

public class TestLineCounter {
	Printer p = new Printer();
	
	LineCounter line1 = new LineCounter(new File("Files\\1.txt"),p);
	LineCounter line2 = new LineCounter(new File("Files\\2.txt"),p);
	LineCounter line3 = new LineCounter(new File("Files\\3.txt"),p);
	LineCounter line4 = new LineCounter(new File("Files\\4.txt"),p);
	LineCounter line5 = new LineCounter(new File("Files\\5.txt"),p);
	
	LineCounter line6 = new LineCounter(new File("Files\\Olegov Shit.txt"),p);
	LineCounter line7 = new LineCounter(new File("Files\\Dekab.txt"),p);
	LineCounter line8 = new LineCounter(new File("Files\\Kozachya.txt"),p);
	LineCounter line9 = new LineCounter(new File("Files\\Oleg.txt"),p);
	LineCounter line10 = new LineCounter(new File("Files\\Zimniy Vecher.txt"),p);
	
	
	@Test
	public void goPotoki2(){
	
	line1.run();
	line2.run();
	
	}
	
	@Test
	public void goLine2(){
		
	line1.getText();
	line2.getText();
	
	}
	
	@Test
	public void goPotoki5(){
	
	line1.run();
	line2.run();
	line3.run();
	line4.run();
	line5.run();
	
	}
	
	@Test
	public void goLine5(){
		
	line1.getText();
	line2.getText();
	line3.getText();
	line4.getText();
	line5.getText();
	
	}
	
	@Test
	public void goPotoki10(){
	
	line1.run();
	line2.run();
	line3.run();
	line4.run();
	line5.run();
	
	line6.run();
	line7.run();
	line8.run();
	line9.run();
	line10.run();
	
	}
	
	@Test
	public void goLine10(){
		
	line1.getText();
	line2.getText();
	line3.getText();
	line4.getText();
	line5.getText();
	
	line6.getText();
	line7.getText();
	line8.getText();
	line9.getText();
	line10.getText();
	}
	

}
