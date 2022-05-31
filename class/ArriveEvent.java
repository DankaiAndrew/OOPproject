package cs2030.simulator;

class ArriveEvent extends Event {
    private final Customer customer;
    
    ArriveEvent(Customer customer) {
        super(customer.getArrivalTime());
        this.customer = customer;
    }

    Customer returnCustomer() {
        return this.customer;
    }

    Server returnServer() {
        return new Server(-1);
    }
    
    String eventType() {
        return "Arrive";
    }

    int customerId() {
        return this.customer.getCustomerId();
    }

    @Override
    public String toString() {
        if (customer.getGreedy()) {
            return String.format("%.3f %s(greedy) arrives", this.customer.getArrivalTime(),
                    this.customer.getCustomerId());
        }
        return String.format("%.3f %s arrives", this.customer.getArrivalTime(),
                this.customer.getCustomerId());
    }
    
    
}