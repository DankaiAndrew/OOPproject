import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import cs2030.simulator.Simulator;

class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> arrivalTimes = new ArrayList<Double>();

        ArrayList<Double> serveTime = new ArrayList<Double>();

        ArrayList<Double> breakTime = new ArrayList<Double>();

        int numberOfServer = sc.nextInt();

        int numberOfSelfCounter = sc.nextInt();

        int numberOfQueue = sc.nextInt();

        int numOfCustomer = sc.nextInt();

        for (int i = 0;i < numOfCustomer;i++) {
            arrivalTimes.add(sc.nextDouble());
            serveTime.add(sc.nextDouble());
        }
        for (int i = 0;i < numOfCustomer;i++) {
            breakTime.add(sc.nextDouble());
        }
        Simulator s = new Simulator(arrivalTimes, numberOfServer,numberOfQueue,
                serveTime,breakTime,numberOfSelfCounter);
        s.simulate();
    }


}