package com.company.controler;

import com.company.data.UserData;
import com.company.model.Role;
import com.company.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//implementuje metody obsługujące żadania, np. rejetracja, pobranie uzytkownika
public class UserControler {

    public void getAllUsers(){
        //for(User user:UserData.users){
          //  System.out.println (user );
       //predykat ctrl+spacja; UserData.users.forEach(user->System.out.ptintln(user)
        UserData.users.forEach(System.out::println);
    }
    public Optional<User> getUserByEmail(String searchEmail){
        return UserData.users                                       // List<User>
                .stream()                                           // Stream<User>
                .filter(user -> user.getEmail().equals(searchEmail))// Stream<User>
                .findFirst();

    }
    public String getUserByEmailWithValidation(String searchEmail){
        Optional<User> userOpt = getUserByEmail(searchEmail);
        return userOpt.map(user -> "Znalezieono użytkownika: " + user.toString())
                .orElseGet(() -> "Nie znaleziono użytkownika o adresie: " + searchEmail);

    }
    public List<User> getAllUsersWithStatus(boolean status){
        return UserData.users
                .stream()
                .filter(user -> user.isStatus() == status)
                .collect(Collectors.toList());
    }
    public void updateUserStatusById(int userId, boolean status){
        UserData.users
                .stream()
                .filter(user -> user.getUserId() == userId)
                .forEach(user -> user.setStatus(status));
    }
    public boolean updateUserRoleById (int userId, Role role){
        // czy jest uzytkownik?
        Optional<User> userOpt = UserData.users
                .stream()
                .filter(user -> user.getUserId() == userId).findFirst ();
                if(userOpt.isPresent()){
                    //userOpt.get() wyciąga zawartość z optional uzytkownika
                    userOpt.get ().setRole (role);
                    return true;
                }
                return false;
}
public int countActiveUsers(){
    return    (int) UserData.users
            .stream()
            .filter(User::isStatus).count();
    }

public int countAdmins(){
        return (int) UserData.users.stream()
                .filter(user -> user.getRole() == Role.ROLE_ADMIN).count();
}
public List<User> getAllUsersOrderByregistrationDateDesc(){
        return UserData.users.stream().sorted (Comparator.comparing (User::getRegistrationDate)
        .reversed()).collect(Collectors.toList ());
}
public List<User> getAlAdminsOrderByEmailAsc(){
    return UserData.users.stream()
            .filter (user -> user.getRole ()==Role.ROLE_ADMIN )
            .sorted (Comparator.comparing (User::getEmail)).collect(Collectors.toList ());
}
}