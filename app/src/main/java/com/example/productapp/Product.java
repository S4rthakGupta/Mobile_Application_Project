package com.example.productapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String image;
    public String description;
    public double price;
}

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    List<Product> getAllProducts();

    @Insert
    void insertProduct(Product product);
}

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}