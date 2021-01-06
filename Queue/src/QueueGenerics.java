import java.util.NoSuchElementException;

public class QueueGenerics <E> {
    private Node<E> head;
    private Node<E> tail;

    private int elementCount;

    private static class Node<E>
    {
        private Node<E> next;
        private Object element;

        private Node(Object element)
        {
            this.element = element;
        }
    }

    @SuppressWarnings("unchecked")
    E headElement()
    {
        return (E) head.element;
    }

    public E peek()
    {
        if(elementCount == 0)
            return null;

        return headElement();
    }

    public E element()
    {
        if(elementCount == 0)
            throw new NoSuchElementException();

        return headElement();
    }

    public boolean add(E element)
    {
        Node<E> node = new Node<>(element);
        Node<E> prevNode = tail;

        if(elementCount == 0)
            head = tail = node;
        else {
            tail = node;
            prevNode.next = tail;
        }

        elementCount++;
        return true;
    }

    public boolean offer(E element)
    {
        return add(element);
    }

    public E remove()
    {
        if(elementCount == 0)
            throw new NoSuchElementException();

        E oldValue = headElement();

        head = head.next;
        elementCount--;

        return oldValue;
    }

    public E poll()
    {
        if(elementCount == 0)
            return null;

        E oldValue = headElement();

        head = head.next;
        elementCount--;

        return oldValue;
    }

    @Override
    public String toString()
    {
        Node<E> node = head;
        StringBuilder stringBuilder = new StringBuilder("[");

        while(node != null) {
            if(node.next != null)
                stringBuilder.append(node.element).append(", ");
            else
                stringBuilder.append(node.element);

            node = node.next;
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
