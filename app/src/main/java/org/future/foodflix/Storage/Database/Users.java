package org.future.foodflix.Storage.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Entity")
public class Users {
    @PrimaryKey(autoGenerate = true) private int id;
    @ColumnInfo(name = "Username") private String username;
    @ColumnInfo(name = "Name")private String realName;
    @ColumnInfo(name = "Surname")private String surName;
    @ColumnInfo(name = "Password")private String password;

    public Users() {
    }

    public Users(String username, String realName, String surName, String password) {
        this.username = username;
        this.realName = realName;
        this.surName = surName;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", surName='" + surName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

