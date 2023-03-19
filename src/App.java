import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import usertypes.BPOManager;
import usertypes.Client;
import utils.Utility;

public class App {
    private static HashMap<Integer, Client> clients = new HashMap<Integer, Client>();
    private static List<BPOManager> bpoManagers = new ArrayList<BPOManager>();
    private static HashMap<Integer, String> texts = new HashMap<Integer, String>(3); // To use with user input opt
                                                                                     // number

    private static Scanner sc = new Scanner(System.in);
    private static Console con = System.console();

    private static void registerNewUser() {
        int opt = 99;
        String username = new String();
        String password = new String();
        String confirmPass = new String();

        System.out.println("Register");
        System.out.println("1. Register Client\n2. Register BPO Manager\n3. Forgot Password\n0. Back to main menu");
        System.out.print("> ");
        opt = sc.nextInt();
        sc.nextLine(); // consume the newline character

        if (opt == 1 || opt == 2) {
            Utility.clearConsoleScreen();
            System.out.println(texts.get(opt) + " Register");
            System.out.print("Username: ");
            username = sc.nextLine();
            if (username.trim().isEmpty()) {
                System.out.println("Username cannot be empty.\nPress any key to continue...");
                Utility.getch();
                return;
            }
            System.out.print("[Input will not be visible]\nPassword: ");
            char[] chararr = con.readPassword();
            password = String.valueOf(chararr);
            if (password.trim().isEmpty()) {
                System.out.println("Password cannot be empty.\nPress any key to continue...");
                Utility.getch();
                return;
            }
            System.out.print("Confirm Password: ");
            chararr = con.readPassword();
            confirmPass = String.valueOf(chararr);
            if (!password.equals(confirmPass)) {
                System.out.print("Password and Confirm password should be same.\nPress Enter to continue...");
                Utility.getch();
                return;
            }
        }

        switch (opt) {
            case 1: { // Register Client
                // If a client with the same name exists, do not create a new one
                if (Client.searchClient(clients, username) == null) {
                    clients.put(clients.size() + 1, new Client(username, password));
                } else {
                    System.out.print("User " + username + " already exists.\nPress Enter to continue...");
                    Utility.getch();
                    return;
                }
                // Check if the new user has been created
                if (Client.searchClient(clients, username) != null) {
                    System.out.print("Client user created successfully.\nPress Enter to continue...");
                } else {
                    System.out.print("There was an error creating the user\nPress Enter to continue...");
                }
                Utility.getch();
                break;
            }
            case 2: { // Register BPO Manager
                // If a BPO Manager with the same name exists, do not create a new one
                if (BPOManager.searchBpoManager(bpoManagers, username) == null) {
                    bpoManagers.add(new BPOManager(username, password));
                } else {
                    System.out.print("User " + username + " already exists.\nPress Enter to continue...");
                    Utility.getch();
                    return;
                }
                // Check if the new user has been created
                if (BPOManager.searchBpoManager(bpoManagers, username) != null) {
                    System.out.print("BPO Manager user created successfully.\nPress Enter to continue...");
                } else {
                    System.out.print("There was an error creating the user\nPress Enter to continue...");
                }
                Utility.getch();
                break;
            }
            case 3: {
                Utility.clearConsoleScreen();
                System.out.println("Reset password");
                System.out.print("Username: ");
                username = sc.nextLine();
                System.out.print("Choose user type\n1. Client\n2. BPO Manager\n> ");
                int ustyp = sc.nextInt();
                if (ustyp != 1 && ustyp != 2) {
                    System.out.println("Invalid choice.Press Enter to continue...");
                    Utility.getch();
                    break;
                }
                System.out.print("Sending OTP");
                Utility.loadingDots();
                Utility.clearConsoleScreen();
                Utility.loadingDots();
                Utility.clearConsoleScreen();
                System.out.print("Connecting");
                Utility.loadingDots();
                Utility.loadingDots();
                Utility.clearConsoleScreen();
                System.out.print();
                switch (ustyp) {
                    case 1: {

                        break;
                    }
                    case 2: {

                        break;
                    }
                    default:
                        break;
                }
                break;
            }
            case 0: { // Back to Main Menu
                break;
            }
            default:
                System.out.println("Invalid Option. Try again\nPress Enter to continue...");
                Utility.getch();
                break;
        }
    }

    public static void main(String[] args) {
        /***************************************************
         * Data declaration
         ***************************************************/
        int opt = 99, opt1 = 99, opt2 = 99;
        String username = new String();
        String password = new String();

        /***************************************************
         * Objects Initialization
         ***************************************************/
        texts.put(1, "Client");
        texts.put(2, "BPO Manager");

        clients.put(1, new Client("ayush", "ayush"));
        clients.put(2, new Client("kumar", "kumar"));
        clients.put(3, new Client("sage", "sage"));
        clients.put(4, new Client("omen", "omen"));

        bpoManagers.add(new BPOManager("breach", "breach"));
        bpoManagers.add(new BPOManager("fade", "fade"));
        bpoManagers.add(new BPOManager("viper", "viper"));

        clients.get(1).addTask("Clean the toilets on second floor.");
        clients.get(1).addTask("BURN the CFO office using all his paper documents");
        clients.get(1).setBpoManagerUsername("fade");
        bpoManagers.get(1).addClient("ayush");

        /***************************************************
         * Execution start
         ***************************************************/
        while (opt != 0) {
            opt = 99;
            opt1 = 99;
            opt2 = 99;
            Utility.clearConsoleScreen();
            System.out.println("Login");
            System.out.println("1. Client Login\n2. BPO Manager Login\n3. Register new user\n0. Exit");
            System.out.print("> ");
            opt = sc.nextInt();
            sc.nextLine(); // consume the newline character

            if (opt == 1 || opt == 2) {
                Utility.clearConsoleScreen();
                System.out.println(texts.get(opt) + " Login");
                System.out.print("Username: ");
                username = sc.nextLine();
                if (username.trim().isEmpty()) {
                    System.out.println("Username cannot be empty.\nPress any key to continue...");
                    Utility.getch();
                    return;
                }
                System.out.print("[Input will not be visible]\nPassword: ");
                char[] chararr = con.readPassword();
                password = String.valueOf(chararr);
                if (password.trim().isEmpty()) {
                    System.out.println("Password cannot be empty.\nPress any key to continue...");
                    Utility.getch();
                    return;
                }
            }

            switch (opt) {
                case 1: { // Client Login
                    Utility.clearConsoleScreen();
                    Client client = Client.searchClient(clients, username);
                    if (client != null) {
                        if (client.checkPassword(password)) {
                            System.out.print("Welcome " + client.getUsername());
                            Utility.loadingDots();
                            while (opt1 != 0) {
                                Utility.clearConsoleScreen();
                                System.out.println("Client Portal");
                                if (client.getBpoManagerUsername() != null) {
                                    System.out
                                            .println(
                                                    "1. View Tasks\n2. Complete tasks\n3. Account Settings\n0. Logout");
                                    System.out.print("> ");
                                    opt1 = sc.nextInt();
                                    sc.nextLine();
                                } else {
                                    System.out.print(
                                            "[BPO Manager is not assigned yet. Actions will be visible once a BPO Manager is assigned to your user.]\nPress Enter to continue...");
                                    Utility.getch();
                                    break;
                                }

                                switch (opt1) {
                                    case 1: { // View Tasks
                                        Utility.clearConsoleScreen();
                                        System.out.println(client.getTasksCount() + " tasks pending");
                                        List<String> tasks = client.getTasks();
                                        for (int i = 0; i < client.getTasksCount(); i++) {
                                            System.out.println((i + 1) + ". " + tasks.get(i));
                                        }
                                        System.out.print("Press Enter to continue...");
                                        Utility.getch();
                                        break;
                                    }
                                    case 2: { // Complete Tasks
                                        Utility.clearConsoleScreen();
                                        System.out.println(client.getTasksCount()
                                                + " tasks pending. Enter task number to mark as complete.");
                                        if (client.getTasksCount() <= 0) {
                                            System.out.println("No Pending tasks.\nPress Enter to continue...");
                                            Utility.getch();
                                            break;
                                        }
                                        List<String> tasks = client.getTasks();
                                        for (int i = 0; i < client.getTasksCount(); i++) {
                                            System.out.println((i + 1) + ". " + tasks.get(i));
                                        }
                                        System.out.println("0. Go back to Client Portal");
                                        System.out.print("> ");
                                        opt2 = sc.nextInt();
                                        sc.nextLine();
                                        if (opt2 == 0) {
                                            break;
                                        }
                                        try {
                                            System.out
                                                    .print("Task \"" + client.completeTask(opt2 - 1) + "\" completed");
                                            Utility.loadingDots();
                                        } catch (IndexOutOfBoundsException e) {
                                            System.out.print("Invalid choice.\nPress Enter to continue...");
                                            Utility.getch();
                                        }
                                        break;
                                    }
                                    case 3: { // Account Details
                                        Utility.clearConsoleScreen();
                                        System.out.println("Client user account");
                                        System.out.println("Username: " + client.getUsername() + "\nBPO Manager: "
                                                + client.getBpoManagerUsername() + "\nPending Tasks: "
                                                + client.getTasksCount());
                                        System.out.println(
                                                "==============================================================");
                                        System.out.println("1. Change Password\n2. /!\\ Delete account /!\\\n0. Go back to Client portal");
                                        System.out.print("> ");
                                        opt2 = sc.nextInt();
                                        sc.nextLine();
                                        switch (opt2) {
                                            case 1: {   // Change Password
                                                Utility.clearConsoleScreen();
                                                System.out.println("Change Password");
                                                System.out.print("Old Password: ");
                                                char[] passChar = con.readPassword();
                                                String oldPass = String.valueOf(passChar);
                                                System.out.print("New Password: ");
                                                passChar = con.readPassword();
                                                String newPass = String.valueOf(passChar);
                                                if (client.checkPassword(oldPass)) {
                                                    if (client.checkPassword(newPass)) {
                                                        System.out.print("Choose a password different from the old password.\nPress Enter to continue...");
                                                        Utility.getch();
                                                    }
                                                    client.setPassword(newPass);
                                                    System.out.print("New password set");
                                                    Utility.loadingDots();
                                                } else {
                                                    System.out.print("Old password incorrect.\nPress Enter to continue...");
                                                    Utility.getch();
                                                }
                                                break;
                                            }
                                            case 2: {   // Delete Account
                                                if (client.getBpoManagerUsername() != null) {
                                                    System.out.print("Contract termination required before deleting account.\nAsk current BPO Manager " + client.getBpoManagerUsername() + " to terminate contract.\nPress Enter to continue...");
                                                    Utility.getch();
                                                    break;
                                                }
                                                System.out.print("This action is irreversible.\n" +
                                                    "You will have to create a new account.\n" +
                                                    "BPO Manager mapping will be deleted.\n" +
                                                    "All tasks will be deleted\n" +
                                                    "Are you sure you want to delete the account?[Y/N]: ");
                                                char ans = sc.next().charAt(0);
                                                Character.toLowerCase(ans);
                                                int indexToDelete = -1;
                                                if (ans == 'y') {
                                                    for (int i = 0; i < clients.size(); i++) {
                                                        if (clients.get(i+1).getUsername().equals(client.getUsername())) {
                                                            indexToDelete = i;
                                                            break;
                                                        }
                                                    }
                                                }
                                                try {
                                                    clients.remove(indexToDelete);
                                                    System.out.print("User has been deleted.Exiting application");
                                                    Utility.loadingDots();
                                                    return;
                                                } catch (IndexOutOfBoundsException e) {
                                                    System.out.println("Something went wrong. Couldn't delete account.");
                                                }
                                                break;
                                            }
                                            case 0: {
                                                break;
                                            }
                                            default:
                                                break;
                                        }
                                        break;
                                    }
                                    case 0: { // Logout
                                        Utility.clearConsoleScreen();
                                        System.out.print("Logging out");
                                        Utility.loadingDots();
                                        continue;
                                    }
                                    default:
                                        break;
                                }
                            }
                        } else {
                            System.out.print("Incorrect password.\nPress Enter to continue...");
                            Utility.getch();
                        }
                    } else {
                        System.out.print("User " + username + " not found.\nPress Enter to continue...");
                        Utility.getch();
                    }
                    break;
                }
                case 2: { // BPO Manager Login
                    Utility.clearConsoleScreen();
                    BPOManager bpoManager = BPOManager.searchBpoManager(bpoManagers, username);
                    if (bpoManager != null) {
                        if (bpoManager.checkPassword(password)) {
                            System.out.print("Welcome " + bpoManager.getUsername());
                            Utility.loadingDots();
                            while (opt2 != 0) {
                                Utility.clearConsoleScreen();
                                System.out.println("BPO Manager Portal");
                                System.out.println(
                                        "1. View your clients\n2. Create new client contract\n3. Terminate a client contract\n4. Add a task\n5. View all tasks\n6. Account Details\n0. Logout");
                                System.out.print("> ");
                                opt2 = sc.nextInt();
                                sc.nextLine();

                                switch (opt2) {
                                    case 1: { // View your clients
                                        Utility.clearConsoleScreen();
                                        System.out.println("My Clients");
                                        int i = 1;
                                        for (String client : bpoManager.getClients()) {
                                            System.out.println(i + ". " + client);
                                            i++;
                                        }
                                        System.out.print("Press Enter to continue...");
                                        Utility.getch();
                                        break;
                                    }
                                    case 2: { // Create new client contract
                                        Utility.clearConsoleScreen();
                                        System.out.println("Choose from the available client numbers.");
                                        int avlClients = 0;
                                        for (int i = 0; i < clients.size(); i++) {
                                            if (clients.get(i + 1).getBpoManagerUsername() == null) {
                                                avlClients++;
                                                System.out.println(
                                                        "[" + (i + 1) + "] " + clients.get(i + 1).getUsername());
                                            }
                                        }
                                        if (avlClients == 0) {
                                            System.out.print("No available clients\nPress Enter to continue...");
                                            Utility.getch();
                                            break;
                                        }
                                        System.out.println("0. Go back to BPO Manager Portal");
                                        System.out.print("> ");
                                        int clientNo = 0;
                                        clientNo = sc.nextInt();
                                        sc.nextLine();
                                        if (clientNo == 0) {
                                            break;
                                        }
                                        Client currClient = clients.get(clientNo);
                                        if (currClient != null && currClient.getBpoManagerUsername() == null) {
                                            currClient.setBpoManagerUsername(bpoManager.getUsername());
                                            bpoManager.addClient(currClient.getUsername());
                                            System.out.print("Contract signed with client " + currClient.getUsername());
                                            Utility.loadingDots();
                                        } else {
                                            System.out.println("Invalid choice.\nPress Enter to continue...");
                                            Utility.getch();
                                        }

                                        break;
                                    }
                                    case 3: { // Terminate a client contract
                                        Utility.clearConsoleScreen();
                                        System.out.println("My Clients");
                                        int i = 1;
                                        if (bpoManager.getClientCount() <= 0) {
                                            System.out.print("No active client contracts. Press Enter to continue...");
                                            Utility.getch();
                                            break;
                                        }
                                        for (String client : bpoManager.getClients()) {
                                            System.out.println(i + ". " + client);
                                            i++;
                                        }
                                        System.out.println("0. Go back to BPO Manager Portal");
                                        System.out.print("> ");
                                        int clientNo = 0;
                                        clientNo = sc.nextInt();
                                        sc.nextLine();
                                        if (clientNo == 0) {
                                            break;
                                        }
                                        Client currClient;
                                        try {
                                            currClient = Client.searchClient(clients,
                                                    bpoManager.getClients().get(clientNo - 1));
                                        } catch (IndexOutOfBoundsException e) {
                                            System.out.print("Invalid choice.\nPress Enter to continue...");
                                            Utility.getch();
                                            break;
                                        }
                                        if (currClient != null && currClient.getBpoManagerUsername() != null) {
                                            currClient.removeBpoManagerUsername();
                                            bpoManager.removeClient(currClient.getUsername());
                                            currClient.clearTasks();
                                            System.out.print(
                                                    "Contract terminated with client " + currClient.getUsername());
                                            Utility.loadingDots();
                                        } else {
                                            System.out.println("Invalid choice.\nPress Enter to continue...");
                                            Utility.getch();
                                        }
                                        break;
                                    }
                                    case 4: { // Add a task
                                        Utility.clearConsoleScreen();
                                        System.out.println("My Clients.\nChoose a client to add a task.");
                                        if (bpoManager.getClientCount() <= 0) {
                                            System.out.println(
                                                    "No current active client contracts.\nPress Enter to continue...");
                                            Utility.getch();
                                            break;
                                        }
                                        int i = 1;
                                        for (String client : bpoManager.getClients()) {
                                            System.out.println(i + ". " + client);
                                            i++;
                                        }
                                        System.out.println("0. Go back to BPO Manager Portal");
                                        System.out.print("> ");
                                        int clientNo = 0;
                                        clientNo = sc.nextInt();
                                        sc.nextLine();
                                        if (clientNo == 0) {
                                            break;
                                        }
                                        Client currClient;
                                        try {
                                            currClient = Client.searchClient(clients,
                                                    bpoManager.getClients().get(clientNo - 1));
                                        } catch (IndexOutOfBoundsException e) {
                                            System.out.print("Invalid choice.\nPress Enter to continue...");
                                            Utility.getch();
                                            break;
                                        }
                                        if (currClient != null && currClient.getBpoManagerUsername() != null) {
                                            System.out.print("Enter a task description: ");
                                            String taskDesc = sc.nextLine();
                                            if (taskDesc.trim().isEmpty()) {
                                                System.out.println(
                                                        "Task description cannot be empty.\nPress Enter to continue...");
                                                Utility.getch();
                                                break;
                                            }
                                            currClient.addTask(taskDesc);
                                            System.out.print("Task \"" + taskDesc + "\" added for client "
                                                    + currClient.getUsername());
                                            Utility.loadingDots();
                                        } else {
                                            System.out.println("Invalid choice.\nPress Enter to continue...");
                                            Utility.getch();
                                        }
                                        break;
                                    }
                                    case 5: { // View all tasks
                                        Utility.clearConsoleScreen();
                                        int taskCountTotal = 0;
                                        for (String clientUname : bpoManager.getClients()) {
                                            taskCountTotal += Client.searchClient(clients, clientUname).getTasksCount();
                                        }
                                        System.out.println(taskCountTotal + " tasks assigned across "
                                                + bpoManager.getClientCount() + " clients");
                                        int i = 1;
                                        System.out.println(
                                                "==============================================================");
                                        for (String client : bpoManager.getClients()) {
                                            System.out.println(i + ". " + client);
                                            System.out.println(
                                                    "--------------------------------------------------------------");
                                            Client currClient = Client.searchClient(clients, client);
                                            int j = 1;
                                            for (String task : currClient.getTasks()) {
                                                System.out.println("\t" + j + ". " + task);
                                                j++;
                                            }
                                            i++;
                                            System.out.println(
                                                    "==============================================================");
                                        }
                                        System.out.print("Press Enter to continue...");
                                        Utility.getch();
                                        break;
                                    }
                                    case 6: { // Account Details
                                        Utility.clearConsoleScreen();
                                        int taskCountTotal = 0;
                                        for (String clientUname : bpoManager.getClients()) {
                                            taskCountTotal += Client.searchClient(clients, clientUname).getTasksCount();
                                        }
                                        System.out.println("BPO Manager user account");
                                        System.out.println("Username: " + bpoManager.getUsername()
                                                + "\nActive contracts: " + bpoManager.getClientCount()
                                                + "\nTotal pending tasks: " + taskCountTotal);
                                        System.out.print("Press Enter to continue...");
                                        Utility.getch();
                                        break;
                                    }
                                    case 0: { // Logout
                                        Utility.clearConsoleScreen();
                                        System.out.print("Logging out");
                                        Utility.loadingDots();
                                        break;
                                    }
                                    default:
                                        break;
                                }
                            }
                        } else {
                            System.out.print("Incorrect password.\nPress Enter to continue...");
                        }
                    } else {
                        System.out.print("User " + username + " not found.\nPress Enter to continue...");
                    }
                    break;
                }
                case 3: { // Register new user
                    Utility.clearConsoleScreen();
                    registerNewUser();
                    break;
                }
                case 0: { // Exit
                    Utility.clearConsoleScreen();
                    System.out.print("Exiting");
                    Utility.loadingDots();
                    return;
                }
                default:
                    System.out.println("Invalid Option. Try again\nPress Enter to continue...");
                    Utility.getch();
                    break;
            }
        }
        sc.close();
    }
}
