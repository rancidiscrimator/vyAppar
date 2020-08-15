package com.example.gov.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CartDao {

    @Insert
    public void insertCartItem(CartItem cartItem);

    @Delete
    public void deleteUser(CartItem cartItem);

    @Update
    public void changeQuantity(CartItem cartItem);

    @Query("SELECT * FROM cartItem")
    public CartItem[] loadAllCartItem();


}
