package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import Class.*;

public class SeeForm {
    private JPanel rootPanel;
    private JTable taskTable;
    private JScrollPane scrollPane;
    private DataTask dataTask;

    public SeeForm(DataTask dataTask) {
        this.dataTask = dataTask;
        updateTable();
        rootPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    }

    public void updateTable() {
        // Ambil data dari DataTask
        ArrayList<Task> taskList = dataTask.getTasks();

        String[] columnNames = {"Nama Tugas", "Tanggal", "Prioritas", "Selesai", "Lihat"};

        // Buat model tabel
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Tambahkan data ke model tabel
        for (Task task : taskList) {
            model.addRow(new Object[]{
                    task.getTaskName(),
                    task.getTaskDate(),
                    task.getTaskAwr(),
                    task.isTaskDone() ? "Selesai" : "Belum Selesai",
                    "Lihat" // Placeholder untuk tombol
            });
        }

        // Set model tabel
        taskTable.setModel(model);

        // Terapkan custom renderer dan editor untuk kolom "Lihat"
        taskTable.getColumn("Lihat").setCellRenderer(new ButtonRenderer());
        taskTable.getColumn("Lihat").setCellEditor(new ButtonEditor(new JCheckBox(), dataTask, taskTable, this));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
