/*
Authors: Alyssa Ingerson and Izaak Kersey
Help Received: https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
 */
package Problem2;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class ItemsPacking {

    public static void main(String [] args) {
        strategy1();
        strategy2();

    }
/*
//Scan the items in the order given; place each new item in the most-filled box that can accept it without overflowing.
Use a priority queue to determine the box that an item goes in
 */
    public static void strategy1(){
        ArrayList<Item> items = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        PriorityQueue<Box> pq = new PriorityQueue<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                if(o1.load < o2.load)
                    return -1;
                else if(o1.load > o2.load)
                    return 1;
                else
                    return 0;
            }
        });
        double weight = 0;

        while(weight != -1) { //enter -1 to end the loop
            System.out.println("Enter a weight for an item: ");
            weight = input.nextDouble();
            Item i = new Item(weight);
            if(weight != -1)
                items.add(i);

        }

        /*for(int i = 0; i < items.size(); i++){
            System.out.print(items.get(i).getWeight() + " ");
        }*/

        for(int i = 0; i < items.size(); i++){
            double itemWeight = items.get(i).getWeight();
            Box box = pq.peek();
            if(box == null || (box.capacity - box.load) < itemWeight){
                box = new Box();
                pq.add(box);
            }
            box.add(items.get(i));
        }

        int count = 1;
        for(Box i : pq){
            System.out.println("Box " + count + " " + i);
            count++;
        }
        System.out.println("The number of boxes used are " + pq.size());

    }
//Sort the items, placing the heaviest item first; then use the strategy above.
    public static void strategy2() {//O(2n + n^2)
        ArrayList<Item> items = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        PriorityQueue<Box> pq = new PriorityQueue<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                if(o1.load < o2.load)
                    return -1;
                else if(o1.load > o2.load)
                    return 1;
                else
                    return 0;
            }
        });
        double weight = 0;

        while(weight != -1) { //enter -1 to end the loop, O(n)
            System.out.println("Enter a weight for an item: ");
            weight = input.nextDouble();
            Item i = new Item(weight);
            if (weight != -1)
                items.add(i);

        }
        double [] weights = new double[items.size()];
        for(int i = 0; i < items.size(); i++){
            weights[i] = items.get(i).getWeight();
        }
        Arrays.sort(weights);
        double [] descendingWeights =  new double[items.size()];
        int j = 0;
        for(int i = weights.length - 1;  i >= 0; i--){ //O(n^2)
            descendingWeights[j] = weights[i];
            j++;
        }

        ArrayList<Item> sortedItems = new ArrayList<>();
        for(int i = 0; i < descendingWeights.length; i++){ //O(n)
            sortedItems.add(new Item(descendingWeights[i]));
        }

        for(int i = 0; i < sortedItems.size(); i++){
            double itemWeight = sortedItems.get(i).getWeight();
            Box box = pq.peek();
            if(box == null || (box.capacity - box.load) < itemWeight){
                box = new Box();
                pq.add(box);
            }
            box.add(sortedItems.get(i));
        }

        int count = 1;
        for(Box i : pq){
            System.out.println("Box " + count + " " + i);
            count++;
        }
        System.out.println("The number of boxes used are " + pq.size());


    }

    public static void strategy3(ArrayList<Item> items, Scanner input, PriorityQueue<Box> pq) {

        double weight = 0;

        while(weight != -1) { //enter -1 to end the loop
            System.out.println("Enter a weight for an item: ");
            weight = input.nextDouble();
            Item i = new Item(weight);
            if (weight != -1)
                items.add(i);

        }

        for(int i = 0; i < items.size(); i++){
            double itemWeight = items.get(i).getWeight();
            Box box = pq.peek();
            if(box == null || (box.capacity - box.load) < itemWeight){
                box = new Box();
                pq.add(box);
            }
            box.add(items.get(i));

        }
    }
}
