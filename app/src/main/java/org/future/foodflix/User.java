package org.future.foodflix;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

}
