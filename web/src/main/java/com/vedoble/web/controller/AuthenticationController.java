package com.vedoble.web.controller;


import com.vedoble.web.Dto.AuthenticationDTO;
import com.vedoble.web.Dto.LoginResponseDto;
import com.vedoble.web.Dto.RegisterDTO;
import com.vedoble.web.configurations.TokenService;
import com.vedoble.web.entity.User;
import com.vedoble.web.repository.UsuaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuaRepository usuaRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.usualogin(),data.usuasenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
    if(this.usuaRepository.findByUsualogin(data.usualogin()) != null) return ResponseEntity.badRequest().build();
    String encryptedSenha = new BCryptPasswordEncoder().encode(data.usuasenha());
    User newUser = new User(data.usualogin(), encryptedSenha, data.perfil());

    this.usuaRepository.save(newUser);
    return ResponseEntity.ok().build();
    }
}
