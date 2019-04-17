package think.generics;

import java.util.EnumSet;
import java.util.Set;
import static think.generics.Water.*;

public class CountedObject {

	private static long counter = 0;
	private final long id = counter++;
	public long id(){
		return id;
	}
	@Override
	public String toString(){
		return "CountedObject "+ id;
	}
	
	public static void main(String[] args) {
		Set<Water> set = EnumSet.range(YELLOW,RED);
		System.out.println(set);
	}
}

