import java.util.*;

public class Queue_fixed_size {
    int capacity;
    int size;
    int head;
    int tail;
    int[] queue;

    public Queue_fixed_size(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.tail = 0;
        this.head = 0;
        queue = new int[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public void Enqueue(int x){
        if(this.isFull()){
            System.out.println("queue already full");
            return;
        }
        queue[tail] = x;
        tail++;
        size++;
        System.out.println("enqueue successfully");
        if(tail == capacity) tail = 0;
        return;
    }

    public int Dequeue(){
        if(this.isEmpty()){
            System.out.println("nothing to dequeue, return 0 as default");
            return 0;
        }
        int res = queue[head];
        head++;
        size--;
        if(head == capacity) head = 0;
        return res;
    }

    public static void main(String[] args) {
        Queue_fixed_size queue = new Queue_fixed_size(3);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Enqueue(5);
        queue.Enqueue(7);
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        System.out.println(queue.Dequeue());
        return;
    }
}