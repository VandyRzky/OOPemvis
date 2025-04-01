package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Class.*;

class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private JTable table;
    private DataTask dataTask;
    private SeeForm seeForm;
    private int selectedRow;

    public ButtonEditor(JCheckBox checkBox, DataTask dataTask, JTable table, SeeForm seeForm) {
        super(checkBox);
        this.dataTask = dataTask;
        this.table = table;
        this.seeForm = seeForm;

        button = new JButton("Lihat");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Task selectedTask = dataTask.getTasks().get(selectedRow);

                    if(selectedTask.isTaskDone()){
                        new TaskDoneForm(selectedTask, dataTask, selectedRow, seeForm);
                    }else {
                        new TaskViewForm(selectedTask, dataTask, selectedRow, seeForm);
                    }
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.selectedRow = row;
        return button;
    }
}
