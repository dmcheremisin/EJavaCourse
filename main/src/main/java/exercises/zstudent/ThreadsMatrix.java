package exercises.zstudent;


import java.util.Random;

/**
 * Created by dmitr on 02.10.2017.
 */
public class ThreadsMatrix {
    public static void main(String[] args) {

        long startgen = System.nanoTime();
        double[][] matrix = generate();
        long stopgen = System.nanoTime();
        System.out.println("Generation = " + (stopgen - startgen));

        long start = System.nanoTime();
        process(matrix);
        long stop = System.nanoTime();

        System.out.println("Elapsed = " + (stop - start));
    }

    private static void process(double[][] matrix) {
        Thread[] threads = new Thread[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            double[] row = matrix[i];
            threads[i] = new Thread() {
                @Override
                public void run() {
                    processRow(row);
                }
            };
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void processRow(double[] ds) {
        for (int i = 0; i < ds.length; i++) {
            Math.pow(ds[i], ds[i]);
        }
    }

    private static double[][] generate() {
        Random random = new Random();
        double[][] matrix = new double[10][8_000_000];
        Thread[] threads = new Thread[matrix.length];
        for (int i=0; i < matrix.length; i++) {
            double[] row = matrix[i];
            threads[i] = new Thread() {
                @Override
                public void run() {
                    generateRow(row, random);
                }
            };
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return matrix;
    }

    private static void generateRow(double[] matrixI, Random random) {
        for (int j = 0; j < matrixI.length; j++) {
            matrixI[j] = random.nextDouble();
        }
    }
}
