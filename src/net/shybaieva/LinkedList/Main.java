package net.shybaieva.LinkedList;


public class Main {

    public static void main(String[] args)
    {
        ArrayListGenerics<String> list = new ArrayListGenerics<>();

        list.add("Hello");
        list.add("Name");
        list.add("Surname");
        list.add(1, "Aoao");
        list.add("Item");

        list.print();
        System.out.println("\nSize: " + list.size());
        System.out.println("Capacity: " + list.capacity());
        System.out.println("isEmpty: " + list.isEmpty());

        list.remove(0);
        list.remove("Surname");

        System.out.println();

        list.print();
        System.out.println("\nSize: " + list.size());
        System.out.println("Capacity: " + list.capacity());
        System.out.println("isEmpty: " + list.isEmpty());

        System.out.println("list.contains(\"Name\"): " + list.contains("Name"));
        System.out.println("list.get(1): " + list.get(1));
        list.set(2, "NewItem");
        list.add("Qwerty");

        System.out.println();

        list.print();
        System.out.println("\nSize = " + list.size());
        System.out.println("Capacity = " + list.capacity());
        System.out.println("isEmpty = " + list.isEmpty());

        list.add(0, "1");
        list.add("1");
        list.add("2");
        list.add("2");

        list.add("item0");
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item5");
        list.add("item6");
        list.add("item7");
        list.add("item8");
        list.add("item9");
        list.add("item10");

        System.out.println("\nlist.indexOf(\"1\"): " + list.indexOf("1"));
        System.out.println("list.lastIndexOf(\"1\"): " + list.lastIndexOf("1"));

        System.out.println();

        list.print();
        System.out.println("\nSize: " + list.size());
        System.out.println("Capacity: " + list.capacity());
        System.out.println("isEmpty: " + list.isEmpty());

        System.out.println("\nlist.clear();");
        list.clear();

        System.out.println("\nSize: " + list.size());
        System.out.println("Capacity: " + list.capacity());
        System.out.println("isEmpty: " + list.isEmpty());
    }
}
