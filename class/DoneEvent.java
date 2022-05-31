package cs2030.simulator;

class DoneEvent extends Event {
    private final Customer customer;
    private final double nextServeTime;
    private final int serverId;
    private final Server server;

    DoneEvent(Customer customer,Server server) {
        super(customer.getBeServedTime() + customer.getServeTime());
        this.customer = customer;
        this.nextServeTime = customer.getBeServedTime();
        this.serverId = server.getId();
        this.server = server;
    }

    String eventType() {
        return "Done";
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

    @Override
    public String toString() {
        if (customer.getGreedy()) {
            return String.format("%.3f %s(greedy) done serving by server %d",
                    this.nextServeTime + customer.getServeTime(),
                    this.customer.getCustomerId(), this.serverId);
        }
        return String.format("%.3f %s done serving by server %d",
                this.nextServeTime + customer.getServeTime(),
                this.customer.getCustomerId(), this.serverId);
    }


}