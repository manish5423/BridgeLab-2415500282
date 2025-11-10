import java.util.function.Consumer;
public class SmartHomeLighting {
    public static void main(String[] args){
        Consumer<String> motionTrigger = room -> System.out.println("Lights in " + room + " turned on due to motion");
        Consumer<String> timeTrigger = room -> System.out.println("Lights in " + room + " turned on at sunset");
        Consumer<String> voiceTrigger = room -> System.out.println("Lights in " + room + " turned on by voice command");
        motionTrigger.accept("Hall");
        timeTrigger.accept("Bedroom");
        voiceTrigger.accept("Kitchen");
    }
}
