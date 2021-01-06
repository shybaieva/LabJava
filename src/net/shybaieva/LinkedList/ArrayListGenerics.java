package net.shybaieva.LinkedList;

import java.util.NoSuchElementException;

public class ArrayListGenerics <E> {
    private int capacity;
    private final int CUT_RANGE = 4;

    private Object[] array;

    private int elementCount;

    public ArrayListGenerics(int initCapacity)
    {
        this.capacity = Math.abs(initCapacity);
        this.array = new Object[this.capacity];
    }

    public ArrayListGenerics()
    {
        this(16);
    }

    @SuppressWarnings("unchecked")
    E array(int index)
    {
        return (E) array[index];
    }

    private void resize(int newLength)
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, elementCount);
        array = newArray;
    }

    public int capacity()
    {
        return array.length;
    }

    public int size()
    {
        return elementCount;
    }

    public boolean isEmpty()
    {
        return elementCount == 0;
    }

    public void clear()
    {
        if(isEmpty())
            throw new NoSuchElementException();

        for(int i = elementCount; i > 0; i--)
            array[i] = null;

        elementCount = 0;
        resize(capacity);
    }

    public void print()
    {
        for(int i = 0; i < elementCount; i++)
            System.out.print(array[i] + " ");
    }

    public boolean contains(E element)
    {
        if(isEmpty())
            throw new NoSuchElementException();

        for(int i = 0; i < elementCount; i++)
            if(array[i] == element)
                return true;

        return false;
    }

    public E set(int index, E element)
    {
        if(isEmpty())
            throw new NoSuchElementException();

        if(index < 0 || index > elementCount - 1)
            throw new IndexOutOfBoundsException();

        E oldItem = array(index);

        array[index] = element;

        return oldItem;
    }

    public E get(int index)
    {
        if(isEmpty())
            throw new NoSuchElementException();

        if(index < 0 || index > elementCount - 1)
            throw new IndexOutOfBoundsException();

        return array(index);
    }

    public int indexOf(E element)
    {
        if(isEmpty())
            throw new NoSuchElementException();

        for(int i = 0; i < elementCount; i++)
            if(array[i] == element)
                return i;

        return -1;
    }

    public int lastIndexOf(E element)
    {
        if(isEmpty())
            throw new NoSuchElementException();

        if(contains(element))
        {
            int lastIndexOf = -1;

            for(int i = 0; i < elementCount; i++)
                if (array[i] == element)
                    lastIndexOf = i;

            return lastIndexOf;
        }

        return -1;
    }

    public boolean add(E element)
    {
        if(elementCount == array.length - 1)
            resize(array.length * 2);

        array[elementCount] = element;

        elementCount++;

        return true;
    }

    public void add(int index, E element)
    {
        if(elementCount == array.length - 1)
            resize(array.length * 2);

        System.arraycopy(array, index, array, index + 1,  elementCount - index);

        array[index] = element;

        elementCount++;
    }

    public E remove(int index)
    {
        if(isEmpty())
            throw new NoSuchElementException();

        if(index < 0 || index > elementCount - 1)
            throw new IndexOutOfBoundsException();

        E oldItem = array(index);

        if (elementCount - index >= 0) System.arraycopy(array, index + 1, array, index, elementCount - index);

        array[elementCount] = null;
        elementCount--;

        if(array.length > capacity && elementCount < array.length / CUT_RANGE)
            resize(array.length/2);

        return oldItem;
    }

    public boolean remove(E element)
    {
        if(isEmpty())
            throw new NoSuchElementException();

        for(int index = 0; index < elementCount; index++)
            if(array[index] == element)
            {
                System.arraycopy(array, index + 1, array, index, elementCount - index);

                array[elementCount] = null;
                elementCount--;

                if(array.length > capacity && elementCount < array.length / CUT_RANGE)
                    resize(array.length/2);

                return true;
            }

        return false;
    }
}
