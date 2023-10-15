package org.howard.edu.lsp.assignment4;


/**
 * The `Driver` class tests the IntegerSet` class.
 * Its `main` method creates instances of `IntegerSet`, perform various
 * operations on them, and displays the results.
 *
 * The main functionalities tested in this class include:
 * - Creation and manipulation of IntegerSet objects
 * - Calculation of the smallest and largest values in the sets
 * - Complement, union, intersection, and difference operations
 * - Checking for set equality and emptiness
 *
 * The class illustrates the capabilities and usage
 * of the `IntegerSet` class methods through a series of test cases.
 *
 * @author Fatimata Niang
 */
public class Driver {

	public static void main(String[] args) throws IntegerSetException {
		
		//creating test sets
		IntegerSet set1 = new IntegerSet();
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("I've added the values 1,2,3 to set1\n" + "set1 is now:" + set1);

		IntegerSet set2 = new IntegerSet();
		
		
		set2.add(4);
		set2.add(5);
		set2.add(6);
		set2.add(7);
		System.out.println("I'm adding the values 4,5,6,7 to set2\n" + "set2 is now:" + set2);
		

		//tests smallest()
		System.out.println("Smallest value of Set1 is:" + set1.smallest());
		System.out.println("Smallest value of Set2 is:" + set2.smallest());

	
		//tests largest()
		System.out.println("Largest value of Set1 is:" + set1.largest());
		System.out.println("Largest value of Set2 is:" + set2.largest());

		
		
		 //tests compliment()
		IntegerSet complementResult = new IntegerSet();
		set1.complement(set2);
		System.out.println("Complement of the set1 with respect to testSet2: " + set1);
		
		// tests toString()	
		System.out.println("Value of Set1 as a string is:" + set1.toString());
		System.out.println("Value of Set2 as a string is:" + set2.toString());

		//tests contains()
		System.out.println("Set1 contains 3?\n" + set1.contains(3));
		System.out.println("Set2 contains 3?\n" + set2.contains(3));
		
		
		
		//tests equal()
		System.out.println("Are the sets equal ? " + set1.equals(set2));
		
		

		//tests union()
		set1.union(set2);
		System.out.println("Reseult of Union of Set1 and Set2: " + set1.toString());


        
       //tests diff() 
        set1.diff(set2);
        System.out.println("Set 1 after diff operation with set 2: " + set1);
       
		
        
		//tests intersect()
        set1.intersect(set2);
        System.out.println("Intersection of Set1 and Set2: " + set1.toString());
  

        
    	//tests clear()
		set1.clear();
		System.out.println("Result of clear is:" + set1.toString());
		
		
		//tests remove()
		IntegerSet testRemove= new IntegerSet();

		testRemove.add(1);
		testRemove.add(2);
		testRemove.add(3);
		System.out.println("Original Set: " + testRemove);
		testRemove.remove(2);
		System.out.println("After removing 2: " + testRemove);
		
	
		
		//tests isEmpty()
		IntegerSet set3 = new IntegerSet();
	
		set3.add(1);
		set3.add(2);
		set3.add(3);
		System.out.println("Set 3 contains:" + set3);
		System.out.println("Is set3 empty? " + set3.isEmpty());
		
		IntegerSet set4 = new IntegerSet();
		System.out.println("Set 4 contains:" + set4);
		System.out.println("Is set4 empty? " + set4.isEmpty());
	
		
	
		
		
		
		
	
	}

}
