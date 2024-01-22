import java.util.ArrayList;

public class Epic extends Task{
    private final ArrayList<Subtask> subTasks = new ArrayList<>();
    public Epic(String name, String description, int idNumber) {
        super(name, description, idNumber);
    }

    public ArrayList<Subtask> getSubTasks() {
        return subTasks;
    }
    void addSubTask(Subtask subtask){
        subTasks.add(subtask);
    }
}
