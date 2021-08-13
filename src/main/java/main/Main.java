/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import beans.User;
import config.Initialization;
import utill.MenuUtill;
import utill.UserUtill;

/**
 *
 * @author 99451
 */
public class Main {

    public static void main(String[] args) {

        User user = UserUtill.checkUserLogin(3, true);
        Initialization.initializeConfig(user);
        System.out.println("Hello, " + user.getName() + "!");
        MenuUtill.showMenu();

    }
}
