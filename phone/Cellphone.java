package phone;

import java.util.ArrayList;
import java.lang.Math;

public class Cellphone implements Phone {

    String merk;
    String type;
    int batteryLevel;
    int status;
    int volume;
    int pulsa;
    ArrayList<Contact> contacts;

    public Cellphone(String merk, String type) {
        this.merk = merk;
        this.type = type;
        this.batteryLevel = (int) (Math.random() * (100 - 0 + 1) + 0);
        this.contacts = new ArrayList<>();
    }

    public void powerOn() {
        this.status = 1;
        System.out.println("Ponsel menyala");
    }

    public void powerOff() {
        this.status = 0;
        System.out.println("Ponsel mati");
    }

    public void volumeUp() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
        } else {
            this.volume++;
            if (this.volume >= MAX_VOLUME) {
                this.volume = MAX_VOLUME;
                System.out.println("Volume pomnsel sudah maksumal");
            }
            System.out.println("Volume = " + this.volume);

        }
    }

    public void volumeDown() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menurunkan volume");
        } else {
            this.volume--;
            if (this.volume <= MIN_VOLUME) {
                this.volume = MIN_VOLUME;
            }
            System.out.println("Volume = " + this.volume);
        }
    }

    public int getVolume() {
        return this.volume;
    }

    public void topUpPulsa(int amount) {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat melakukan top up pulsa");
        } else {
            this.pulsa += amount;
            System.out.println("Top up pulsa sebesar " + amount + " berhasil");
        }
    }

    public int getSisaPulsa() {
        return this.pulsa;
    }

    public void addContact(String name, String number) {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menambahkan kontak");
        } else {
            Contact contact = new Contact(name, number);
            contacts.add(contact);
            System.out.println("Kontak " + name + " berhasil ditambahkan");
        }
    }

    public void showAllContacts() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
        } else {
            if (contacts.isEmpty()) {
                System.out.println("Tidak ada kontak yang tersimpan");
            } else {
                System.out.println("Daftar Kontak:");
                for (Contact contact : contacts) {
                    System.out.println("Nama: " + contact.getName() + ", Nomor: " + contact.getNumber());
                }
            }
        }

    }

    public void searchContact(String name) {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
        } else {
            boolean found = false;
            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(name)) {
                    System.out.println("Kontak ditemukan:");
                    System.out.println("Nama: " + contact.getName() + ", Nomor: " + contact.getNumber());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Kontak dengan nama " + name + " tidak ditemukan");
            }
        }

    }
}
