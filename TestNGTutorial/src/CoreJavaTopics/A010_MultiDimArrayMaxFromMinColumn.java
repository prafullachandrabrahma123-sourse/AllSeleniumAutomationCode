package CoreJavaTopics;

public class A010_MultiDimArrayMaxFromMinColumn {

    public static void main(String[] args) {

        int[][] abc = {{2,4,5},{3,2,10},{1,2,0}};

        int min = abc[0][0];
        int minColumn = 0;

        // Find minimum element and its column
        for (int i = 0; i < abc.length; i++) {
            for (int j = 0; j < abc[i].length; j++) {
                if (abc[i][j] < min) {
                    min = abc[i][j];
                    minColumn = j;
                }
            }
        }

        // Find maximum in that column
        int max = abc[0][minColumn];
        for (int i = 0; i < abc.length; i++) {
            if (abc[i][minColumn] > max) {
                max = abc[i][minColumn];
            }
        }

        System.out.println(max);
    }
}
