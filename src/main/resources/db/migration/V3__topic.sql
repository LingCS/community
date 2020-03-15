create table topic
(
	id int auto_increment,
	title varchar(50),
	description text,
	gmt_create bigint,
	creator int,
	comment_count int default 0,
	view_count int default 0,
	like_count int default 0,
	tag varchar(256),
	constraint topic_pk
		primary key (id)
);