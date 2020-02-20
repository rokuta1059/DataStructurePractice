package work2_mazeSearcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * maze를 탐색하는 클래스
 * 위, 아래, 왼쪽, 오른쪽 순서로 길을 탐색하고
 * 길이 존재하지 않을 경우
 * Stack을 활용한 역추적 방식을 이용하여
 * 계속해서 미로를 탐색한다.
 * @author 김우섭
 *
 */
public class Maze {

    char[][] mazeArray;
    Scanner input;
    int x;
    int y;
    LinkedStack<Location> finder;	// 역추적을 위해 탐색 가능한 길을 저장한 LinkedStack
    LinkedStack<Location> start;	// 시작점을 저장한 LinkedStack
    Location end;

    /**
     * 생성자
     * @throws IOException
     */
    public Maze() throws IOException {
        input = new Scanner(new File("src/work2_mazeSearcher/maze.txt"));

        // maze.txt의 첫째 줄에 있는
        // 미로의 크기를 이용하여
        // 미로가 저장될 행렬의 크기를 지정해준다.
        x = input.nextInt();
        y = input.nextInt();
        mazeArray = new char[x][y];

        finder = new LinkedStack<Location>();
        start = new LinkedStack<Location>();
    }

    /**
     * maze.txt파일을 읽어들이고
     * 파일 안에 저장된 미로 텍스트를 읽어들여서
     * mazeArray에 저장한다.
     * @throws IOException
     */
    public void makeMaze() throws IOException {

        // 파일이 잘못 읽히는 문제를 막기 위하여
        // maze.txt를 다시 불러들인다.
        input = new Scanner(new File("src/work2_mazeSearcher/maze.txt"));
        input.nextLine();

        for(int i = 0; i < mazeArray.length; i++) {
            String line = input.nextLine();
            for(int j = 0; j < mazeArray[i].length; j++) {
                mazeArray[i][j] = line.charAt(j);
            }
        }
        // 이후 맵을 읽어들이는 Scanner는 사용하지 않기 때문에
        // 종료를 해준다.
        input.close();

    }

    /**
     * 입력받은 미로가 저장된 행렬에
     * 가장자리의 통로를 제한하기 위해
     * 벽을 새로 생성한 후
     * mazeArray에 저장한다.
     * @param maze 미로가 저장된 행렬
     */
    public void changeWallMaze(char[][] maze) {

        // 양 옆과 위, 아래에 벽이 생성되므로
        // 기존 미로 행렬의 크기보다 2씩 큰 새로운 행렬을 만든다.
        char[][] wallmaze = new char[maze.length + 2][maze[0].length + 2];
        for(int i = 0; i < wallmaze.length; i++) {
            for(int j = 0; j < wallmaze[i].length; j++) {
                // 왼쪽과 오른쪽에 벽을 만들어준다.
                if(i == 0 || i == (wallmaze.length - 1))
                    wallmaze[i][j] = '1';
                    // 맨 위와 아래에 벽을 만들어준다.
                else if(j == 0 || j == (wallmaze[i].length - 1))
                    wallmaze[i][j] = '1';
                    // 그 외의 경우 미로를 다시 넣어준다.
                else
                    wallmaze[i][j] = maze[i-1][j-1];
            }
        }
        // 완성된 미로를 저장해준다.
        mazeArray = wallmaze;
    }

    /**
     * 미로를 출력해준다.
     */
    public void printMaze() {

        for(int i = 0; i < mazeArray.length; i++) {
            for(int j = 0; j < mazeArray[i].length; j++) {
                System.out.print(mazeArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * input.txt 파일을 불러들여
     * 탐색을 시작해야 하는 좌표를 읽어들이고
     * 그 값을 start에 push하여 저장한다.
     * @throws FileNotFoundException
     */
    public void inputStart() throws FileNotFoundException {
        Scanner inputStart = new Scanner(new File("src/work2_mazeSearcher/input.txt"));
        while(inputStart.hasNext()) {
            int x = inputStart.nextInt();
            int y = inputStart.nextInt();
            start.push(new Location(x, y));
        }
        inputStart.close();
    }

    /**
     * 받아들인 좌표값이 길인지 아닌지 여부를 판단한다.
     * @param lo 현재 좌표값
     * @return 길(0)이 존재할 경우 1, 끝(E)이 존재할 경우 0, 그 외의 경우 -1
     */
    public int findroute(Location lo) {

        // lo가 끝(E)이 아니면서 길(0)인 경우
        if(!lo.equals(end)) {
            if(mazeArray[lo.LocationX()][lo.LocationY()] == '0') {
                return 1;
            }
        }
        // lo가 끝(E)인 경우
        else {
            return 0;
        }
        // lo가 끝(E)도, 길(0)도 아닌 경우
        return -1;
    }

    /**
     * mazeArray 안에서 끝(E)를 찾아낸 다음
     * 이를 end에 저장해준다.
     */
    public void findEnd() {
        boolean find = false;
        for(int i = 0; i < mazeArray.length; i++) {
            for(int j = 0; j < mazeArray[i].length; j++) {
                if(mazeArray[i][j] == 'E') {
                    end = new Location(i, j);
                    find = true;
                }
            }
        }
        if(find == false)
            System.out.println("Error: End is not exist");
        else
            System.out.println("End of Maze: " + end);
    }

    /**
     * 입력받은 Location 객체의 좌표를 읽어서
     * 미로의 끝을 탐색한다.
     * @param lo
     * @return 길을 찾아냈을 경우 도착할 때 까지의 루트, 찾아내지 못할 경우 null
     */
    public String finddirection(Location lo) {
        Location now = lo;

        // 현재 위치가 길이 아닌 벽인 경우
        // null값을 바로 반환한다.
        if(findroute(now) == -1)
            return null;

        // 미로의 끝을 찾거나 길을 저장한 Stack이 완전히 소모될 때 까지
        // while 안을 반복해준다.
        while(true) {

            // 현재 위치가 end일 경우
            // mazeArray 내에 지나온 길이 저장되어 있으므로
            // 이를 초기화 시켜주고
            // 도착할 때 까지의 루트를 반환한다.
            if(now.equals(end)) {
                resetMaze();
                finder.reset();
                return now.route();
            }

            // 현재 위치가 end가 아닐 경우
            else {
                // 현재 위치에 '+'를 저장하여
                // 지나온 길을 다시 가면서 무한루프에 빠지지 않게 한다.
                mazeArray[now.LocationX()][now.LocationY()] = '+';

                // 위쪽에 길이 있는지 확인
                Location up = new Location((now.LocationX() - 1),
                        now.LocationY(), now.addRoute("U"));
                if(findroute(up) != -1)
                    finder.push(up);

                // 아래쪽에 길이 있는지 확인
                Location down = new Location((now.LocationX() + 1),
                        now.LocationY(), now.addRoute("D"));
                if(findroute(down) != -1)
                    finder.push(down);

                // 왼쪽에 길이 있는지 확인
                Location left = new Location(now.LocationX(),
                        (now.LocationY() - 1), now.addRoute("L"));
                if(findroute(left) != -1)
                    finder.push(left);

                // 오른쪽에 길이 있는지 확인
                Location right = new Location(now.LocationX(),
                        (now.LocationY() + 1), now.addRoute("R"));
                if(findroute(right) != -1)
                    finder.push(right);

                // finder가 비어있으면 더이상 탐색 가능한 길이 없다는 의미이므로
                // null값을 반환한다.
                if(finder.isEmpty()) {
                    return null;
                }
                // finder에 길이 있으면 pop을 해주어
                // 계속해서 길을 탐색한다.
                else {
                    now = finder.pop();
                }
            }
        }
    }

    /**
     * 미로의 길을 찾아낸 후
     * 결과값을 출력해주는 메소드
     */
    public void mazefinder() {
        // end를 먼저 찾아낸다.
        findEnd();

        // start 좌표가 더이상 존재하지 않을 때 까지 작업을 수행한다.
        while(!start.isEmpty()) {
            Location startPosition = start.pop();
            String endRoute = finddirection(startPosition);

            // 길을 찾았을 경우
            if(endRoute != null) {
                System.out.println(startPosition.toString() + "\tfind End!");
                System.out.println("\t" + endRoute);
            }

            // 길을 찾지 못했을 경우
            else {
                System.out.println(startPosition.toString() +
                        "\tcannot find End!");
                resetMaze();
                finder.reset();
            }
        }
    }

    /**
     * 지도를 처음 상태로 초기화한다.
     */
    public void resetMaze() {

        // 지나온 길의 경우 +로 바뀌어 있기 때문에
        // 이를 전부 길(0)으로 바꾸어준다.
        for(int i = 0; i < mazeArray.length; i++) {
            for(int j = 0; j < mazeArray[i].length; j++) {
                if(mazeArray[i][j] == '+') {
                    mazeArray[i][j] = '0';
                }
            }
        }
    }

}
