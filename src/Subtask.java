import java.util.ArrayList;

public class Subtask extends Task{
    public int epicID;

    public Subtask (String name, String description, int idNumber, int epicID) {
        super(name, description, idNumber);
        this.epicID = epicID;
    }
    public int getEpicID() {
        return epicID;
    }
}
