// -----------------------------------------------
// firefly.java
// Jeremy Campbell
// Computation geometry problem for Applied
// -----------------------------------------------
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.lang.Double;

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
            return "(" + this.x.intValue() + "," + this.y.intValue() + ")";
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
            // TODO: Finish this function using the distance and slope formulas
            for (Point p : fireflyLocations) {
                double distance = distanceToFirefly(p);
                if (distance <= (maxDistance + 1)) {
                    // Firefly will be caught
                    return p;
                } else {
                    // Firefly will not be caught, chaser teleports closer
                    chaserLocation.x = buildClosestPoint(distance, chaserLocation.x, p.x);
                    chaserLocation.y = buildClosestPoint(distance, chaserLocation.y, p.y);
                }
            }
            // Firefly was never caught
            return null;
        }

        private double distanceToFirefly(Point p) {
            return Math.sqrt(Math.pow(p.x - chaserLocation.x, 2)
                            + Math.pow(p.y - chaserLocation.y, 2));
        }

        private double buildClosestPoint(double d, double c, double f) {
            return ((maxDistance * (f - c)) / d) + c;
        }

        public void reset() {
            fireflyLocations.clear();
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new File("firefly.in"));
        PrintWriter fout = new PrintWriter("firefly.out");

        ChaseScenario cs = new ChaseScenario();
        double maxDistance = fin.nextDouble();
        int fireflyNum = 1;

        while (maxDistance != 0) {
            cs.readChaseScenario(fin, maxDistance);
            Point captureLocation = cs.catchFirefly();

            if (captureLocation != null)
                fout.print("Firefly " + fireflyNum + " caught at " + captureLocation.toString());
            else
                fout.print("Firefly " + fireflyNum + " not caught");

            cs.reset();
            fireflyNum++;

            // Print the endline if there is another scenario
            maxDistance = fin.nextDouble();
            if (maxDistance != 0)
                fout.println();
        }

        fin.close();
        fout.close();
    }
}