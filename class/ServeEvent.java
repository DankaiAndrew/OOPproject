package cs2030.simulator;

class ServeEvent extends Event {
    private final Customer customer;
    private final double nextServeTime;
    private final int serverId;
    private final Server server;

    ServeEvent(Customer customer,Server server) {
        super(customer.getBeServedTime());
        this.customer = customer;
        this.nextServeTime = customer.getBeServedTime();
        this.serverId = server.getId();
        this.server = server;
    }

    String eventType() {
        return "Serve";
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
            return String.format("%.3f %s(greedy) serves by server %d",
                    this.nextServeTime,
                    this.customer.getCustomerId(), this.serverId);
        }
        return String.format("%.3f %s serves by server %d",
                this.nextServeTime,
                this.customer.getCustomerId(), this.serverId);
    }


}