package Problem2;

import java.util.ArrayList;

public class Box{

    final double capacity = 1.0;
    double load;
    ArrayList<Item> items = new ArrayList<>();

    public Box() {
        this.load = 0;
    }

    public void add(Item x) {
        if(load + x.getWeight() <= capacity) {
            items.add(x);
            load += x.getWeight();
        }
    }

    @Override
    public String toString() {
        String str = "Box = {";
        for(int i = 0; i < items.size(); i++){
            if(i < items.size() - 1)
                str += "Item weight = " + items.get(i).getWeight() + ", ";
            else
                str += "Item weight = " + items.get(i).getWeight() + "}";
        }
        return str;
    }

}
