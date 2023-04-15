/*
Author: Cadet Alyssa Ingerson
Help Received: BinarySearchTree code from class, https://stackoverflow.com/questions/1509391/how-to-get-the-one-entry-from-hashmap-without-iterating
 */
package Problem1;

import java.util.HashMap;
import java.util.Map;

public class BinarySearchTree <AnyType extends Comparable<AnyType>>{
    class BinaryNode<AnyType> {
        HashMap<AnyType,Integer> element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        public BinaryNode() {
            this(null);
        }

        public BinaryNode(AnyType element) {
            HashMap <AnyType,java.lang.Integer> store = new HashMap<>();
            store.put(element, Integer.valueOf(1));
            this.element = store;
            this.left = null;
            this.right = null;
        }

        public BinaryNode(Integer element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            HashMap <AnyType,Integer> store = new HashMap<>((int) element, Integer.valueOf(1));
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

    public BinaryNode<AnyType> insert(AnyType x) {
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

    public boolean contains(AnyType x){
        return this.contains(x,root);
    }

    public static void main(String [] args){
        BinarySearchTree<Integer> t = new BinarySearchTree(3);
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
        System.out.println(t.contains(10));
        System.out.println(t.contains(3));
        System.out.println(t.contains(5));
    }
}
