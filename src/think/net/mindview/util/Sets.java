package think.net.mindview.util;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Sets {

	//求并集
	public static <T> Set<T> union(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	//求交集
	public static <T> Set<T> intersection(Set<T> a,Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	// A - A交B
	public static <T> Set<T> difference(Set<T> superset,Set<T> subset){
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;
	}
	
	// A并B - A交B
	public static <T> Set<T> complement(Set<T> a,Set<T> b){
		return difference(union(a, b), intersection(a, b));
	}
	
	//引用类型
	@Test
	public void test_O(){
		Set<D> a = new HashSet<D>(){{
			add(new D(1));
			add(new D(2));
			add(new D(3));
			add(new D(4));
		}};
		
		Set<D> b = new HashSet<D>(){{
			add(new D(1));
			add(new D(2));
			add(new D(5));
			add(new D(6));
		}};
		
		System.out.println(complement(a, b));
		System.out.println(a);
		System.out.println(b);
	}
	
	
	
	//基本类型
	@Test
	public void test(){
		Set<Integer> a = new HashSet<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
		}};
		
		Set<Integer> b = new HashSet<Integer>(){{
			add(1);
			add(2);
			add(5);
			add(6);
		}};
		System.out.println(complement(a, b));
		System.out.println(a);
		System.out.println(b);
	}
}

class D{
	private Integer num;
	private String name;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public D(Integer num) {
		super();
		this.num = num;
	}
	@Override
	public String toString() {
		return "D [num=" + num + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D other = (D) obj;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
	
	
}
