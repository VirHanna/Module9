public class Task3 {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        queue.add("Apple");
        queue.add("Banana");
        queue.add("Cherry");

        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Size: " + queue.size());

        queue.clear();
        System.out.println("Size after clear: " + queue.size());
    }
}

class MyQueue<E> {
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        front = rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.value;
    }

    public E poll() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        E value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return value;
    }
}
