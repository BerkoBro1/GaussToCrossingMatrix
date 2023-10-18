import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] gaussTrefoil = {1,-2,3,-1,2,-3};
        int[][] crossingTrefoil = crossingMatrix(gaussTrefoil);

    }

    public static int[][] crossingMatrix(int[] nums) {
        //num of strands = crossing number = 2 * numbers in gauss encoding
        int numStrands = nums.length/2;

        //initialize all strands
        Strand[] strands = new Strand[numStrands];
        for(int i = 0; i < numStrands; i++) strands[i] = new Strand();

        int currentStrand = 0;

        for(int i : nums) {
            //if going over at this crossing, add the crossing as over to the current strand
            if(i > 0) strands[currentStrand].addCrossing(i);

            //otherwise add the crossing as an under to both the current and next strands
            else {
                strands[currentStrand].addCrossing(i);

                //make sure to wrap to beginning strand just in case
                currentStrand = currentStrand==numStrands-1 ? 0 : currentStrand+1;

                strands[currentStrand].addCrossing(i);
            }
        }

        /* test print crossing matrix
        for(Strand s : strands) {
            System.out.println(Arrays.toString(s.getCrossings(numStrands)));
        }
        */

        //crossing matrix
        int[][] cm = new int[numStrands][numStrands];

        //get crossing matrix from crossings of each of the
        for(int i = 0; i < cm.length; i++) {
            int[] ccm = strands[i].getCrossings(numStrands);
            for(int j = 0; j < cm.length; j++) {
                cm[j][i] = ccm[j];
            }
        }
        return cm;
    }

}