import java.util.NoSuchElementException;

public class LinkedListGenerics <E> {
    private transient Node<E> head;
    private transient Node<E> tail;

    private transient int elementCount = 0;

    private static class Node<E>
    {
        private Node<E> prev;
        private Node<E> next;

        private Object element;

        private Node(Node<E> prev, Object element, Node<E> next)
        {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        private Node(Object element)
        {
            this(null, element, null);
        }
    }
    public void clear()
    {
        head = tail = null;
        elementCount = 0;
    }

    public int size()
    {
        return elementCount;
    }

    public boolean contains(Object element)
    {
        if(size() == 0)
            throw new NoSuchElementException();

        Node<E> node = head;

        if(element == null) {
            while(node != null) {
                if(node.element == null)
                    return true;

                node = node.next;
            }
        } else {
            while(node != null) {
                if(node.element == element)
                    return true;

                node = node.next;
            }
        }

        return false;
    }

    public E set(int index, E element)
    {
        if(index < 0 || index >= elementCount)
            throw new IndexOutOfBoundsException();

        return (E) (findByIndex(index).element = element);
    }

    public E get(int index)
    {
        if(size() == 0)
            throw new NoSuchElementException();

        if(index < 0 || index >= elementCount)
            throw new IndexOutOfBoundsException();

        Node<E> node = head;

        for(int i = 0; i < index; i++)
            node = node.next;

        return (E) node.element;
    }

    public E getHead()
    {
        if(size() == 0)
            throw new NoSuchElementException();

        return (E) head.element;
    }

    public E getTail()
    {
        if(size() == 0)
            throw new NoSuchElementException();

        return (E) tail.element;
    }

    public int indexOf(Object element)
    {
        Node<E> node = head;

        int index = 0;

        if(element == null) {
            while(node != null) {
                if(node.element == null)
                    return index;

                index++;
                node = node.next;
            }
        } else {
            while(node != null) {
                if(element.equals(node.element))
                    return index;

                index++;
                node = node.next;
            }
        }

        return -1;
    }

    public int lastIndexOf(E element)
    {
        Node<E> node = tail;

        int index = elementCount - 1;

        if(element == null) {
            while(node != null) {
                if(node.element == null)
                    return index;

                index--;
                node = node.prev;
            }
        } else {
            while(node != null) {
                if(element.equals(node.element))
                    return index;

                index--;
                node = node.prev;
            }
        }

        return -1;
    }

    public boolean add(E element)
    {
        Node<E> nodePrev = tail;
        Node<E> newNode = new Node<>(nodePrev, element, null);

        tail = newNode;

        if(nodePrev == null)
            head = newNode;
        else
            nodePrev.next = newNode;

        elementCount++;
        return true;
    }

    public void addHead(E element)
    {
        Node<E> nodeNext = head;
        Node<E> newNode = new Node<>(null, element, nodeNext);

        head = newNode;

        if(nodeNext == null)
            tail = newNode;
        else
            nodeNext.prev = newNode;

        elementCount++;
    }

    public void addTail(E element)
    {
        Node<E> nodePrev = tail;
        Node<E> newNode = new Node<>(nodePrev, element, null);

        tail = newNode;

        if(nodePrev == null)
            head = newNode;
        else
            nodePrev.next = newNode;

        elementCount++;
    }

    public void add(int index, E element)
    {
        if(index < 0 || index > elementCount)
            throw new IndexOutOfBoundsException();

        if(index == 0) {
            addHead(element);
            return;
        } else if(index == elementCount) {
            addTail(element);
            return;
        }

        Node<E> newNode = new Node<>(element);

        Node<E> nextNode = head;

        for(int i = 0; i < index; i++)
            nextNode = nextNode.next;

        Node<E> prevNode = nextNode.prev;
        prevNode.next = newNode;

        nextNode.prev = newNode;

        newNode.next = nextNode;
        newNode.prev = prevNode;

        elementCount++;
    }

    public boolean remove(Object element)
    {
        Node<E> node = head;

        if(node == null)
            throw new NoSuchElementException();

        int index = 0;

        if(element == null) {
            while(node != null) {
                if(node.element == null)
                    return remove(index);

                index++;
                node = node.next;
            }
        } else {
            while(node != null) {
                if (element.equals(node.element))
                    return remove(index);

                index++;
                node = node.next;
            }
        }

        return false;

//        if(size() == 0)
//            throw new NoSuchElementException();
//
//        if(elementCount == 1)
//        {
//            first = last = null;
//            elementCount = 0;
//
//            return true;
//        }
//
//        Node<E> node = findNodeByItem(element);
//
//        if(node != null) {
//            if(first.element == element) {
//                first = first.next;
//                first.prev = null;
//            }
//            else if(last.element == element) {
//                last = last.prev;
//                last.next = null;
//            } else if(node.next != null && node.prev != null) {
//                    Node<E> nodeNext = node.next;
//                    node = node.prev;
//                    node.next = nodeNext;
//            }
//
//            elementCount--;
//            return true;
//        }
//
//        return false;
    }

    public boolean remove(int index)
    {
        if(size() == 0)
            throw new NoSuchElementException();

        if(index < 0 || index >= elementCount)
            throw new IndexOutOfBoundsException();

        if(index == 0 && elementCount == 1)
        {
            head = tail = null;
            elementCount = 0;
            return true;
        }

        if(index == 0) {
            head = head.next;
            head.prev = null;
        } else if(index == elementCount - 1) {
            tail = head;
            tail.next = null;
        } else {
            Node<E> nodePrev = findNodeBeforeByIndex(index);
            Node<E> node = findByIndex(index);

            if (nodePrev != null && node != null) {
                nodePrev.next = node.next;
            } else throw new NullPointerException("Debug: << remove(index) >>");
        }

        elementCount--;
        return true;
    }

    public E removeHead()
    {
        if(size() == 0)
            throw new NoSuchElementException();

        E oldValue = (E) head.element;

        if(head.next != null)
        {
            head = head.next;
            head.prev = null;
            elementCount--;

            return oldValue;
        }

        head = tail = null;
        elementCount = 0;

        return null;
    }

    public E removeTail()
    {
        if(size() == 0)
            throw new NoSuchElementException();

        if(tail.prev != null)
        {
            tail = tail.prev;
            tail.next = null;
            elementCount--;

            return (E) tail.element;
        }

        head = tail = null;
        elementCount = 0;

        return null;
    }

    private Node<E> findNodeByItem(Object element)
    {
        Node<E> node = head;

        while(node != null)
        {
            if(node.element == element)
                return node;

            node = node.next;
        }

        return null;
    }

    private Node<E> findByIndex(int index)
    {
        if(index == 0)
            return head;

        if(index == elementCount - 1)
            return tail;

        int currentIndex = 0;
        Node<E> node = head;

        while(node != null)
        {
            if(currentIndex == index)
                return node;

            currentIndex++;
            node = node.next;
        }

        return null;
    }

    private Node<E> findNodeBeforeByIndex(int index)
    {
        Node<E> node = head;

        int prevIndex = 0;
        while(node != null)
        {
            if(prevIndex == index - 1)
                return node;

            prevIndex++;
            node = node.next;
        }

        return null;
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