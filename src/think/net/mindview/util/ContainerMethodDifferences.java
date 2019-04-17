package think.net.mindview.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainerMethodDifferences {
	
	static Set<String> methodSet(Class<?> type){
		Set<String> result = new TreeSet<String>();
		for (Method m : type.getMethods()) {
			result.add(m.getName());
		}
		return result;
	}
	
	static void interfaces(Class<?> type){
		System.out.println("Interface in "+ type.getSimpleName()+" : ");
		List<String> result = new ArrayList<String>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
		System.out.println(result);
	}
	
	static Set<String> object = methodSet(Object.class);
	static {
		object.add("clone");
	}
	
	static void differnce(Class<?> superSet,Class<?> subSet){
		System.out.println(superSet.getSimpleName() + " extends " + subSet.getSimpleName() + ",adds: ");
		Set<String> comp = Sets.difference(methodSet(superSet), methodSet(subSet));
		comp.removeAll(object);//不展示 object的方法
		System.out.println(comp);
		interfaces(superSet);
	}
	
	public static void main(String[] args) {
		System.out.println("Collection: "+methodSet(Collection.class));
		interfaces(Collection.class);
		differnce(Set.class, Collection.class);
		differnce(HashSet.class, Set.class);
		differnce(LinkedHashSet.class, HashSet.class);
		
		differnce(TreeSet.class, Set.class);
		differnce(List.class, Collection.class);
		differnce(ArrayList.class, List.class);
		differnce(LinkedList.class, List.class);
		differnce(Queue.class, Collection.class);
		differnce(PriorityQueue.class, Queue.class);
		
		System.out.println("Map: " + methodSet(Map.class));
		differnce(HashMap.class, Map.class);
		differnce(LinkedHashMap.class, Map.class);
		differnce(SortedMap.class, Map.class);
		differnce(TreeMap.class, Map.class);
	}

}
