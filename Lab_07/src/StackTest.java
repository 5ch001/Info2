public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Top element is: " + stack.peek()); // 30

            System.out.println("Popped element is: " + stack.pop()); // 30
            System.out.println("Popped element is: " + stack.pop()); // 20

            stack.push(40);

            System.out.println("Top element is: " + stack.peek()); // 40

            stack.clear();

            System.out.println("Is stack empty? " + stack.isEmpty()); // true

            // This will throw StackUnderflowException
            stack.pop();

        } catch (StackUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}