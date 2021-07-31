package pers.pan.springHW.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserByAccountNumber(long accountNumber) {
        Optional<User> optional = userRepository.findById(accountNumber);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for account number ::" +
                    " " + accountNumber);
        }
        return user;
    }

    @Override
    public void deleteUserByAccountNumber(long accountNumber) {
        this.userRepository.deleteById(accountNumber);
    }
}
