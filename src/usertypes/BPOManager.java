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

    public int getClientCount() {
        return clients.size();
    }

    public void addClient(String clientUname) {
        clients.add(clientUname);
    }

    public void removeClient(String clientUname) {
        clients.remove(clientUname);
    }

    public static BPOManager searchBpoManager(List<BPOManager> bpoManagers, String uname) {
        for (BPOManager bpoManager : bpoManagers) {
            if (bpoManager.getUsername().equals(uname)) {
                return bpoManager;
            }
        }
        return null;
    }
}