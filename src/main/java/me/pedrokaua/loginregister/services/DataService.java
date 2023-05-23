package me.pedrokaua.loginregister.services;

import me.pedrokaua.loginregister.dto.UserDTO;
import me.pedrokaua.loginregister.entitites.User;
import me.pedrokaua.loginregister.infrastructure.UserDAO;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    UserDAO dao = new UserDAO();

    public DataService() {}

    public UserDTO findById(Long id){
        User user = dao.findById(id);
        return new UserDTO(user);
    }

    public List<User> findAll(){
        return dao.findAll();
    }

    public List<String[]> findAllInfos() {
        List<String[]> infos = new ArrayList<>();
        List<User> users = findAll();

        for (User user : users) {
            String[] userinfo = {
                    user.getId().toString(),
                    user.getName(),
                    user.getUserName(),
                    user.getBirth()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    user.getGender(),
                    user.getEmail(),
                    user.getPassword()
            };
            infos.add(userinfo);
        }
        if (infos.size() != 0) {
            return infos;
        } else {
            return new ArrayList<>();
        }
    }
}
