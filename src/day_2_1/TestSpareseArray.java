package day_2_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 희소 배열을 테스트하는 클래스
 */
public class TestSpareseArray {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("src/" +
                "day_2_1/input.txt"));
        int size, index, value;
        size = inFile.nextInt();

        // 리스트 생성
        SparseArray sa = new SparseArray(size);

        // 파일을 읽고 리스트에 추가한다
        while (inFile.hasNextInt()) {
            index = inFile.nextInt();
            value = inFile.nextInt();
            sa.set(index, value);
        }
        sa.print();
        inFile.close();

    }

}
