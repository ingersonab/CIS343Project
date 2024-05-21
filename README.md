# CIS343Project

Authors: Alyssa Ingerson and Izaak Kersey

Part 1- Binary Search Tree with Duplicates:
Implement a generic binary search tree that allows duplicates. Have each node store a HashMap in which
the key is an item and the value represents the number of times the item is stored. You should use the key
item to control branching. Your tree should support the following methods:

public boolean insert(AnyType x) // add item x into the tree and increase the count for x
public boolean contains(AnyType x) // returns true if tree contains at least one item x
public int count(AnyType x) //returns the frequency of item x in the tree
public boolean removeOne(AnyType x) // decrement count by 1 if count > 1, otherwise remove x
public boolean removeAll(AnyType x) // remove x irrespective of the value of the frequency count

• Provide main method that tests your implementation of the binary search tree with duplicates
• Provide detail analyses of the running times for the construction of your data structure and the algo-
rithms for each of the methods above

Part 2- Approximate Items Packing:
Suppose that you have a number of boxes, each of which can hold total weight 1.0 and items i1, i2, i3, . . . , in,
which weigh w1, w2, w3, . . . , wn, respectively. The objective is to pack all the items, using as few boxes as
possible, without placing more weight in any box than its capacity. For instance, if the items have weights
0.4, 0.4, 0.6, and 0.6, you can solve the problem with two boxes. This problem is difficult, and no efficient
algorithm is known. Several strategies give good, but not optimal, packings.

i. Write Java programs to implement efficiently the following approximation strategies:
• Scan the items in the order given; place each new item in the most-filled box that can accept it without
overflowing. Use a priority queue to determine the box that an item goes in.
• Sort the items, placing the heaviest item first; then use the strategy above.
• Design a customized strategy of your own to solve the problem.

ii. Provide detail analysis of the running times of your data structures and algorithms for each of the three
strategies above.
Hint: Use your OOP skills here by creating classes for boxes and items, before attempting to solve
the problem.

