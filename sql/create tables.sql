

create table user (
	openid varchar(30) primary key,
	nickname varchar(16) not null,
	sex  integer check (sex=1 or sex=2 or sex=0),
	headimgurl varchar(200) not null
);

drop table theme

create table theme(
	themeId integer primary key,
	themeName varchar(10) not null
)

alter table info drop column infoTitle

create table info(
	openid varchar(30) ,
	themeId integer,
	infoId 	 integer primary key,
	infoContent varchar(300)  check (infoContent>30),
	publishTime Date not null,
	FOREIGN KEY (openid) REFERENCES user (openid),
    FOREIGN KEY (themeId) REFERENCES theme (themeId)
)

create table image(
	infoId integer,
	imgPath varchar(200) not null,
	primary key(infoId,imgPath),
    FOREIGN KEY (infoId) REFERENCES info (infoId)
)

create table likeInfo(
	openId varchar(30),
	infoId integer,
	likeStatus integer,
	primary key(openId,infoId),
    FOREIGN KEY (infoId) REFERENCES info (infoId),
    FOREIGN KEY (openId) REFERENCES user (openId)
)

drop table comment 

create table comment(
	openId varchar(30),
	infoId integer ,
	commentContent varchar(200) check (commentContent>30),
	publishDate date,
    primary key(openId,infoId),
	FOREIGN KEY (infoId) REFERENCES info (infoId),
    FOREIGN KEY (openId) REFERENCES user (openId)
)

CREATE TABLE IF NOT EXISTS `sequence` (  
  `name` varchar(50) NOT NULL,  
  `current_value` int(11) NOT NULL,  
  `increment` int(11) NOT NULL DEFAULT '1'  
) 

  
INSERT INTO `sequence` (`name`, `current_value`, `increment`) VALUES ('themeId', 0, 1);
INSERT INTO `sequence` (`name`, `current_value`, `increment`) VALUES ('infoId', 0, 1);



DROP FUNCTION IF EXISTS `currval`;  
DELIMITER //  
CREATE  FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS int(11)    
    READS SQL DATA  
    DETERMINISTIC    
BEGIN  
DECLARE VALUE INTEGER;  
SET VALUE = 0;  
SELECT current_value INTO VALUE FROM sequence WHERE NAME = seq_name;  
RETURN VALUE;  
END//  
DELIMITER ;

DROP FUNCTION IF EXISTS `nextval`;  
DELIMITER //  
CREATE  FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS int(11)  
    DETERMINISTIC  
BEGIN  
UPDATE sequence SET current_value = current_value + increment WHERE NAME = seq_name;  
RETURN currval(seq_name);  
END//  
DELIMITER ;

select currval('themeId')


