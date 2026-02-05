package implhashmap;

public class ImplHashMap<K, V> {
    private Node<K,V>[] table;
    private int size = 0;
    private final int INITIAL_CAPACITY = 16;

    public ImplHashMap() {
        table = new Node[INITIAL_CAPACITY];
    }

    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = table[index];

        while (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) return node.value;
            node = node.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = table[index];

        while (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K,V> newNode = new Node<> (key,value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> node = table[index];
        Node<K, V> prev = null;

        while (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                if (prev == null) table[index] = node.next;
                else prev.next = node.next;
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    private int getIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
