package think.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {

	@SafeVarargs
	public static <T> List<T> makeList(T... args){
		List<T> list = new ArrayList<T>();
		for (T t : args) {
			list.add(t);
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<String> makeList = makeList("A","B");
		System.out.println(makeList);
		for (String string : makeList) {
			System.out.println(string);
		}
	}
	
}
