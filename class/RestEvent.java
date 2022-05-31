package cs2030.simulator;

class RestEvent extends Event {
    private final Customer customer;
    private final double restTime;
    private final Server server;

    RestEvent(Customer customer,Server server,double restTime) {
        super(customer.getBeServedTime() + customer.getServeTime() + restTime);
        this.customer = customer;
        this.restTime = restTime;
        this.server = server;
    }

    String eventType() {
        return "Rest";
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


}