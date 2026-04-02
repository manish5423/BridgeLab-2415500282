import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int capacity = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        table = new LinkedList[capacity];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        if (table[index] == null) return null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) return entry.value;
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (table[index] == null) return;
        table[index].removeIf(entry -> entry.key.equals(key));
        size--;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        System.out.println("Alice: " + map.get("Alice"));
        map.remove("Alice");
        System.out.println("Alice after removal: " + map.get("Alice"));
        System.out.println("Size: " + map.size());
    }
}
