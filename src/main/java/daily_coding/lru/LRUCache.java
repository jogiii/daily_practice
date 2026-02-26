package daily_coding.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache implements a Least Recently Used (LRU) cache.
 * It uses a HashMap for O(1) access and a doubly linked list to track usage order.
 * When the cache exceeds its capacity, the least recently used item is evicted.
 */
public class LRUCache<T> {

    private final int capacity; // Maximum number of items the cache can hold
    private int size; // Current number of items in the cache
    private final Map<String, Node> hashmap; // Maps keys to nodes for O(1) access
    private final DoublyLinkedList internalQueue; // Maintains usage order

    LRUCache(final int capacity) {
        this.capacity = capacity;
        this.hashmap = new HashMap<>();
        this.internalQueue = new DoublyLinkedList();
        this.size = 0;
    }

    /**
     * Retrieves the value for the given key if present.
     * Moves the accessed node to the front (most recently used).
     */
    public T get(final String key) {
        Node node = hashmap.get(key);
        if(node == null) {
            return null;
        }
        internalQueue.modeNodeToFront(node);
        return hashmap.get(key).value;
    }

    /**
     * Inserts or updates the value for the given key.
     * Moves the node to the front if it already exists.
     * If the cache is full, removes the least recently used item.
     */
    public void put(final String key, final T value) {
        Node currentNode = hashmap.get(key);
        if(currentNode != null) {
            currentNode.value = value;
            internalQueue.modeNodeToFront(currentNode);
            return;
        }

        if(size == capacity) {
            String rearNodeKey = internalQueue.getRearKey();
            internalQueue.removeNodeFromRear();
            hashmap.remove(rearNodeKey);
            size--;
        }

        Node node = new Node(key, value);
        internalQueue.addNodeToFront(node);
        hashmap.put(key, node);
        size++;
    }

    /**
     * Node represents an entry in the doubly linked list.
     */
    private class Node {
        String key;
        T value;
        Node next, prev;
        public Node(final String key, final T value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * DoublyLinkedList maintains the order of usage.
     * Front is most recently used, rear is least recently used.
     */
    private class DoublyLinkedList {
        private Node front, rear;
        public DoublyLinkedList() {
            front = rear = null;
        }

        // Adds a node to the front (most recently used)
        private void addNodeToFront(final Node node) {
            if(rear == null) {
                front = rear = node;
                return;
            }
            node.next = front;
            front.prev = node;
            front = node;
        }

        // Moves an existing node to the front
        public void modeNodeToFront(final Node node) {
            if(front == node) {
                return;
            }

            if(node == rear) {
                rear = rear.prev;
                rear.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;
        }

        // Removes the node at the rear (least recently used)
        private void removeNodeFromRear() {
            if(rear == null) {
                return;
            }

            System.out.println("Deleting key: " + rear.key);
            if(front == rear) {
                front = rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
        }

        // Returns the key of the rear node
        private String getRearKey() {
            return rear.key;
        }
    }
}
