package org.gevernova.SpringCurdDemo.controller;
import jakarta.validation.Valid;
import org.gevernova.SpringCurdDemo.dtos.UserRequestDto;
import org.gevernova.SpringCurdDemo.dtos.UserResponseDto;
import org.gevernova.SpringCurdDemo.model.User;
import org.gevernova.SpringCurdDemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

   private final Logger log= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@Valid  @RequestBody UserRequestDto requestDto)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.saveUserService(requestDto));

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable long id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserService(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable long id, @Valid @RequestBody UserRequestDto requestDto )
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserService(id,requestDto));
    }
}
