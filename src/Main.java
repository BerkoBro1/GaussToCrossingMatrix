public class Main {

    public static void main(String[] args) {
        int[] gaussTrefoil = {1,-2,3,-1,2,-3};
        int[][] crossingTrefoil = crossingMatrix(gaussTrefoil);

    }

    public static int[][] crossingMatrix(int[] nums) {
        //num of strands = crossing number = 2 * numbers in gauss encoding
        Strand[] strands = new Strand[nums.length/2];

        //crossing matrix
        int[][] cm = new int[strands.length][strands.length];
        for(int i = 0; i < cm.length; i++) { cm[i/cm.length][i%cm.length] = 0; }

        return cm;
    }

}