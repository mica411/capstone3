BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants,  business_days, business_hours;
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

CREATE TABLE business_hours(
	hours_id serial PRIMARY KEY NOT NULL,
	hours_open varchar NOT NULL
	
);

CREATE TABLE restaurants(
	res_id serial PRIMARY KEY NOT NULL,
    restaurant_name varchar(255)  NOT NULL,
   	street varchar(255)NOT NULL,
   	cuisine_type varchar(50) NOT NULL,
    city varchar(50) NOT NULL,
    state_name varchar(50) NOT NULL,
    zip int NOT NULL,
    phone_number varchar NOT NULL,
	open_days int NOT NULL,
	open_hours int NOT NULL,
	CONSTRAINT restaurant_fk0 FOREIGN KEY (open_days) REFERENCES business_days(day_id),
	CONSTRAINT restaurant_fk1 FOREIGN KEY (open_hours) REFERENCES business_hours(hours_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO business_days (days_open) VALUES('Monday-Sunday');
INSERT INTO business_days (days_open) VALUES('Monday-Saturday');
INSERT INTO business_days (days_open) VALUES('Tuesday-Saturday');



INSERT INTO business_hours (hours_open) VALUES('12-16, 17-23');
INSERT INTO business_hours (hours_open) VALUES('12-22');
INSERT INTO business_hours (hours_open) VALUES('17-20:30');
INSERT INTO business_hours (hours_open) VALUES('17-23');
INSERT INTO business_hours (hours_open) VALUES('11:30-23');

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number, open_days, open_hours) 
VALUES ('Momofuku Noodle Bar', '171 1st Ave', 'Ramen', 'New York', 'NY', 10003, '212-777-7773', 1, 1);

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number, open_days, open_hours) 
VALUES ('Pure Thai Cookhouse', '766 9th Ave #2', 'Thai', 'New York', 'NY', 10019, '212-581-0999', 2, 2);

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number, open_days, open_hours) 
VALUES ('Wildair', '142 Orchard St', 'New American', 'New York', 'NY', 10002, '646-964-5624', 3, 3);

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number, open_days, open_hours) 
VALUES ('Shukette', '230 9th Ave', 'Middle Eastern', 'New York', 'NY', 10001, '212-242-1803', 1, 4);

INSERT INTO restaurants (restaurant_name, street, cuisine_type, city, state_name, zip, phone_number, open_days, open_hours) 
VALUES ('Piccola Cucine Estiatorio', '75 Thompson St', 'Sicilian', 'New York', 'NY', 10012, '646-781-9183', 1, 5);
COMMIT TRANSACTION;

--*QUERY TO SHOW RESTAURANT NAMES, OPERATION DAYS, AND HOURS*:
-- select restaurant_name, business_days.days_open, business_hours.hours_open from restaurants r
-- join business_days ON business_days.day_id = r.open_days
-- JOIN business_hours ON business_hours.hours_id = r.open_hours;