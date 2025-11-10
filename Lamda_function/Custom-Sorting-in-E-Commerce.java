import java.util.*;
public class EcommerceSorting {
    public static void main(String[] args){
        class Product {
            String name;
            double price;
            double rating;
            int discount;
            Product(String n, double p, double r, int d){ name=n; price=p; rating=r; discount=d; }
            public String toString(){ return name+" "+price+" "+rating+" "+discount; }
        }
        List<Product> items = new ArrayList<>();
        items.add(new Product("A", 999, 4.1, 5));
        items.add(new Product("B", 799, 4.8, 10));
        items.add(new Product("C", 1199, 4.5, 15));
        items.sort((x,y) -> Double.compare(x.price, y.price));
        System.out.println("Price sort");
        items.forEach(System.out::println);
        items.sort((x,y) -> Double.compare(y.rating, x.rating));
        System.out.println("Rating sort");
        items.forEach(System.out::println);
        items.sort((x,y) -> Integer.compare(y.discount, x.discount));
        System.out.println("Discount sort");
        items.forEach(System.out::println);
    }
}
