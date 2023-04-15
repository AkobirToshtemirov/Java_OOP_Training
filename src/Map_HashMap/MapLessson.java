package Map_HashMap;

import java.util.HashMap;
import java.util.Map;

public class MapLessson {
    public static void main(String[] args) {
        // A HashMap is an implementation of an interface named Map

        Map<String, String> map = new HashMap<>();

        map.put("Tashkent", "Sergeli");
        map.put("Surkhandarya", "Termez");
        map.put("Samarkand", "Samarkand");

        System.out.println(map);
        map.put("Andijan", "AndijanShahar");
        System.out.println(map);

        String capital = map.get("Tashkent");
        System.out.println(capital);
        map.remove("Andijan");
        System.out.println(map);

    }
}
