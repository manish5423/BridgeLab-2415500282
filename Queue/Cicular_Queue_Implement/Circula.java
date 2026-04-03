public class Circula {
//Implement cicular list using linedlist.
public static void main(String[] args) {
    Node2.Circular c1 = new Node2.Circular();
    c1.enqueue(12);
    c1.enqueue(32);
    c1.enqueue(42);
    c1.enqueue(52);

    c1.dequeue();
    c1.dequeue();


    c1.display();
}
}
