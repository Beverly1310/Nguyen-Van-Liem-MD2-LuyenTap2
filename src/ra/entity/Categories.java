package ra.entity;

import java.util.Scanner;

public class Categories {
    public static int count=0;
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
        this.catalogStatus=true;
        this.catalogId=++count;
    }

    public Categories( String catalogName, String descriptions) {
        this.catalogId=++count;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = true;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
    public void inputData(Scanner scanner, Categories[] arrCategories){
        while (true){
            System.out.println("Nhap ten danh muc:");
            String inputName = scanner.nextLine();
            boolean checkExsist = false;
            for (int i = 0; i < arrCategories.length; i++) {
                if (arrCategories[i] != null) {
                    if (arrCategories[i].getCatalogName().equals(inputName)) {
                        System.out.println("Ten da ton tai");
                        checkExsist = true;
                        break;
                    }
                }
            }
            boolean checkLength=false;
            if (inputName.length()>50){
                checkLength=true;
                System.out.println("Toi da 50 ky tu");
            }
            if (!checkExsist&&!checkLength){
                this.setCatalogName(inputName);
                break;
            }
        }
        System.out.println("Nhap mo ta cho danh muc: ");
        this.descriptions=scanner.nextLine();
        System.out.println("Nhap trang thai(true/false): ");
        this.catalogStatus=Boolean.parseBoolean(scanner.nextLine());
    }



    public void displayData(){
        System.out.println(
                "Ma danh muc: " + catalogId +
                "\nTen danh muc: " + catalogName  +
                "\nMo ta: " + descriptions  +
                "\nTrang thai:" + (catalogStatus? "Hoat dong":"Khong hoat dong") );
        System.out.println("============================================");
    }
}
