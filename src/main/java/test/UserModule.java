package test;

import java.util.List;

import dao.UserDAO;
import daoimpl.UserDAOImpl;
import dto.UserDTO;

public class UserModule {

    public static void main(String[] args) {

        UserDAO dao = new UserDAOImpl();

        
        // REGISTER USER
    

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
//        if(result)
//            System.out.println("User Registered Successfully");
//        else
//            System.out.println("Registration Failed");


       
        // LOGIN
        

//        UserDTO user = dao.loginUser("varun@gmail.com", "1234");
//
//        if(user != null)
//            System.out.println(user);
//        else
//            System.out.println("Invalid Email or Password");


       
        // DISPLAY ALL USERS
       

//        List<UserDTO> list = dao.getAllUsers();
//
//        for(UserDTO user : list) {
//
//            System.out.println(user);
//
//        }

     
        // SEARCH USER
       
//  UserDTO user = dao.getUserById(1);
//
//        if(user != null)
//            System.out.println(user);
//        else
//            System.out.println("User Not Found");


        // UPDATE USER
        

//        UserDTO user = new UserDTO();
//
//        user.setUserId(1);
//        user.setFullName("Varun NR");
//        user.setEmail("varun@gmail.com");
//        user.setMobile("9999999999");
//        user.setUsername("varun");
//        user.setPassword("12345");
//        user.setRole("ADMIN");
//
//        boolean result = dao.updateUser(user);
//
//        if(result)
//            System.out.println("Updated Successfully");
//        else
//            System.out.println("Update Failed");


        // DELETE USER
       

//        boolean result = dao.deleteUser(1);
//
//        if(result)
//            System.out.println("Deleted Successfully");
//        else
//            System.out.println("Delete Failed");

    }
}