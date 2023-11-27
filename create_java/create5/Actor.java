package create_java.create5;


public abstract class Actor implements ActorBehavoir {

    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;


    public Actor(String name) {
        this.name = name;
    }

    public abstract String getName();
}
