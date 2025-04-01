package Class;

public class Task {
    private String taskName;
    private String taskDate;
    private String taskDesc;
    private String taskAwr;
    private boolean taskIsDone;

    public String getTaskName(){return this.taskName;}
    public String getTaskDate(){return this.taskDate;}
    public String getTaskDesc(){return this.taskDesc;}
    public String getTaskAwr(){return this.taskAwr;}
    public boolean isTaskDone(){return this.taskIsDone;}

    public Task(String taskName, String taskDate, String taskDesc, String taskAwr){
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskDesc = taskDesc;
        this.taskAwr = taskAwr;
        this.taskIsDone = false;
    }

    public void setTaskDone(){
        this.taskIsDone = true;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setTaskDate(String deadlineTask){
        this.taskDate = deadlineTask;
    }

    public void setTaskDesc(String taskDesc){
        this.taskDesc = taskDesc;
    }

    public String getTaskIsDone(){
        if (!this.taskIsDone){
            return "Belum selesai";
        }
        return "Selesai";
    }

    @Override
    public String toString() {
        return """
                Nama Tugas: %s 
                Deadline: %s
                Desc: %s
                Kepentingan: %s
                Keterangan: %s """.formatted(this.taskName, this.taskDate, this.taskDesc, this.taskAwr, this.getTaskIsDone())
;    }
}
