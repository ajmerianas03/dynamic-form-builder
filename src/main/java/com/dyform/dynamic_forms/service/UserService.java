package com.dyform.dynamic_forms.service;

import com.dyform.dynamic_forms.dto.LoginDTO;
import com.dyform.dynamic_forms.dto.UserDTO;

public interface UserService {
    void register(UserDTO userDTO);

    String login(LoginDTO loginDTO);
}
