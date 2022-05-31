package cs2030.simulator;

import java.util.ArrayList;

class Customer implements Comparable<Customer> {
    private final int[] customerStatus;
    private final int customerId;
    private final ArrayList<Double> arrivalTime;
    private final double[] serveTime;
    private final double[] beServedTime;
    private final boolean[] ifGreedy;

    Customer(int iD,double arriveTime,double serveTime) {
        this.customerId = iD;
        this.customerStatus = new int[1];
        this.customerStatus[0] = 0;// 0 denotes arrival 1 served 2 waits 3 leaves 4 done
        this.arrivalTime = new ArrayList<>();
        this.arrivalTime.add(arriveTime);
        this.serveTime = new double[1];
        this.serveTime[0] = serveTime;
        this.beServedTime = new double[1];
        this.beServedTime[0] = arriveTime;
        this.ifGreedy = new boolean[1];
        this.ifGreedy[0] = false;
    }

    Customer(int customerId,int customerStatus,double arriveTime,double serveTime) {
        this.customerId = customerId;
        this.customerStatus = new int[1];
        this.customerStatus[0] = customerStatus;
        this.arrivalTime = new ArrayList<>();
        this.arrivalTime.add(arriveTime);
        this.serveTime = new double[1];
        this.serveTime[0] = serveTime;
        this.beServedTime = new double[1];
        this.beServedTime[0] = arriveTime;
        this.ifGreedy = new boolean[1];
        this.ifGreedy[0] = false;
    }

    public boolean getGreedy() {
        return this.ifGreedy[0];
    }

    public void setGreedy() {
        this.ifGreedy[0] = true;
    }

    public void setNormal() {
        this.ifGreedy[0] = false;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getArrivalTime() {
        return this.arrivalTime.get(0);
    }

    public double getServeTime() {
        return this.serveTime[0];
    }

    public void setServeTime(double serveTime) {
        this.serveTime[0] = serveTime;
    }

    public double getBeServedTime() {
        return this.beServedTime[0];
    }

    void setBeServedTime(double time) {
        this.beServedTime[0] = time;
    }

    @Override
    public boolean equals(Object obj) {
        Customer customer = (Customer) obj;

        return this.customerId == customer.getCustomerId();
    }

    @Override
    public int compareTo(Customer customer) {
        return this.customerId - customer.getCustomerId();
    }

    @Override
    public String toString() {
        return Integer.toString(this.customerId);
    }

}