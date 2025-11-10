import java.util.Scanner;
public class PrimitiveToWrapper {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int primitiveValue = 42;
        System.out.println("Enter an integer (or press Enter to use 42):");
        String line = sc.nextLine().trim();
        if(!line.isEmpty()){
            try{ primitiveValue = Integer.parseInt(line); } catch(Exception e){}
        }
        Integer wrapperValue = Integer.valueOf(primitiveValue);
        System.out.println("Primitive int: " + primitiveValue);
        System.out.println("Wrapper Integer: " + wrapperValue);
        sc.close();
    }
}

