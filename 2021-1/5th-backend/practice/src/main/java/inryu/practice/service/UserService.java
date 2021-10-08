package inryu.practice.service;

import inryu.practice.dao.UserDao;
import inryu.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired //userDao 불러오기 생성자를 활용해서 의존성 주입
    UserDao userDao;


    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserByUserId(String userId) {
        return userDao.getUserByUserId(userId);
    }

    public User registerUser(User user) {
        return userDao.insertUser(user);
    }

    public void modifyUser(String userId, User user) {
        userDao.updateUser(userId, user);
    }

    public void removeUser(String userId) {
        userDao.deleteUser(userId);
    }
}
