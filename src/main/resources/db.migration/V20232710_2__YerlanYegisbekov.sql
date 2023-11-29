CREATE TABLE authority (
                           id BIGSERIAL PRIMARY KEY,
                           title VARCHAR(255) NOT NULL UNIQUE
);

ALTER TABLE user_role
    ADD authority_id INT;

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_authority
        FOREIGN KEY (authority_id) REFERENCES authority(id);

ALTER TABLE user_role
    ALTER COLUMN role_id DROP NOT NULL;

ALTER TABLE user_role
    ADD CONSTRAINT unique_user_role_authority UNIQUE (user_id, role_id, authority_id);
