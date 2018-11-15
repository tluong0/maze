
import java.util.Random;



/**
 *
 * @author trangluong
 */
public class main {
    public static void main(String args[]){
        
       
        
        GenericMaze maze = new GenericMaze(5, '#','.');
        maze.createMaze();
//        maze.printMaze();
        System.out.println("Start");
        maze.mazeTraversal(maze.getStart(), 0);
        maze.checkCompete();
        System.out.println("Done");
    }
}
