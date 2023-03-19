package usertypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    private String username;
    private String password;
    private String bpoManagerUsername;
    private List<String> tasks;

    public Client(String name, String pass) {
        this.username = name;
        this.password = pass;
        this.bpoManagerUsername = null;
        tasks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getBpoManagerUsername() {
        return bpoManagerUsername;
    }

    public void setBpoManagerUsername(String uname) {
        this.bpoManagerUsername = String.valueOf(uname);
    }

    public void removeBpoManagerUsername() {
        this.bpoManagerUsername = null;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public int getTasksCount() {
        return tasks.size();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public String completeTask(int index) {
        return tasks.remove(index);
    }

    public void clearTasks() {
        tasks.clear();
    }

    public static Client searchClient(HashMap<Integer, Client> clients, String uname) {
        for (int i = 1; i <= clients.size(); i++) {
            if (clients.get(i) != null) {
                if (clients.get(i).getUsername().equals(uname)) {
                    return clients.get(i);
                }
            }
        }
        return null;
    }
}