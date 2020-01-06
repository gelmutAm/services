create schema mail;

use mail;

create table users(
	id int not null auto_increment,
	email varchar(200) not null,
    constraint users_pk primary key (id)
);

create table mails(
	id int not null auto_increment,
    to_id int not null,
    theme varchar(1000) not null,
    message varchar(10000) not null,
    constraint mails_pk primary key (id),
    constraint mails_users_fk
    foreign key (to_id) references users (id) on delete cascade
);

create table users_and_mails(
	id int not null auto_increment,
    mail_id int not null,
    from_id int not null,
    constraint users_and_mails_pk primary key (id),
    constraint users_and_mails_mails_fk
    foreign key (mail_id) references mails (id) on delete cascade,
    constraint users_and_mails_users_fk
    foreign key (from_id) references users (id) on delete cascade
);