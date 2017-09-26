

create database if not exist test;
use test;


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
		 VALUES ( 1, '�ʼǱ�' ); 

INSERT INTO cateries (catery_id, catery_name) 
		 VALUES ( 2, '̨ʽ��' ); 

INSERT INTO cateries (catery_id, catery_name) 
		 VALUES ( 3, '�������' ); 





INSERT INTO products (product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0001', 3, '���� NV3', 1899 ); 

INSERT INTO products (product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0002', 2, '���� ����A6040 P4 2.8HT 512120pV(W)', 4000 );

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0003', 1, '��˶ A8Js', 6000 ); 

INSERT INTO products (product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0004', 1, '���� Compaq Presario', 6999 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0005', 3, '�´�Z712', 2060 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0006', 3, '���� T200', 3180 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0007', 3, '��ʿ S6500', 2680 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0008', 1, '���� Compaq Presario V3414TX(GP259PA)', 6550 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0009', 1, '���� ����T500N', 6998 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0010', 1, '���� Inspiron 1420(Q510802)', 6999 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0011', 1, '���� R25-X008', 7488 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0012', 2, '���� EC280(Q210506EM)', 2598 ); 

INSERT INTO products ( product_no, catery_id, product_name, product_price ) 
		 VALUES ( '0013', 2, 'TCL SHE8533', 5198 ); 






insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0001'	,	'����ʱ�˵���'	,	'ר��Ʒ��'	);	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0002'	,	'�������˳�'	,	'Ӳ������'	);	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0003'	,	'������������'	,	'���ݻ���Ʒ�ƻ�'	);	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0004'	,	'���ڴ����'	,	'���ݻ���Ʒ�ƻ�'	);	

insert  suppliers(SUPPLY_NO,SUPPLY_NAME,SUPPLY_DESCN)  values('S0005'	,	'���¹�˾'	,	'Ӳ������'	);	





insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0001'	,	'0002'	);
	
insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0001'	,	'0003'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0001'	,	'0004'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002'	,	'0005'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002'	,	'0006'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002'	,	'0007'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0003'	,	'0008'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0004'	,	'0009'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0005'	,	'0010'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0005'	,	'0011'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0002'	,	'0012'	);	

insert  product_supply(SUPPLY_NO,PRODUCT_NO)  values('S0004'	,	'0013'	);







