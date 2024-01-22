public class Task {
    private String name;
    private String description;
    private int id;
    private Status status = Status.NEW;
    public Status getStatus() {
        return status;
    }
    public Task(String name, String description, int idNumber){
        this.name = name;
        this.description = description;
        this.id = idNumber;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



}
