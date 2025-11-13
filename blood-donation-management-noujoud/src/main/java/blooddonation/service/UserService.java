package blooddonation.service;

import blooddonation.bean.Donneur;
import blooddonation.bean.Hopital;
import blooddonation.bean.User;
import blooddonation.dao.interfaces.UserDao;

import java.util.Base64;


public class UserService {

    private final UserDao userDao;
    public UserService(UserDao userDao) { this.userDao = userDao; }
    public boolean registerUser(String prenom, String nom, String email, String phone, String password, String role) {
        String hashed = Base64.getEncoder().encodeToString(password.getBytes());
        try {

            User user;
            switch (role) {
                case "donneur":
                    user = new Donneur();
                    break;
                case "hopital":
                    user = new Hopital();
                    break;
                default:
                    return false; // don't allow admin registration from this form
            }


            user.setPrenom(prenom);
            user.setNom(nom);
            user.setEmail(email);
            user.setPhoneNum(phone);
            user.setPassword(hashed);
            user.setRole(role);

            // Call DAO to save user using Hibernate
            userDao.save(user);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User authenticateUser(String email, String password) {
        try {
            User user = userDao.findByEmail(email);
            if (user != null) {
                // Encode the entered password just like during registration
                String hashedInput = Base64.getEncoder().encodeToString(password.getBytes());

                // Compare the encoded version with the stored one
                if (user.getPassword().equals(hashedInput)) {
                    return user; // ✅ success
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // ❌ fail
    }

}
