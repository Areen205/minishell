import java.util.Scanner;
public class MiniShell{

    public static void main(String[] args) {

            ShellCommandHandler handler = new ShellCommandHandler();
            Scanner scanner = new Scanner(System.in);
            String command;

            while (true) {
                handler.printWorkingDirectory();
                System.out.print("> ");
                command = scanner.nextLine().trim();


                if (command.equals("exit")){
                    break;
                } else if (command.equals("ls")) {
                    handler.listDirectory();
                } else if (command.startsWith("cd ")){
                    String dirName = command.substring(3).trim();
                    handler.changeDirectory(dirName);
                } else if (command.startsWith("mkdir ")) {
                    String dirName = command.substring(6).trim();
                    handler.makeDirectory(dirName);
                } else if (command.startsWith("touch ")){
                    String fileName = command.substring(6).trim();
                    handler.createFile(fileName);
                } else if (command.equals("help")) {
                    handler.printHelp();
                } else if (command.equals("pwd")){
                    handler.printWorkingDirectory();
                } else{
                    System.out.println("Unknown command. Type 'help' to see available commands. ");
                }
            }


            scanner.close();
            System.out.println("Exiting MiniShell. Goodbye! ");
        }
    }


