package ra.business;

import ra.design.IProduct;
import ra.entity.Categories;
import ra.entity.Product;

import java.text.ParseException;
import java.util.Scanner;

import static ra.business.CategoriesImplement.arrCategories;

public class ProductsImplement implements IProduct {
    public static Product[] arrProduct = new Product[100];

    @Override
    public int findById(String inputId) {
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                if (arrProduct[i].getProductId().equals(inputId)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void createData(Scanner scanner) {
        System.out.println("Nhap so san pham muon them");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            Product newProduct = new Product();
            System.out.println("Nhap thong tin cho san pham thu " + (i + 1));
            newProduct.inputData(scanner, arrProduct, arrCategories);
            for (int j = 0; j < arrProduct.length; j++) {
                if (arrProduct[i] == null) {
                    arrProduct[i] = newProduct;
                    break;
                }
            }
        }
    }

    @Override
    public void readData() {
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                arrProduct[i].displayData();
            }
        }
    }

    @Override
    public void updateData(Scanner scanner) {
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                System.out.println("Ma san pham: " + arrProduct[i].getProductId() + " || Ten san pham: " + arrProduct[i].getProductName());
            }
        }
        System.out.println("Nhap Id san pham");
        String inputId = scanner.nextLine();
        int byId = findById(inputId);
        if (byId != -1) {
            arrProduct[byId].displayData();
            Product newProduct = new Product();
            arrProduct[byId]=newProduct;
            arrProduct[byId].inputData(scanner, arrProduct, arrCategories);
        } else System.out.println("San pham khong ton tai");
    }


    @Override
    public void sortProduct() {

        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                for (int j = i + 1; j < arrProduct.length; j++) {
                    if (arrProduct[j] != null) {
                        if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                            Product tg = arrProduct[i];
                            arrProduct[i] = arrProduct[j];
                            arrProduct[j] = tg;
                        }
                    }
                }
            }
        }
        readData();
    }

    @Override
    public void searchProduct(Scanner scanner) {
        System.out.println("Nhap ten san pham");
        String inputName = scanner.nextLine();
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                if (arrProduct[i].getProductName().equals(inputName)) {
                    arrProduct[i].displayData();
                    break;
                }
            }
        }
    }

    @Override
    public void searchWithin(Scanner scanner) {
        System.out.println("Nhap gia toi thieu");
        float fistPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhap gia toi da");
        float lastPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Danh sach san pham trong tam gia");
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                if (arrProduct[i].getPrice() >= fistPrice && arrProduct[i].getPrice() <= lastPrice) {
                    arrProduct[i].displayData();
                }
            }
        }
    }

    @Override
    public void deleteData(Scanner scanner) {
        System.out.println("Nhap Id san pham: ");
        String inputId = scanner.nextLine();
        int byId = findById(inputId);
        if (byId != -1) {
            Product[] newArr = new Product[99];
            for (int i = 0; i < byId; i++) {
                newArr[i] = arrProduct[i];
            }
            for (int i = byId; i < 99; i++) {
                newArr[i] = arrProduct[i + 1];
            }
            arrProduct = newArr;
        } else {
            System.out.println("San pham khong ton tai");
        }
    }
}
