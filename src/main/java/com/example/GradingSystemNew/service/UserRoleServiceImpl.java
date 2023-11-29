package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.RoleDtoRequest;
import com.example.GradingSystemNew.dto.request.UserRoleDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.module.security.Authority;
import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.module.security.User;
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

    private final RoleService roleService;
    private final UserService userService;
    private final AuthorityService authorityService;
    private UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole create(UserRoleDtoRequest dtoRequest) {
        try {
        UserRole userRole = new UserRole();
        Role role = roleService.getByIdThrowException(dtoRequest.getRoleId());
        User user = userService.getByIdThrowException(dtoRequest.getUserId());
        Authority authority = authorityService.getByIdThrowException(dtoRequest.getUserId());
        userRole.setRole(role);
        userRole.setUser(user);
        userRole.setAuthority(authority);
            return this.save(userRole);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }
}
