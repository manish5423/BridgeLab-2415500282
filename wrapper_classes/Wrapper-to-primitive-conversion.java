public class WrapperToPrimitive {
    public static void main(String[] args){
        Double wrapperDouble = Double.valueOf(45.67);
        double primDouble = wrapperDouble.doubleValue();
        int primInt = (int) wrapperDouble.doubleValue();
        System.out.println("Double object: " + wrapperDouble);
        System.out.println("Primitive double: " + primDouble);
        System.out.println("Primitive int (cast): " + primInt);
    }
}

