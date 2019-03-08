package moe.emilia.relearn.linear.linked;

import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 单链表
 *
 * @author lihuaye
 */
public class SingleList<E> {

    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    private class Node {
        private E value;

        private Node next;

        public boolean hasNext() {
            return next != null;
        }
    }

    private Node head = new Node();
    private int size = 0;

    public boolean isEmpty() {
        return 0 == size;
    }

    public void add(E value) {
        Node last = head;
        for (; last != null; last = last.next) {
            if (last.next == null) {
                break;
            }
        }
        assert last != null;
        last.next = new Node(value, null);
        size += 1;
    }

    public void delete(E value) {
        if (isEmpty()) {
            return;
        }

        Node last = head;
        Node now = head.next;
        for (; now != null; now = now.next) {
            if (value == now.value) {
                break;
            }
            // 保留上个节点
            last = now;
        }

        assert now != null;
        last.next = now.next;
        size--;
    }

    public E get(int index) {
        if (index < 0 || isEmpty()) {
            return null;
        }

        Node now = head.next;
        for (int i = 0; now != null; now = now.next, i++) {
            if (i == index) {
                return now.value;
            }
        }

        return null;
    }

    public void set(E value, int index) {
        if (index < 0 || isEmpty()) {
            return;
        }

        Node now = head.next;
        for (int i = 0; now != null; now = now.next, i++) {
            if (i == index) {
                now.value = value;
            }
        }
    }

    public List<E> toArray() {
        if (isEmpty()) {
            return Collections.emptyList();
        }

        List<E> array = new ArrayList<>(size);

        for (Node now = head.next; now != null; now = now.next) {
            array.add(now.value);
        }

        return array;
    }

}
