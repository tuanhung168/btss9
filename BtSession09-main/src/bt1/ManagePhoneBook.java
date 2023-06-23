package bt1;

import java.util.Scanner;

public class ManagePhoneBook {
    private static PhoneBook phoneBook = new PhoneBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
                case 1:
                    insertPhone();
                    break;
                case 2:
                    removePhone();
                    break;
                case 3:
                    updatePhone();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    sortPhoneBook();
                    break;
                case 6:
                    System.out.println("Danh sách phone:");
                    phoneBook.getAll();
                    break;
                case 7:
                    System.out.println("Thoát. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không đúng. Mời chọn lại: ");
            }
        } while (choice != 7);
    }


    private static void displayMenu() {
        System.out.println("PHONEBOOK MANAGEMENT SYSTEM");
        System.out.println("1. Insert Phone");
        System.out.println("2. Remove Phone");
        System.out.println("3. Update Phone");
        System.out.println("4. Search Phone");
        System.out.println("5. Sort");
        System.out.println("6. Exit");
    }

    private static int getChoice() {
        System.out.print("Mời lựa chọn: ");
        return scanner.nextInt();
    }

    private static void insertPhone() {
        scanner.nextLine(); // Clear the input buffer
        System.out.print("Nhập vào tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập vào phone: ");
        String phone = scanner.nextLine();
        phoneBook.insertPhone(name, phone);
    }

    private static void removePhone() {
        scanner.nextLine(); // Clear the input buffer
        System.out.print("Nhập vào tên: ");
        String name = scanner.nextLine();
        phoneBook.removePhone(name);
    }

    private static void updatePhone() {
        scanner.nextLine(); // Clear the input buffer
        System.out.print("Nhập vào tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập vào phone mới: ");
        String newPhone = scanner.nextLine();
        phoneBook.updatePhone(name, newPhone);
    }

    private static void searchPhone() {
        scanner.nextLine(); // Clear the input buffer
        System.out.print("Nhập vào tên: ");
        String name = scanner.nextLine();
        phoneBook.searchPhone(name);
    }

    private static void sortPhoneBook() {
        phoneBook.sort();
    }
}
