public class Main {

    public static void main(String[] args) {
        StackGenerics<Integer> stackGenerics = new StackGenerics<>();

        System.out.println("Empty: " + stackGenerics.empty());

        System.out.println("=====");

        for(int i = 0; i < 8; i++)
            System.out.println("Element \"" + stackGenerics.push(i*i) + "\" has been added");

        System.out.println(stackGenerics);

        System.out.println("Empty: " + stackGenerics.empty());

        System.out.println("=====");

        System.out.println("search(9): " + stackGenerics.search(9));

        System.out.println("=====");

        for(int i = 0; i < 8; i++)
        {
            System.out.print("Peek: " + stackGenerics.peek() + " -> ");
            System.out.println("Element \"" + stackGenerics.pop() + "\" has been deleted");
        }

        System.out.println("=====");

        System.out.println("Empty: " + stackGenerics.empty());
    }
}
