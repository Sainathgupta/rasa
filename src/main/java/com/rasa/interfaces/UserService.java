package com.rasa.interfaces;

import com.rasa.dto.CreateUserDTO;
import com.rasa.dto.UserDTO;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

import java.util.List;

public interface UserService{

    public List<UserDTO> showAllUsers();
    public String insertUser(CreateUserDTO user);

}
