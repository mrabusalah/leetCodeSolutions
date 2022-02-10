import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));

    }

    static class LRUCache {

        private final Map<Integer, Integer> db;
        private final int size;
        private int lastKey;

        public LRUCache(int capacity) {
            db = new HashMap<>();
            this.size = capacity;
        }

        public int get(int key) {
            return db.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (db.size() == this.size)
                db.remove(this.lastKey);
            db.put(key, value);
            this.lastKey = key;
        }
    }
}
