package com.loando.userService.serviceImpl;

import com.loando.mysql.dao.GenericDao;
import com.loando.mysql.dao.HibernateDaoImp;
import com.loando.userService.dto.request.UserRegistrationDTO;
import com.loando.userService.entities.User;
import com.loando.userService.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final GenericDao genericDao;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(@Qualifier("genericdao") GenericDao genericDao, ModelMapper mapper) {
        this.genericDao = genericDao;
        this.mapper = mapper;
    }

    @Override
    public void createUser(UserRegistrationDTO userRegistrationDTO) {
        User user = mapper.map(userRegistrationDTO,User.class);
        genericDao.save(user);
    }
}
