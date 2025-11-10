class Prototype implements Cloneable {
    private String name;
    private int value;
    Prototype(String name, int value){ this.name = name; this.value = value; }
    protected Prototype clone() throws CloneNotSupportedException { return (Prototype) super.clone(); }
    public String toString(){ return name + ":" + value; }
}
public class CloningDemo {
    public static void main(String[] args) throws Exception {
        Prototype original = new Prototype("template", 42);
        Prototype copy = original.clone();
        System.out.println("Original -> " + original);
        System.out.println("Copy -> " + copy);
    }
}
