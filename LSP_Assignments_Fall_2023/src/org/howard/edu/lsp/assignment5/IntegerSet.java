package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The IntegerSet class represents a set of unique integers.
 * It has several methods for manipulating and working with integer sets.
 * An IntegerSet is a list of unique integers, and it can perform operations 
 * such as adding elements, removing elements, computing the union, intersection, 
 * difference, checking if the set is empty, and more.
 *
 * @author Fatimata Niang
 */

public class IntegerSet {
	
	private List<Integer> set = new ArrayList<Integer>();
	
	
	/**
	 * 
	 * @return integer item at the given index
	 */
	public ArrayList<Integer> getSet() { return (ArrayList<Integer>) set; }
	public int get(int index) {
		return set.get(index);
	}

	

	/**
	 * This adds an int to IntegerSet
	 * 
	 * @param item is an integer to add
	 */
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);	
		}
	}
	
	
	/**
	 * 
	 * @param item is removed from set 
	 * 
	 * if the item does not exist in the set, nothing happens
	 * 
	 */
	public void remove(int item) {
		set.removeIf(element -> element == item);	
	}
	
	
	/**
	 * Removes all elements present in the set
	 */
	public void clear() {
		set.clear();
	}
	
	
	/**
	 * @return returns String representation of IntegerSet
	 */
	public String toString() {
		return set.toString();
	}
	
	/**
	 * @return length of the set
	 */
	public int length() {
		return set.size();
	}
	
	
	/**
	 * 
	 * @param IntegerSet b is converted into an Array List
	 * @return false if the array lists are equal, and returns true if they are equal, even after sorting
	 *  
	 */
	public boolean equals(IntegerSet b) {
		if (b.length() != set.size()) {
			return false;
		}
		else {
			ArrayList <Integer> copySet1 = new ArrayList<Integer>(set);
			ArrayList <Integer> copySet2 = new ArrayList<Integer>(b.getSet());
			
			
			Collections.sort((copySet1));
			Collections.sort(copySet2);
			
			return copySet1.equals(copySet2);	
				
			}	  
	 }
	
	/**
	 * 
	 * @param value an integer that may be apart of the set 
	 * @return true or false  depending on if the passed parameter is in the set or not
	 */
	public boolean contains(int value) {
		for (int i = 0; i < set.size(); i++) {
			if(value == set.get(i)) {
				return true;
			}
		}
		return false; 
	 }
	
	
	/**
	 * 
	 * This method checks if the set is empty
	 * @return true if empty, false if there are items in the set
	 */
	public boolean isEmpty(){
		if (set.size() == 0) {; 
			return true;
		} else {
			return false;
		}		
	}
	
	
	
	/** 
	 * This method finds the smallest integer in a given set
	 * 
	 * @return the smallest integer in the set
	 * @throws IntegerSetException if the length of the set is 0 
	 */
	public int smallest() throws IntegerSetException{
		if (set.size() == 0) {
			throw new IntegerSetException("The Length of the set is 0");
		}
		else {
			int minimumValue = set.get(0);
			int currentValue = set.get(0);
			
			for (int i = 0; i <set.size(); i++) {
				currentValue = set.get(i);
				if(currentValue < minimumValue) 
					minimumValue = currentValue;
			}
			return minimumValue;
		}
	}
	
	
	
	/**
	 * This method find the largest integer in a given set
	 * 
	 * @return the largest integer in the set
	 * @throws IntegerSetException if the length of the set is 0 
	 */
	public int largest() throws IntegerSetException { 
		if (set.size() == 0) {
			throw new IntegerSetException("The set length is 0");
		}
		else {
			int maximumValue = set.get(0); 
			int currentValue = set.get(0);
			
			for (int i = 0; i< set.size(); i++) {
				currentValue = set.get(i);
				if(currentValue > maximumValue)
					maximumValue = currentValue;
			}
			return maximumValue;
		}
		
	}
	
	
	
	/**
	 * This method adds all unique elements from two sets, the called set and the set passed in as an argument
	 *
	 * @param intSetb another IntegerSet to be unionized with the called set.
	 * 
	 */
	public void union(IntegerSet intSetb) {
		List<Integer> setB = intSetb.getSet();	
		for (int i = 0; i<setB.size(); i++) {
			if (!this.contains(setB.get(i))) {
				this.add(setB.get(i));
			}
		}
    }
	
	
	
	/**
	 * 
	 * This method calculates the intersection of this IntegerSet with another IntegerSet
	 * It modifies the set to only contain the elements that are present in both sets
	 * 
	 * @param intSetb another IntegerSet will be intersected with intSetb
	 */
	public void intersect(IntegerSet intSetb) {
		 List<Integer> copySet = new ArrayList<>(set);
		    for (Integer element : copySet) {
		        if (!intSetb.contains(element)) {
		            set.remove(element);
		        }
		    }
		}
	
	
	
	/**
	 * 
	 * Calculates the difference between the items in the below IntegerSet and another.
	 * This method modifies the current IntegerSet to only contain the difference.
	 * 
	 * @param intSetb is the IntegerSet to compute the difference with.
	 */
	public void diff(IntegerSet intSetb) {
		 List<Integer> copySet = new ArrayList<>(set);
		    for (Integer element : copySet) {
		        if (intSetb.contains(element)) {
		            set.remove(element);
		        }
		    }
		}
	
	
	
	/**
     * Computes the set complement, which is all elements that are in this IntegerSet but not in intSetb
     *
     * @param intSetb The IntegerSet used to compute the complement with.
     * 
     */
    public void complement(IntegerSet intSetb) {
    	List<Integer> copy = new ArrayList<>(intSetb.getSet());

        for (Integer element : copy) {
            if (this.contains(element)) {
                this.remove(element);
            }
        }
    }

	
}
