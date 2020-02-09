package day1;

/**
 * 1차원 배열을 2차원 배열로 만든다.
 */
public class practice2 {

    public static final int SIZE = 12;
    public static final int ROWSIZE = 4;
    public static final int COLSIZE = 3;

    // 1차원 배열을 2차원 배열로 변환
    public static void makeTwoDimension(int a[], int[][] twoDimensionArray) {
        int tmp = 0;
        for (int i = 0; i < twoDimensionArray.length; i++) {
            for (int j = 0; j < twoDimensionArray[i].length; j++) {
                twoDimensionArray[i][j] = a[tmp];
                tmp++;
            }
        }
    }

    // 1차원 배열 출력
    public static void printOneDimensionArray(int[] a) {
        System.out.println("One Dimension Array");
        for(int i = 0; i < a.length; i++) {
            System.out.printf("%d\t", a[i]);
        }
        System.out.println();
        System.out.println();
    }

    // 2차원 배열 출력
    public static void printTwoDimension(int[][] twoDimensionArray) {
        System.out.println("Two Dimension Array");
        for (int i = 0; i < twoDimensionArray.length; i++) {
            for (int j = 0; j < twoDimensionArray[i].length; j++) {
                System.out.printf("%d\t", twoDimensionArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }

    // 2차원 배열의 각 행의 최대값을 구하여 1차원 배열 maxArray에 저장
    public static void findMax(int[][] twoDimensionArray, int[] maxArray) {

        for (int i = 0; i < twoDimensionArray.length; i++) {
            int max = 0;
            for (int j = 0; j < twoDimensionArray[i].length; j++) {
                if (max <= twoDimensionArray[i][j]) max = twoDimensionArray[i][j];
            }
            maxArray[i] = max;
        }

    }

    // 2차원 배열과 행과 열의 최대값을 출력
    public static void printTwoDimensionWithMax(int[][] twoDimensionArray, int[] maxArray) {
        System.out.println("Two Dimension Array With Max");
        for (int i = 0; i < twoDimensionArray.length - 1; i++) {
            System.out.print("\t");
        }
        System.out.println("Max");
        for (int i = 0; i < twoDimensionArray.length; i++) {
            for (int j = 0; j < twoDimensionArray[i].length; j++) {
                System.out.printf("%d\t", twoDimensionArray[i][j]);
            }
            System.out.printf("%d\n",maxArray[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] twoArray = new int[ROWSIZE][COLSIZE];
        int[] array = {89, 88, 96, 23, 77, 12, 36, 28, 93, 83, 25, 30};
        int[] maxArray = new int[SIZE];

        printOneDimensionArray(array);
        makeTwoDimension(array, twoArray);
        printTwoDimension(twoArray);
        findMax(twoArray, maxArray);
        printTwoDimensionWithMax(twoArray, maxArray);

    }


}
