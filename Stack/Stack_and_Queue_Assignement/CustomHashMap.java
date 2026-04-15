public class CustomHashMap {
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size;

    public CustomHashMap() {
        this(16);
    }

    public CustomHashMap(int capacity) {
        buckets = new Node[Math.max(1, capacity)];
        size = 0;
    }

    private int index(int key) {
        return (key & 0x7fffffff) % buckets.length;
    }

    public void put(int key, int value) {
        int idx = index(key);
        Node curr = buckets[idx];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node node = new Node(key, value);
        node.next = buckets[idx];
        buckets[idx] = node;
        size++;

        if ((double) size / buckets.length > 0.75) {
            resize();
        }
    }

    public Integer get(int key) {
        int idx = index(key);
        Node curr = buckets[idx];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public boolean containsKey(int key) {
        return get(key) != null;
    }

    public Integer remove(int key) {
        int idx = index(key);
        Node curr = buckets[idx];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[idx] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Node[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2];
        size = 0;

        for (Node head : oldBuckets) {
            Node curr = head;
            while (curr != null) {
                put(curr.key, curr.value);
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(17, 30);
        System.out.println(map.get(2));
        System.out.println(map.containsKey(17));
        System.out.println(map.remove(1));
        System.out.println(map.size());
    }
}
