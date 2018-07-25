package rk.org.concepts;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import rk.org.linkedList.DLListNode;
import rk.org.linkedList.ListNode;

/**
 * @author rahul
 *
 *         How to implement LRU caching scheme? What data structures should be
 *         used? We are given total possible page numbers that can be referred.
 *         We are also given cache (or memory) size (Number of page frames that
 *         cache can hold at a time). The LRU caching scheme is to remove the
 *         least recently used frame when the cache is full and a new page is
 *         referenced which is not there in cache.
 * 
 *         We use two data structures to implement an LRU Cache.
 * 
 *         1. Queue which is implemented using a doubly linked list. The maximum
 *         size of the queue will be equal to the total number of frames
 *         available (cache size). The most recently used pages will be near
 *         front end and least recently pages will be near rear end.
 * 
 *         2. A Hash with page number as key and address of the corresponding
 *         queue node as value. When a page is referenced, the required page may
 *         be in the memory. If it is in the memory, we need to detach the node
 *         of the list and bring it to the front of the queue. If the required
 *         page is not in the memory, we bring that in memory. In simple words,
 *         we add a new node to the front of the queue and update the
 *         corresponding node address in the hash. If the queue is full, i.e.
 *         all the frames are full, we remove a node from the rear of queue, and
 *         add the new node to the front of queue.
 *
 *
 */
public class LRUCache {
	Deque<DLListNode> dq;
	int cacheSize;
	Map<Integer, DLListNode> map;

	LRUCache() {
	}

	LRUCache(int size) {
		this.dq = new LinkedList<DLListNode>();
		this.cacheSize = size;
		this.map = new ConcurrentHashMap<Integer, DLListNode>();
	}

	public void refer(int data) {
		if (map.containsKey(data)) {
			if (dq.getFirst().getData() != data) {
				DLListNode existingNode = map.get(data);
				DLListNode first = dq.peekFirst();
				DLListNode temp = first.getNext();

				if (existingNode.getNext() == null) {
					first.setNext(null);
				} else {
					existingNode.getNext().setPrev(first); // note prev next  combination
					first.setNext(existingNode.getNext());
					
				}
				first.setPrev(existingNode.getPrev());
				existingNode.getPrev().setNext(first);

				existingNode.setPrev(null);
				existingNode.setNext(temp);
				temp.setPrev(existingNode);

				map.put(first.getData(), first);
				map.put(existingNode.getData(), existingNode);
				map.put(temp.getData(), temp);
				map.put(existingNode.getNext().getData(), existingNode.getNext());
				map.put(existingNode.getPrev().getData(), existingNode.getPrev());
				
			}

		} else {
			if (map.size() == cacheSize) {
				DLListNode x = dq.pollLast();
				map.remove(x.getData());
				x.getPrev().setNext(null);
				map.put(x.getPrev().getData(), x.getPrev());
			}
			DLListNode newNode = new DLListNode(data);
			if (map.size() == 0) {
				newNode.setNext(null);
			} else {
				newNode.setNext(dq.getFirst());
				dq.getFirst().setPrev(newNode);
				map.put(dq.getFirst().getData(), dq.getFirst());
			}
			dq.addFirst(newNode);
			map.put(data, newNode);
		}
	}

	public void displayCache() {
		dq.forEach(e -> System.out.print(" " + e.getData()));
	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(5);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(4);
		cache.refer(5);
		cache.refer(6);
		cache.refer(7);
		cache.refer(8);
		cache.displayCache();
		cache.refer(7);
		System.out.println();
		cache.displayCache();
	}
}
