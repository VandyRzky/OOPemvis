package App;

import Class.*;
import form.Dasboard;
import form.SplashScreen;

import javax.swing.*;


public class App {

    public static void main(String[] args) {
        DataTask dataTask = new DataTask();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Program ditutup, menyimpan data ke database...");
            dataTask.saveDataToDatabase();
        }));

        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);

        // Delay beberapa detik
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splash.setVisible(false);
        splash.dispose();         // Hapus splash

        // Tampilkan aplikasi utama
        SwingUtilities.invokeLater(() -> {
            new Dasboard(dataTask);
        });
    }
}
