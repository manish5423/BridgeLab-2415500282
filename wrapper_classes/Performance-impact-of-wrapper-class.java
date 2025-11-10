import java.util.*;
public class WrapperPerformanceBenchmark {
    public static void main(String[] args){
        final int N = 1_000_000;
        int[] prim = new int[N];
        for(int i=0;i<N;i++) prim[i] = i;
        long startPrim = System.currentTimeMillis();
        long sumPrim = 0;
        for(int v : prim) sumPrim += v;
        long timePrim = System.currentTimeMillis() - startPrim;
        ArrayList<Integer> boxed = new ArrayList<>(N);
        for(int i=0;i<N;i++) boxed.add(i);
        long startBox = System.currentTimeMillis();
        long sumBox = 0;
        for(Integer v : boxed) sumBox += v;
        long timeBox = System.currentTimeMillis() - startBox;
        System.out.println("Primitive array sum: " + sumPrim + " time(ms)=" + timePrim);
        System.out.println("ArrayList<Integer> sum: " + sumBox + " time(ms)=" + timeBox);
    }
}

