
import java.util.Random;

/**
 *
 * @author trangluong
 */
public class GenericMaze {

    private char[][] maze;
    private int size;
    private char wall;
    private char path;
    private Random r;
    static int num;
    static int num2;

    public GenericMaze(int size, char wall, char path) {
        this.size = size;
        this.wall = wall;
        this.path = path;
        this.maze = new char[this.size][this.size];

    }

    public GenericMaze() {
        this.size = 0;
        this.wall = ' ';
        this.path = ' ';
        this.maze = new char[0][0];

    }

    public void createMaze() {
        r = new Random();
        Random r1 = new Random();
        num = r1.nextInt(this.size - 1);
        num2 = r1.nextInt(this.size - 1);

        for (int j = 0; j < this.size; j++) {
            this.maze[0][j] = this.wall;

        }
        for (int i = 0; i < this.size; i++) {
            this.maze[this.size - 1][i] = this.wall;

        }

        for (int i = 0; i < this.size; i++) {
            this.maze[i][this.size - 1] = this.wall;

        }
        for (int j = 0; j < this.size; j++) {
            this.maze[this.size - 1][j] = this.wall;
        }
        for (int j = 0; j < this.size; j++) {
            this.maze[j][0] = this.wall;
        }
        this.maze[num2][0] = this.path;//in
        this.maze[num][this.size - 1] = this.path;//out

        for (int i = 1; i < this.size - 1; i++) {
            for (int j = 1; j < this.size - 1; j++) {
                if (r.nextInt(100) < 28) {
                    this.maze[i][j] = this.wall;
                } else {
                    this.maze[i][j] = this.path;
                }
            }
        }

    }

    public void printMaze() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {

                System.out.print(this.maze[i][j] + "\t");

            }
            System.out.println();
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public int getStart() {
        return num2;
    }

    public int getEnd() {

        return num;

    }

    public void setPosition(int x, int y) {
        this.maze[x][y] = ('x');
    }

    public void setDeadEnd(int x, int y) {
        this.maze[x][y] = 'o';
    }

    public void mazeTraversal(int x, int y) {
        setPosition(x, y);
        printMaze();
        if (x == getEnd() && y == this.size - 1) {
            setPosition(x, y);

        } else {

            if ((x < this.size - 1) && maze[x + 1][y] == this.path) {
                mazeTraversal(x + 1, y);
                setPosition(x + 1, y);


            } else if ((y < this.size - 1) && (maze[x][y + 1] == this.path)) {
                mazeTraversal(x, y + 1);
                setPosition(x, y + 1);

            } else if ((x > 0) && (maze[x - 1][y] == this.path)) {
                mazeTraversal(x - 1, y);
                setPosition(x - 1, y);

            } else if ((y > 0) && maze[x][y - 1] == this.path) {
                mazeTraversal(x, y - 1);
                setPosition(x, y - 1);

            } else {
                setDeadEnd(x, y);
                if ((x < this.size - 1) && maze[x + 1][y] == this.path
                        || (y < this.size - 1) && (maze[x][y + 1] == this.path)
                        || (x > 0) && (maze[x - 1][y] == this.path)
                        || (y > 0) && (maze[x][y - 1] == this.path)) {
                    mazeTraversal( x, y);
                }else{
                    if ((x < this.size - 1) && maze[x + 1][y] == 'x') {
                        mazeTraversal(x + 1, y);
                        setPosition(x + 1, y);


                    } else if ((y < this.size - 1) && (maze[x][y + 1] == 'x')) {
                        mazeTraversal(x, y + 1);
                        setPosition(x, y + 1);

                    } else if ((x > 0) && (maze[x - 1][y] == 'x')) {
                        mazeTraversal(x - 1, y);
                        setPosition(x - 1, y);

                    } else if ((y > 0) && maze[x][y - 1] == 'x') {
                        mazeTraversal(x, y - 1);
                        setPosition(x, y - 1);

                    }

                }

            }

        }
       
    }
    public void checkCompete(){
        if(this.maze[num][this.size-1]=='.'){
           System.out.println("Maze can't be complete");
       }
       else
            System.out.println("Maze complete!");
    }
}
