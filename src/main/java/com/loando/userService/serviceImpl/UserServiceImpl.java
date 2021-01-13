package com.loando.userService.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loando.mysql.dao.GenericDao;
import com.loando.mysql.dao.HibernateDaoImp;
import com.loando.userService.dto.request.UserRegistrationDTO;
import com.loando.userService.entities.User;
import com.loando.userService.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.loando.userService.query.UserSQLQuery.GET_USER_BY_EMAIL;

@Service
public class UserServiceImpl implements UserService {
    private final GenericDao genericDao;
    private final ObjectMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(@Qualifier("genericdao") GenericDao genericDao, ObjectMapper mapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.genericDao = genericDao;
        this.mapper = mapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void createUser(UserRegistrationDTO userRegistrationDTO) {
        User user = mapper.convertValue(userRegistrationDTO,User.class);
        user.setPassword(bCryptPasswordEncoder.encode(userRegistrationDTO.getPassword()));
        genericDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HashMap<String,Object> param = new HashMap<>();
        param.put("email", username);

        List<User> userList = (List<User>) genericDao.get(User.class, GET_USER_BY_EMAIL, param);
        if(Objects.isNull(userList) || userList.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new org.springframework.security.core.userdetails.User(userList.get(0).getEmail(), userList.get(0).getPassword(), true, true, true, true, new ArrayList<>());
    }
}
