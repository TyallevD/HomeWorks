package ru.java413.homework24.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java413.homework24.DTO.UserRegistrationDTO;
import ru.java413.homework24.entity.NoteUser;
import ru.java413.homework24.repository.UserRepository;
import ru.java413.homework24.service.RegistryService;

@Service
public class RegistryServiceImpl implements RegistryService {
    @Autowired
    UserRepository userRepository;

    public NoteUser createNewUser(UserRegistrationDTO dto) {
        NoteUser user = UserRegistrationDTO.toEntity(dto);
        return userRepository.save(user);
    }
}
