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
        System.out.println("1. Register Client\n2. Register BPO Manager\n0. Back to main menu");
        System.out.print("> ");
        opt = sc.nextInt();
        sc.nextLine(); // consume the newline character

        if (opt == 1 || opt == 2 || opt == 3) {
            Utility.clearConsoleScreen();
            System.out.println(texts.get(opt) + " Register");
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("[Input will not be visible]\nPassword: ");
            char[] chararr = con.readPassword();
            password = String.valueOf(chararr);
            System.out.print("Confirm Password: ");
            chararr = con.readPassword();
            confirmPass = String.valueOf(chararr);
            if (!password.equals(confirmPass)) {
                System.out.print("Password and Confirm password should be same.\nPress any key to continue...");
                Utility.getch();
                return;
            }
        }

        switch (opt) {
            case 1: {
                // if (Client.searchClient(clients, username) == null) {
                    clients.put(clients.size() + 1, new Client(username, password));
                // } else {
                //     System.out.print("User " + username + " already exists.\nPress any key to continue...");
                // }
                if (Client.searchClient(clients, username) != null) {
                    System.out.print("Client user created successfully.\nPress any key to continue...");
                } else {
                    System.out.print("There was an error creating the user\nPress any key to continue...");
                }
                Utility.getch();
                break;
            }
            case 2: {
                bpoManagers.add(new BPOManager(username, password));
                if (BPOManager.searchBpoManager(bpoManagers, username) != null) {
                    System.out.print("BPO Manager user created successfully.\nPress any key to continue...");
                } else {
                    System.out.print("There was an error creating the user\nPress any key to continue...");
                }
                Utility.getch();
                break;
            }
            case 0: {
                break;
            }
            default:
                System.out.println("Invalid Option. Try again\nPress any key to continue...");
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

        /***************************************************
         * Execution start
         ***************************************************/
        while (opt != 0) {
            opt = 99; opt1 = 99; opt2 = 99;
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
                System.out.print("Password: ");
                char[] chararr = con.readPassword();
                password = String.valueOf(chararr);
            }

            switch (opt) {
                case 1: {   // Client Login
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
                                            .println("1. View Tasks\n2. Complete tasks\n3. Account Details\n0. Logout");
                                    System.out.print("> ");
                                    opt1 = sc.nextInt();
                                    sc.nextLine();
                                } else {
                                    System.out.print(
                                            "[BPO Manager is not assigned yet. Actions will be visible once a BPO Manager is assigned to your user.]\nPress any key to continue...");
                                    Utility.getch();
                                    break;
                                }

                                switch (opt1) {
                                    case 1: {

                                        break;
                                    }
                                    case 2: {

                                        break;
                                    }
                                    case 3: {
                                        Utility.clearConsoleScreen();
                                        System.out.println("Client user account");
                                        System.out.println("Client user: " + client.getUsername() + "\nBPO Manager: "
                                                + client.getBpoManagerUsername() + "\nPending Tasks: "
                                                + client.getTasksCount());
                                        System.out.print("Press any key to continue...");
                                        Utility.getch();
                                        break;
                                    }
                                    case 0: {
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
                            System.out.print("Incorrect password.\nPress any key to continue...");
                        }
                    } else {
                        System.out.print("User " + username + " not found.\nPress any key to continue...");
                    }
                    break;
                }
                case 2: {   // BPO Manager Login
                    Utility.clearConsoleScreen();
                    BPOManager bpoManager = BPOManager.searchBpoManager(bpoManagers, username);
                    if (bpoManager != null) {
                        if (bpoManager.checkPassword(password)) {
                            System.out.print("Welcome " + bpoManager.getUsername());
                            Utility.loadingDots();
                            while (opt2 != 0) {
                                Utility.clearConsoleScreen();
                                System.out.println("Client Portal");
                                System.out.println("1. View your clients\n2. Create new client contract\n3. Terminate a client contract\n4. Add a task\n5. View all tasks\n6. Account Details\n0. Logout");
                                System.out.print("> ");
                                opt2 = sc.nextInt();
                                sc.nextLine();

                                switch (opt2) {
                                    case 1: {
                                        Utility.clearConsoleScreen();
                                        System.out.println("My Clients");
                                        int i = 1;
                                        for (String client : bpoManager.getClients()) {
                                            System.out.println(i + ". " + client);
                                            i++;
                                        }
                                        System.out.print("Press any key to continue...");
                                        Utility.getch();
                                        break;
                                    }
                                    case 2: {
                                        int clientNo = 0;
                                        Utility.clearConsoleScreen();
                                        System.out.println("Choose from the available client numbers.");
                                        int avlClients = 0;
                                        for (int i = 0; i < clients.size(); i++) {
                                            if (clients.get(i+1).getBpoManagerUsername() == null) {
                                                avlClients++;
                                                System.out.println((i + 1) + ". " + clients.get(i+1).getUsername());
                                            }
                                        }
                                        if (avlClients == 0) {
                                            System.out.print("No available clients\nPress any key to continue...");
                                            Utility.getch();
                                            break;
                                        }
                                        System.out.print("> ");
                                        clientNo = sc.nextInt();
                                        sc.nextLine();
                                        Client currClient = clients.get(clientNo);
                                        if (currClient != null && currClient.getBpoManagerUsername() == null) {
                                            currClient.setBpoManagerUsername(bpoManager.getUsername());
                                            bpoManager.addClient(currClient.getUsername());
                                        } else {
                                            System.out.println("Invalid choice.\nPress any key to continue...");
                                            Utility.getch();
                                        }
                                        
                                        break;
                                    }
                                    case 3: {
                                        
                                        break;
                                    }
                                    case 4: {
                                        
                                        break;
                                    }
                                    case 5: {
                                        
                                        break;
                                    }
                                    case 6: {
                                        
                                        break;
                                    }
                                    case 0: {
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
                            System.out.print("Incorrect password.\nPress any key to continue...");
                        }
                    } else {
                        System.out.print("User " + username + " not found.\nPress any key to continue...");
                    }
                    break;
                }
                case 3: {   // Register new user
                    Utility.clearConsoleScreen();
                    registerNewUser();
                    break;
                }
                case 0: {   // Exit
                    Utility.clearConsoleScreen();
                    System.out.print("Exiting");
                    Utility.loadingDots();
                    return;
                }
                default:
                    System.out.println("Invalid Option. Try again\nPress any key to continue...");
                    Utility.getch();
                    break;
            }
        }
        sc.close();
    }
}
