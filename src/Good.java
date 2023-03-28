import java.util.ArrayList;

public class Good {
    public static ArrayList<Good> goodArrayList = new ArrayList<Good>();
    private String name;
    private Integer cost;

    public Good(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public static void getGoods(){
        int cnt = 1;
        for(Good to: goodArrayList){
            System.out.print("Номер:" + cnt + " -- Товар:" + to.getName() + " -- Стоимость:" + to.getCost() + "\n");
            cnt++;
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }


}
