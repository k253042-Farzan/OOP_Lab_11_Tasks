import java.util.Scanner;

class Login<T, U> {
    T username;
    U password;

    Login(T username, U password) {
        this.username = username;
        this.password = password;
    }

    void checkLogin(T user, U pass) {
        if (username.equals(user) && password.equals(pass)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Username or Password.");
            System.exit(0);
        }
    }
}

//class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        // Pre-stored username and password
//        Login<String, String> obj = new Login<>("admin", "123456");
//
//        System.out.print("Enter Username: ");
//        String user = input.nextLine();
//        System.out.print("Enter Password: ");
//        String pass = input.nextLine();
//        obj.checkLogin(user, pass);
//
//        input.close();
//    }
//}