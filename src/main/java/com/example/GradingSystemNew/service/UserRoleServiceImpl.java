package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.RoleDtoRequest;
import com.example.GradingSystemNew.dto.request.UserRoleDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.module.security.UserRole;
import com.example.GradingSystemNew.repository.GroupRepository;
import com.example.GradingSystemNew.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService{
    private final UserRoleRepository userRoleRepository;
    private UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole create(UserRoleDtoRequest dtoRequest) {
        UserRole userRole = new UserRole();

        try {
            userRole.setRole(userRole.getRole());
            userRole.setUser(userRole.getUser());

            return this.save(userRole);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }
}
