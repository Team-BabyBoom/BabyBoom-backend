package com.babyboom.controllers;

import com.babyboom.dtos.UserDTO;
import com.babyboom.entities.Users;
import com.babyboom.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService usuarioService;
    @Autowired
    private PasswordEncoder bcrypt;

    @PostMapping
    public void insert(@RequestBody UserDTO udto){
            ModelMapper mp = new ModelMapper();
            Users usuario = mp.map(udto, Users.class);
            String bcryptPassword = bcrypt.encode(usuario.getPassword());
            usuario.setPassword(bcryptPassword);
            usuarioService.insert(usuario);
    }

    /*@GetMapping("/list")
    public String listUser(Model model) {
        try {
            model.addAttribute("user", new Users());
            model.addAttribute("listaUsuarios", usuarioService.list());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "usersecurity/listUser";
    }*/

    /*@PostMapping
    public void insert(@RequestBody UserDTO udto){
        ModelMapper mp = new ModelMapper();
        User usuario = mp.map(udto, User.class);
        usuarioService.insert(usuario);
    }*/
    @GetMapping
    public List<UserDTO> list(){
        return usuarioService.list().stream().map(x->{
            ModelMapper mp= new ModelMapper();
            return mp.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idUsuario){
        usuarioService.delete(idUsuario);
    }

    @GetMapping({"/{id}"})
    public UserDTO listId(@PathVariable("id") Integer idUsuario){
        ModelMapper mp= new ModelMapper();
        UserDTO udto = mp.map(usuarioService.listId(idUsuario), UserDTO.class);
        return udto;
    }

    @PutMapping
    public void update (@RequestBody UserDTO udto){
        ModelMapper mp = new ModelMapper();
        Users usuario = mp.map(udto, Users.class);
        usuarioService.insert(usuario);
    }
}
