package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.RoleDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private Role save(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Role create(RoleDtoRequest dtoRequest) {
        Role role = new Role();

        try {
            role.setName(dtoRequest.getName());

            return this.save(role);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }
}
