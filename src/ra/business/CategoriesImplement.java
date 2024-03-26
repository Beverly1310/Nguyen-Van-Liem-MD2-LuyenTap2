package ra.business;

import ra.design.ICategories;
import ra.entity.Categories;

import java.util.Scanner;

import static ra.business.ProductsImplement.arrProduct;

public class CategoriesImplement implements ICategories {
    public static Categories[] arrCategories = new Categories[100];


    @Override
    public int findById(int inputId) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories != null) {
                if (arrCategories[i].getCatalogId() == inputId) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public void createData(Scanner scanner) {
        System.out.println("Nhap so danh muc muon tao");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Categories newCategories = new Categories();
            System.out.println("Nhap thong tin cho danh muc thu " + (i + 1));
            newCategories.inputData(scanner, arrCategories);
            for (int j = 0; j < arrCategories.length; j++) {
                if (arrCategories[j] == null) {
                    arrCategories[j] = newCategories;
                    break;
                }
            }
        }
    }

    @Override
    public void readData() {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null) {
                arrCategories[i].displayData();
            }
        }
    }

    @Override
    public void updateData(Scanner scanner) {
        for (int i = 0; i < arrCategories.length; i++) {
            if (arrCategories[i] != null) {
                System.out.println("Ma danh muc: " + arrCategories[i].getCatalogId() + " || Ten danh muc: " + arrCategories[i].getCatalogName());
            }
        }
        System.out.println("Nhap Id danh muc: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        int byId = findById(inputId);
        if (byId != -1) {
            arrCategories[byId].displayData();
            Categories newCategori = new Categories();
            arrCategories[byId]=newCategori;
            arrCategories[byId].inputData(scanner, arrCategories);
        } else {
            System.out.println("Danh muc khong ton tai");
        }
    }

    @Override
    public void deleteData(Scanner scanner) {
        System.out.println("Nhap Id danh muc: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        int byId = findById(inputId);
        if (byId != -1) {
            boolean flag = true;
            for (int i = 0; i < arrProduct.length; i++) {
                if (arrCategories[i]!=null){
                if (arrProduct[i].getCatalogId() == arrCategories[byId].getCatalogId()) {
                    flag = false;
                    break;
                }
                }
            }
            if (flag) {
                Categories[] newArr = new Categories[99];
                for (int i = 0; i < byId; i++) {
                    newArr[i] = arrCategories[i];
                }
                for (int i = byId; i < 99; i++) {
                    newArr[i] = arrCategories[i + 1];
                }
                arrCategories = newArr;
            }
        } else {
            System.out.println("Danh muc khong ton tai");
        }
    }

    @Override
    public void changeStatus(Scanner scanner) {
        System.out.println("Nhap Id danh muc: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        int byId = findById(inputId);
        if (byId != -1) {
            if (arrCategories[byId].isCatalogStatus()) {
                arrCategories[byId].setCatalogStatus(false);
            } else {
                arrCategories[byId].setCatalogStatus(true);
            }
            System.out.println("Thay doi thanh cong");
        } else {
            System.out.println("Danh muc khong ton tai");
        }
    }

}
