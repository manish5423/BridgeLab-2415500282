class CircularBuffer {
    int[] arr;
    int size, index = 0;

    CircularBuffer(int s){
        size = s;
        arr = new int[s];
    }

    void add(int x){
        arr[index] = x;
        index = (index + 1) % size;
    }

    void print(){
        for(int i : arr)
            System.out.print(i + " ");
    }
}

public class Buffer {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.add(1);
        cb.add(2);
        cb.add(3);
        cb.add(4);

        cb.print();
    }
}
