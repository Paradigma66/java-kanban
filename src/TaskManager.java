import java.util.HashMap;

public class TaskManager {
    int number = 0;
    HashMap<Integer, Task> tasks = new HashMap<>();

    public void registerTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public int getNewNumber(){
        return number++;
    }
    public void clearTasks(){
        tasks.clear();
    }
    public Task getTask(int id){
        return tasks.get(id);
    }
    public Task removeTask(int id) {
        Task task = tasks.remove(id);
    if (task != null) {
        for (Task subTask : task.getSubTasks()) {
            tasks.remove(subTask.getId());
        }
    }
        return task;
    }

}
