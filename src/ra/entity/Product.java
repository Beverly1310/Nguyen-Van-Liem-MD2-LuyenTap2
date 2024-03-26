package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
    public void inputData(Scanner scanner, Product[] arrProduct,  Categories[] arrCategories)  {
        boolean flagId = true;
        while (flagId) {
            System.out.println("Nhap ma san pham: ");
            String inputId = scanner.nextLine();
            if (inputId.matches("^[CSA].{3}$")) {
                for (int i = 0; i < arrProduct.length; i++) {
                    if (arrProduct[i].getProductId().equals(inputId)) {
                        System.out.println("Id da ton tai: ");
                        break;
                    } else {
                        this.productId = inputId;
                        flagId = false;
                        break;
                    }
                }
            } else {
                System.out.println("Phai dung dinh dang C/S/A___");
            }
        }
        boolean flagName = true;
        while (flagName) {
            System.out.println("Nhap ten san pham: ");
            String inputName = scanner.nextLine();
            if (inputName.length() >= 10 && inputName.length() <= 50) {
                for (int i = 0; i < arrProduct.length; i++) {
                    if (arrProduct[i].getProductName().equals(inputName)) {
                        System.out.println("ten da ton tai: ");
                        break;
                    } else {
                        this.productName = inputName;
                        flagName = false;
                        break;
                    }
                }
            } else {
                System.out.println("Do dai phai trong khoang 10-50 ky tu");
            }
        }
        while (true) {
            System.out.println("Nhap gia cho san pham:");
            float inputPrice =Float.parseFloat(scanner.nextLine());
            if (inputPrice>0){
                this.price=inputPrice;
                break;
            }
            else {
                System.out.println("Gia san pham phai lon hon 0");
            }
        }
        SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyy");
        while (true){
            System.out.println("Ngay nhap san pham:");
            String inputDate =scanner.nextLine();
            if (inputDate.matches("^\\d{2}/\\d{2}/\\d{4}$")){
                try {
                    this.created=sdf.parse(inputDate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            else {
                System.out.println("Ngay khong dung dinh dang");
            }
        }
        boolean flagCateId=true;
        while (flagCateId) {
            if (arrCategories.length > 0) {
                for (int i = 0; i < arrCategories.length; i++) {
                    System.out.printf("%-5s", arrCategories[i].getCatalogId());
                }
            } else {
                System.out.println("Khong co danh muc nao,hay them danh muc ");
                break;
            }
            System.out.println("Nhap ma danh muc san pham: ");
            int inputCateId = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < arrCategories.length; i++) {
                if (inputCateId == arrCategories[i].getCatalogId()) {
                    flagCateId=false;
                    break;
                }
            }
            if (flagCateId){
                System.out.println("Khong co danh muc phu hop");
            }else {
                this.catalogId = inputCateId;
                break;
            }
        }
        System.out.println("Nhap trang thai san pham: ");
        productStatus=Integer.parseInt(scanner.nextLine());
    }



    public void displayData(){
        System.out.println(
                "Ma san pham: " + productId + '\'' +
                "\nTen san pham: " + productName + '\'' +
                "\nGia: " + price +
                "\nMo ta: " + description + '\'' +
                "\nNgay nhap: " + created.toString() +
                "\nMa danh muc" + catalogId +
                "\nTrang thai" + (productStatus==0 ? "Dang ban" : (productStatus==1? "Het hang":"Khong ban"))
                );
        System.out.println("============================================");
    }
}
