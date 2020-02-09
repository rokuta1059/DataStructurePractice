package day1;

/**
 * 파스칼 삼각형을 만들고 출력한다.
 * 파스칼 삼각형의 구조는 배열을 사용한다.
 */
public class practice1 {

    public static void main(String[] args) {

        // 배열 생성
        // 2차원 배열이지만 사각형 배열이 아닌 불균일 배열
        int[][] array = new int[10][];

        for (int i = 0; i < array.length; i++) {
            // 불균일 배열 생성
            array[i] = new int[i+1];

            for (int j = 0; j < array[i].length; j++) {
                if (j == 0 || j == array[i].length - 1) {
                    // 배열의 첫 번째이거나 맨 끝인 경우 1을 입력
                    array[i][j] = 1;
                } else {
                    // 그 외의 경우 윗 배열의 바로 위와 왼쪽의 값을 더해서 입력
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }
            }
        }

        // 출력
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d\t", array[i][j]);
            }
            System.out.println();
        }

    }
}
