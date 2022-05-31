package cs2030.simulator;

import java.util.Comparator;
import java.util.PriorityQueue;

class PQ {
    private final PriorityQueue<Event> queue = new PriorityQueue<Event>(new EventComparator());

    void add(Event e) {
        this.queue.add(e);
    }

    Event poll() {
        Event e = this.queue.poll();
        return e;
    }

    int size() {
        return this.queue.size();
    }
}