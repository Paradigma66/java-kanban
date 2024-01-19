import java.util.ArrayList;

public class Task {
    private String name;
    private String description;
    private int id;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setStatus(Gradation status) {
        this.status = status;
    }

    public Gradation getStatus() {
        return status;
    }

    private  Gradation status = Gradation.NEW;
    private Task epic;
    private final ArrayList<Task> subTasks = new ArrayList<>();

    public Task(String name, String description, int idNumber){
        this.name = name;
        this.description = description;
        this.id = idNumber;


    }
    public void addSubTask(Task subTask) {
        this.subTasks.add(subTask);
        subTask.epic = this;
    }

    public Task getEpic() {
        return epic;
    }

    public ArrayList<Task> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        String text = getType();

        text += " №" + id + ": " + name + " (" + description + ") | Статус: " + status;
        if (!this.subTasks.isEmpty()) {
            text += "\n Подзадачи:\n";
            for (Task subTask : subTasks) {
              text += " - " + subTask + "\n";
            }
        }
        return text;
    }
    public String getType() {
        if (this.epic != null) {
             return "Подзадача";
        } else if (!this.subTasks.isEmpty()) {
            return "Epic";
        } else {
            return "Задача";
        }
    }
}
