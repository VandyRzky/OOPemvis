package form;

import Class.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskViewForm extends JFrame {
    private JPanel rootPanel;
    private JTextField namaTask;
    private JTextField deadlineTask;
    private JTextField descTask;
    private JButton finishBtn;
    private JButton simpanButton;
    private JButton hapusButton;
    private JLabel kepentinganLabel;
    private Task task;
    private DataTask dataTask;
    private int taskIndex;
    private SeeForm seeForm; // Tambahkan referensi ke SeeForm

    public TaskViewForm(Task task, DataTask dataTask, int taskIndex, SeeForm seeForm) {
        this.task = task;
        this.dataTask = dataTask;
        this.taskIndex = taskIndex;
        this.seeForm = seeForm;

        setTitle("Detail Tugas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Isi form dengan data task
        namaTask.setText(task.getTaskName());
        deadlineTask.setText(task.getTaskDate());
        descTask.setText(task.getTaskDesc());

        // Menampilkan prioritas sebagai label (tidak bisa diedit)
        kepentinganLabel.setText("Prioritas: " + task.getTaskAwr());

        // Tombol "Tandai Selesai"
        finishBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task.setTaskDone();
                JOptionPane.showMessageDialog(null, "Tugas ditandai sebagai selesai!");
                seeForm.updateTable(); // Perbarui tabel di SeeForm
                dispose(); // Tutup form setelah aksi selesai
            }
        });

        // Tombol "Simpan"
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perbarui data task
                task.setTaskName(namaTask.getText());
                task.setTaskDate(deadlineTask.getText());
                task.setTaskDesc(descTask.getText());

                JOptionPane.showMessageDialog(null, "Perubahan tersimpan!");
                seeForm.updateTable(); // Perbarui tabel di SeeForm
                dispose(); // Tutup form setelah aksi selesai
            }
        });

        // Tombol "Hapus"
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