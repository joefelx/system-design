package taskmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private static TaskManager instance =  null;
    private Map<Integer, List<Task>> userTaskMap;
    private List<Task> tasks;

    private TaskManager(){
        userTaskMap = new HashMap<>();
        tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }

        return instance;
    }



    public void create(String title, String description, String dueDate, Priority priority, User user) {
        if (!userTaskMap.containsKey(user.getId())) {
            userTaskMap.put(user.getId(), new ArrayList<>());
        }
        Task newTask = new Task(title, description, dueDate, priority);
        newTask.setAssigned(user);
        tasks.add(newTask);
        userTaskMap.get(user.getId()).add(newTask);
    }

    public boolean update(int userId, int taskId, String title, String description, String dueDate, Priority priority, Status status) {
        List<Task> userTasks = search(userId);

        if (userTasks.isEmpty()) return false;

        Task taskForUpdate = (Task) userTasks.stream().filter(task -> task.getId() == taskId);

        taskForUpdate.setTitle(title);
        taskForUpdate.setDescription(description);
        taskForUpdate.setDueDate(dueDate);
        taskForUpdate.setPriority(priority);
        taskForUpdate.setStatus(status);

        return true;
    }

    public boolean delete(int userId, int taskId) {
        List<Task> userTasks = search(userId);

        if (userTasks.isEmpty()) return false;

        userTasks =  userTasks.stream().filter(task -> task.getId() != taskId).toList();
        tasks = tasks.stream().filter(task -> task.getId() != taskId).toList();

        userTaskMap.put(userId, userTasks);

        return true;

    }
    public boolean assign(User user, int taskId) {
        if (!userTaskMap.containsKey(user.getId())) {
            userTaskMap.put(user.getId(), new ArrayList<>());
        }

        for (Task task : tasks) {
            if (task.getId() == taskId){
                User assignedUser = task.getAssigned();
                userTaskMap.put(assignedUser.getId(), userTaskMap.get(assignedUser.getId()).stream().filter(t -> t.getId() != taskId).toList());
                userTaskMap.get(user.getId()).add(task);
                task.setAssigned(user);
                break;
            }
        }


        return true;
    }
    public void setRemainder() {}

    public List<Task> search(int userId) {
        if (!userTaskMap.containsKey(userId)) return new ArrayList<>();
        return userTaskMap.get(userId);
    }

    public List<Task> search(Priority priority) {
        return tasks.stream().filter(task -> task.getPriority().equals(priority)).toList();
    }

    public List<Task> search(String dueDate) {
        return tasks.stream().filter(task -> task.getDueDate().equals(dueDate)).toList();
    }


    public void filter() {}
    public void markTask() {}
    public List<Task> view (int userId) {
        if (!userTaskMap.containsKey(userId)) return new ArrayList<>();

        return userTaskMap.get(userId);
    }

}
