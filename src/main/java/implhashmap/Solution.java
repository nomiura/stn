package implhashmap;

import java.util.HashMap;

public class Solution {
    public static void main() {
        ImplHashMap<String, Integer> map = new ImplHashMap<>();

        map.put("a", 1);
        map.put("s", 642);
        map.put("i", 52);

        System.out.println(map.get("a"));

        map.put("a", 12);
        System.out.println(map.get("a"));

        System.out.println("Размер массива: " + map.size());

        ImplHashMap<String, Integer> emptyMap = new ImplHashMap<>();
        System.out.println("Размер массива: " + emptyMap.size() + "\nМассив пустой? " + emptyMap.isEmpty());
    }
}
