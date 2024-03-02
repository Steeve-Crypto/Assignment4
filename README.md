IntegerSet Class
The IntegerSet class represents a set of integers with various methods for set operations.


The equals method checks if two sets contain the same elements, ignoring order.

The largest and smallest methods use streams to find the max/min values. They throw an IntegerSetException if the set is empty.

The add method only adds the item if it's not already present, to avoid duplicates.

The union method adds all elements from the other set.

The intersect method retains only elements present in both sets.

The diff method removes elements from the other set.

The complement method adds elements from the other set that are not present in this set. 


Challenges
I try using javaDoc *.java in vain
