package com.company.data;

import com.company.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserData {
    List<User> users = new ArrayList<> (Arrays.asList (
            new User("Michał", "Kruczkowski", "mk@mk.pl", "mk"),
            new User ("Jan", "T", "jt@jt.pl", "jt"),
            new User("Kasia", "J", "kj@kj.pl", "jk"),
            new User("Anna", "G", "ag@ag.pl", "ag"),
            new User ("Gosia", "G", "gg@gg.pl", "gg"),
            new User ("Emil", "Z", "ez@ez.pl", "ez"))
    );
}
