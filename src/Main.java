import java.util.Scanner;

public class Main {
    static TaskManager taskManager = new TaskManager();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("Вас приветствует трекер задач!");
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Добавить новую задачу.");
            System.out.println("2 - Напечатать список задач.");
            System.out.println("3 - Удалить все задачи.");
            System.out.println("4 - Напечатать информацию о задаче по её ID.");
            System.out.println("5 - Удалить задачу по её ID.");
            System.out.println("6 - Изменить статус задачи.");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    Task epic = makeTask();
                    System.out.println("Хотите добавить подзадачи? Да/Нет");
                    String command1 = scanner.next();
                    if (command1.equalsIgnoreCase("Да")) {
                        do {
                            Task subTask = makeTask();
                            epic.addSubTask(subTask);
                            System.out.println("Хотите добавить еще одну подзадачу? Да/Нет");
                        } while (!scanner.next().equalsIgnoreCase("Нет"));
                    }
                    break;
                case 2:
                    for (Task task : taskManager.tasks.values()){
                        if (task.getEpic() == null) {
                            System.out.println(task);
                        }
                    }
                    break;
                case 3:
                    taskManager.clearTasks();
                    System.out.println("Все задачи удалены.");
                    break;
                case 4:
                    System.out.println("Введите id задачи");
                    int id = scanner.nextInt();
                    Task task = taskManager.getTask(id);
                    if (task == null) {
                        System.out.println("Задачи с указанным ID не найдена.");
                    } else {
                        System.out.println("Задача № " + id);
                        System.out.println(" Тип: " + task.getType());
                        System.out.println(" Название: " + task.getName());
                        System.out.println(" Описание: " + task.getDescription());
                        System.out.println(" Статус: " + task.getStatus());
                        if (!task.getSubTasks().isEmpty()) {
                            System.out.println(" Подзадачи:");
                            for (Task subTask : task.getSubTasks()) {
                                System.out.println(" - " + subTask);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Введите ID задачи.");
                    int idi = scanner.nextInt();
                    taskManager.removeTask(idi);
                    Task taskRemoved = taskManager.removeTask(idi);
                    if (taskRemoved == null) {
                        System.out.println("Задача не найдена!");
                    } else {
                        System.out.println("Задача с названием: " + taskRemoved.getName() + " удалена.");
                    }
                case 6:
                    System.out.println("Напишите ID задачи, статус которой вы хотите изменить.");
                    int idTask = scanner.nextInt();
                    Task taskToUpdate = taskManager.getTask(idTask);
                    if (taskToUpdate == null) {
                        System.out.println("Задача не найдена!");
                        break;
                    }
                    if (taskToUpdate.getStatus() == Gradation.DONE){
                        System.out.println("Эта задача уже выполнена.");
                        break;
                    }
                    if (taskToUpdate.getSubTasks().isEmpty()) {
                        taskToUpdate.setStatus(taskToUpdate.getStatus().next());
                        if (taskToUpdate.getEpic() != null) {
                            Task epicToUpdate = taskToUpdate.getEpic();
                            boolean finished = true;
                            for (Task subTask : epicToUpdate.getSubTasks()) {
                                if (subTask.getStatus() != Gradation.DONE) {
                                    finished = false;
                                    break;
                                }
                            }
                            if (finished) {
                                epicToUpdate.setStatus(Gradation.DONE);
                            } else {
                                epicToUpdate.setStatus(Gradation.IN_PROGRESS);
                            }
                        }
                    } else {
                        System.out.println("Вы не можете напрямую изменять статс EPIC'а!");
                        System.out.println("Для этого отметьте все подзадачи EPIC'а как DONE.");
                    }
                    break;
            }
        }
    }
    public static Task makeTask() {
        scanner.nextLine();
        System.out.println("Напишите название задачи.");
        String name = scanner.nextLine();
        System.out.println("Напишите описание задачи.");
        String description = scanner.nextLine();
        Task task = new Task(name, description, taskManager.getNewNumber());
        System.out.println("Задача создана.");
        System.out.println("Идентификационный номер задачи " + name + ": " + task.getId());
        taskManager.registerTask(task);
        return task;
    }
}
