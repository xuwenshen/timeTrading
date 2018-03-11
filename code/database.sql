create table User(
	UID varchar(50) not null, 
	LoginPwd varchar(100) not null,
	NickName varchar(50),
	Skills varchar(100),
	Signature varchar(100),
	primary key(UID)
);


create table UserOrder(
	OID int(16) not null auto_increment,
	NID varchar(50),
	HID varchar(50),
	Location varchar(50),
	StartTime Datetime not null,
	EndTime Datetime not null,
	Price varchar(50),
	KeyWord varchar(50),
	Description varchar(50),
	Is_ordered boolean,
	primary key(OID)
);
