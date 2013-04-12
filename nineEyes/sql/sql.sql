-- -------
-- 管理员表Admin
-- -------
create table Admin
(
	ID int(4) not null,
	NAME varchar(30) not null,
	PASSWORD varchar(50) not null,
	STATE char(1) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
alter table Admin add primary key(ID);
alter table Admin modify ID int(4) not null auto_increment;
-- ------------
-- BigIndex表
-- ------------
create table BigIndex
(
	ID int(4) not null,
	URL varchar(200) not null,
	INTRO varchar(50) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
alter table BigIndex add primary key(ID);
alter table BigIndex modify ID int(4) not null auto_increment;
alter table BigIndex add column NAME varchar(50) not null;
alter table BigIndex add column CREATETIME datetime not null;
alter table BigIndex add column STATE varchar(1) not null default '0';
-- --------------
--    新闻表
-- -----------------
create table News
(
	ID int(4) not null primary key auto_increment,
	CONTENT text not null,
	CREATETIME datetime not null,
	AUTHOR varchar(30) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
alter table News add column TITLE varchar(50) not null;
alter table News add column CATEGORY char(1) not null default '0';
-- ---------------------
-- 链接新闻表
-- -----------------------
create table LinkNews
(
	ID int(4) not null primary key auto_increment,
	TITLE varchar(50) not null,
	URL varchar(600) not null,
	AUTHOR varchar(50) not null,
	CREATETIME datetime not null
)engine=innodb default charset=utf8 collate=utf8_bin;
-- -----------
-- 媒体分类
-- -----------
create table MediaCategory
(
	ID int(4) not null primary key auto_increment,
	NAME varchar(100) not null,
	INTRO text not null
)engine=innodb default charset=utf8 collate=utf8_bin;

-- ---
-- 媒体
-- ---
create table Media
(
	ID int(4) not null primary key auto_increment,
	TITLE varchar(50) not null,
	OUTLINE text not null,
	INTRO text not null,
	URL varchar(600) not null,
	AUTHOR varchar(50) not null,
	CREATETIME datetime not null,
	CATEGORY int(4) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
alter table Media add constraint FK_Media_Category foreign key(CATEGORY) references MediaCategory(ID);
-- ---------
-- 媒体图片
-- ---------
create table MediaPic
(
	ID int(4) not null primary key auto_increment,
	URL varchar(800) not null,
	MEDIA int(4) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
alter table MediaPic add constraint FK_MediaPic_Media foreign key(MEDIA) references Media(ID);
alter table MediaPic add column TYPE char(1) not null default '0';

-- -------------
-- 事件(活动与交流)
-- -------------
create table Event
(
	ID int(4) not null primary key auto_increment,
	TITLE varchar(50) not null,
	OUTLINE text not null,
	INTRO text not null,
	AUTHOR varchar(50) not null,
	CREATETIME datetime not null,
	CATEGORY char(1) not null default '0'
)engine=innodb default charset=utf8 collate=utf8_bin;
-- -------
-- EventToMedia
-- ------------
create table EventToMedia
(
	EVENT int(4) not null,
	MEDIA int(4) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
alter table EventToMedia add constraint fk_eventToMedia_Event foreign key(EVENT) references Event(ID);
alter table EventToMedia add constraint fk_eventToMedia_Media foreign key(MEDIA) references Media(ID);
-- -------
-- EventToNews
-- --------------
create table EventToNews
(
	EVENT int(4) not null,
	NEWS int(4) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
alter table EventToNews add constraint fk_EventToNews_Event foreign key(EVENT) references Event(ID);
alter table EventToNews add constraint fk_EventToNews_News foreign key(NEWS) references News(ID);
alter table MediaPic add column BELONG char(1) not null default '0';
ALTER TABLE mediapic DROP INDEX FK_MediaPic_Media;

ALTER TABLE mediapic DROP FOREIGN KEY FK_MediaPic_Media;


-- ---------------------
-- 链接新闻表
-- -----------------------
create table LinkNewsEvent
(
	ID int(4) not null primary key auto_increment,
	TITLE varchar(50) not null,
	URL varchar(600) not null,
	EVENT int(4) not null
)engine=innodb default charset=utf8 collate=utf8_bin;
ALTER table LinkNewsEvent add constraint fk_linkNewsEvent foreign key(EVENT) references Event(ID);
ALTER table News add column SORT int(4) not null default '0'; -- 用来标识大分类下哪个小分类
ALTER table News add column OUTLINE text; --  用来加入概述
ALTER table News add column PRIORITY char(1) not null default '0'; -- 标识优先级