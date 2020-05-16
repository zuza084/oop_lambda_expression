package com.company;

import com.company.controler.UserControler;
import com.company.model.Role;
import com.company.model.User;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // write your code here
        UserControler uc = new UserControler ( );
        uc.getAllUsers ( );
        System.out.println (uc.getUserByEmailWithValidation ("gg@gg.pl"));
        System.out.println (uc.getUserByEmailWithValidation ("ee@ww.pl") );        uc.updateUserStatusById(1, false);
        uc.updateUserStatusById(4, false);
        System.out.println("Aktywni użytkownicy");
        uc.getAllUsersWithStatus(true).forEach(System.out::println);
        System.out.println (uc.updateUserRoleById (2, Role.ROLE_ADMIN) );
        System.out.println (uc.updateUserRoleById (6, Role.ROLE_USER) );
        System.out.println ("aktywni " + uc.countActiveUsers () );
        System.out.println ("admin " + uc.countAdmins () );
        System.out.println (uc.getAllUsersOrderByregistrationDateDesc ());
        uc.getAllUsersOrderByregistrationDateDesc ().forEach (System.out::println);
        System.out.println ( );
        uc.getAlAdminsOrderByEmailAsc ().forEach(System.out::println);
    }

}
