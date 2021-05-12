package controller;

import model.PhoneDirectory;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDirectoryManager {
    private String name;
    private List<PhoneDirectory> list = new ArrayList<>();
    private static PhoneDirectoryManager INSTASCE;

    private PhoneDirectoryManager() {
    }

    private PhoneDirectoryManager(String name, List<PhoneDirectory> list) {
        this.name = name;
        this.list = list;
    }
    public static PhoneDirectoryManager getInstance(String name,List<PhoneDirectory> list){
        if (INSTASCE == null){
            INSTASCE = new PhoneDirectoryManager(name,list);
        }return INSTASCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneDirectory> getList() {
        return list;
    }

    public void setList(List<PhoneDirectory> list) {
        this.list = list;
    }

    public static void setINSTASCE(PhoneDirectoryManager INSTASCE) {
        PhoneDirectoryManager.INSTASCE = INSTASCE;
    }
//    Thêm danh bạ
    public void addPhoneDirectory(PhoneDirectory phoneDirectory) throws IOException {
        list.add(phoneDirectory);
        System.out.println("Đã thêm thành công");
        FileManager fileManager = FileManager.getInstance("Sang");
        fileManager.writeFile(list);

    }
//    Sửa danh bạ
    public void editPhoneDirectory(String phoneNumber,PhoneDirectory phoneDirectory) throws IOException {
        for(int i = 0; i< list.size();i++){
            if (list.get(i).getPhoneNumber().equals(phoneNumber)){
                list.set(i,phoneDirectory);
                System.out.println("Đã sửa thành công");
                FileManager fileManager = FileManager.getInstance("Sang");
                fileManager.writeFile(list);
            }
        }
    }
//    Xoá danh bạ
    public void deletePhoneDirectory(PhoneDirectory phoneDirectory) throws IOException {
        list.remove(phoneDirectory);
        System.out.println("Đã xoá thành công");
        FileManager fileManager = FileManager.getInstance("Sang");
        fileManager.writeFile(list);
    }
//    Tiimf danh bạ theo số điện thoại
    public PhoneDirectory find(String numberphone){
        PhoneDirectory phoneDirectory = null;
        for (int i =0; i<list.size();i++){
            if (list.get(i).getPhoneNumber().equals(numberphone)){
                return list.get(i);
            }
        }return phoneDirectory;
    }
//    Hiển thị
    public void showall(){
        for (PhoneDirectory p:list
             ) {
            System.out.println(p.toString());
        }
    }
}
