create table role(id serial primary key, name varchar(50) not null);

create table sprint(id serial primary key, name varchar(50) not null,
			start_date timestamp not null,
			end_date timestamp not null,
			time_available integer not null);

create table status(id serial primary key, name varchar(50) not null);

create table task_type(id serial primary key, name varchar(50) not null);

create table users(id serial primary key, role integer references role(id), 
			email varchar(75));

create table task(id serial primary key,
		  task_type integer not null references task_type(id),
		  title varchar(100) not null,
		  description varchar(2048),
		  estimated_time integer,
		  real_time integer,
		  assignee integer not null references users(id),
		  sprint integer not null references sprint(id),
		  status integer not null references status(id));

create table time_log(id serial primary key,
		      task integer not null references task(id),
		      time double precision not null,
		      date timestamp not null);

create table task_comments(id serial primary key,
			   task integer not null references task(id),
			   author integer not null references users(id),
			   date timestamp not null,
			   comment varchar(2048));