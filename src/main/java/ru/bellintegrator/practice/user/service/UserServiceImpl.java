package ru.bellintegrator.practice.user.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.dao = userDao;
    }

    @Override
    public List<UserView> users() throws SQLException {
        List<User> offices = dao.all();
        return offices.stream()
                .map(mapUser())
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserView view) throws SQLException {
        dao.save(viewToUser(view));
    }

    @Override
    public void updateUser(UserView view) throws SQLException {
        dao.update(viewToUser(view));
    }

    @Override
    public UserView loadById(int id) throws Exception {
        return userToView(dao.loadById(id));
    }

    private Function<User,UserView> mapUser(){
        return o -> {
            return userToView(o);
        };
    }

    private User viewToUser(UserView view){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(UserView.class, User.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(view,User.class);
    }

    private UserView userToView(User office){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(UserView.class,User.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(office,UserView.class);
    }
}
