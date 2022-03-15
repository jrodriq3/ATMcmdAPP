import java.util.Scanner;

public class Main {
    static Account[] actArr = new Account[10];
    static Scanner scanner = new Scanner(System.in);
    static int idInput = -1;
    static boolean exitPressed = false;
    static boolean completeQuit = false;
    public static void main(String[] args) {
        populateMainArray(actArr);
        while(true) {
            exitPressed = false;
            idInput = -1;
            promptForID();
            if (idInput == 999) {
                break;
            }
            while(exitPressed == false) {
                showMenu();
                mainLoop();
            }
        }
        
    }
    private static void populateMainArray(Account[] arr) {
        for (int i = 0; i < 9; i++) {
            arr[i] = new Account(i, 100);
        }
    }
    private static void promptForID() {
        while (idInput < 0 || idInput > 9) {
            System.out.println("Enter id number between 0 and 9 or 999 to quit");
            idInput = scanner.nextInt();
            if (idInput == 999) {
                break;
            }
        }
        sleep(); 
    }
    private static void showMenu() {
        System.out.println("Main Menu");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
    }
    private static void mainLoop() {
        int optionSelected = scanner.nextInt();
        if (optionSelected == 1) {
            System.out.println("Here is your balance...");
            sleep();
            System.out.println(actArr[idInput].getBalance());
        }
        else if (optionSelected == 2) {
            System.out.println("How much would you like to withdraw?");
            double withdrawAmount = scanner.nextDouble();
            while (withdrawAmount > actArr[idInput].getBalance()) {
                System.out.println("Sorry you dont have enough in your account, please enter new amount");
                withdrawAmount = scanner.nextDouble();
            }
            actArr[idInput].setBalance(actArr[idInput].getBalance() - withdrawAmount);
            System.out.println("You withdrew " + withdrawAmount);
            System.out.println("Your new balance after withdraw is " + actArr[idInput].getBalance());
        }
        else if (optionSelected == 3) {
            System.out.println("How much would you like to deposit?");
            double depositAmount = scanner.nextDouble();
            while (depositAmount <= 0) {
                sleep();
                System.out.println("You can't deposit a negative amount, enter new amount");
                depositAmount = scanner.nextDouble();
                sleep();
            }
            actArr[idInput].setBalance(actArr[idInput].getBalance() + depositAmount);
            sleep();
            System.out.println("You deposited " + depositAmount);
            System.out.println("Your balance after deposit is " + actArr[idInput].getBalance());
        }
        else if (optionSelected == 4) {
            exitPressed = true;
            System.out.println("Exiting your account...");
            sleep();

        }
        sleep();
    }
    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // ignore error
        }
    }
}
