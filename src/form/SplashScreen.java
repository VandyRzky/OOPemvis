package form;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    public SplashScreen() {
        // Panel utama
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.WHITE);

        // Gambar/logo
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/iconLogo.png"));
        JLabel label = new JLabel(icon);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Teks tambahan (opsional)
        JLabel text = new JLabel("Memuat aplikasi...", JLabel.CENTER);
        text.setFont(new Font("SansSerif", Font.BOLD, 14));
        text.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Tata letak
        content.setLayout(new BorderLayout());
        content.add(label, BorderLayout.CENTER);
        content.add(text, BorderLayout.SOUTH);

        // Ukuran dan posisi tengah layar
        setSize(300, 200);
        setLocationRelativeTo(null);
    }
}