import java.util.Scanner;

public class Main {
    static TaskManager taskManager = new TaskManager();



    public static void main(String[] args) {
        Epic epic = new Epic("Test", "test,", taskManager.getNewNumber());
        taskManager.addEpic(epic);
        Subtask subtask = new Subtask("tested", "tested2", taskManager.getNewNumber(), epic.getId());
        taskManager.addSubTask(subtask);
        taskManager.updateSubTask(subtask.getId());



        Epic epic2 = new Epic("Test2", "test2,", taskManager.getNewNumber());
        Subtask subtask1 = new Subtask("Ustal", "Ne_ponyatno", taskManager.getNewNumber(), epic2.getId());
        Subtask subtask2 = new Subtask("Ustal_Silno", "Ne_ponyatno_Nichego", taskManager.getNewNumber(), epic2.getId());
        taskManager.addEpic(epic2);
        taskManager.addSubTask(subtask1);
        taskManager.addSubTask(subtask2);
        taskManager.updateSubTask(subtask1.getId());
        taskManager.updateSubTask(subtask2.getId());

        Task task = new Task("Slojno", "ochen'", taskManager.getNewNumber());
        Task task2 = new Task("Ne_slojno", "ne_ochen'", taskManager.getNewNumber());
        taskManager.addTask(task);
        taskManager.addTask(task2);

        System.out.println("Список эпиков:");
        for (Epic allEpic : taskManager.getAllEpics()) {
            System.out.println(allEpic.getName());
        }

        System.out.println("Список подзадач:");
        for (Subtask allSubtask : taskManager.getAllSubTasks()) {
            System.out.println(allSubtask.getEpicID() + " " + allSubtask.getName());
        }

        System.out.println("Список задач:");
        for (Task allTask : taskManager.getAllTasks()) {
            System.out.println(allTask.getId() + " " + allTask.getName());
        }



        System.out.println("Изменение статуса задачи:");
        System.out.println("ДО:");
        System.out.println(task.getStatus());
        taskManager.updateTask(task.getId());
        System.out.println("ПОСЛЕ:");
        System.out.println(task.getStatus());

        System.out.println("Статус эпика до:");
        System.out.println(epic.getStatus());
        System.out.println("Изменение статуса задачи...");
        taskManager.updateSubTask(subtask.getId());
        System.out.println("Статус эпика после:");
        System.out.println(epic.getStatus());

        System.out.println("Удаление задачи:");
        System.out.println("Удаление эпика:");
        taskManager.removeEpic(epic.getId());
        taskManager.removeTask(task.getId());
    }


}
