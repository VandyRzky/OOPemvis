package Class;

public abstract class Data {
    public abstract void seeAllTask();
    public void loadDataFromDatabase(){
        System.out.println("Load data from database");
    }
    public void saveDataToDatabase(){
        System.out.println("Saave data to database");
    }
}
