package org.gevernova.SpringCurdDemo.service;


import org.gevernova.SpringCurdDemo.dtos.UserRequestDto;
import org.gevernova.SpringCurdDemo.dtos.UserResponseDto;
import org.gevernova.SpringCurdDemo.exception.IdNotFoundException;
import org.gevernova.SpringCurdDemo.model.User;
import org.gevernova.SpringCurdDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public String saveUserService(UserRequestDto requestDto)
    {
        User user1=new User();
        user1.setName(requestDto.getName());
        user1.setPassword(requestDto.getPassword());
         userRepository.save(user1);
         return "Successfully saved user";
    }

    public UserResponseDto getUserService(long id)
    {
       User user= userRepository
               .findById(id)
               .orElseThrow(()-> new IdNotFoundException("id not found"));
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }
    public User updateUserService(long id, UserRequestDto requestDto)
    {
        User user1=userRepository
                .findById(id)
                .orElseThrow(()->new IdNotFoundException("id not found"));
        user1.setName(requestDto.getName());
        user1.setPassword(requestDto.getPassword());
        userRepository.save(user1);
        return user1;
    }
}
