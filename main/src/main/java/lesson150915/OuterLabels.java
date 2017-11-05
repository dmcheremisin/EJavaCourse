package lesson150915;

/**
 * Created by dmitr on 09.08.2017.
 */
public class OuterLabels {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
        };

        OUTER: for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                if(matrix[i][j] >= 5)
                    continue OUTER;
            }
            System.out.println();
        }
    }
}
