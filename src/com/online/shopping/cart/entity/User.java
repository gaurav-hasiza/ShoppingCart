package com.online.shopping.cart.entity;

import com.online.shopping.cart.enums.AccountStatus;
import com.online.shopping.cart.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

//import javax.management.relation.Role;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class User extends BaseEntity{
    private String name;
    private UserRole userRole;
    private AccountStatus accountStatus;
    private String password;
    private boolean isActive;

}
