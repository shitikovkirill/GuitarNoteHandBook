package my.ex1.linecount;

public class Printer {
	
synchronized public void print(int count, String str){
	System.out.println("Количество строк: "+ count);
	System.out.println("");
	//System.out.println(str);
	System.out.println("-----------------------------------------------------");
}

}
