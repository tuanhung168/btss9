package bt1;

import java.util.ArrayList;

public class PhoneBook  extends Phone{

    private ArrayList<String> phoneList;

    public PhoneBook() {
        phoneList = new ArrayList<>();
    }
    public void getAll() {
    for (String phone : phoneList){
        System.out.println(phone);
    }
    }

    @Override
    public void insertPhone(String name, String phone) {
        for (int i = 0; i < phoneList.size(); i++) {
            String entry = phoneList.get(i);
            if (entry.startsWith(name)) {
                String existingPhone = entry.substring(entry.indexOf(":") + 2);
                if (!existingPhone.equals(phone)) {
                    entry += " : " + phone;
                    phoneList.set(i, entry);
                    System.out.println("Đã cập nhật số điện thoại mới cho " + name);
                } else {
                    System.out.println("Số điện thoại đã tồn tại cho " + name);
                }
                return;
            }
        }
        phoneList.add(name + " : " + phone);
        System.out.println("Đã thêm số điện thoại cho " + name);
    }

    @Override
    public void removePhone(String name) {
        int removedEntries = 0;
        for (int i = 0; i < phoneList.size(); i++) {
            String entry = phoneList.get(i);
            if (entry.startsWith(name)) {
                phoneList.remove(i);
                removedEntries++;
                i--; // Adjust the index after removing an entry
            }
        }
        if (removedEntries > 0) {
            System.out.println("Đã xóa " + removedEntries + " số điện thoại của " + name);
        } else {
            System.out.println("Không tìm thấy số điện thoại của " + name);
        }
    }

    @Override
    public void updatePhone(String name, String newPhone) {
        boolean updated = false;
        for (int i = 0; i < phoneList.size(); i++) {
            String entry = phoneList.get(i);
            if (entry.startsWith(name)) {
                entry = name + " : " + newPhone;
                phoneList.set(i, entry);
                updated = true;
                break;
            }
        }
        if (updated) {
            System.out.println("Đã cập nhật số điện thoại mới cho " + name);
        } else {
            System.out.println("Không tìm thấy số điện thoại của " + name);
        }
    }

    @Override
    public void searchPhone(String name) {
        for (String entry : phoneList) {
            if (entry.startsWith(name)) {
                System.out.println("Số điện thoại của " + entry);
                return;
            }
        }
        System.out.println("Không tìm thấy số điện thoại của " + name);
    }

    @Override
    public void sort() {
        phoneList.sort((entry1, entry2) -> {
            String name1 = entry1.substring(0, entry1.indexOf(":")).trim();
            String name2 = entry2.substring(0, entry2.indexOf(":")).trim();
            return name1.compareToIgnoreCase(name2);
        });
        System.out.println("Đã sắp xếp danh bạ theo tên người dùng.");
    }
}
