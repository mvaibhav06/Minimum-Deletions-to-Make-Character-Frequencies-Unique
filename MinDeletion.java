import java.util.Arrays;
import java.util.HashSet;

public class MinDeletion {
    public static int minDeletion(String s){
        char[] temp = s.toCharArray();
        Arrays.sort(temp);

        HashSet<Integer> counters = new HashSet<>();
        int counter = 1;
        int out = 0;
        int i = 0;
        for (i=0; i<temp.length-1; i++){
            if (temp[i] == temp[i+1]){
                counter++;
            }else {
                if (counters.contains(counter)){
                    while (counters.contains(counter)){
                        counter--;
                        out++;
                    }
                    if (counter != 0) {
                        counters.add(counter);
                    }
                }else {
                    counters.add(counter);
                }
                counter = 1;
            }
        }
        while (counters.contains(counter)){
            counter--;
            out++;
        }

        return out;
    }
    public static void main(String[] args) {
        System.out.println(minDeletion("bbcebab"));
    }
}
