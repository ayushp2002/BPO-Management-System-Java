package usertypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * It's a class that represents a client
 */
public class Client {
    private String username;
    private String password;
    private String bpoManagerUsername;
    private List<String> tasks;

    // It's a constructor.
    public Client(String name, String pass) {
        this.username = name;
        this.password = pass;
        this.bpoManagerUsername = null;
        tasks = new ArrayList<>();
    }

    /**
     * This function returns the username of the user
     * 
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This function returns the username of the BPO Manager
     * 
     * @return The value of the bpoManagerUsername variable.
     */
    public String getBpoManagerUsername() {
        return bpoManagerUsername;
    }

    /**
     * This function sets the value of the bpoManagerUsername variable to the value of the uname
     * variable
     * 
     * @param uname The username of the user who is currently logged in.
     */
    public void setBpoManagerUsername(String uname) {
        this.bpoManagerUsername = String.valueOf(uname);
    }

    /**
     * This function removes the bpoManagerUsername from the object
     */
    public void removeBpoManagerUsername() {
        this.bpoManagerUsername = null;
    }

    /**
     * This function checks if the password passed in is the same as the password stored in the object
     * 
     * @param password The password to check.
     * @return The password is being returned.
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * This function sets the password of the user
     * 
     * @param pass The password to set
     */
    public void setPassword(String pass) {
        this.password = pass;
    }

    /**
     * This function returns a list of strings
     * 
     * @return A list of strings.
     */
    public List<String> getTasks() {
        return tasks;
    }

    /**
     * This function returns the number of tasks in the list
     * 
     * @return The number of tasks in the list.
     */
    public int getTasksCount() {
        return tasks.size();
    }

    /**
     * This function adds a task to the list of tasks
     * 
     * @param task The task to be added to the list
     */
    public void addTask(String task) {
        tasks.add(task);
    }

    /**
     * // Java
     * public String completeTask(int index) {
     *         return tasks.remove(index);
     *     }
     * 
     * @param index The index of the task to be removed.
     * @return The task that was removed from the list.
     */
    public String completeTask(int index) {
        return tasks.remove(index);
    }

    /**
     * This function clears the tasks array
     */
    public void clearTasks() {
        tasks.clear();
    }

    /**
     * It searches through a HashMap of clients and returns the client with the username that matches
     * the username passed in as a parameter
     * 
     * @param clients HashMap of clients
     * @param uname username of the client
     * @return The client object that matches the username.
     */
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