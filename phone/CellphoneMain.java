package phone;

import java.util.Scanner;

public class CellphoneMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        int input_pulsa = 0;
        String name = "";
        String phone_number = "";

        Cellphone cp = new Cellphone("Nokia", "3310");

        while (!input.equals(0)) {
            System.out.println("\nPilih Menu: ");
            System.out.println("1. Nyalakan Ponsel");
            System.out.println("2. Matikan Ponsel");
            System.out.println("3. Naikan Volume");
            System.out.println("4. Turunkan Volume");
            System.out.println("5. Top Up Pulsa");
            System.out.println("6. Cek Pulsa");
            System.out.println("7. Tambah Kontak");
            System.out.println("8. Lihat Semua Kontak");
            System.out.println("9. Cari Kontak");
            System.out.println("0. Keluar");
            System.out.print("\nPilih menu: ");
            input = scanner.nextLine();

            if (input.endsWith("1")) {
                cp.powerOn();
            } else if (input.endsWith("2")) {
                cp.powerOff();
            } else if (input.endsWith("3")) {
                cp.volumeUp();
            } else if (input.endsWith("4")) {
                cp.volumeDown();
            } else if (input.endsWith("5")) {
                System.out.print("Masukan nominal pulsa: ");
                input_pulsa = scanner.nextInt();
                cp.topUpPulsa(input_pulsa);
                scanner = new Scanner(System.in);

            } else if (input.endsWith("6")) {
                System.out.print("Sisa pulsa anda sebesar: " + cp.getSisaPulsa());

            } else if (input.endsWith("7")) {
                System.out.print("Masukan nama : ");
                name = scanner.nextLine();

                System.out.print("Masukan nomor kontak: ");
                phone_number = scanner.nextLine();

                cp.addContact(name, phone_number);

            } else if (input.endsWith("8")) {
                cp.showAllContacts();

            } else if (input.endsWith("9")) {
                System.out.print("Masukan nama kontak : ");
                name = scanner.nextLine();

                cp.searchContact(name);

            } else if (input.endsWith("0")) {
                System.out.print("Keluar");
            }

        }
        scanner.close();

        // cp.powerOn();
        // cp.volumeUp();
        // cp.topUpPulsa(50000);
        // cp.topUpPulsa(10000);
        // System.out.println("Sisa pulsa anda adalah: " + cp.getSisaPulsa());
        // cp.addContact("John", "1234567890");
        // cp.addContact("Jane", "0987654321");
        // cp.showAllContacts();
        // cp.searchContact("John");
        // cp.searchContact("Alice");
        // cp.powerOff();

    }
}
