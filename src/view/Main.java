package view;

import controller.PhoneDirectoryManager;
import model.PhoneDirectory;
import storage.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PhoneDirectory> list = new ArrayList<>();
        PhoneDirectoryManager manager = PhoneDirectoryManager.getInstance("Sang",list);
        FileManager fileManager = FileManager.getInstance("Sang");
        try {
            list = fileManager.readFile("phone.dat");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        menu(manager);

    }
    public static void menu(PhoneDirectoryManager manager){

        int choice = 0;
        while (choice!=6){
            System.out.println("_____Danh bạ Điện Thoại______");
            System.out.println("Nhấn 1: Xem Danh Sách: ");
            System.out.println("Nhấn 2: Thêm mới: ");
            System.out.println("Nhấn 3: Cập nhật: ");
            System.out.println("Nhấn 4: Xoá: ");
            System.out.println("Nhấn 5: Tìm Kiếm: ");
            System.out.println("Nhấn 6: Thoát ");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                {
                    List<PhoneDirectory>list = manager.getList();
                    if (list.size()>0){
                        manager.showall();
                    }else {
                        System.out.println("Danh bạ trống");
                    }

                    break;
                }
                case 2:
                {
                    PhoneDirectory phoneDirectory = createNewPhoneDirectory();
                    try {
                        manager.addPhoneDirectory(phoneDirectory);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                case 3:
                {
                    System.out.println("Nhập số điện thoai bạn muốn sửa");
                    Scanner scanner1 = new Scanner(System.in);
                    String numberPhone = scanner1.nextLine();
                    PhoneDirectory phoneDirectory= manager.find(numberPhone);
                    if (phoneDirectory!=null){
                        PhoneDirectory phoneDirectory1 = createNewPhoneDirectory();
                        try {
                            manager.editPhoneDirectory(numberPhone,phoneDirectory1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    break;
                }
                case 4:
                {
                    System.out.println("Nhập số điieenj thoại muốn xoá:");
                    Scanner scanner1 = new Scanner(System.in);
                    String numberPhone = scanner1.nextLine();
                    PhoneDirectory phoneDirectory = manager.find(numberPhone);
                    if (phoneDirectory!=null){
                        try {
                            manager.deletePhoneDirectory(phoneDirectory);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("Không có danh số điện thhoaij nào trong danh bạ");
                    }

                    break;
                }
                case 5:
                {
                    System.out.println("Nhập vào số điện thoại bạn cần tìm kiếm: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String numberPhone = scanner1.nextLine();
                    PhoneDirectory phoneDirectory = manager.find(numberPhone);
                    if (phoneDirectory!=null){
                        System.out.println(phoneDirectory.toString());
                    }else {
                        System.out.println("KHông có thôngn tin về số điện thoại này trong danh bạ");
                    }
                    break;
                }
                case 6:
                {
                    break;
                }
            }

        }
    }

    public static PhoneDirectory createNewPhoneDirectory(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập Địa chỉ: ");
        String address = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập Email: ");
        String email = scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập FaceBook: ");
        String faceBook = scanner4.nextLine();

        PhoneDirectory phoneDirectory = new PhoneDirectory(name,phoneNumber,address,email,faceBook);
        return phoneDirectory;
    }
}
