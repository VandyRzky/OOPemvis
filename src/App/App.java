package App;

import Class.*;
import form.Dasboard;

import javax.swing.*;
import form.*;

public class App {

    public static void main(String[] args) {
        DataTask dataTask = new DataTask();

        // Tambahkan shutdown hook agar data tersimpan saat program dihentikan
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Program ditutup, menyimpan data ke database...");
            dataTask.saveDataToDatabase();
        }));

        // Jalankan aplikasi GUI
        new Dasboard(dataTask);
    }
}
