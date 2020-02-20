package work2_mazeSearcher;

/**
 * 미로의 위치와 루트를 저장하는 클래스
 * 행의 값과 열의 값을 저장하면서
 * 지금까지 지나온 길 또한 저장한다.
 *
 */
public class Location {

    private int x;
    private int y;
    private String route;

    /**
     * 생성자
     * @param x 행의 값
     * @param y 열의 값
     * @param route 지금까지 지나온 루트
     */
    public Location (int x, int y, String route) {
        this.x = x;
        this.y = y;
        this.route = route;
    }

    /**
     * 생성자
     * @param x 행의 값
     * @param y 열의 값
     */
    public Location (int x, int y) {
        this(x, y, " ");
    }

    /**
     * 행의 값을 반환한다.
     * @return 행의 값 x
     */
    public int LocationX() {
        return x;
    }

    /**
     * 열의 값을 반환한다.
     * @return 열의 값 y
     */
    public int LocationY() {
        return y;
    }

    /**
     * 지금까지 온 루트를 저장한다.
     * @param newRoute 현재 위치에 오기위해 탐색한 방향
     * 		(U)P, (D)own, (L)eft, (R)ight 중 한 값이 입력된다.
     * @return 지금까지 탐색한 방향
     */
    public String addRoute(String newRoute) {
        StringBuilder sb = new StringBuilder();
        sb.append(route);
        sb.append(newRoute);
        return sb.toString();
    }

    /**
     * 현재 위치와 입력받은 위치가 같은지 확인한다.
     * @param another 입력받은 위치
     * @return 행의 값과 열의 값이 둘 다 일치할 경우 true,
     * 	하나라도 다를 경우 false
     */
    public boolean equals(Location another) {
        return ((x == another.x) && (y == another.y));
    }

    /**
     * 행과 열의 값을 출력한다.
     */
    public String toString() {
        return x + ", " + y;
    }

    /**
     * 지금까지 지나온 루트를 반환한다.
     * @return 지금까지 지나온 루트
     */
    public String route() {
        return route;
    }
}
