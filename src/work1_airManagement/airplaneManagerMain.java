package work1_airManagement;

/**
 * airplaneManager의 메인 메소드가 있는 클래스
 * 프로그램의 실행과 테스트는 메인 메소드 안에서 수행된다.
 *
 */
public class airplaneManagerMain {

    public static void main(String[] args) {

        airplaneManager app = new airplaneManager();

        int progressFinish = 0;
        do {
            progressFinish = app.airplaneMenu();
        } while(progressFinish != -1);

        System.out.println("End of commends!");
        app.close();


    }

}
