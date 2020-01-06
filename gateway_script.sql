create schema gateway;

use gateway;

create table users_and_sessions(
	id int not null auto_increment, 
    user_id integer not null,
    session_id varchar(200) not null,
    unique(user_id),
    constraint users_and_sessions_pk primary key (id)
);