package com.harman.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int option;
        while(true){
            System.out.println("select an option: ");
            System.out.println("1.Add the Products: ");
            System.out.println("2.View All products: ");
            System.out.println("3.Search a product using product code: ");
            System.out.println("4.Update product details using product Code: ");
            System.out.println("5.Delete a product using product Code: ");
            System.out.println("6.Display all the details of products whose price is greater than 50000: ");
            System.out.println("7.Display the count of total number of products  in the company: ");
            System.out.println("8.Display all the product details in alphabetical order: ");
            System.out.println("9.Exit: ");
            option= in.nextInt();
            switch (option) {
                case 1:
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcd company?autoReconnect=true&useSSL=false", "root", "");
                        Scanner input = new Scanner(System.in);
                        String Productcode, productname, brand, price, model, yearofmanufacturing, expirydate;
                        System.out.println("Enter the Product code");
                        Productcode = input.next();
                        System.out.println("Enter the product name");
                        productname = input.next();
                        System.out.println("Enter the brand");
                        brand = input.next();
                        System.out.println("Enter the price");
                        price = input.next();
                        System.out.println("Enter the model");
                        model = input.next();
                        System.out.println("Enter the yearofmanufacturing");
                        yearofmanufacturing = input.next();
                        System.out.println("Enter the expirydate");
                        expirydate = input.next();

                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `products`(`Productcode`, `productname`, `brand`, `price`, 'model', 'yearofmanufacturing', 'expirydate') " +
                                "VALUES(" + Productcode + ",'" + productname + "','" + brand + "'," + price + ",'" + model + "'," + yearofmanufacturing + "," + expirydate + ")");
                        System.out.println("inserted successfully");


                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View All products:");
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ abcd company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `Productcode`, `productname`, `brand`, `price`, `model`, 'yearofmanufacturing', 'expirydate' FROM `products` WHERE 1");
                        while (rs.next()) {
                            System.out.println("Productcode= " + rs.getInt("Productcode"));
                            System.out.println("productname= " + rs.getString("productname"));
                            System.out.println("brand= " + rs.getString("brand"));
                            System.out.println("price= " + rs.getInt("price"));
                            System.out.println("model= " + rs.getString("model"));
                            System.out.println("yearofmanufacturing= " + rs.getInt("brand"));
                            System.out.println("expirydate= " + rs.getInt("expirydate"));
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        Scanner input = new Scanner(System.in);

                        String brand;
                        System.out.println("Search a product using product code: ");
                        String productcode = input.next();

                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ abcd company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE 'productcode'=" + productcode + "");

                        while (rs.next()) {
                            System.out.println("productcode= " + rs.getInt("productcode"));


                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    try {
                        Scanner input = new Scanner(System.in);
                        int Productcode;
                        System.out.println("Update product details using product Code: ");
                        int productcode = input.nextInt();

                        String productname, brand, price, model, yearofmanufacturing, expirydate;


                        System.out.println("enter the productname: ");
                        productname = input.next();
                        System.out.println("enter the brand: ");
                        brand = input.next();
                        System.out.println("enter the price: ");
                        price = input.next();
                        System.out.println("enter the model: ");
                        model = input.next();
                        System.out.println("enter the yearofmanufacturing: ");
                        yearofmanufacturing = input.next();
                        System.out.println("enter the expirydate: ");
                        expirydate = input.next();


                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ abcd company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("UPDATE `products` SET `Productcode`=`productname`='" + productname + "',`brand`='" + brand + "','price'=" + price + ",'model'='" + model + "','yearofmanufacturing'=" + yearofmanufacturing + ",'expirydate'=" + expirydate + " WHERE `productcode`=" + productcode);

                        System.out.println("updated successfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    try {
                        String Productcode;
                        System.out.println("Delete a product using product Code: ");
                        Productcode = in.next();
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ abcd company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        String productcode;
                        stmt.executeUpdate("DELETE FROM `products` WHERE 'Productcode'=" + Productcode);
                        System.out.println("deleted successfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcd companydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT * FROM `products` WHERE `price` > 50000");
                        while (rs.next())
                        {
                            System.out.println("productcode = " + rs.getInt("productcode"));
                            System.out.println("productname = " + rs.getString("productname"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Yearofmanufacturing = " + rs.getInt("yearofmanufacturing"));
                            System.out.println("Expirydate = " + rs.getInt("expirydate"));
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 7:
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcd companydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM `products`");


                        rs.next();
                        int count = rs.getInt(1);
                        System.out.println("The Total Count of the Products = " + count);

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case 8:
                    try
                    {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abcd companydb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();

                        ResultSet rs = stmt.executeQuery("SELECT `productcode`, `productname`, `brand`, `price`, `model`, `yearofmanufacturing`, `expirydate` FROM `products` WHERE 1 order by productname asc ");
                        while (rs.next())
                        {
                            System.out.println("product code = " + rs.getInt("product_code"));
                            System.out.println("product name = " + rs.getString("product_name"));
                            System.out.println("brand = " + rs.getString("brand"));
                            System.out.println("price = " + rs.getInt("price"));
                            System.out.println("model = " + rs.getString("model"));
                            System.out.println("Year of manufacturing = " + rs.getInt("year_of_manufacturing"));
                            System.out.println("Expiry date = " + rs.getInt("expiry_date"));
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 9:
                    System.exit(0);



                default:
                    System.out.println("Invalid Option = ??? ");

            }
        }
    }
}
