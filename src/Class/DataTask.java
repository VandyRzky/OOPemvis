package Class;

import java.util.ArrayList;
import Database.DatabaseConnection;
import java.sql.*;

public class DataTask extends Data {
    final ArrayList <Task> dataTask = new ArrayList<Task>();

    public DataTask(){
        loadDataFromDatabase();
    }

    public void insertTask(Task taskTemp){
        this.dataTask.add(taskTemp);
    }

    @Override
    public void loadDataFromDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM task")) {

            dataTask.clear(); // Hapus data di memori sebelum load

            while (rs.next()) {
                Task task = new Task(
                        rs.getString("name_task"),
                        rs.getString("deadline_task"),
                        rs.getString("desc_task"),
                        rs.getString("priority_task")
                );
                task.setTaskDone(rs.getBoolean("isdone_task"));
                dataTask.add(task);
            }

            // Hapus data dari database setelah diambil
            try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM task")) {
                pstmt.executeUpdate();
            }

            System.out.println("Data dari database berhasil dimuat ke DataTask.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDataToDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO task (name_task, deadline_task, desc_task, priority_task, isdone_task) VALUES (?, ?, ?, ?, ?)"
             )) {

            for (Task task : dataTask) {
                pstmt.setString(1, task.getTaskName());
                pstmt.setString(2, task.getTaskDate());
                pstmt.setString(3, task.getTaskDesc());
                pstmt.setString(4, task.getTaskAwr());
                pstmt.setBoolean(5, task.isTaskDone());
                pstmt.executeUpdate();
            }

            System.out.println("Data berhasil disimpan ke database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void seeAllTask(){
        int i = 1;
        for (Task value : dataTask){
            System.out.println(i + ".------------------------------");
            System.out.println(value);
            i++;
        }
        System.out.println("--------------------------------");
    }

    public void seeAllTask(String priority) {
        int i = 1;
        for (Task value : dataTask){
            if (value.getTaskAwr().equalsIgnoreCase(priority)) {
                System.out.println(i + ".------------------------------");
                System.out.println(value);
                i++;
            }
        }
        System.out.println("--------------------------------");
    }

    public ArrayList<Task> getTasks() {
        return dataTask;
    }
}
