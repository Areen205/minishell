import java.io.File;
import java.io.IOException;

public class ShellCommandHandler{
    private File currentDirectory;


        public ShellCommandHandler(){
            this.currentDirectory = new File(System.getProperty("user.dir"));
        }


        public void printWorkingDirectory(){
            System.out.println("Current Directory:" + currentDirectory.getAbsolutePath());
        }


        public void listDirectory(){
            String[] files = currentDirectory.list();
            if (files != null) {
                System.out.println("Files and directories in" + currentDirectory.getAbsolutePath() + ":");
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("The directory is empty or an error occurred.  ");
            }
        }


        public void changeDirectory(String name){
            File newDirectory = new File(currentDirectory, name);
            if (newDirectory.isDirectory()){
                currentDirectory = newDirectory;
                System.out.println("Changed directory to: " + currentDirectory.getAbsolutePath());
            } else{
                System.out.println("No such directory:  " + name);
            }
        }


        public void makeDirectory(String name){
            File newDir = new File(currentDirectory, name);
            if (newDir.mkdir()){
                System.out.println("Directory created:  " + newDir.getAbsolutePath());
            } else{
                System.out.println("Failed to create directory:  " + name);
            }
        }


        public void createFile(String name) {
            File newFile = new File(currentDirectory, name);
            try{
                if (newFile.createNewFile()) {
                    System.out.println("File created:  " + newFile.getAbsolutePath());
                } else{
                    System.out.println("File already exists:  " + name);
                }
            } catch (IOException e) {
                System.out.println("Error creating file:  " + e.getMessage());
            }
        }


        public void printHelp(){
            System.out.println("Supported commands: ");
            System.out.println("pwd - Print working directory ");
            System.out.println("ls - List directory contents ");
            System.out.println("cd <directory> - Change directory ");
            System.out.println("mkdir <directory> - Create a new directory ");
            System.out.println("touch <file> - Create a new file  ");
            System.out.println("help - Show this help message   ");
            System.out.println("exit - Exit the shell    ");
        }


        public File getCurrentDirectory(){
            return currentDirectory;
        }

    }












