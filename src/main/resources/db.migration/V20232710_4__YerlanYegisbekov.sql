ALTER TABLE users
    ADD user_roles_id BIGINT;

ALTER TABLE users
    ADD CONSTRAINT fk_users_user_roles
        FOREIGN KEY (user_roles_id) REFERENCES user_role(id);