

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

-- 二手市场新增关系表

-- 商品类型表
-- 一定要有其他分类
create table category(
	categoryId integer primary key,
    name varchar(20) not null 
)

-- 主图表
create table mainImage(
	imgId integer primary key,
    imgPath varchar(200) not null
)

-- 子图表
create table subImage(
	imgId integer,
	imgPath varchar(200) not null,
	primary key(imgId,imgPath),
    FOREIGN KEY (imgId) REFERENCES mainImage (imgId)
)
-- 主图是可以直接在goodsCenter的商品列表中可以浏览的，每个商品只有一张，商品外键关联主图表
-- 每个商品又可以有多张图片，所以添加子图表

-- 		要分成两个表的原因，为了把 商品和图片关联起来，如果图片是依赖商品表，在商品中又设置了图片id字段，这样又
-- 		会导致商品依赖图片表，所以把图片表分成主图和子图，子图和商品同时依赖主图表，做插入时，最先插入主图

-- 商品表
create table goods(
	openid varchar(30) ,
	categoryId integer,
	goodsId integer primary key,
	goodsTitle varchar(40) not null,
    goodsIntroduction varchar(300) ,
	price float not null check(price>0),
	publishTime Date not null,
    imgId integer ,
    tips varchar(30) , -- 备注 --> 可小刀，包邮，面议，等等
	FOREIGN KEY (openid) REFERENCES user (openid),
    FOREIGN KEY (categoryId) REFERENCES category (categoryId),
	FOREIGN KEY (imgId) REFERENCES mainImage (imgId)
)

-- 商品评论表
create table goodsComment(
	openId varchar(30),
	goodsId integer ,
	commentContent varchar(200) check (commentContent>30),
	publishDate date,
    primary key(openId,goodsId,publishDate),
	FOREIGN KEY (goodsId) REFERENCES goods (goodsId),
    FOREIGN KEY (openId) REFERENCES user (openId)
)
