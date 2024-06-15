public class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop an element from the stack
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack underflow: Cannot pop from an empty stack");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    // Peek at the top element of the stack
    public T peek() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack underflow: Cannot peek at an empty stack");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Clear the stack
    public void clear() {
        top = null;
    }
}
