package com.modeling.modeling.service;

import com.modeling.modeling.model.Department;
import com.modeling.modeling.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    private List<User> users= new ArrayList<>();
    private Long idCounter = 1L;


    @Override
    public User create(User user) {
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User update(Long id, User user) {
        for(User u : users){
            if(u.getId().equals(id)){
                u.setFirst_name(user.getFirst_name());
                u.setLast_name(user.getLast_name());
                u.setEmail(user.getEmail());
                u.setPhone_number(user.getPhone_number());
                u.setDob(user.getDob());
                return u;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        users.removeIf(u->u.getId().equals(id));
        return false;
    }
}
