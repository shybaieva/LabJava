import java.util.EmptyStackException;

public class StackGenerics <E> {
    private Node<E> head;

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

    public boolean empty()
    {
        return elementCount == 0;
    }

    public E peek()
    {
        if(empty())
            throw new EmptyStackException();

        return headElement();
    }

    public synchronized E push(E element)
    {
        Node<E> node = new Node<>(element);

        node.next = head;
        head = node;

        elementCount++;

        return element;
    }

    public synchronized E pop()
    {
        if(elementCount == 0)
            throw new EmptyStackException();

        E oldValue = headElement();
        head = head.next;

        elementCount--;

        return oldValue;
    }

    public int search(Object element)
    {
        int lastIndexOfElement = -1;

        Node<E> node = head;
        int currentIndex = 0;

        if(element == null) {
            while (node != null) {
                if (node.element == null)
                    lastIndexOfElement = currentIndex;

                currentIndex++;
                node = node.next;
            }
        } else {
            while (node != null) {
                if (element.equals(node.element))
                    lastIndexOfElement = currentIndex;

                currentIndex++;
                node = node.next;
            }
        }

        if(lastIndexOfElement >= 0)
            return lastIndexOfElement + 1;

        return -1;
    }

    @Override
    public synchronized String toString()
    {
        Node<E> node = head;
        StringBuilder stringBuilder = new StringBuilder("[");

        while(node != null)
        {
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
