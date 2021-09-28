package com.classes;

/**
 * This class is for creating linked lists.
 *
 *
 * @author Shevchenko Darya
 * @param <T> Any of the data types
 */


public class LinkedList<T> {
    private Node head;
    private int size;

    /**
     * Construct
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Size of list
     *
     * @return Number of items in the list
     */
    public int size() {
        return size;
    }

    /**
     * Checking for emptiness
     *
     * @return 'true' if the list is empty and 'false' if it contains elements
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * Adds the first element to the list (since numbering is from zero, then zero)
     *
     * @param data The value to be added
     */
    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Adds the last item to the list
     *
     * @param data The value to be added
     */
    public void addLast(T data) {
        Node newNode = new Node(data);
        Node currentNode = head;
        if (isEmpty()) {
            head = newNode;
        }
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    /**
     * Adds a value to a specific place in the list by index.
     * If the index goes out of bounds, then the operation does not occur.
     *
     * @param index The place where you want to insert the element
     * @param data The value to be added
     * @throws Exception A warning that may appear as a result if the index has gone beyond
     * the limits of what is possible.
     */
    public void add(int index, T data) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Array indexing error");
        }
        else {
            if (index == 0) {
                addFirst(data);
            } else if (index == size) {
                addLast(data);
            } else {
                Node newNode = new Node(data);
                Node currentNode = head;
                Node previousNode = null;
                int i = 0;
                while (i != index && currentNode.next != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                    i++;
                }
                newNode.next = currentNode;
                previousNode.next = newNode;
                size++;
                }
            }
    }

    /**
     * The method removes the first matched element;
     *
     * @param data The value to be removed from the list;
     * @throws Exception A warning that may appear as a result if the index has gone beyond
     * the limits of what is possible.
     */
    public void remove(T data) throws Exception {
        if (isEmpty()) {
            throw new Exception("The list is empty: it is impossible to delete the element!");
        }
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode.data != data && currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode.data == data) {
            if (currentNode == head) {
                removeFirst();
            } else {
                Node nextNode = currentNode.next;
                previousNode.next = nextNode;
                size--;
            }
        }
    }

    /**
     * Method for removing the first (null) element from the list
     *
     * @throws Exception A warning that may appear as a result if the index has gone beyond
     * the limits of what is possible.
     */
    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("The list is empty: it is impossible to delete the first element!");
        }
        Node currentNode = head;
        head = head.next;
        size--;
    }

    /**
     * Method for removing the last element from the list
     *
     * @throws Exception A warning that may appear as a result if the index has gone beyond
     * the limits of what is possible.
     */
    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("The list is empty: it is impossible to delete the last element!");
        }
        Node currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        size--;
    }

    /**
     * Method for deleting an element by index
     *
     * @param index Index of the item we want to delete
     * @throws Exception A warning that may appear as a result if the index has gone beyond
     * the limits of what is possible.
     */
    public void removeByIndex(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Going beyond the boundaries of the list!");
        }
        else if (index == 0) {
            removeFirst();
        }
        else if (index == size - 1) {
            removeLast();
        }
        else {
            Node currentNode = head;
            Node previousNode = null;
            int i = 0;
            while (i != index) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                i++;
            }
            previousNode.next = currentNode.next;
            size--;
        }
    }

    /**
     * A method for deleting all items in the list.
     */
    public void clear() { // Clearing the entire list
        if (isEmpty()) {
            return;
        }
        Node currentNode = head;
        while (head.next != null) {
            while (currentNode.next.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            currentNode = head;
        }
        head = null;
        size = 0;
    }

    /**
     * A method for extracting an element by its index.
     *
     * @param index The index of the element we need.
     * @return Returns the value itself under this index.
     * @throws Exception A warning that may appear as a result if the index has gone beyond
     * the limits of what is possible.
     */
    public T get(int index) throws Exception {
        if (index >= size || index < 0 || isEmpty()) {
            throw new Exception("Going beyond the boundaries of the list!");
        }
        int i = 0;
        Node currentNode = head;
        while (i != index){
            currentNode = currentNode.next;
            i++;
        }
        return (T) currentNode.data;
    }

    /**
     * Output of the entire list
     *
     * @return The entire list is in the string type
     */
    @Override public String toString() {
        String list = new String("");
        if (isEmpty()) {
            return list;
        }
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            list += currentNode.data.toString() + " ";
            currentNode = currentNode.next;
        }
        list = list.substring(0, list.length()-1);
        return list;
    }
}
