class Node {
    int data;
    Node next;
    Node pre;

    Node(int data){
        this.data=data;
        this.next=null;
        this.pre =null;
    }
}

class Dqueue{
    Node front;
    Node rear;

    //Insert At front;

    void InserAtFront(int val){
        Node newNode = new Node(val);

        if(front == null){
            front=newNode;
            rear= newNode;
            return;
        }

        newNode.next=front;
        front.pre=newNode;
        front=newNode;

    }

    void InsertAtEnd(int val){
        Node newNode = new Node(val);

        if(rear==null){
            rear=newNode;
            front=newNode;
            return;
        }

        newNode.pre=rear;
        rear.next=newNode;
        rear=newNode;
    }

    void display(){
        Node temp = front;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void deleteAtfront(){
        if(front == null){
            System.out.println("Dqueue is Empty..");
        }

        if(front == rear){
            front=rear=null;
            return;
        }

        front = front.next;
        front.pre = null;

    }

    void deleteAtEnd(){
        if(front == null){
            System.out.println("Dqueue is Empty..");
        }

        if(front == rear){
            front=rear=null;
            return;
        }

        rear = rear.pre;
        rear.next = null;

    }

}

