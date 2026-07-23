package dao;

import java.util.List;

import dto.UserDTO;

public interface UserDAO {

    boolean registerUser(UserDTO user);

    UserDTO loginUser(String email, String password);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(int userId);

    boolean updateUser(UserDTO user);

    boolean deleteUser(int userId);

}