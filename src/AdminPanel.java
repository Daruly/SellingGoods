import java.util.Scanner;

public class AdminPanel {
    public static Scanner input = new Scanner(System.in);
    public static PhoneValidator phoneValidator = new PhoneValidator();
    public static void adminPanel() {
        try {
            for(;;) {
                    System.out.println("Чтобы добавить товар в список впишите 1\n" +
                            "Чтобы удалить товар по номеру в списке впишите 2\n" +
                            "Чтобы просмотреть информацию о пользователях впишите 3\n" +
                            "Чтобы сменить роль пользователю впишите 4\n" +
                            "Чтобы выйти впишите 0\n");
                    int detect = input.nextInt();
                    input.nextLine();
                    if (detect == 1) addGood();
                    else if (detect == 2) deleteGood();
                    else if (detect == 3) seeUsers();
                    else if (detect == 4) {
                        System.out.println("Чтобы сделать админа нажмите 1 \nЧтобы удалить админа нажмите 2");
                        int detect2 = input.nextInt();
                        input.nextLine();
                        if (detect2 == 1) addAdmin();
                        else if (detect2 == 2) deleteAdmin();
                        else {
                            System.out.println("Введите только команду указанную выше");
                        }
                    }else if(detect == 0){
                        break;
                    }else {
                        System.out.println("Введите только команду указанную выше");
                    }
            }
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
    static void addGood(){
        try {
            String name;
            Integer cost;
            for(;;) {
                System.out.println("Введите название:");
                name = input.nextLine();
                System.out.println("Введите цену");
                cost = input.nextInt();
                input.nextLine(); // This line you have to add (It consumes the \n character)
                if(!(cost instanceof Integer)){
                    System.out.println("Вводите только цифры.");
                    continue;
                }
                break;
            }
                Good good = new Good(name, cost);
                Good.goodArrayList.add(good);
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
    static void deleteGood(){
        try {
            Good.getGoods();
            System.out.println("Введите номер удаляемого товара:");
            int id = input.nextInt();
            input.nextLine();
            Good del = Good.goodArrayList.get(id - 1);
            Good.goodArrayList.remove(id - 1);
            System.out.println("Товар:" + del.getName() + "успешно удален");
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
    static void seeUsers(){
        Admin.getAdmins();
        Customer.getCustomers();
    }
    static void addAdmin(){
        try {
            Customer.getCustomers();
            System.out.println("Введите номер пользователя:");
            int id = input.nextInt();
            input.nextLine();
            Customer del = Customer.customerArrayList.get(id - 1);
            Customer.customerArrayList.remove(id - 1);
            Admin.adminArrayList.add(new Admin(del.getSecondName(), del.getFirstName(), del.getMiddleName(),
                    del.getPhone(), del.getEmail(), del.getLogin(), del.getPassword()));
            System.out.println("Пользователь:" + del.getFirstName() + "успешно стал Админом");
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
    static void deleteAdmin(){
        try {
            Admin.getAdmins();
            System.out.println("Введите номер админа:");
            int id = input.nextInt();
            input.nextLine();
            Admin del = Admin.adminArrayList.get(id - 1);
            Admin.adminArrayList.remove(id - 1);
            Customer.customerArrayList.add(new Customer(del.getSecondName(), del.getFirstName(), del.getMiddleName(),
                    del.getPhone(), del.getEmail(), del.getLogin(), del.getPassword()));
            System.out.println("Админ:" + del.getFirstName() + "успешно стал Пользователем");
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
}
