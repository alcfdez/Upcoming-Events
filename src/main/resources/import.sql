


INSERT INTO events( id, title, date_hour, max_participants, description, actual_participants) VALUES (default,'Conciertazo', '19/05/2023-15:00h',  300,  'Madonna Tour Nations',  100)
INSERT INTO events( id, title, date_hour, max_participants, description, actual_participants) VALUES (default,'El Fary', '11/09/2023-15:00h',  300,  'El fary ninio',  200)
INSERT INTO events( id, title, date_hour, max_participants, description, actual_participants) VALUES (default,'Las Ketchup', '09/12/2023-15:00h',  90,  'Asere Jeee',  80)
INSERT INTO events( id, title, date_hour, max_participants, description, actual_participants) VALUES (default,'Las Ketchup', '09/12/2023-15:00h',  90,  'Asere Jeee',  80)
INSERT INTO events( id, title, date_hour, max_participants, description, actual_participants) VALUES (default,'Las Ketchup', '09/12/2023-15:00h',  90,  'Asere Jeee',  80)
INSERT INTO users( id, username, password) VALUES (default,'Raul', '1234' )
INSERT INTO users( id, username, password) VALUES (default,'GobizConBambas', 'asas22' )
INSERT INTO roles (id, name) VALUES (default,'ROLE_ADMIN')
INSERT INTO roles (id, name) VALUES (default,'ROLE_USER')
INSERT INTO user_roles (user_id, role_id) VALUES (1,1)