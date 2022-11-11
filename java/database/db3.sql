BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants, business_days, business_hours, restaurant_open;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

--NEW: 
CREATE TABLE business_days(
	day_id serial PRIMARY KEY NOT NULL,
	days_open varchar(50) NOT NULL
	
);



CREATE TABLE restaurants(
	res_id serial PRIMARY KEY NOT NULL,
    restaurant_name varchar(255)  NOT NULL,
   	street varchar(255)NOT NULL,
   	cuisine_type varchar(50) NOT NULL,
    city varchar(50) NOT NULL,
    state_name varchar(50) NOT NULL,
    zip int NOT NULL,
    phone_number varchar NOT NULL
	
);

CREATE TABLE business_hours(
	hours_id serial PRIMARY KEY NOT NULL,
	hours_open time NOT NULL,
	hours_closing time NOT NULL
);

CREATE TABLE restaurant_open(
	open_id serial PRIMARY KEY,
	res_id int NOT NULL,
	day_id int NOT NULL,
	hours_id int NOT NULL,
	CONSTRAINT restaurant_open_fk0 FOREIGN KEY (res_id) REFERENCES restaurants(res_id),
	CONSTRAINT restaurant_open_fk1 FOREIGN KEY (day_id) REFERENCES business_days(day_id),
	CONSTRAINT restaurant_open_fk2 FOREIGN KEY (hours_id) REFERENCES business_hours(hours_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO business_days (days_open) VALUES('Monday');
INSERT INTO business_days (days_open) VALUES('Tuesday');
INSERT INTO business_days (days_open) VALUES('Wednesday');
INSERT INTO business_days (days_open) VALUES('Thursday');
INSERT INTO business_days (days_open) VALUES('Friday');
INSERT INTO business_days (days_open) VALUES('Saturday');
INSERT INTO business_days (days_open) VALUES('Sunday');


INSERT INTO business_hours (hours_open, hours_closing) VALUES('17:00', '23:00');
INSERT INTO business_hours (hours_open, hours_closing) VALUES('12:00', '16:00');
INSERT INTO business_hours (hours_open, hours_closing) VALUES('12:00', '22:00');
INSERT INTO business_hours (hours_open, hours_closing) VALUES('12:00', '23:00');
INSERT INTO business_hours (hours_open, hours_closing) VALUES('17:00', '22:30');
INSERT INTO business_hours (hours_open, hours_closing) VALUES('12:00', '14:30');
INSERT INTO business_hours (hours_open, hours_closing) VALUES('11:30', '23:00');
INSERT INTO business_hours (hours_open, hours_closing) VALUES('11:30', '00:00');

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number) 
VALUES ('Momofuku Noodle Bar', '171 1st Ave', 'Ramen', 'New York', 'NY', 10003, '212-777-7773');

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number) 
VALUES ('Pure Thai Cookhouse', '766 9th Ave #2', 'Thai', 'New York', 'NY', 10019, '212-581-0999');

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number) 
VALUES ('Wildair', '142 Orchard St', 'New American', 'New York', 'NY', 10002, '646-964-5624');

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number) 
VALUES ('Shukette', '230 9th Ave', 'Middle Eastern', 'New York', 'NY', 10001, '212-242-1803');

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number) 
VALUES ('Piccola Cucine Estiatorio', '75 Thompson St', 'Sicilian', 'New York', 'NY', 10012, '646-781-9183');

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number) 
VALUES ('Slows Bar BQ', '2138 Michigan Ave', 'Barbecue', 'Detroit', 'MI', 48216, '313-962-9828');

INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 1, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 2, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 3, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 4, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 5, 2);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 5, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 6, 2);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 6, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 7, 2);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (1, 7, 1);



INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (2, 1, 3);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (2, 2, 3);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (2, 3, 3);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (2, 4, 3);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (2, 5, 4);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (2, 6, 4);


INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (3, 2, 5);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (3, 3, 5);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (3, 4, 5);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (3, 5, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (3, 5, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (3, 6, 6);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (3, 6, 1);


INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (4, 1, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (4, 2, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (4, 3, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (4, 4, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (4, 5, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (4, 6, 1);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (4, 7, 1);


INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (5, 1, 7);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (5, 2, 7);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (5, 3, 7);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (5, 4, 7);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (5, 5, 8);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (5, 6, 8);
INSERT INTO restaurant_open (res_id, day_id, hours_id) VALUES (5, 7, 7);


COMMIT TRANSACTION;