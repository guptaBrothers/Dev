package rk.org.concepts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rahul
 * 
 *         Proof 1. Why Hashtable doen't allow null keys and(or) values 2. Why
 *         and how HashMap allows null key and values 3. Why
 *         ConcurrentHashMap,ConcurrentSkipListMap followed hashtable strategy
 *         on null key and(or) values
 * 
 *         Proof 1. HashSet and LinkedHashSet allows null value but TreeSet
 *         doesn't allow null value 2. Note*** : Although HashSet and Linked
 *         HashSet allows null value, but those are stored in Wrapper Object. so
 *         when we retrieve null Object it cannot be cast into primitive value ,
 *         hence null value should be avoided.
 * 
 *         hashSet.add(2); hashSet.add(5); equivalent to // collections work
 *         only with wrapper classes so does iterator hashSet.add(new
 *         Integer(2)); hashSet.add(new Integer(5));
 * 
 *         while(it.hasNext()){ int i = it.next(); // results in null pointer
 *         exception System.out.print(i+" "); }
 * 
 *         correct way to implement while(it.hasNext()){ final Integer i =
 *         it.next(); // no exception thrown System.out.print(i+" "); }
 * 
 *
 */
public class MapNullKeyExperiment {

	public static void main(String[] args) {

		boolean testSet = true;
		boolean testMap = false;
		if (testMap) {
			Map<String, String> hashTable = new Hashtable<String, String>();
			Map<String, String> hashMap = new HashMap<>();
			Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

			// hashTable.put(null, null); // java.lang.NullPointerException
			hashMap.put(null, null);
			// concurrentHashMap.put(null, null);
			// //java.lang.NullPointerException
			// System.out.println(hashTable.get(null)); //
			// java.lang.NullPointerException java.util.Hashtable.get(Unknown
			// Source)
			System.out.println(hashMap.get(null)); // prints null
			// System.out.println(concurrentHashMap.get(null));
			// //ava.lang.NullPointerException
			// java.util.concurrent.ConcurrentHashMap.get(Unknown Source)

			// Null value check
			// hashTable.put("A", null); // java.lang.NullPointerException
			// java.util.Hashtable.put(Unknown Source)
			hashMap.put("A", null);
			// concurrentHashMap.put("A", null); //
			// java.lang.NullPointerException at
			// java.util.concurrent.ConcurrentHashMap.putVal(Unknown Source)

			System.out.println(hashTable.get("A")); // prints null
			System.out.println(hashMap.get("A")); // prints null
			System.out.println(concurrentHashMap.get("A")); // prints null
		}

		/////////////////////////////// Set null value Test /////////////////
		if(testSet){
			Set<Integer> hashSet = new HashSet<>();
			Set<Integer> linkedHashSet = new LinkedHashSet<>();
			Set<Integer> treeSet = new TreeSet<>();

			hashSet.add(1);
			hashSet.add(null);
			linkedHashSet.add(1);
			linkedHashSet.add(null);
			treeSet.add(1);
			// treeSet.add(null); // java.lang.NullPointerException at
			// java.util.TreeMap.put(Unknown Source)
			// at java.util.TreeSet.add(Unknown Source)
			System.out.println("set print using stream i.e internal iterator ");
			hashSet.stream().forEach(e -> System.out.println(e));
			linkedHashSet.stream().forEach(e -> System.out.println(e));
			treeSet.stream().forEach(e -> System.out.println(e));
			Iterator<Integer> itrhSet = hashSet.iterator();
			Iterator<Integer> itrlHSet = hashSet.iterator();
			Iterator<Integer> itrtSet = hashSet.iterator();
			System.out.println("set print using  iterator ");
			while (itrhSet.hasNext())
				System.out.println(itrhSet.next());
			while (itrlHSet.hasNext())
				System.out.println(itrlHSet.next());
			while (itrtSet.hasNext())
				System.out.println(itrtSet.next());

			/*
			 * Note here above condition works fine when itr.next() is directly
			 * printed but if we store that value in primitve variable NPE
			 * expception will be thrown for null values.
			 */
			System.out.println("testing with value stored in primitive variable");
			Iterator<Integer> itrlhSet1 = linkedHashSet.iterator();
			while (itrlhSet1.hasNext()) {
				// int i = itrlhSet1.next(); //java.lang.NullPointerException for
				// null value
				Integer i = itrlhSet1.next();
				System.out.println(i);
			}
		}

	}

}
