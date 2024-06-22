create table if not exists notifications(
	id serial PRIMARY KEY,
	document VARCHAR (80) not null,
	status VARCHAR (20) not null,
	create_doc VARCHAR (20) not null,
	update_doc VARCHAR (20) not nulL
);