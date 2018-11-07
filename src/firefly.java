// -----------------------------------------------
// firefly.java
// Jeremy Campbell
// Computation geometry problem for Applied
// -----------------------------------------------
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class firefly {

    private static class Point {
        double x;
        double y;
    }

    private static class ChaseScenario {

        private int maxDistance;

        public boolean readChaseScenario(Scanner fin) {
            maxDistance = fin.nextInt();
            if (maxDistance == 0) {
                return false;
            } else {

            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner("firefly.in");
        PrintWriter fout = new PrintWriter("firefly.out");

        ChaseScenario cs = new ChaseScenario();
        while (cs.readChaseScenario(fin) != false) {

        }
    }
}