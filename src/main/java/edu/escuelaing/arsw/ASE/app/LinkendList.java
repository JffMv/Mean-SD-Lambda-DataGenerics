package edu.escuelaing.arsw.ASE.app;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.Iterator;

/**
 * It is container the data work the head and tail, and elements are connect between themselves.
 * @param <E>
 */
public class LinkendList<E> implements Collection<E> {
    private Node<E> head;
    private int size;

    /**
     * This class is Node for this container
     * @param <E> Receive anything data for storage.
     */
    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the element to add
     * @return true if the element is added successfully
     */
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Removes the specified element from the list.
     *
     * @param o the element to remove
     * @return true if the element is removed successfully
     */
    @Override
    public boolean remove(Object o) {
        if (head == null) {
            return false;
        }
        if (head.element.equals(o)) {
            head = head.next;
            size--;
            return true;
        }
        Node<E> current = head;
        while (current.next != null && !current.next.element.equals(o)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Returns the size of the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param o the element to check
     * @return true if the list contains the element, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        for (Node<E> x = head; x != null; x = x.next) {
            if (o == null ? x.element == null : o.equals(x.element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an iterator over the elements in the list
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Returns an array containing all elements in the list.
     *
     * @return an array containing all elements in the list
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            array[i++] = x.element;
        }
        return array;
    }

    /**
     * Returns an array containing all elements in the list; the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of the list are to be stored
     * @return an array containing all elements in the list
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.element;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Checks if the list contains all elements in the specified collection.
     *
     * @param c the collection to check
     * @return true if the list contains all elements, false otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements from the specified collection to the list.
     *
     * @param c the collection containing elements to be added
     * @return true if the list changed as a result
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all elements in the specified collection from the list.
     *
     * @param c the collection containing elements to be removed
     * @return true if the list changed as a result
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c) {
            if (remove(e)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in the list that are contained in the specified collection.
     *
     * @param c the collection containing elements to be retained
     * @return true if the list changed as a result
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node<E> current = head;
        Node<E> prev = null;
        while (current != null) {
            if (!c.contains(current.element)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                modified = true;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return modified;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns the next node element after the specified element.
     *
     * @param o the element to find the next node for
     * @return the next node element or "Not exist anything" if not found
     */
    public Object nextNode(Object o) {
        for (Node<E> x = head; x != null; x = x.next) {
            if (o == null ? x.element == null : o.equals(x.element)) {
                return x.next != null ? x.next.element : "Not exist anything";
            }
        }
        return "Not exist anything";
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element in the list
     */
    public Object priorNode() {
        return head != null ? head.element : "List is empty";
    }

    /**
     * Returns the index of the specified element.
     *
     * @param o the element to find the index for
     * @return the index of the element or -1 if not found
     */
    public int indexOf(Object o) {
        int index = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            if (o == null ? x.element == null : o.equals(x.element)) {
                return index;
            }
            index++;
        }
        return -1;
    }
    /**
     * Prints the elements stored in each node of the container.
     * If the container is empty, prints a message indicating so.
     * Each printed element represents the Mean and SD of a column.
     */
    public void printer(){
        Node current = head;
        int index = 0;
        if (head.element == null){
            System.out.println("Is empty the container.");
        }
        while (current != null){
            System.out.println("The Mean and SD of the column "+index+" are:");
            System.out.println(current.element.toString());
            current = current.next;
            index++;
        }
    }

}