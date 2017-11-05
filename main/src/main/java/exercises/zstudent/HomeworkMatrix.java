package exercises.zstudent;

/**
 * Created by dmitr on 09.08.2017.
 */
public class HomeworkMatrix {

    static int size = 7;
    static int[][] matrix = new int[size][size];

    public static void main(String[] args) {
        populateMatrix();
        printMatrix();
    }

    private static void printMatrix() {
        int middleV = matrix.length/2;
        int middleH = matrix[middleV].length/2;
        boolean odd = matrix.length%2 == 0;
        for (int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++) {
                if (i == middleV || (odd && i == middleV-1)){
                    System.out.print(matrix[i][j] + " ");
                } else if(j == middleH || (odd && j == middleH-1)) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("00 ");
                }

            }
            System.out.println();
        }
    }

    private static void populateMatrix() {
        int k = 9;
        for (int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = ++k;
            }
        }
    }
}
