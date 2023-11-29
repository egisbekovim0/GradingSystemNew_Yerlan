ALTER TABLE role
    ADD user_roles_id BIGINT;

ALTER TABLE role
    ADD CONSTRAINT fk_role_user_roles
        FOREIGN KEY (user_roles_id) REFERENCES user_role(id);
