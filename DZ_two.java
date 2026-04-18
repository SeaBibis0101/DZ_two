public class SimpleQueue {
    private int[] elements;
    private int front;  // начало очереди
    private int rear;   // конец очереди
    private int size;
    private int capacity;
    
    public SimpleQueue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Добавить в конец очереди
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Очередь переполнена!");
            return;
        }
        rear = (rear + 1) % capacity;
        elements[rear] = value;
        size++;
        System.out.println("Добавлен элемент: " + value);
    }
    
    // Удалить из начала очереди
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return -1;
        }
        int value = elements[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Удален элемент: " + value);
        return value;
    }
    
    // Просматриваем первый элемент
    public int peek() {
        if (isEmpty()) {
            System.out.println("Очередь пуста!");
            return -1;
        }
        return elements[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }
        System.out.print("Очередь: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(elements[index] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(5);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();  // Очередь: 10 20 30
        System.out.println();

        System.out.println("Первый элемент: " + queue.peek());  // 10
        queue.dequeue();  // Удален: 10
        queue.display();  // Очередь: 20 30
        System.out.println();
        
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();  // Очередь: 20 30 40 50
    }
}
