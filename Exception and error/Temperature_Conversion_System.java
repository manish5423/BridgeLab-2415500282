public class TemperatureConversionTool {
    static class InvalidTemperatureException extends Exception { InvalidTemperatureException(String m){ super(m); } }
    static double cToF(double c) { return c * 9/5 + 32; }
    static double fToC(double f) { return (f - 32) * 5/9; }
    static void convert(double value, String unit) throws InvalidTemperatureException {
        if(unit.equalsIgnoreCase("C")){
            if(value < -273.15) throw new InvalidTemperatureException("Temperature below absolute zero");
            System.out.println(value + "øC = " + cToF(value) + "øF");
        } else {
            if(value < -459.67) throw new InvalidTemperatureException("Temperature below absolute zero");
            System.out.println(value + "øF = " + fToC(value) + "øC");
        }
    }
    public static void main(String[] args){
        try{
            convert(-300, "C");
        } catch(InvalidTemperatureException e){
            System.out.println("Error: Temperature below absolute zero is not possible!");
        }
    }
}

