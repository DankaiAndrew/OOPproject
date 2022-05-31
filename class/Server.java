package cs2030.simulator;

import java.util.ArrayList;

class Server {
    private final int id;
    private final int queueCapacity;
    private final double[] nextServeAt;
    private final int[] waitingNum;
    private final ArrayList<Double> waitingTime;
    private final ArrayList<Customer> queueList;
    private final boolean[] isRest;
    private final double[] restBackTime;
    
    Server(int id) {
        this.id = id;
        this.queueCapacity = 1;
        this.nextServeAt = new double[1];
        this.waitingNum = new int[1];
        this.waitingTime = new ArrayList<>();
        this.queueList = new ArrayList<>();
        this.waitingNum[0] = 0;
        this.nextServeAt[0] = 0.0;
        this.isRest = new boolean[1];
        this.isRest[0] = false;
        this.restBackTime = new double[1];
        this.restBackTime[0] = 0.0;
    }

    Server(int id,int queueCapacity) {
        this.id = id;
        this.queueCapacity = queueCapacity;
        this.nextServeAt = new double[1];
        this.waitingNum = new int[1];
        this.waitingTime = new ArrayList<>();
        this.queueList = new ArrayList<>();
        this.waitingNum[0] = 0;
        this.nextServeAt[0] = 0.0;
        this.isRest = new boolean[1];
        this.isRest[0] = false;
        this.restBackTime = new double[1];
        this.restBackTime[0] = 0.0;
    }


    public int getId() {
        return this.id;
    }

    public double getWaitingTime() {
        double time = 0.0;
        for (int i = 0;i < this.waitingTime.size();i++) {
            time += this.waitingTime.get(i);
        }
        return time;
    }

    public boolean ifRest() {
        return this.isRest[0];
    }

    public void setRest() {
        this.isRest[0] = true;
    }

    public void setRestBack() {
        this.isRest[0] = false;
    }

    public void setRestBackTime(double time) {
        this.restBackTime[0] = time;
    }

    public double getRestBackTime() {
        return this.restBackTime[0];
    }

    public double nextServeTime() {
        return this.nextServeAt[0];
    }

    public void setNextServeTime(double serveTime) {
        this.nextServeAt[0] = this.nextServeAt[0] + serveTime;
    }

    public void setNextServeTime(double arrivalTime,double serveTime) {
        this.nextServeAt[0] = arrivalTime + serveTime;
    }

    public boolean hasWaitingCustomer() {
        return this.waitingNum[0] == 0;
    }

    public void increaseWaitingCustomer() {
        this.waitingNum[0] += 1;
    }

    public void removeWaitingCustomer() {
        this.waitingNum[0] -= 1;
    }

    public boolean reachMaxCapacity() {
        return this.waitingNum[0] >= this.queueCapacity;
    }

    public int canServe(Customer customer) {
        if (this.queueList.size() == 0 && this.nextServeTime() <= customer.getArrivalTime()) {
            return 1;
        } else if (! this.reachMaxCapacity()) {
            return 0;
        } else {
            return -1;
        }

    }
    
    void updateQueue(double restTime) {
        for (int i = 0;i < queueList.size();i++) {
            this.queueList.get(i).setBeServedTime(restTime +
                    this.queueList.get(i).getBeServedTime());
            this.waitingTime.add(restTime);
        }
    }

    public void addWaitingTime(double breakTime) {
        this.waitingTime.add(breakTime);
    }
    
    public boolean canDequeue() {
        return this.queueList.size() > 0;
    }
    
    public Customer dequeue() {
        Customer customer = this.queueList.get(0);
        this.queueList.remove(0);
        this.removeWaitingCustomer();
        this.waitingTime.add(this.nextServeTime() - customer.getArrivalTime());
        customer.setBeServedTime(this.nextServeTime());
        return customer;
    }

    public int queueListSize() {
        return this.queueList.size();
    }

    public void addQueue(Customer customer) {
        this.increaseWaitingCustomer();
        this.queueList.add(customer);
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }


}