create table toy (
	id identity,
	name varchar not null,
	description varchar not null,
	onhand int not null
);

create table child (
	id identity,
	name varchar not null,
	address varchar not null,
	naughty boolean default false
);
