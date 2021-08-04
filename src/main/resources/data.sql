Drop table if exists Tag;
Drop table if exists Appeal;
Drop table if exists Operator_groups;
Drop table if exists Groups;
Drop table if exists Operator;

CREATE TABLE Groups
(
    id LONG NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);
insert into Groups (id)
values (1),
       (2),
       (3),
       (4);

CREATE TABLE Operator
(
    id      LONG NOT NULL AUTO_INCREMENT,
    account VARCHAR(254),
    PRIMARY KEY (id)
);

insert into Operator (account)
values ('first'),
       ('second'),
       ('third'),
       ('fourth');

CREATE TABLE Operator_groups
(
    groups_id   LONG REFERENCES Groups (id),
    operator_id LONG REFERENCES Operator (id)
);

insert into Operator_groups (groups_id, operator_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (4, 2);
CREATE TABLE Appeal
(
    id          LONG NOT NULL AUTO_INCREMENT,
    CREATE_DATE DATE,
    weight      INT,
    PRIMARY KEY (id)
);
insert into Appeal (CREATE_DATE, weight)
values ('2021-05-03', 24),
       ('2021-01-04', 24),
       ('2021-07-03', 24),
       ('2021-09-03', 24);
CREATE TABLE Tag
(
    id        LONG NOT NULL AUTO_INCREMENT,
    name      VARCHAR(254),
    groups_id LONG REFERENCES Groups (id),
    appeal_id Long REFERENCES Appeal (id),
    PRIMARY KEY (id)
);
insert into Tag (name, groups_id, appeal_id)
VALUES ('tag#1', 1, 3),
       ('tag#2', 2, 2),
       ('tag#3', 3, 1),
       ('tag#4', 1, 2),
       ('tag#5', 4, 2),
       ('tag#6', 2, 4);
