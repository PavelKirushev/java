import java.util.Random;

class DataBuffer{
    static int n = 5, cnt;
    static int [] array = new int[n];

    private void output(){
        System.out.print("Array: ");
        for(int i = 0; i < 5; i ++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public synchronized void add(int value){
        while(cnt == n){
            System.out.println("Array is full, wait...");
            try{
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        array[cnt ++] = value;
        System.out.println(Thread.currentThread().getName() + " added " + value);
        output();
        notify();
    }

    public synchronized void remove(){
        while(cnt == 0){
            System.out.println("Array is empty, wait...");
            try{
                wait();
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        int value = array[cnt - 1];
        array[--cnt] = 0;
        System.out.println(Thread.currentThread().getName() + " removed " + value);
        output();
        notify();
    }
}

class Producer implements Runnable{
    DataBuffer buffer;
    Random random = new Random();
    public Producer(DataBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            buffer.add(random.nextInt(100));
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable{
    DataBuffer buffer;
    public Consumer(DataBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            buffer.remove();
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer();
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}
