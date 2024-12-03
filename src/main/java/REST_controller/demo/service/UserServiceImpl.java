package REST_controller.demo.service;

import REST_controller.demo.entetie.User;
import REST_controller.demo.reposotorie.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    @Transactional
    public User deleteUserById(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    @Override
    @Transactional
    public User updateUser(User updateUser) {
        User user = userRepository.findById(updateUser.getId()).orElseThrow(()->new IllegalArgumentException("User not found"));
        String currentPassword =user.getPassword();
        String newPassword = updateUser.getPassword();

        if (!currentPassword.equals(newPassword)) {
            updateUser.setPassword((bCryptPasswordEncoder.encode(updateUser.getPassword())));
        }

        return userRepository.save(updateUser);
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException(String.format(" User '%s' not found", email));
        return user;
    }
}

