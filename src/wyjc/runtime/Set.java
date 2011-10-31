package wyjc.runtime;

import java.math.BigInteger;
import java.util.*;


public final class Set extends java.util.HashSet {	
	/**
	 * The reference count is use to indicate how many variables are currently
	 * referencing this compound structure. This is useful for making imperative
	 * updates more efficient. In particular, when the <code>refCount</code> is
	 * <code>1</code> we can safely perform an in-place update of the structure.
	 */
	int refCount = 100; // TODO: implement proper reference counting

	// ================================================================================
	// Generic Operations
	// ================================================================================	 	
		
	public Set() {		
			
	}
	
	private Set(java.util.Collection items) {
		super(items);
		for(Object o : items) {
			Util.incRefs(o);
		}
	}	
	
	public String toString() {
		String r = "{";
		boolean firstTime=true;
		ArrayList ss = new ArrayList(this);
		Collections.sort(ss,Util.COMPARATOR);

		for(Object o : ss) {
			if(!firstTime) {
				r = r + ", ";
			}
			firstTime=false;
			r = r + whiley.lang.Any$native.toString(o);
		}
		return r + "}";
	} 

	// ================================================================================
	// Set Operations
	// ================================================================================	 	
	
	public static boolean subset(Set lhs, Set rhs) {
		return rhs.containsAll(lhs) && rhs.size() > lhs.size();
	}
	
	public static boolean subsetEq(Set lhs, Set rhs) {
		return rhs.containsAll(lhs);
	}
	
	public static Set union(Set lhs, Set rhs) {
		Set items = new Set(lhs);
		items.addAll(rhs);
		for(Object o : rhs) {
			Util.incRefs(o);
		}
		return items;
	}
	
	public static Set union(Set lhs, Object rhs) {
		Set set = new Set(lhs);
		set.add(rhs);
		Util.incRefs(rhs);
		return set;
	}
	
	public static Set union(Object lhs, Set rhs) {
		Set set = new Set(rhs);
		set.add(lhs);
		Util.incRefs(lhs);
		return set;
	}
	
	public static Set difference(Set lhs, Set rhs) {
		Set items = new Set(lhs);
		items.removeAll(rhs);
		for(Object o : rhs) {
			Util.decRefs(o); // because of constructor increment	
		}
		return items;
	}
	
	public static Set difference(Set lhs, Object rhs) {
		Set set = new Set(lhs);
		set.remove(rhs);
		Util.decRefs(rhs); // because of constructor increment		
		return set;
	}	
	
	public static Set intersect(Set lhs, Set rhs) {
		Set set = new Set(); 		
		for(Object o : lhs) {
			if(rhs.contains(o)) {
				Util.incRefs(o);
				set.add(o);
			}
		}
		return set;
	}
	
	public static Set intersect(Set lhs, Object rhs) {
		Set set = new Set(); 		
		
		if(lhs.contains(rhs)) {
			Util.incRefs(rhs);
			set.add(rhs);
		} 
				
		return set;
	}
	
	public static Set intersect(Object lhs, Set rhs) {
		Set set = new Set(); 		
		
		if(rhs.contains(lhs)) {
			Util.incRefs(lhs);
			set.add(lhs);
		} 		
		
		return set;
	}	
	
	public static BigInteger length(Set set) {
		set.refCount--;
		return BigInteger.valueOf(set.size());
	}
}
