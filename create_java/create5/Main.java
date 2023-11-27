package create_java.create5;

public  class Main {
    public static void main(String[] args){
        Market market = new Market();
        Human human1 = new Human("Иван");
        market.acceptToMarket(human1);
        Human human2 = new Human("Михаил");
        market.acceptToMarket(human2);
        Human human3 = new Human("Кирилл");
        market.acceptToMarket(human3);
        market.update();
    }
}
