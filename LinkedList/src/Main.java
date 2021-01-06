public class Main {

    public static void main(String[] args) {
        LinkedListGenerics<String> listGenerics = new LinkedListGenerics<>();

        listGenerics.add("Name");
        listGenerics.add(null);
        listGenerics.add("Surname");
        listGenerics.add("name1");
        listGenerics.add("surname1");
        listGenerics.addHead("name1");
        listGenerics.addHead("Surname");

        System.out.println("Size: " + listGenerics.size());
        System.out.println(listGenerics);

        System.out.println("indexOf(name1): " + listGenerics.indexOf("name1"));
        System.out.println("lastIndexOf(Surname): " + listGenerics.lastIndexOf("Surname"));

        System.out.println(listGenerics.get(6));
        listGenerics.add(6,"new");

        System.out.println(listGenerics.contains(null));

        System.out.println("Size: " + listGenerics.size());
        System.out.println(listGenerics);
//        listGenerics.addFirst("Name");
//        listGenerics.addFirst("Hello3");
//        listGenerics.addLast("Name1");
//        listGenerics.addFirst("Surname");
//        listGenerics.addLast("Hello3");
//        listGenerics.addFirst("Hello");
//        listGenerics.addLast("Surname2");
//
//        listGenerics.addFirst("0");
//        listGenerics.addLast("0");
//        listGenerics.add("New Element");
//        listGenerics.add(2,"ITEM");
//
//        listGenerics.print();
//        System.out.println();
//
//        System.out.println(listGenerics.contains("New Element"));
//
//        System.out.println(listGenerics.getFirst());
//        System.out.println(listGenerics.getLast());
//        System.out.println(listGenerics.get(2));
//
//        System.out.println(listGenerics.indexOf("0"));
//        System.out.println(listGenerics.lastIndexOf("0"));
//
//        System.out.println(listGenerics.set(2, "New Item"));
//
//        System.out.println(listGenerics.removeFirst());
//        System.out.println(listGenerics.removeLast());
//        System.out.println(listGenerics.remove(0));
//        System.out.println(listGenerics.remove("Name"));
//
//        listGenerics.print();
//
//        System.out.println("\nSize: " + listGenerics.size());
//        System.out.println("Is empty: " + listGenerics.isEmpty());
//
//        listGenerics.clear();
    }
}
