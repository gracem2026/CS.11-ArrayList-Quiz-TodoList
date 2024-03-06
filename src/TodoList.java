import java.util.ArrayList;

public class TodoList {

    private String owner;
    private ArrayList<Task> tasks;

    public TodoList(String owner) {
        this.owner = owner;
        this.tasks = new ArrayList<Task>();
    }

    public boolean addTask(String name, int urgency) {
        for (Task task: tasks) {
            if (task.getName().equals(name))
                return false;
        }
        tasks.add(new Task(name, urgency));
        return true;
    }

    public boolean removeTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateTaskUrgency(String name, int urgency) {

        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setUrgency(urgency);
                return true;
            }
        }
        return false;
    }

    /**
     * The method mostUrgent will return the name of the task that is the most urgent (i.e. the task with the
     * highest urgency). If there are multiple tasks whose urgency is equal to the maximum, the first task
     * with that urgency will be returned.
     * @return the name of the task with the current highest urgency (a String).
     */
    public String mostUrgent() {
        Task urgent = new Task("", 0);

        for (int i = 0; i < tasks.size()-1; i++) {

            Task t1 = tasks.get(i);
            Task t2 = tasks.get(i+1);
            int u1 = t1.getUrgency();
            int u2 = t2.getUrgency();

            if (i == 0) {
                if(u1 >= u2) {urgent = t1;}
                else {urgent = t2;}
            }
            else {
                if(u1 >= u2 && u1 > urgent.getUrgency()) {urgent = t1;}
                else if(u2 >= u1 && u2 > urgent.getUrgency()) {urgent = t2;}
            }

        }

        return urgent.getName();

    }

    /**
     * The method averageUrgency will return the average (arithmetic mean) of the urgency across all tasks
     * @return the average urgency across all tasks (a double).
     */
    public double averageUrgency() {
        double avg = 0.0;
        double sum = 0.0;
        for (int i = 0; i < tasks.size(); i++) {
            sum += tasks.get(i).getUrgency();
        }
        avg = sum / tasks.size();
        return avg;

    }

    /**
     * The method toString will return all tasks with their urgency in the form of a String.
     * The returned String will be in the following format:
     *
     * To-do List of [owner]
     * [Task 1] [tab] [urgency]
     * [Task 2] [tab] [urgency]
     * [Task 3] [tab] [urgency]
     * [Task 4] [tab] [urgency]
     * ...
     * @return the printable representation of the to-do list (a String).
     *
     * BONUS Challenge:  Sort your to-do list in descending order of urgency
     */
    public String toString() {

        return "";
        
    }

}
