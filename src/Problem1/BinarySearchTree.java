/*
Author: Cadet Alyssa Ingerson
Help Received: BinarySearchTree code from class, https://stackoverflow.com/questions/1509391/how-to-get-the-one-entry-from-hashmap-without-iterating
 */
package Problem1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinarySearchTree <AnyType extends Comparable<AnyType>>{
    class BinaryNode<AnyType> {
        HashMap<AnyType,Integer> element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        public BinaryNode() {
            this(null);
        }

        public BinaryNode(AnyType element) {
            HashMap <AnyType,Integer> store = new HashMap<>();
            store.put(element, Integer.valueOf(1));
            this.element = store;
            this.left = null;
            this.right = null;
        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            HashMap <AnyType,java.lang.Integer> store = new HashMap<>();
            store.put(element, Integer.valueOf(1));
            this.element = store;
            this.left = left;
            this.right = right;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {

            if(right != null)
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);

            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(element.toString()).append("\n");

            if(left != null)
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);

            return sb;
        }
        public void setLeft(BinaryNode<AnyType> left) {
            this.left = left;
        }
        public void setRight(BinaryNode<AnyType> right) {
            this.right = right;
        }
        @Override
        public String toString() {

            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }
    BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(AnyType item){

        root = new BinaryNode<AnyType>(item);
    }

    public BinarySearchTree(BinaryNode<AnyType> root){
        this.root = root;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
        if(t == null)
            return new BinaryNode<>(x);

        Map.Entry<AnyType, java.lang.Integer> entry = t.element.entrySet().iterator().next();
        Integer val = entry.getValue();
        int compareResult = x.compareTo(entry.getKey());

        if(compareResult == 0)
            entry.setValue(Integer.valueOf(((int)val + 1)));
        if(compareResult < 0)
            t.left = insert(x, t.left);
        else if(compareResult > 0)
            t.right = insert(x,t.right);
        else
            ;
        return t;
    }

    public BinaryNode<AnyType> insert(AnyType x) { // add item x into the tree and increase the count for x
        return this.insert(x, root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t){
        Map.Entry<AnyType, java.lang.Integer> entry = t.element.entrySet().iterator().next();

        if(t == null)
            return false;
        int compareResult = x.compareTo(entry.getKey());

        if(compareResult == 0)
            return true;
        else if(compareResult > 0 && t.right != null)
            return contains(x, t.right);
        else if(compareResult < 0 && t.left != null)
            return contains(x, t.left);
        else
            return false;

    }

    public boolean contains(AnyType x){ // returns true if tree contains at least one item x
        return this.contains(x,root);
    }

    public int count(AnyType x, BinaryNode<AnyType> t){
        Map.Entry<AnyType, Integer> entry = t.element.entrySet().iterator().next();

        if(t == null)
            return 0;
        int compareResult = x.compareTo(entry.getKey());

        if(compareResult == 0)
            return entry.getValue();
        if(compareResult > 0 && t.right != null)
            return count(x, t.right);
        else if(compareResult < 0 && t.left != null)
            return count(x, t.left);
        else
            return 0;

    }

    public int count(AnyType x){ //returns the frequency of item x in the tree
        return this.count(x, root);
    }

    public boolean removeOne(AnyType x, BinaryNode<AnyType> t){
        Map.Entry<AnyType, java.lang.Integer> entry = t.element.entrySet().iterator().next();

        if(t == null)
            return true;
        int compareResult = x.compareTo(entry.getKey());

        if(compareResult == 0) {
            if (entry.getValue() > 1) {
                t.element.put(x, entry.getValue() - 1);
            }
            else
                t.element.remove(x);

            return true;
        }
        else if(compareResult > 0 && t.right != null)
            return removeOne(x, t.right);
        else if(compareResult < 0 && t.left != null)
            return removeOne(x, t.left);
        else
            return false;
    }

    public boolean removeOne(AnyType x){ // decrement count by 1 if count > 1, otherwise remove x
        return this.removeOne(x, root);
    }

    public boolean removeAll(AnyType x, BinaryNode<AnyType> t){
        Map.Entry<AnyType, java.lang.Integer> entry = t.element.entrySet().iterator().next();

        if(t == null)
            return true;
        int compareResult = x.compareTo(entry.getKey());

        if(compareResult == 0) {
            t.element.remove(x);
            return true;
        }
        else if(compareResult > 0 && t.right != null)
            return removeAll(x, t.right);
        else if(compareResult < 0 && t.left != null)
            return removeAll(x, t.left);
        else
            return false;
    }

    public boolean removeAll(AnyType x){ // remove x irrespective of the value of the frequency count
        return this.removeAll(x, root);
    }

    public static void main(String [] args){
        BinarySearchTree<Integer> t = new BinarySearchTree(5);

        int selection = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Welcome to my Binary Search Tree Program!");
            System.out.println("---------------------------------------------");
            System.out.println("1- Add element \n2- Remove element \n3- Get element count \n4- Check for element \n" +
                    "5- View Binary Search Tree \n6- Exit program");

            System.out.print(">>");
            selection = input.nextInt();

            switch(selection) {
                case 1:
                    System.out.print("Add an integer element >>");
                    int num = input.nextInt();
                    t.insert(num);
                    System.out.println();
                    System.out.println("Element added successfully!");
                    break;
                case 2:
                    System.out.println("1- Decrement element count by 1 \n2- Remove entire element");
                    System.out.print(">>");
                    int removeSelect = input.nextInt();
                    switch(removeSelect){
                        case 1:
                            System.out.print("Enter element to decrement >>");
                            int num2 = input.nextInt();
                            t.removeOne(num2);
                            System.out.println();
                            System.out.println("Element decremented successfully!");
                            break;
                        case 2:
                            System.out.println("Enter element to remove >>");
                            int num3 = input.nextInt();
                            t.removeAll(num3);
                            System.out.println();
                            System.out.println("Element removed successfully!");
                            break;
                    }
                    break;
                case 3:
                    System.out.print("Enter element to find count >>");
                    int num2 = input.nextInt();
                    System.out.println("The frequency of element " + num2 + " is " + t.count(num2));
                    break;
                case 4:
                    System.out.println("Enter element to check >>");
                    int num3 = input.nextInt();
                    System.out.println(t.contains(num3) ? "Element " + num3 + " exists in the tree" : "Element " + num3 + " does not exist in the tree");
                    break;
                case 5:
                    System.out.println(t.root.toString());
                    break;
            }
        }while(selection != 6);

        t.insert(1);
        t.insert(4);
        t.insert(2);
        t.insert(5);
        t.insert(0);
        t.insert(6);
        t.insert(3);
        t.insert(5);
        t.insert(5);
        t.insert(2);

        System.out.println(t.root.toString());

        System.out.println("Does t contain 10:");
        System.out.println(t.contains(10));
        System.out.println("Does t contain 3:");
        System.out.println(t.contains(3));
        System.out.println("Does t contain 5:");
        System.out.println(t.contains(5));
        System.out.println("The number of copies for 3:");
        System.out.println(t.count(3));
        System.out.println("The number of copies for 5:");
        System.out.println(t.count(5));
        System.out.println("Remove one copy of 3");
        System.out.println(t.removeOne(3));
        System.out.println("Remove one copy of 6");
        System.out.println(t.removeOne(6));
        System.out.println(t.root.toString());
        System.out.println("Remove all copies of 0");
        System.out.println(t.removeAll(0));
        System.out.println(t.root.toString());

    }
}
