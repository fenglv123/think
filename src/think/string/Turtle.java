package think.string;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
	
	private String name;
	private Formatter format;
	
	public Turtle(String name,Formatter format){
		this.name = name;
		this.format = format;
	}
	
	public void move(int x,int y){
		format.format("%s Turtle is at (%d,%d)\n", name,x,y);
	}
	
	public static void main(String[] args) {
		PrintStream ps = System.out;
		Turtle tommy = new Turtle("tommy", new Formatter(System.out));
		
		Turtle jerry = new Turtle("jerry", new Formatter(ps));
		
		tommy.move(1, 3);
		tommy.move(2, 4);
		jerry.move(3, 5);
		jerry.move(5, 75);
		tommy.move(1, 9);
		jerry.move(1, 3);
		tommy.move(1, 1);
	}
	
	

}
