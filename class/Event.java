package cs2030.simulator;

abstract class Event implements Comparable<Event> {
    private final double time;
    private static final double SMALLNUM = 0.000001;

    public Event(double time) {
        this.time = time;
    } //the time is 

    public double getTime() {
        return this.time;
    }

    abstract String eventType();
    
    abstract int customerId();

    abstract Customer returnCustomer();

    abstract Server returnServer();

    @Override
    public int compareTo(Event e) {
        if (Math.abs(this.getTime() - e.getTime()) < SMALLNUM) {
            return 0;
        } else if (this.getTime() > e.getTime()) {
            return 1;
        } else {
            return -1;
        }
    }
}