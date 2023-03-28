import java.util.ArrayList;

public class Customer {
    public static ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
    private String secondName;
    private String firstName;
    private String middleName;
    private String phone;
    private String email;
    private String login;
    private String password;

    public Customer(String secondName, String firstName, String middleName, String phone, String email, String login, String password) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public static void getCustomers(){
        int cnt = 1;
        System.out.println("Список покупателей:");
        for(Customer to: customerArrayList){
            System.out.print("Номер:" + cnt + " -- Фамилия:" + to.getSecondName() + " -- Имя:"
                    + to.getFirstName()  + " -- Очество:" + to.getMiddleName() + " -- Номер:"
                    + to.getPhone() + " -- Почта:" + to.getEmail() + " -- Логин:"
                    + to.getLogin() + "\n");
            cnt++;
        }
        System.out.println();
    }

    public static ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
