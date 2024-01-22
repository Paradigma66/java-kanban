import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
    int number = 0;
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Subtask> subTasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();

    public void registerTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public int getNewNumber() {
        return number++;
    }

    public void clearTasks() {
        tasks.clear();
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    void addTask(Task task) {
        tasks.put(task.getId(), task);
    }
    public Collection<Task> getAllTasks(){
        return tasks.values();
    }
    void updateTask(int id) {
        Task taskToUpdate = getTask(id);
        if (taskToUpdate.getStatus() == Status.NEW) {
            taskToUpdate.setStatus(Status.IN_PROGRESS);
        } else if (taskToUpdate.getStatus() == Status.IN_PROGRESS) {
            taskToUpdate.setStatus(Status.DONE);
        }
    }

    void removeTask(int id) {
        tasks.remove(id);
    }

    public void addSubTask(Subtask subtask) {
        subTasks.put(subtask.getId(), subtask);
        getEpic(subtask.getEpicID()).addSubTask(subtask);
    }
    public Collection<Subtask> getAllSubTasks(){
        return subTasks.values();
    }
    void removeSubTask(int id) {
        subTasks.remove(id);
    }

    public Subtask getSubTask(int id) {
        return subTasks.get(id);
    }

    void updateSubTask(int id) {
        Subtask taskToUpdate = subTasks.get(id);
        if (taskToUpdate.getStatus() == Status.NEW) {
            taskToUpdate.setStatus(Status.IN_PROGRESS);
        } else if (taskToUpdate.getStatus() == Status.IN_PROGRESS) {
            taskToUpdate.setStatus(Status.DONE);
        }
        updateEpic(taskToUpdate.getEpicID());
    }

    public void addEpic(Epic epic){
        epics.put(epic.getId(), epic);
    }
    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public void updateEpic(int id) {
        Epic epicToUpdate = epics.get(id);
        boolean finished = true;
        for (Task subTask : epicToUpdate.getSubTasks()) {
            if (subTask.getStatus() != Status.DONE) {
                finished = false;
                break;
            }
        }
        if (finished) {
            epicToUpdate.setStatus(Status.DONE);
        } else {
            epicToUpdate.setStatus(Status.IN_PROGRESS);
        }
    }
    void removeEpic(int id) {
        epics.remove(id);
    }
    void removeAllEpics(){
        epics.clear();
    }
    public Collection<Epic> getAllEpics(){
        return epics.values();
    }

    public List<Subtask> getEpicSubTasks(int id){
        return getEpic(id).getSubTasks();
    }



}


