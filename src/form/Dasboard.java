package form;

import javax.swing.*;
import java.awt.*;
import Class.*;

public class Dasboard extends JFrame {
    private JPanel panel1;
    private JPanel menuPanel;
    private JPanel cardPanel;
    private JButton tambahTugasBtn;
    private JButton lihatTugasBtn;
    private CardLayout cardLayout;
    private DataTask dataTask;

    public Dasboard(DataTask dataTask) {
        super("To do list");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Debugging: Pastikan cardPanel tidak null sebelum digunakan
        System.out.println("cardPanel: " + cardPanel);
        if (cardPanel == null) {
            System.err.println("Error: cardPanel belum diinisialisasi di GUI Designer!");
            return;
        }

        this.dataTask = dataTask;

        initComponents();

        setContentPane(panel1);
        setVisible(true);
    }

    private void initComponents(){
        // Atur CardLayout untuk cardPanel
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Buat halaman "Tambah" dan "Lihat"
        CreateForm panelTambah = new CreateForm(dataTask);
        SeeForm panelLihat = new SeeForm(dataTask);
        cardPanel.add(panelLihat.getRootPanel(), "Lihat");
        cardPanel.add(panelTambah.getRootPanel(), "Tambah");

        // Event tombol navigasi
        tambahTugasBtn.addActionListener(e -> cardLayout.show(cardPanel, "Tambah"));
        lihatTugasBtn.addActionListener(e -> {
            panelLihat.updateTable();
            cardLayout.show(cardPanel, "Lihat");
        });
    }
}
