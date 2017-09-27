create database if not exists test character set utf8;
use test;

create table person(
pid int primary key,
pname varchar(50) not null
)default charset=utf8;

create table card(
cid int primary key,
cname varchar(50) not null
)default charset=utf8;

create table CATERIES (
   CATERY_ID int,
   CATERY_NAME varchar(100) not null,
   CATERY_DESCN varchar(500),
   constraint PK_CATERIES primary key  (CATERY_ID)
)default charset=utf8;


create table PRODUCTS (
   PRODUCT_NO           varchar(10)          not null,
   CATERY_ID          int               not null,
   PRODUCT_NAME         varchar(300)         not null,
   PRODUCT_PRICE        float                not null,
   PHOTO_PATH           varchar(100)         null,
   PRODUCT_DESCN        varchar(2000)        null,
   constraint PK_PRODUCTS primary key  (PRODUCT_NO)
)default charset=utf8;



create table PRODUCT_SUPPLY (
   SUPPLY_NO            varchar(10)          null,
   PRODUCT_NO           varchar(10)          null
)default charset=utf8;

create table SUPPLIERS (
   SUPPLY_NO            varchar(10)          not null,
   SUPPLY_NAME          varchar(200)         not null,
   SUPPLY_DESCN         varchar(400)         null,
   constraint PK_SUPPLIERS primary key  (SUPPLY_NO)
)default charset=utf8;



INSERT INTO cateries (catery_id, catery_name) 
		 VALUES (1, '笔记本'); 

INSERT INTO cateries (catery_id, catery_name) 
		 VALUES (2, '台式机'); 

INSERT INTO cateries (catery_id, catery_name) 
		 VALUES (3, '数码相机'); 





INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0001', 3, '三星 NV3', 1899); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0002', 2, '联想 锋行A6040 P4 2.8HT 512120pV(W)', 4000); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0003', 1, '华硕 A8Js', 6000); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0004', 1, '惠普 Compaq Presario', 6999); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0005', 3, '柯达Z712', 2060); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0006', 3, '索尼 T200', 3180); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0007', 3, '富士 S6500', 2680); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0008', 1, '惠普 Compaq Presario V3414TX(GP259PA)', 6550); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0009', 1, '神舟 优雅T500N', 6998); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0010', 1, '戴尔 Inspiron 1420(Q510802)', 6999); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0011', 1, '三星 R25-X008', 7488);

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0012', 2, '戴尔 EC280(Q210506EM)', 2598); 

INSERT INTO products (product_no, catery_id, product_name, product_price) 
		 VALUES ('0013', 2, 'TCL SHE8533', 5198); 






insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0001' , '湖南时运电脑' , '专做品牌');	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0002' , '湖南新浪潮' , '硬件批发');	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0003' , '湖南蓝威电脑' , '兼容机及品牌机');	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0004' , '联众达电脑' , '兼容机及品牌机');	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0005' , '锐新公司' , '硬件批发');	





insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0001' , '0002');
	
insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0001' , '0003');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0001' , '0004');

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002' , '0005');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002' , '0006');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002' , '0007');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0003' , '0008');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0004' , '0009');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0005' , '0010');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0005' , '0011');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002' , '0012');	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0004' , '0013');	
