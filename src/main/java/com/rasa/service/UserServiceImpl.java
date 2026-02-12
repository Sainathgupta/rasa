package com.rasa.service;

import com.rasa.dto.CreateUserDTO;
import com.rasa.dto.UserDTO;
import com.rasa.entity.User;
import com.rasa.exception.BusinessLogicException;
import com.rasa.exception.RasaException;
import com.rasa.interfaces.UserService;
import com.rasa.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private UserDTO convertToDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );


    }
    private User convertToUser(CreateUserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.email());
        user.setUsername(userDTO.username());
        return user;
    }

    @Override
    public List<UserDTO> showAllUsers(){

        List<UserDTO> users = userRepository.findAll().stream().map(this::convertToDto).toList();
        System.out.println("Users size is "+users.size());
        if(users.isEmpty()){
            throw new RasaException("Size is large");
        }
        return users;
    }

    @Override
    public String insertUser(CreateUserDTO user) {
        userRepository.findByEmail(user.email())
                .ifPresent(rr -> {
                    throw new BusinessLogicException("User already exists with email: " + user.email());
                });

        User savedUser = userRepository.save(convertToUser(user));

        return "User Created successfully with ID: "+savedUser.getId();
    }


}
