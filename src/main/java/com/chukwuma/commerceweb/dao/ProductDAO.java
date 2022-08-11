package com.chukwuma.commerceweb.dao;

import com.chukwuma.commerceweb.model.Product;
import com.chukwuma.commerceweb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet resultSet;
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" +
            " (name, category, price, quantity) VALUES" +
            " (?,?,?,?);";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products";
    private static final String SELECT_PRODUCTS_BY_ID = "SELECT id, name, price FROM" +
            " products WHERE id =? ";
    private static final String SELECT_ALL_PRODUCTS_BY_CATEGORY = "SELECT * FROM products";
    private static final String DELETE_PRODUCTS_SQL = "DELETE FROM products WHERE user_id IN (?);";
    private static final String UPDATE_PRODUCTS_PRICE_SQL = "UPDATE products SET price = ? WHERE name = ?;";
    private static final String UPDATE_PRODUCTS_QTY_SQL = "UPDATE products SET quantity = ? WHERE name = ?;";

    //insert
    //update
    //delete
    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public ProductDAO(Connection connection, PreparedStatement pst, ResultSet resultSet) {
        this.connection = connection;
        this.pst = pst;
        this.resultSet = resultSet;
    }

    public String insertProducts(Product product){
        String result;
        int queryStatus;
        try{
            pst = this.connection.prepareStatement(INSERT_PRODUCTS_SQL);
            pst.setString(1, product.getName());
            pst.setString(2, product.getCategory());
            pst.setDouble(3, product.getPrice());
            pst.setLong(4, product.getQuantity());

            queryStatus = pst.executeUpdate();

            if (queryStatus == 1){
                result = "Successfully Added Product To Store";
            }
            else {result = "Failed, Couldn't Add Product To Store";}

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String updatePrice(String productName, Double price){
        Product product = new Product();
        String result;
        int queryStatus;
        try{
            pst = this.connection.prepareStatement(UPDATE_PRODUCTS_PRICE_SQL);
            pst.setDouble(1, price);
            pst.setString(2, productName);
            System.out.println(pst);
            pst.executeUpdate();





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Successfully updated";
    }

}
