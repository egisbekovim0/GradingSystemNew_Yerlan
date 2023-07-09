CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                    name VARCHAR(255) NOT NULL
);
CREATE TABLE role (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);
CREATE TABLE user_role (
                           id BIGSERIAL PRIMARY KEY,
                           user_id BIGINT NOT NULL,
                           role_id BIGINT NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES users(id),
                           FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE TABLE students (
                          id BIGSERIAL PRIMARY KEY,
                          f_name VARCHAR(30) NOT NULL,
                          l_name VARCHAR(30) NOT NULL,
                          user_id BIGINT NOT NULL UNIQUE,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE teachers (
                          id BIGSERIAL PRIMARY KEY,
                          f_name VARCHAR(30) NOT NULL,
                          l_name VARCHAR(30) NOT NULL,
                          user_id BIGINT NOT NULL UNIQUE,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE subjects (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(30) NOT NULL
);


CREATE TABLE groups (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(30) NOT NULL
);


CREATE TABLE group_subject (
                               id BIGSERIAL PRIMARY KEY,
                               group_id bigint NOT NULL,
                               subject_id bigint NOT NULL,
                               teacher_id bigint NOT NULL,
                               term INT NOT NULL,
                               year INT NOT NULL,
                               FOREIGN KEY (group_id) REFERENCES groups(id),
                               FOREIGN KEY (subject_id) REFERENCES subjects(id),
                               FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);
create table mark_type(
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE mark (
                      id BIGSERIAL PRIMARY KEY,
                      group_subject_id BIGINT NOT NULL,
                      student_id BIGINT NOT NULL,
                      mark_type_id BIGINT not null,
                      mark FLOAT not null,
                      FOREIGN KEY (mark_type_id) REFERENCES mark_type(id),
                      FOREIGN KEY (group_subject_id) REFERENCES group_subject(id),
                      FOREIGN KEY (student_id) REFERENCES students(id)
);