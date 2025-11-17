package net.engineeringdigest.journalApp.service;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository UserRepository;
    private static final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            UserRepository.save(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void saveadmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        UserRepository.save(user);

    }
    public void saveUser(User user){

        UserRepository.save(user);

    }
    public List<User> getAll(){

        return UserRepository.findAll();
    }
    public Optional<User> findById(ObjectId id){

        return UserRepository.findById(id);
    }
    public void deleteById(ObjectId id ){

        UserRepository.deleteById(id);
    }
    public User findByUserName(String userName){
        return UserRepository.findByUsername(userName);
    }
}
