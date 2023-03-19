package usertypes;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store the details of a BPO Manager
 */
public class BPOManager {
    private String username;
    private String password;
    private List<String> clients;

    // A constructor.
    public BPOManager(String name, String pass) {
        this.username = name;
        this.password = pass;
        clients = new ArrayList<>();
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
     * This function checks if the password passed in is the same as the password stored in the object
     * 
     * @param password The password to check
     * @return A boolean value.
     */
    public boolean checkPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
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
     * This function returns a list of strings that contains the names of all the clients
     * 
     * @return A list of strings.
     */
    public List<String> getClients() {
        return clients;
    }

    /**
     * This function returns the number of clients in the list
     * 
     * @return The number of clients in the list.
     */
    public int getClientCount() {
        return clients.size();
    }

    /**
     * This function adds a client to the list of clients
     * 
     * @param clientUname The username of the client to add to the list of clients.
     */
    public void addClient(String clientUname) {
        clients.add(clientUname);
    }

    /**
     * This function removes a client from the list of clients
     * 
     * @param clientUname The username of the client to be removed.
     */
    public void removeClient(String clientUname) {
        clients.remove(clientUname);
    }

    /**
     * It takes a list of BPOManagers and a username, and returns the BPOManager with the given
     * username
     * 
     * @param bpoManagers List of BPOManager objects
     * @param uname username of the user
     * @return A list of BPOManager objects.
     */
    public static BPOManager searchBpoManager(List<BPOManager> bpoManagers, String uname) {
        for (BPOManager bpoManager : bpoManagers) {
            if (bpoManager.getUsername().equals(uname)) {
                return bpoManager;
            }
        }
        return null;
    }
}