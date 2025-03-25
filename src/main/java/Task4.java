public class Task4 {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());

        stack.clear();
        System.out.println("Size after clear: " + stack.size());
    }
}

class MyStack<E> {
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    private Node<E> top;
    private int size;

    public void push(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public E pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        E value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public E peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
