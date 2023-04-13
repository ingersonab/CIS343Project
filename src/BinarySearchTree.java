public class BinarySearchTree {
    static class BinaryNode  <Integer> {
        Integer element;
        BinaryNode<Integer> left;
        BinaryNode<Integer> right;

        public BinaryNode() {
            this(null);
        }

        public BinaryNode(Integer element) {
            this(element, null, null);
        }

        public BinaryNode(Integer element, BinaryNode<Integer> left, BinaryNode<Integer> right) {
            this.element = element;
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
        public void setLeft(BinaryNode<Integer> left) {
            this.left = left;
        }
        public void setRight(BinaryNode<Integer> right) {
            this.right = right;
        }
        @Override
        public String toString() {

            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }
    BinaryNode<Integer> root;

    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(Integer item){
        root = new BinaryNode<>(item);
    }

    public BinarySearchTree(BinaryNode<Integer> root){
        this.root = root;
    }

    private BinaryNode<Integer> insert(Integer x, BinaryNode<Integer> t){
        if(t == null)
            return new BinaryNode<>(x);

        int compareResult = x.compareTo(t.element);

        if(compareResult < 0)
            t.left = insert(x, t.left);
        else if(compareResult > 0)
            t.right = insert(x,t.right);
        else
            ;
        return t;
    }

    public BinaryNode<Integer> insert(Integer node) {
        return this.insert(node, root);
    }

    public static void main(String [] args){
        BinarySearchTree t = new BinarySearchTree(3);
        t.insert(1);
        t.insert(4);
        t.insert(2);
        t.insert(5);
        t.insert(0);
        t.insert(6);

        System.out.println(t.root.toString());
    }
}
