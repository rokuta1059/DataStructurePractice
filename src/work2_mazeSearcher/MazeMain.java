package work2_mazeSearcher;

import java.io.IOException;

/**
 * 메인 메소드가 포함된 클래스
 * 프로그램의 작동과 테스트를 담당한다.
 * @author 김우섭
 *
 */
public class MazeMain {

    public static void main(String[] args) throws IOException {

        Maze maze = new Maze();
        maze.makeMaze();
        System.out.println("Input Maze: ");
        maze.printMaze();

        maze.changeWallMaze(maze.mazeArray);
        System.out.println("Walled Maze: ");
        maze.printMaze();

        maze.inputStart();
        maze.mazefinder();

    }

}
