package com.online.shopping.cart.entity;

import com.online.shopping.cart.enums.AccountStatus;
import com.online.shopping.cart.enums.UserRole;
import lombok.Builder;
import lombok.Data;

//import javax.management.relation.Role;

@Data
@Builder
public class User extends BaseEntity{
    private String name;
    private UserRole role;
    private AccountStatus accountStatus;
    private String password;
    private String isActive;
}
