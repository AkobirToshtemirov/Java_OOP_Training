package Collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        // ArrayList is resizeable array
        List<String> states = new ArrayList<>();
        states.add("Tashkent");
        states.add("Surkhandarya");
        states.add("Samarkand");
        System.out.println(states);

        for (String state: states) {
            System.out.println(state);
        }

        //List<int> it won't work items in the list must be objects not primitives

        List<Integer> nums = new ArrayList<>();
        states.remove(1);
        System.out.println(states);
        String state2 = states.get(1);
        System.out.println("The second state is " + state2);

        int pos = states.indexOf("Tashkent");
        System.out.println(pos);
        
    }
}
