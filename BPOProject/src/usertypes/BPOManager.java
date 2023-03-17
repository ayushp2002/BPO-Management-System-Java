package usertypes;

import java.util.ArrayList;
import java.util.List;

public class BPOManager {
    private String username;
    private String password;
    private List<String> clients;

    public BPOManager(String name, String pass) {
        this.username = name;
        this.password = pass;
        clients = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public List<String> getClients() {
        return clients;
    }

    public void addClient(String clientUname) {
        clients.add(clientUname);
    }

    public void removeClient(String clientUname) {
        clients.remove(clientUname);
    }

    // public void assignTask(String clientUname, String task) {
    //     if (clients.contains(clientUname)) {
    //         Client.searchClient(clients, clientUname).addTask(task);
    //     }
    // }

    // public List<String> viewTasks(String username) {
    //     Client client = Client.searchClient(clients, username);
    //     if (client != null) {
    //         return client.getTasks();
    //     }
    //     return null;
    // }

    public static BPOManager searchBpoManager(List<BPOManager> bpoManagers, String uname) {
        for (BPOManager bpoManager : bpoManagers) {
            if (bpoManager.getUsername().equals(uname)) {
                return bpoManager;
            }
        }
        return null;
    }
}