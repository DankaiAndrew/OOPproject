import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import cs2030.simulator.Simulator;

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> arrivalTimes = new ArrayList<Double>();

        ArrayList<Double> serveTime = new ArrayList<Double>();

        int numberOfServer = sc.nextInt();

        int numberOfQueue = sc.nextInt();

        while (sc.hasNextDouble()) {
            arrivalTimes.add(sc.nextDouble());
            serveTime.add(sc.nextDouble());
        }
        Simulator s = new Simulator(arrivalTimes, numberOfServer,numberOfQueue,serveTime);
        s.simulate();
    }


}