package org.future.foodflix.Storage.Database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface UserDAO {

    @Insert(onConflict = REPLACE)
    public void save(Users data);
    @Insert(onConflict = REPLACE)
    public void save(Users[] data);

    @Query("SELECT * FROM Users")
    @Nullable
    public List<Users>read();

    @Update
    public void update(Users data);

    @Delete
    public void delete(Users data);
    @Delete
    public void delete(Users[] data);
}
