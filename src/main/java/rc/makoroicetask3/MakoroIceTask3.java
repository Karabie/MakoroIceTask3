/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package rc.makoroicetask3;

import javax.swing.JOptionPane;

/**
 *
 * @author Makoro ST10461176
 */
public class MakoroIceTask3 {
    static Login objUser = new Login();
    public static String full_name, last_name, username, password;
    static boolean register = true;
    static boolean login = false;

    public static void main(String[] args) {

        while (register) {
            getUserInput();
            if (objUser.checkUserName()) {
                if (objUser.checkPasswordComplexity()) {
                    JOptionPane.showMessageDialog(null, objUser.registerUser());
                    register = false;
                } else {
                    JOptionPane.showMessageDialog(null, objUser.registerUser());
                }
            } else {
                JOptionPane.showMessageDialog(null, objUser.registerUser());
            }
        }

        //Do while method for Login process 
        while (!login) {

            String usernames = JOptionPane.showInputDialog("Please Enter Login Username");

            String passwords = JOptionPane.showInputDialog("Please Enter Login Password");

            if (objUser.loginUser(usernames, passwords)) {
                JOptionPane.showMessageDialog(null, objUser.returnLoginStatus());
                JOptionPane.showMessageDialog(null, "Welcome " + objUser.getFullName() + " , " + objUser.getLastName() + " it is great to see you again.");

                login = true;
                objUser.setLoginStatus(login);
            } else {
                JOptionPane.showMessageDialog(null, objUser.returnLoginStatus());
                JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");

            }

        }

    }

    public static void getUserInput() {

        full_name = JOptionPane.showInputDialog("Please Enter Full Name");
        last_name = JOptionPane.showInputDialog("Please Enter Last Name");
        username = JOptionPane.showInputDialog("Please Enter Username");
        password = JOptionPane.showInputDialog("Enter Password");

        objUser = new Login(full_name, last_name, username, password, login);
        if (!objUser.checkUserName()) {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        } else {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        }
        if (!objUser.checkPasswordComplexity()) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        } else {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        }

    }

}
