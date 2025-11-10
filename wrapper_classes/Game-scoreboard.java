import java.util.*;
public class GameScoreboard {
    public static void main(String[] args){
        Integer[] scores = {100, null, 250, 0, null, 75};
        int notPlayed = 0;
        int total = 0;
        for(Integer s : scores){
            if(s == null) notPlayed++;
            else total += s;
        }
        System.out.println("Players not played: " + notPlayed);
        System.out.println("Total of valid scores: " + total);
    }
}

