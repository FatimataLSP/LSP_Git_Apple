package org.howard.edu.lsp.assignment5;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for the IntegerSet class
 * @author Fatimata Niang
 */


public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;
    private IntegerSet set3;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
        set3 = new IntegerSet();
    }
    
    /**
     * Test for the isEmpty method.
     * This test checks if the isEmpty method correctly identifies an empty set.
     */
    @Test
    @DisplayName("IntegerSet.isEmpty test cases")
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());

        set1.add(1);
        assertFalse(set1.isEmpty());
    }


    /**
     * Test for the clear method.
     * This test checks if the clear method empties the set.
     */
    @Test
    @DisplayName("IntegerSet.clear test cases")
    public void testClear() {
        set1.clear();
        assertTrue(set1.isEmpty());

        for (int i = 1; i < 5; i++)
            set2.add(i);
        assertFalse(set2.isEmpty());
        set2.clear();
        assertTrue(set2.isEmpty());
    }
    
    /**
     * Test for the length method.
     * This test checks if the length method returns the correct number of elements in the set.
     */
    @Test
    @DisplayName("IntegerSet.length test cases")
    public void testLength() {
        assertTrue(set1.length() == 0);

        for (int i = -20; i < 20; i++)
            set2.add(i);
        assertTrue(set2.length() == 40);
    }
    
    /**
     * Test for the equals method.
     * This test checks if the equals method correctly compares sets.
     */
    
    @Test
    @DisplayName("IntegerSet.equals test cases")
    public void testEquals() {
        for (int i = -20; i < 20; i++)
            set1.add(i);
        for (int i = -20; i < 20; i++)
            set2.add(i);
        for (int i = -10; i < 10; i++)
            set3.add(i);
        assertFalse(set1.equals(set3));

        assertTrue(set1.equals(set2));
    }

    /**
     * Test for the contains method.
     * This test checks if the contains method correctly identifies elements in the set.
     */
    
    @Test
    @DisplayName("IntegerSet.contains test cases")
    public void testContains() {
        assertFalse(set1.contains(99));

        for (int i = -30; i < 30; i++)
            set2.add(i);
        assertFalse(set2.contains(-31));
        assertFalse(set2.contains(31));
        assertTrue(set2.contains(0));
        assertTrue(set2.contains(9));

        for (int i = -20; i < 20; i++)
            set1.add(i);
        assertFalse(set1.contains(-30));
        assertFalse(set1.contains(21));
        assertTrue(set1.contains(0));
        assertTrue(set1.contains(10));
    }

    
    /**
     * Test for the largest method.
     * This test checks if the largest method correctly finds the largest element in the set.
     */
    
    @Test
    @DisplayName("IntegerSet.largest test cases")
    public void testLargest() throws IntegerSetException {
        assertThrows(IntegerSetException.class, () -> set1.largest(), "Set length is 0 cannot search");

        for (int i = -2; i > -100; i--)
            set1.add(i);
        assertFalse(set1.largest() == 1);
        assertFalse(set1.largest() == 99);
        assertEquals(-2, set1.largest());
    }

    
    /**
     * Test for the smallest method.
     * This test checks if the smallest method correctly finds the smallest element in the set.
     */
    
    @Test
    @DisplayName("IntegerSet.smallest test cases")
    public void testSmallest() throws IntegerSetException {
        assertThrows(IntegerSetException.class, () -> set1.smallest(), "Set length is 0 cannot search");

        for (int i = -2; i > -100; i--)
            set1.add(i);
        assertFalse(set1.smallest() == 1);
        assertFalse(set1.smallest() == -40);
        assertEquals(-99, set1.smallest());
    }
    

    /**
     * Test for the add method.
     * This test checks if the add method correctly adds elements to the set.
     */
    
    
    @Test
    @DisplayName("IntegerSet.add test cases")
    public void testAdd() {
        set1.add(0);
        assertTrue(set1.contains(0));

        for (int i = 1; i < 50; i++) {
            set1.add(i);
            assertTrue(set1.contains(i));
            assertFalse(set1.contains(i * 100));
            assertTrue(set1.contains(i % 100));
        }
    }
    
    
    /**
     * Test for the remove method.
     * This test checks if the remove method correctly removes elements from the set.
     */

    @Test
    @DisplayName("IntegerSet.remove test cases")
    public void testRemove() {
        set1.add(0);
        set1.add(2);
        set1.add(4);
        set1.add(12);

        set2.add(0);
        set2.add(2);
        set2.add(4);
        set2.add(10);
        set2.add(12);
        set2.remove(0);

        assertEquals(set1.length(), set2.length());

        set1.clear();
        set2.clear();

        set1.add(0);
        set1.add(2);
        set1.add(4);
        set1.add(6);
        set1.add(10);
        set1.add(12);
        set1.remove(2);

        assertFalse(set1.contains(2));

        set1.clear();
        set2.clear();

        set1.add(2);
        set1.add(9);
        set1.add(5);
        set1.add(0);
        set1.add(1);

        set2.add(9);
        set2.add(2);
        set2.add(5);
        set2.add(1);
        set2.add(0);
        set2.remove(1);

        assertFalse(set1.equals(set2));
    }

    
    /**
     * Test for the union method.
     * This test checks if the union method correctly computes the union of two sets.
     */
    
    @Test
    @DisplayName("IntegerSet.union test cases")
    public void testUnion() {
        set1.union(set2);
        assertTrue(set1.equals(set2));
        assertTrue(set1.equals(set3));

        for (int i = 1; i < 20; i++) {
            set1.add(i);
            set3.add(i);
        }

        for (int i = -1; i > -20; i--) {
            set2.add(i);
            set1.union(set2);
            assertTrue(set1.contains(9));
        }

        assertFalse(set1.length() == set3.length());
        assertTrue(set1.length() == set3.length() + set2.length());
    }


    
    /**
     * Test for the intersect method.
     * This test checks if the intersect method correctly computes the intersection of two sets.
     * It also verifies that the resulting set contains the common elements between the two sets
     * and does not contain elements that are unique to either set.
     */
    
    @Test
    @DisplayName("IntegerSet.intersect test cases")
    public void testIntersect() {
        set1.intersect(set2);
        assertTrue(set1.isEmpty()); // Make sure that set1 is empty after intersection
        assertTrue(set1.equals(set2));
        assertTrue(set1.equals(set3));

        for (int i = 0; i < 50; i++)
            set1.add(i);
        for (int i = 1; i < 50; i++)
            set2.add(i);

        set1.intersect(set2);

        // The intersected set should contain all numbers from 1 to 49
        for (int i = 1; i < 50; i++) {
            assertTrue(set1.contains(i));
        }

        // It should not contain 0 or 50
        assertFalse(set1.contains(0));
        assertFalse(set1.contains(50));

        assertEquals(49, set1.length()); // Length should be 49

        set3.intersect(set1);
        assertFalse(set3.contains(0));
        assertFalse(set3.contains(50));
    }

}
