package test;

import java.util.List;

import dao.UserDAO;
import daoimpl.UserDAOImpl;
import dto.UserDTO;

public class UserModule {

    public static void main(String[] args) {

//        UserDAO dao = new UserDAOImpl();
//
//        UserDTO user = new UserDTO();
//
//        user.setFullName("Varun N R");
//        user.setEmail("varun@gmail.com");
//        user.setMobile("9876543210");
//        user.setUsername("varun");
//        user.setPassword("1234");
//        user.setRole("ADMIN");
//
//        boolean result = dao.registerUser(user);
//
//        if (result)
//            System.out.println("User Registered Successfully");
//        else
//            System.out.println("Registration Failed");
//
//        UserDTO loginUser = dao.loginUser("varun@gmail.com", "1234");
//
//        if (loginUser != null) {
//            System.out.println("Login Successful");
//            System.out.println(loginUser);
//        } else {
//            System.out.println("Invalid Email or Password");
//        }
//
//        List<UserDTO> list = dao.getAllUsers();
//
//        System.out.println("All Users:");
//
//        for (UserDTO u : list) {
//            System.out.println(u);
//        }
//
//        UserDTO searchUser = dao.getUserById(1);
//
//        if (searchUser != null)
//            System.out.println(searchUser);
//        else
//            System.out.println("User Not Found");
    }
}