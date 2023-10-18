import java.util.ArrayList;

public class Strand {

    ArrayList<Integer> crossings;
    public Strand() {
        crossings = new ArrayList<>();
    }

    public void addCrossing(int n) {crossings.add(n);}

    public int[] getCrossings(int length) {
        int[] c = new int[length];
        for(int i = 1; i <= length; i++) {
            if(crossings.contains(i)) c[i-1] = 2;
            else if(crossings.contains(-i)) c[i-1] = -1;
            else c[i] = 0;
        }
        return c;
    }

}
