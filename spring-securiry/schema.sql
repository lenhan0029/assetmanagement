
create table USERS
(
    "ID"       INT auto_increment,
    "NAME"     VARCHAR(50),
    "USERNAME" VARCHAR(50)  not null,
    "EMAIL"    VARCHAR(50),
    "PASSWORD" VARCHAR(100) not null,
    constraint USERS_PK
        primary key ("ID")
);


create table ROLES
(
    "ID"   INT auto_increment,
    "NAME" VARCHAR(20) not null,
    constraint ROLES_PK
        primary key (ID)
);


create table USER_ROLES
(
    USER_ID INT not null,
    ROLE_ID INT not null,
    constraint USER_ROLES_PK
        primary key (USER_ID, ROLE_ID)
);


