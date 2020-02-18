package work1_airManagement;

import java.util.Scanner;

/**
 * 항공권 예약 프로그램
 *
 * 비행기 좌석을 예약하고 취소, 검색이 가능한 프로그램
 * Seat객체를 활용하여 프로그램이 작동한다.
 *
 */
public class airplaneManager {

    public String[][] seatArray;
    public Scanner input;
    public Seat seat;

    /**
     * 구성자
     * 좌석의 이름이 저장된 행렬을 만들고
     * Scanner 객체를 생성한다
     */
    public airplaneManager() {
        seatArray = new String[5][4];
        for(int i = 0; i < seatArray.length; i++) {
            for(int j = 0; j < seatArray[i].length; j++) {
                String seatName = (char)(i + 49) + "" + (char)(j + 65);
                seatArray[i][j] = seatName;
            }
        }
        input = new Scanner(System.in);
    }

    /**
     * 현재 좌석의 상태를 출력한다
     * 고객이 예약한 좌석은 *를
     * 그렇지 않은 좌석은 열의 값에 맞는 알파벳을 출력한다.
     */
    public void printLayout() {
        System.out.println("\nSeat Layout");
        System.out.println("------------");
        for(int i = 0; i < seatArray.length; i++) {
            System.out.print((i + 1) + " ");				// 좌석 행의 번호를 먼저 출력
            for(int j = 0; j < seatArray[i].length; j++) {
                if(findSeat(seatArray[i][j]) == null) 		// 고객이 예약되지 않은 좌석
                    System.out.print((char)(65 + j) + " ");
                else										// 고객이 예약한 좌석
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 고객의 이름과 예약좌석을 입력받고
     * 값을 Seat에 저장한다
     * @return 정상적으로 예약되었을 경우 true, 그렇지 않은 경우 false
     */
    private boolean setCustomer() {

        int row;
        int col;

        printLayout();

        System.out.print(">Enter a customer name and desired seat number: ");
        String customerName = input.next();
        String customerSeat = input.next();

        // 좌석이 소문자로 입력된 경우 대문자로 바꾸어준다
        customerSeat = customerSeat.toUpperCase();

        // 입력된 좌석이 유효한 값인지 확인한다
        // 현재 좌석은 반드시 2글자로 존재하므로 2글자인지 확인
        if(customerSeat.length() == 2) {

            try {	// 1번째 글자가 숫자가 맞는지 판단한다
                Integer.parseInt(customerSeat.substring(0,1));
            } catch (NumberFormatException e) {
                System.out.println("Wrong seat number!");
                return false;
            }

            // 행과 열의 값을 Integer형으로 바꾸어준다
            row = Integer.parseInt(customerSeat.substring(0, 1)) - 1;
            col = customerSeat.substring(1, 2).charAt(0) - 65;

            // 고객의 이름이 이미 존재하는 경우
            if(findCustomer(customerName) != null) {
                System.out.println("That name is already exists!");
                return false;
            }

            // 행의 값이 존재하지 않는 값일 경우
            if (row > seatArray.length ||
                    row < 0) {
                System.out.println("Wrong seat number!");
                return false;
            }

            // 열의 값이 존재하지 않는 값일 경우
            if (col < 0 ||
                    col > seatArray[seatArray.length - 1].length) {
                System.out.println("Wrong seat number!");
                return false;
            }

            // 좌석 배정이 이미 되어있는 경우
            if (findSeat(customerSeat) != null) {
                System.out.println("That seat is already exists!");
                return false;
            }

            // 모든 경우의 수를 만족하면 좌석을 저장한다.
            Seat customer = new Seat(customerName, customerSeat);
            addCustomer(customer);
            return true;
        }

        return false;
    }

    /**
     * 고객의 이름을 입력받고
     * 고객의 배열에서 같은 이름이 존재하는지 확인한다.
     * @param name 찾아낼 고객의 이름
     * @return 같은 이름의 고객이 존재하는 경우 고객의 Seat, 존재하지 않는 경우 null
     */
    private Seat findCustomer(String name) {
        Seat find = seat;
        while(find != null) {
            if(find.name.equals(name))
                return find;
            find = find.next;
        }
        return null;
    }

    /**
     * 고객의 좌석을 입력받고
     * 입력받은 좌석이 이미 예약된 좌석인지 고객의 배열에서 확인한다.
     * @param seatName 찾아낼 고객의 좌석
     * @return 이미 예약된 좌석일 경우 좌석의 Seat, 예약되지 않은 경우 null
     */
    private Seat findSeat(String seatName) {
        Seat find = seat;
        while(find != null) {
            if(find.seat.equals(seatName))
                return find;
            find = find.next;
        }
        return null;
    }

    /**
     * 고객의 정보를 고객이 저장된 배열에 추가한다.
     * 이름순으로 저장하여 효율적으로 배열을 관리하도록 한다.
     * @param newSeat 저장할 고객 정보
     */
    private void addCustomer(Seat newSeat) {
        if(seat == null)
            seat = newSeat;
        else {
            Seat front = null;
            Seat back = seat;

            // 이름순으로 정렬하기 위해 검색한다
            while(back != null) {
                if(back.name.compareTo(newSeat.name) < 0) {
                    front = back;
                    back = back.next;
                }
                else
                    break;
            }
            // 맨 앞에 저장되는 경우
            if(front == null) {
                seat = newSeat;
                newSeat.next = back;
            }
            // 맨 뒤에 저장되는 경우
            else if(back == null) {
                front.next = newSeat;
            }
            // 중간에 저장되는 경우
            else {
                front.next = newSeat;
                newSeat.next = back;
            }
        }

    }

    /**
     * 고객의 이름을 입력받고 예약정보를 확인하여
     * 예약이 되어있는 경우 예약을 취소하고
     * 좌석정보와 고객 정보를 삭제한다.
     * @return 예약이 정상적으로 취소될 경우 true, 그렇지 않은 경우 false
     */
    private boolean doCancel() {
        System.out.print("> Enter a customer name: ");
        Seat find = seat;
        String name = input.next();
        Seat front = null;
        Seat back;

        while(find != null) {
            if(find.name.equals(name))
                break;
            front = find;
            // 배열의 맨 끝까지 탐색 후에도 고객의 이름을 찾지 못하면
            // 그 즉시 false를 반환한다
            if (find.next == null) {
                System.out.println("No such customer: " + name);
                return false;
            }
            find = find.next;
        }
        // 배열 중간의 고객을 삭제할 경우를 위해
        // 삭제될 고객의 바로 다음 고객을 임시로 저장해둔다
        back = find.next;

        // 배열의 맨 앞의 고객이 삭제될 경우
        if(front == null) {
            seat = back;
            find = null;
        }

        // 그 외의 경우
        else {
            front.next = back;
            find = null;
        }

        System.out.println("Customer name: " + name + ", reservation canceled");
        return true;
    }

    /**
     * 고객의 이름을 입력받고 예약이 되어있는 이름인지 확인한 후
     * 예약이 되어있을 경우 좌석과 함께 정보를 출력한다
     * @return 정상적으로 이름과 예약좌석이 출력될 경우 true, 그렇지 않은 경우 false
     */
    private boolean doFind() {
        Seat find;

        System.out.print("> Enter a customer name: ");
        String name = input.next();
        find = findCustomer(name);
        // 예약된 고객의 이름을 찾을 경우 바로 출력하고 true를 반환한다.
        if(find != null) {
            System.out.println("Seat Number: " + find.seat);
            return true;
        }
        System.out.println("No such customer: " + name);
        return false;
    }

    /**
     * 현재 좌석 현황을 행렬을 이용한 표를 통해 보여주고
     * 예약자의 명단을 이름순으로 나열하여 좌석과 함께 출력한다.
     */
    private void printReservation() {
        System.out.println("Reservation information");
        System.out.println("Name\t\tSeat number");
        System.out.println("----\t\t-----------");

        // seat에 이미 사전순으로 정렬을 해놓았으므로
        // 이를 불러들여 순서대로 출력한다
        Seat find = seat;
        while(find != null) {
            System.out.println(find.name + "\t\t" + find.seat);
            find = find.next;
        }

        // 먼저 총 좌석의 수를 구하고
        // 예약된 수 만큼 총 좌석의 수에서 차감해준다
        int count = seatArray.length * seatArray[seatArray.length - 1].length;
        for(int i = 0; i < seatArray.length; i++) {
            for(int j = 0; j < seatArray[i].length; j++) {
                if(findSeat(seatArray[i][j]) != null) {
                    count--;
                }
            }
        }
        System.out.println();
        System.out.println("Available number of seats: " + count);
    }

    /**
     * 메뉴를 호출하고
     * 사용자가 입력한 값에 따라 작업을 시행한다.
     * @return 정상적으로 완료될 시 0, 오류로 인해 종료될 시 1, 프로그램 종료시 -1
     */
    public int airplaneMenu() {
        System.out.print("> Enter a commend: (r)eserve, (c)ancel, (f)ind, (p)rint, or (q)uit: ");
        String commend = input.next();

        switch(commend) {
            case "r":	// 예약 커맨드
                if(setCustomer())
                    return 0;
                else
                    return 1;
            case "c":	// 취소 커맨드
                if(doCancel())
                    return 0;
                else
                    return 1;
            case "f":	// 이름검색 커맨드
                if(doFind())
                    return 0;
                else
                    return 1;
            case "p":	// 좌석과 예약현황 출력 커맨드
                printLayout();
                printReservation();
                return 0;
            case "q":	// 종료 커맨드
                return -1;
            default:
                return 1;
        }

    }

    /**
     * 생성자에서 선언한 스캐너 객체를 종료하는 메소드
     * 종료 직전에 사용한다
     */
    public void close() {
        input.close();
    }


}
