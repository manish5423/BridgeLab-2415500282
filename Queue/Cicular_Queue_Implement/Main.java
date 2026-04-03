public class Main{
    public static void main(String[] args) {
//        Dqueue.
//        Card of deck example of dqueue
            Dqueue d= new Dqueue();
            d.InserAtFront(10);
            d.InsertAtEnd(20);
            d.InsertAtEnd(12);
            d.InsertAtEnd(100);
            d.InserAtFront(120);


            d.deleteAtfront();
            d.deleteAtEnd();

            d.display();


    }

}
