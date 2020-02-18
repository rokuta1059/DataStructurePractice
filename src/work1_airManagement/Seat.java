package work1_airManagement;

/**
 * 좌석을 저장하는 단일 연결 리스트
 * 고객의 이름과 좌석을 저장한다.
 *
 */
class Seat {

    public String name;
    public String seat;
    public Seat next;

    /**
     * 구성자
     * @param name 이름
     * @param seat 좌석번호
     * @param next 다음 Seat 객체
     */
    public Seat(String name, String seat, Seat next) {

        this.name = name;
        this.seat = seat;
        this.next = next;
    }

    /**
     * 구성자
     * @param name 이름
     * @param seat 좌석 번호
     */
    public Seat(String name, String seat) {

        this(name, seat, null);
    }

    /**
     * Seat가 직접 print되는 경우
     * 좌석 번호를 출력한다.
     */
    public String toString() {
        return seat;
    }

}
