package edu.escuelaing.arsw.ASE.app;

import com.sun.tools.javac.util.JCDiagnostic;

import java.util.Collection;
import java.util.Iterator;

public class LinkendList<E> implements Collection<E> {
    private Node<E> head;
    private int size;
    private static class Node<E>{
        E element;
        Node<E> next;
        Node (E element){
            this.element=element;
        }
    }
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



    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }



    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }
    public Object nextNode(Object o){
        int index = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            if (o == null ? x.element == null : o.equals(x.element)) {
                return x.next.element;
            }
        }
        return "Not exist anything";
    }
    public Object priorNode(){
        return this.head.element;
    }

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
}
