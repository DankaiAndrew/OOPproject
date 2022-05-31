package cs2030.simulator;

class WaitEvent extends Event {
    private final Customer customer;
    private final int serverId;
    private final Server server;

    WaitEvent(Customer customer,Server server) {
        super(customer.getArrivalTime());
        this.customer = customer;
        this.serverId = server.getId();
        this.server = server;
    }

    Customer returnCustomer() {
        return this.customer;
    }

    Server returnServer() {
        return this.server;
    }

    int customerId() {
        return this.customer.getCustomerId();
    }

    String eventType() {
        return "Wait";
    }
    
    @Override
    public String toString() {
        if (customer.getGreedy()) {
            return String.format("%.3f %s(greedy) waits at server %d",
                    this.customer.getArrivalTime(), this.customer.getCustomerId(), this.serverId);
        }
        return String.format("%.3f %s waits at server %d",
                this.customer.getArrivalTime(), this.customer.getCustomerId(), this.serverId);
    }


}