// -----------------------------------------------
// firefly.java
// Jeremy Campbell
// Computation geometry problem for Applied
// -----------------------------------------------
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class firefly {

    private static class Point {
        Double x;
        Double y;

        public Point() {}

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x.toString() + this.y.toString() + ")";
        }
    }

    private static class ChaseScenario {

        private double maxDistance;
        private Point chaserLocation = new Point();
        private List<Point> fireflyLocations = new LinkedList<>();

        public void readChaseScenario(Scanner fin, double max) {
            maxDistance = max;
            chaserLocation.x = fin.nextDouble();
            chaserLocation.y = fin.nextDouble();

            Point temp = new Point(fin.nextDouble(), fin.nextDouble());
            while (temp.x != -1 && temp.y != -1) {
                fireflyLocations.add(temp);
                temp = new Point(fin.nextDouble(), fin.nextDouble());
            }
        }

        public Point catchFirefly() {
            // TODO: Finish this function using the distance and slope formula's

            return new Point(-1, -1);
        }

        public void reset() {
            fireflyLocations.clear();
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner("firefly.in");
        PrintWriter fout = new PrintWriter("firefly.out");

        ChaseScenario cs = new ChaseScenario();
        double maxDistance = fin.nextDouble();
        while (maxDistance != 0) {
            cs.readChaseScenario(fin, maxDistance);
            Point captureLocation = cs.catchFirefly();
            fout.print(captureLocation.toString());
            cs.reset();

            // Print the endline is there is another scenario
            maxDistance = fin.nextDouble();
            if (maxDistance != 0)
                fout.println();
        }

        fin.close();
        fout.close();
    }
}