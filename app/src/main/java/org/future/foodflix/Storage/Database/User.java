package org.future.foodflix.Storage.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(tableName = "User")
public class User {


    @PrimaryKey(autoGenerate = true) private int id;
    @ColumnInfo(name = "Username") private String username;
    @ColumnInfo(name = "Name")private String realName;
    @ColumnInfo(name = "Surname")private String surName;
    @ColumnInfo(name = "Password")private String password;

    public User(String username, String realName, String surName, String password) {
        this.username = username;
        this.realName = realName;
        this.surName = surName;
        this.password = password;
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
    public int getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getRealName() {
        return this.realName;
    }

    public String getSurName() {
        return this.surName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

