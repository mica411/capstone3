-- data.sql

 DROP TABLE IF EXISTS lobby, restaurant, group_votes;
--NEW:
CREATE TABLE restaurant (
    res_id serial NOT NULL,
    retsurant_name varchar(255) NOT NULL,
    street varchar(255) NOT NULL,
    cuisine_type varchar(50) NOT NULL,
    city varchar(50) NOT NULL,
    state_name varchar(50) NOT NULL,
    zip int NOT NULL,
    phone_number int NOT NULL,
    open_hour varchar(255) NOT NULL,
    CONSTRAINT restaurant_pk PRIMARY KEY (res_id)
) WITH (
  OIDS=FALSE
);
CREATE TABLE lobby (
    group_id serial NOT NULL,
    group_user varchar(255) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT lobby_pk PRIMARY KEY (group_id)
) WITH (
  OIDS=FALSE
);
CREATE TABLE group_votes (
    group_id int NOT NULL,
    thumbs_up int,
    res_id int NOT NULL,
    thumbs_dowm int
) WITH (
  OIDS=FALSE
);
ALTER TABLE lobby ADD CONSTRAINT lobby_fk0 FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE group_votes ADD CONSTRAINT group_votes_fk0 FOREIGN KEY (group_id) REFERENCES lobby(group_id);
ALTER TABLE group_votes ADD CONSTRAINT group_votes_fk1 FOREIGN KEY (res_id) REFERENCES restaurant(res_id);