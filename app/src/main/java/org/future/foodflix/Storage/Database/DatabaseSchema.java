package org.future.foodflix.Storage.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={User.class},version=1)
public abstract class DatabaseSchema extends RoomDatabase {
    public abstract UserDAO getUserDao();
}
