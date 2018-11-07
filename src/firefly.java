// -----------------------------------------------
// firefly.java
// Jeremy Campbell
// Computation geometry problem for Applied
// -----------------------------------------------
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class firefly {

    private static class Point {
        double x;
        double y;

        public Point() {}

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class ChaseScenario {

        private int maxDistance;
        private Point chaserLocation;
        private List<Point> fireflyLocations = new LinkedList<>();

        public boolean readChaseScenario(Scanner fin) {
            maxDistance = fin.nextInt();
            if (maxDistance == 0) {
                return false;
            }
            chaserLocation.x = fin.nextInt();
            chaserLocation.y = fin.nextInt();

            Point temp = new Point(fin.nextInt(), fin.nextInt());
            while (temp.x != -1 && temp.y != -1) {
                fireflyLocations.add(temp);
                temp = new Point(fin.nextInt(), fin.nextInt());
            }
            return true;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner("firefly.in");
        PrintWriter fout = new PrintWriter("firefly.out");

        ChaseScenario cs = new ChaseScenario();
        while (cs.readChaseScenario(fin)) {

        }
    }
}