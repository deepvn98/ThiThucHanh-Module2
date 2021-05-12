package storage;

import model.PhoneDirectory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private String name;
    private static FileManager INSTACE;

    public FileManager(String name) {
        this.name = name;
    }
    public static FileManager getInstance(String name){
        if (INSTACE == null){
            INSTACE =new FileManager(name);
        }return INSTACE;
    }
    public void writeFile(List<PhoneDirectory>phoneDirectories) throws IOException {
        File file = new File("phone.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(phoneDirectories);
        objectOutputStream.close();
        fileOutputStream.close();
    }
    public List<PhoneDirectory> readFile(String file1) throws IOException, ClassNotFoundException {
        File file = new File(file1);
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length()>0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            List<PhoneDirectory> phoneDirectories =(List<PhoneDirectory>) obj;
            return phoneDirectories;
        }else {
            return new ArrayList<>();
        }

    }
    public FileManager() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public static FileManager getINSTACE() {
//        return INSTACE;
//    }

    public static void setINSTACE(FileManager INSTACE) {
        FileManager.INSTACE = INSTACE;
    }
}
