package pers.pan.springHW.bank;


import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserByAccountNumber(long accountNumber);
    void deleteUserByAccountNumber(long accountNumber);

    void depositByAccountNumber(long accountNumber, double funds);

    void withdrawByAccountNumber(long accountNumber, double funds);
}
