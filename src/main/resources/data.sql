

INSERT INTO user(first_name, last_name, email, password, awesome) VALUES ('Denis', 'Klopyshko', 'klopushko@gmail.com', '310892', true);
INSERT INTO user(first_name, last_name, email, password, awesome) VALUES ('Nastya', 'Maltseva', 'malceva596@gmail.com', '310892', true);


INSERT INTO groups(name, rating) VALUES ('Noobs', 0);
INSERT INTO groups(name, rating) VALUES ('Pro', 100500);


INSERT INTO user_groups(user_id, group_id) VALUES (1, 2);
INSERT INTO user_groups(user_id, group_id) VALUES (2, 1);
INSERT INTO user_groups(user_id, group_id) VALUES (1, 1);
