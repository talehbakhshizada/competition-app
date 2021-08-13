/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

import beans.User;
import java.util.Scanner;

/**
 *
 * @author 99451
 */
public class UserUtill {

    public static User login(String username, String password) {
        if ("Taleh".equals(username) && "12345".equals(password)) {
            System.out.println("You logged succesfully");
            User user = new User(username, password);
            return user;
        } else {
            throw new IllegalArgumentException("Username or password is invaild.");
        }
    }

    public static User requiredUserLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your username");
        String username = sc.nextLine();

        System.out.println("Please enter your password");
        String password = sc.nextLine();

        User user = UserUtill.login(username, password);

        return user;
    }

    public static User checkUserLogin(int tryCount, boolean exception) {
        for (int i = 0; i < tryCount; i++) {
            try {
                User user = UserUtill.requiredUserLogin();
                return user;
            } catch (IllegalArgumentException exp) {
                exp.printStackTrace();
                System.out.println("Try again");
            }
        }
        if (exception) {
            throw new IllegalArgumentException("You have banned!");
        }
        return null;
    }
}
