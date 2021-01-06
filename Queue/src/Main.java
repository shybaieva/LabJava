public class Main {

    public static void main(String[] args) {
        QueueGenerics<String> queueGenerics = new QueueGenerics<>();

        queueGenerics.add("Name");
        queueGenerics.add("Surname");
        queueGenerics.add("LastName");

        System.out.println("First element in queue: " + queueGenerics.element());

        System.out.println(queueGenerics);

        System.out.println("=====");

        System.out.println("Removed: " + queueGenerics.poll());

        System.out.println("=====");

        System.out.println("First element in queue: " + queueGenerics.peek());

        System.out.println(queueGenerics);
    }
}
