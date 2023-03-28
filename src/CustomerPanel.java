import java.util.Scanner;

public class CustomerPanel {
    public static Scanner input = new Scanner(System.in);

    public static void customerPanel() {
        try {
            for(;;){
                    System.out.println("Чтобы получить список товаров нажмите 1\n" +
                            "Чтобы выйти впишите 0" );
                    int detect = input.nextInt();
                    input.nextLine();
                    if (detect == 1) seeGoods();
                    else if(detect == 0) break;
                    else {
                        System.out.println("Введите только команду указанную выше\n");
                    }
            }
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
    static void seeGoods(){
        Good.getGoods();
    }
}
