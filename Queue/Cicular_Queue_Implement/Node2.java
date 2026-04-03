class Node2 {
    int data;
    Node next;

    Node2(int data){
        this.data=data;
        this.next=null;
    }

    public static class Circular{
        Node front;
        Node rear;

        void enqueue(int val){
            Node newNode = new Node(val);

            if(front == null){   // if the queue is empty;
                front = newNode;
                rear = newNode;
                rear.next = front;
                return;
            }

            rear.next = newNode;
            rear = newNode;    // pointer shift.
            rear.next = front; //rear point the front element.  // store address of next node.
        }


        // Dequeue implementation.
        void dequeue(){

            if(front == null){
                System.out.println("Queue is Empty");
                return;
            }
            if(front == rear){
                front=null;
                rear=null;
                return;
            }

            front = front.next;
            rear.next = front;
        }
        void display() {
            if (front == null) {
                System.out.println("Queue is empty");
                return;
            }

            Node temp = front;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != front);  // stop when back at front
            System.out.println();
        }

    }

}
