public class NestedTryCatchPropagation {
    static void methodB(String input){
        try{
            Integer.parseInt(input);
            String maybeNull = null;
            maybeNull.length();
        } catch(NumberFormatException e){
            System.out.println("Caught NumberFormatException in methodB");
        }
    }
    static void methodA(){
        methodB(null);
    }
    public static void main(String[] args){
        try{
            methodA();
        } catch(Exception e){
            System.out.println("Exception propagated to methodA/main: " + e.getClass().getSimpleName());
        }
    }
}

