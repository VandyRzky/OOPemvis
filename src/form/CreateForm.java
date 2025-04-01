package form;

import javax.swing.*;
import Class.*;

public class CreateForm extends JFrame {
    private JPanel rootPanel;
    private JTextField namaTugas;
    private JTextField deadline;
    private JButton simpanButton;
    private JComboBox<Kepentingan> kepentingan;
    private JTextField descTugas;
    private DataTask dataTask;


    public CreateForm(DataTask dataTask){
        setTitle("Form Tambah Tugas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(rootPanel);

        initKepentinganComboBox();

        simpanButton.addActionListener(e -> simpanTugas());

        this.dataTask = dataTask;


    }

    private void simpanTugas() {
        String nama = namaTugas.getText();
        String dueDate = deadline.getText();
        String desc = descTugas.getText();
        String priority = ((Kepentingan) kepentingan.getSelectedItem()).toString();

        if (nama.isEmpty() || dueDate.isEmpty() || desc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }else {
            insertTask(nama, dueDate, desc, priority);
            clearForm();
            dataTask.seeAllTask();
        }
//        else {
//            JOptionPane.showMessageDialog(this, "Tugas disimpan:\n" +
//                    "Nama: " + nama + "\n" +
//                    "Deadline: " + dueDate + "\n" +
//                    "Deskripsi: " + desc + "\n" +
//                    "Kepentingan: " + priority, "Sukses", JOptionPane.INFORMATION_MESSAGE);
//            clearForm();
//        }


    }

    private void insertTask(String taskName,String taskDate,String taskDesc,String taskAwr){
        Task taskTemp = new Task(taskName, taskDate, taskDesc, taskAwr);
        dataTask.insertTask(taskTemp);

    }
    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void clearForm() {
        namaTugas.setText("");
        deadline.setText("");
        descTugas.setText("");
        kepentingan.setSelectedIndex(0);
    }

    private void initKepentinganComboBox(){
        DefaultComboBoxModel<Kepentingan> comboBoxModel =(DefaultComboBoxModel<Kepentingan>)kepentingan.getModel();

        for(Kepentingan value: Kepentingan.values()){
            comboBoxModel.addElement(value);
        }

    }


}
