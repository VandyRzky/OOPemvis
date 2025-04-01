package Class;

import java.util.ArrayList;

public class DataTask {
    ArrayList <Task> dataTask = new ArrayList<Task>();

    public void insertTask(Task taskTemp){
        this.dataTask.add(taskTemp);
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

    public ArrayList<Task> getTasks() {
        return dataTask;
    }
}
