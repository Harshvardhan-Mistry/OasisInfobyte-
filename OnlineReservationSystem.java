import java.util.Scanner;

class LoginForm {
    String loginId;
    String password;

    boolean validateUser() {
        // validation logic
        return true; // return true if login credentials are valid
    }
}

class ReservationSystem {
    String name;
    String trainNumber;
    String from;
    String to;
    String dateOfJourney;
    String classType;

    void insertReservationDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter train number: ");
        trainNumber = scanner.nextLine();

        System.out.print("Enter from: ");
        from = scanner.nextLine();

        System.out.print("Enter to: ");
        to = scanner.nextLine();

        System.out.print("Enter date of journey: ");
        dateOfJourney = scanner.nextLine();

        System.out.print("Enter class type: ");
        classType = scanner.nextLine();

        // insert reservation details into database

        scanner.close();
    }
}

class CancellationForm {
    String pnrNumber;

    void cancelTicket() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PNR number: ");
        pnrNumber = scanner.nextLine();

        // display ticket information for the given PNR number
        // implement cancellation logic

        scanner.close();
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LoginForm loginForm = new LoginForm();

        System.out.print("Enter your login ID: ");
        loginForm.loginId = scanner.nextLine();

        System.out.print("Enter your password: ");
        loginForm.password = scanner.nextLine();

        if (loginForm.validateUser()) {
            ReservationSystem reservationSystem = new ReservationSystem();
            reservationSystem.insertReservationDetails();
        } else {
            System.out.println("Invalid login credentials.");
        }

        CancellationForm cancellationForm = new CancellationForm();
        cancellationForm.cancelTicket();
        scanner.close();
    }
}