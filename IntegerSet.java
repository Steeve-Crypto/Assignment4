package howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of integers with various methods for set operations.
 */
public class IntegerSet {
    // Store the set elements in an ArrayList
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default Constructor.
     */
    public IntegerSet() {
    }

    /**
     * Constructor if you want to pass in an already initialized set.
     *
     * @param set the set of integers
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length of the set.
     *
     * @return the length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if the two sets are equal, false otherwise.
     * Two sets are equal if they contain all of the same values in any order.
     * This overrides the equals method from the Object class.
     *
     * @param o the object to compare with
     * @return true if the sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IntegerSet)) {
            return false;
        }
        IntegerSet other = (IntegerSet) o;
        return set.containsAll(other.set) && other.set.containsAll(set);
    }

    /**
     * Returns true if the set contains the specified value, otherwise false.
     *
     * @param value the value to check for
     * @return true if the set contains the value, otherwise false
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * Throws an IntegerSetException if the set is empty.
     *
     * @return the largest item in the set
     * @throws IntegerSetException if the set is empty
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int max = set.get(0);
        for (int i : set) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * Returns the smallest item in the set.
     * Throws an IntegerSetException if the set is empty.
     *
     * @return the smallest item in the set
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        int min = set.get(0);
        for (int i : set) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Adds an item to the set or does nothing if it is already there.
     *
     * @param item the item to add to the set
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set or does nothing if it is not there.
     *
     * @param item the item to remove from the set
     */
    public void remove(int item) {
        set.remove((Integer) item);
    }

    /**
     * Performs the set union operation.
     * Adds all elements from the specified set to this set.
     *
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int i : intSetb.set) {
            add(i);
        }
    }

    /**
     * Performs the set intersection operation.
     * Retains only the elements that are present in both sets.
     *
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs the set difference operation.
     * Removes from this set all of its elements that are contained in the specified set.
     *
     * @param intSetb the set to subtract
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Computes the set complement operation.
     * Removes all elements from this set that are present in the specified set.
     *
     * @param intSetb the set to complement with
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complementSet = new ArrayList<>();
        for (int i : intSetb.set) {
            if (!set.contains(i)) {
                complementSet.add(i);
            }
        }
        set = complementSet;
    }

    /**
     * Returns true if the set is empty, false otherwise.
     *
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     *
     * @return a string representation of the set
     */
    @Override
    public String toString() {
        return set.toString();
    }

    /**
     * Exception class for IntegerSet.
     */
    public static class IntegerSetException extends Exception {
        /**
         * Constructs an IntegerSetException with the specified detail message.
         *
         * @param message the detail message
         */
        public IntegerSetException(String message) {
            super(message);
        }
    }
}


/**
Summary:

The equals method checks if two sets contain the same elements, ignoring order.

The largest and smallest methods use streams to find the max/min values. They throw an IntegerSetException if the set is empty.

The add method only adds the item if it's not already present, to avoid duplicates.

The union method adds all elements from the other set.

The intersect method retains only elements present in both sets.

The diff method removes elements from the other set.

The complement method adds elements from the other set that are not present in this set. 
*/