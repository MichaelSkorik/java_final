package create_java.create5;

public interface QueueBehaviour {

    void takeInQueue(Actor actor);

    void takeOrders();

    void giveOrders();

    void releaseFromQueue();
}