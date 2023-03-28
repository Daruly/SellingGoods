import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static EmailValidator emailValidator = new EmailValidator();
    public static OnlyWordValidator onlyWordValidator = new OnlyWordValidator();
    public static PasswordValidator passwordValidator = new PasswordValidator();
    public static PhoneValidator phoneValidator = new PhoneValidator();
    public static void main(String[] args){
        init();
        for(;;) {
            try {
                System.out.println("Для Регистрации впишите 1 \nДля Авторизации впишите 2 \nДля Выхода впишите 3");
                int detect = input.nextInt();
                input.nextLine(); // This line you have to add (It consumes the \n character)
                if (detect == 1) register();
                else if (detect == 2) auth();
                else if (detect == 3) System.exit(0);
                else {
                    System.out.println("Введите команды указанные выше");
                }
            } catch (Exception e) {
                System.out.println("Что то пошло не так");
            }
        }
    }
    static void init(){
        Admin.adminArrayList.add(new Admin("Petrov", "Petr", "Petrovich"
                , "87077777777", "petr@gmail.com", "petrpetr", "Petr123123123!"));
    }
    static void register(){
        try {
            String secondName, firstName, middleName, phone, email, login, password;
            for(;;) {
                boolean valid = true;

                // // // ФАМИЛИЯ // // //
                System.out.println("Впишите Фамилию:");
                secondName = input.nextLine();
                valid = phoneValidator.validate(secondName);
                if (valid) {
                    System.out.println("Вводите только буквы.");
                    continue;
                }

                // // // ИМЯ // // //
                System.out.println("Впишите Имя:");
                firstName = input.nextLine();
                valid = phoneValidator.validate(firstName);
                if (valid) {
                    System.out.println("Вводите только буквы.");
                    continue;
                }

                // // // ОТЧЕСТВО // // //
                System.out.println("Впишите Отчество:");
                middleName = input.nextLine();
                valid = phoneValidator.validate(middleName);
                if (valid) {
                    System.out.println("Вводите только буквы.");
                    continue;
                }

                // // // НОМЕР // // //
                System.out.println("Впишите Номер:");
                phone = input.nextLine();
                valid = phoneValidator.validate(phone);
                if (!valid) {
                    System.out.println("Вводите только цифры.");
                    continue;
                }

                // // // ПОЧТА // // //
                System.out.println("Впишите Почту:");
                email = input.nextLine();
                valid = emailValidator.validate(email);
                if (!valid) {
                    System.out.println("Почта введена некорректно.Введите правильную почту.");
                    continue;
                }
                for(Admin to: Admin.adminArrayList){
                    if(to.getEmail().equals(email)){
                        valid = false;
                        break;
                    }
                }
                for(Customer to: Customer.customerArrayList){
                    if(to.getEmail().equals(email) || !valid){
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    System.out.println("Почта уже существует. Введите другую почту");
                    continue;
                }

                // // // // ЛОГИН // // // //
                System.out.println("Впишите Логин:");
                login = input.nextLine();
                for(Admin to: Admin.adminArrayList){
                    if(to.getLogin().equals(login)){
                        valid = false;
                        break;
                    }
                }
                for(Customer to: Customer.customerArrayList){
                    if(to.getLogin().equals(login) || !valid){
                        valid = false;
                        break;
                    }
                }
                if(!valid){
                    System.out.println("Логин уже существует. Введите другой логин");
                    continue;
                }

                // // // ПАРОЛЬ // // //
                System.out.println("Впишите Пароль:");
                password = input.nextLine();
                valid = passwordValidator.validate(password);
                if(!valid){
                    System.out.println("Введите пароль по следующим правилам:По крайней мере, одна заглавная английская буква, (?=.*?[A-Z])\n" +
                            "По крайней мере, одна английская буква в нижнем регистре, (?=.*?[a-z])\n" +
                            "По крайней мере, одна цифра, (?=.*?[0-9])\n" +
                            "По крайней мере, один специальный символ, (?=.*?[#?!@$%^&*-])\n" +
                            "Минимум восемь в длину .{8,}");
                    continue;
                }
                break;
            }
            Customer user = new Customer(secondName, firstName, middleName, phone, email, login, password);
            Customer.customerArrayList.add(user);
            System.out.println("Пользователь " + firstName + " успешно добавлен");
            CustomerPanel.customerPanel();
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
    static void auth(){
        try {
            System.out.println("Впишите Логин или Почту:");
            String auth = input.nextLine();
            System.out.println("Впишите Пароль:");
            String password = input.nextLine();
            int flag = 0;
            for(Admin to: Admin.adminArrayList){
                if((auth.equals(to.getEmail()) || auth.equals(to.getLogin())) && password.equals(to.getPassword())){
                    flag = 1;
                }
            }
            for(Customer to: Customer.customerArrayList){
                if((auth.equals(to.getEmail()) || auth.equals(to.getLogin())) && password.equals(to.getPassword())){
                    flag = 2;
                }
            }
            if(flag == 1) AdminPanel.adminPanel();
            else if(flag == 2) CustomerPanel.customerPanel();
            else if(flag == 0){
                System.out.println("Пользователь не найден! \n Введите корректные данные.");
                auth();
            }
        } catch (Exception e) {
            System.out.println("Что то пошло не так\n");
        }
    }
}
