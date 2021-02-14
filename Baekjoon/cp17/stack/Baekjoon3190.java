package cp17.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon3190 {
    
    private static final String BLANK = " ";
    private static final String RIGHT_DIRECTION = "D";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static boolean[][] appleLocation;
    private static boolean[][] snakeLocation;
    
    private static int passedTime = 0;
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        setApple(n);
        
        snakeLocation = new boolean[n + 1][n + 1];
        snakeLocation[1][1] = true;
        
        Snake snake = new Snake();
        snake.move();
        System.out.println(passedTime);
    }
    
    private static void setApple(int n) throws IOException {
        appleLocation = new boolean[n + 1][n + 1];
        
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] appleLocations = br.readLine()
                                        .split(BLANK);
            
            int appleX = Integer.parseInt(appleLocations[0]);
            int appleY = Integer.parseInt(appleLocations[1]);
            
            appleLocation[appleX][appleY] = true;
        }
    }
    
    private static class Snake {
        Point point;
        int direction;
        
        List<Integer> times;
        List<String> directions;
        
        public Snake() throws IOException {
            direction = 1;
            point = new Point(1, 1);
            setTimeAndDirection();
        }
        
        public void move() {
            
            outLoop:
            for (int i = 0; i < times.size(); i++) {
                int time = times.get(i);
                for (int j = 0; j < time; j++) {
                    passedTime++;
                    
                    point.move(direction);
                    
                    if (point.isEnd()) {
                        break outLoop;
                    }
                    
                    point.eatApple();
                }
                
                if (i != times.size() - 1) {
                    changeDirection(directions.get(i));
                }
            }
        }
        
        private void setTimeAndDirection() throws IOException {
            times = new ArrayList<>();
            directions = new ArrayList<>();
            
            int l = Integer.parseInt(br.readLine());
            for (int i = 0, time = 0; i < l; i++) {
                String[] secondAndDirect = br.readLine()
                                             .split(BLANK);
                
                int second = Integer.parseInt(secondAndDirect[0]) - time;
                times.add(second);
                time += second;
                
                directions.add(secondAndDirect[1]);
            }
            
            times.add(10000);
        }
        
        private void changeDirection(String changeTo) {
            if (changeTo.equals(RIGHT_DIRECTION)) {
                direction = (direction == 3) ? 0 : direction + 1;
            } else {
                direction = (direction == 0) ? 3 : direction - 1;
            }
        }
    }
    
    private static class Point {
        
        private static final Queue<Point> POINT_QUEUE = new LinkedList<>();
        private static final int[] VALUE_TO_ADD_ROW_LOCATION = {-1, 0, 1, 0};
        private static final int[] VALUE_TO_ADD_COLUMN_LOCATION = {0, 1, 0, -1};

        static {
            POINT_QUEUE.add(new Point(1, 1));
        }
        
        int x;
        int y;
        
        public Point(Point point) {
            this(point.x, point.y);
        }
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public void move(int direction) {
            x += VALUE_TO_ADD_ROW_LOCATION[direction];
            y += VALUE_TO_ADD_COLUMN_LOCATION[direction];
        }
        
        private void eatApple() {
            if (!appleLocation[x][y]) {
                Point tailPoint = POINT_QUEUE.poll();
                snakeLocation[tailPoint.x][tailPoint.y] = false;
            }
            
            appleLocation[x][y] = false;
            snakeLocation[x][y] = true;
            POINT_QUEUE.add(new Point(this));
        }
        
        public boolean isEnd() {
            return touchWall() || existsBody();
        }
        
        private boolean touchWall() {
            return x < 1 || x == appleLocation.length || y < 1 || y == appleLocation.length;
        }
        
        private boolean existsBody() {
            return snakeLocation[x][y];
        }
    }
}
