package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveEntry(User user){
        userRepo.save(user);
    }


    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> byId(ObjectId id){

        return  userRepo.findById(id);
    }

    public void deleteById(ObjectId id){

        userRepo.deleteById(id);
    }

    public User findByUserName(String username){
        return  userRepo.findByUserName(username);
    }
}
