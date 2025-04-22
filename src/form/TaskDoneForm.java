package form;

import Class.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TaskDoneForm extends JFrame {
    private JPanel rootPanel;
    private JTextField namaTask;
    private JTextField deadlineTask;
    private JTextField descTask;
    private JButton hapusButton;
    private JLabel kepentinganLabel;
    private Task task;
    private DataTask dataTask;
    private int taskIndex;
    private SeeForm seeForm; // Tambahkan referensi ke SeeForm

    public TaskDoneForm(Task task, DataTask dataTask, int taskIndex, SeeForm seeForm){
        this.task = task;
        this.dataTask = dataTask;
        this.taskIndex = taskIndex;
        this.seeForm = seeForm;

        setTitle("Detail Tugas");
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/res/iconLogo.png")));
        setIconImage(icon.getImage());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Isi form dengan data task
        namaTask.setText(task.getTaskName());
        deadlineTask.setText(task.getTaskDate());
        descTask.setText(task.getTaskDesc());

        namaTask.setEditable(false);
        deadlineTask.setEditable(false);
        descTask.setEditable(false);

        // Menampilkan prioritas sebagai label (tidak bisa diedit)
        kepentinganLabel.setText("Prioritas: " + task.getTaskAwr());


        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus tugas ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dataTask.getTasks().remove(taskIndex);
                    JOptionPane.showMessageDialog(null, "Tugas dihapus!");
                    seeForm.updateTable(); // Perbarui tabel di SeeForm
                    dispose(); // Tutup form setelah aksi selesai
                }
            }
        });

        setContentPane(rootPanel);
        setVisible(true);

    }

}
