package rk.org.concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author rahul
 * 
 * There is a contract between hashCode method and equals method,
 * hence once any one is overridden other should be also be overridden 
 * to get  correct behaviour (check this on commentting the equals method)
 *
 */
public class HashMapExperiment {
	private Map<MyObject,String> myObjects;
	
	
	private static class MyObject {
		private int id;
		private String name;
		
		public MyObject(){
		}
		
		public MyObject(int id, String name){
			this.name = name;
			this.id = id;
		}
		
		@Override
		public int hashCode(){
			
			return id % 10;
		}
		
		@Override
		public boolean equals(Object obj){
			if(obj instanceof MyObject && this.id == ((MyObject) obj).id){
			 return true;	
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		HashMapExperiment obj = new HashMapExperiment();
		obj.myObjects = new HashMap<MyObject,String>();
		obj.myObjects.put(new MyObject(1,"A"), "A");
		obj.myObjects.put(new MyObject(1,"B"), "B");
		
		for(Entry e : obj.myObjects.entrySet()){
			System.out.println("Key " + e.getKey().hashCode() + "\t Value " + e.getValue() +" \t Hashcode " +e.hashCode());
		}
		
		System.out.println(obj.myObjects.size());
		
	}

}
