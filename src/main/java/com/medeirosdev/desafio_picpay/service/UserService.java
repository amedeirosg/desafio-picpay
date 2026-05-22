package com.medeirosdev.desafio_picpay.service;

import com.medeirosdev.desafio_picpay.dtos.UserCreateDTO;
import com.medeirosdev.desafio_picpay.dtos.UserResponseDTO;
import com.medeirosdev.desafio_picpay.entities.User;
import com.medeirosdev.desafio_picpay.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> findUserByDocument(String document){

        return userRepository.findByDocument(document);

    }

    public List<UserResponseDTO> createUser(List<UserCreateDTO> dtos){

        List<User> users = dtos.stream()
                .map(dto ->new User
                        (dto.getFirstName(), dto.getLastName(),dto.getDocument(),dto.getBalance(), dto.getEmail(), dto.getPassword(),dto.getUserType()))
                .toList();

        userRepository.saveAll(users);

        return users.stream()
                .map(this::toDTO)
                .toList();

    }

    public List<UserResponseDTO> getAllUser(){

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::toDTO)
                .toList();

    }

    public void save(User user){

        userRepository.save(user);

    }

    public UserResponseDTO toDTO(User user){

        return new UserResponseDTO(user.getFirstName(),user.getLastName(),user.getDocument(),user.getBalance(),user.getEmail(), user.getUserType());

    }

}
