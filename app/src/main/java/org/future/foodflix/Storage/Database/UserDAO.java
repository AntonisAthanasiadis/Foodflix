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
    public void save(User data);
    @Insert(onConflict = REPLACE)
    public void save(User[] data);

    @Query("SELECT * FROM User")
    @Nullable
    public List<User>read();

    @Update
    public void update(User data);

    @Delete
    public void delete(User data);
    @Delete
    public void delete(User[] data);
}
