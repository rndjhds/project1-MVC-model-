select * from tab;

select * from book;

select * from member;

select * from cart;

select * from seq;

select * from order_check;

select * from bookadmin;

update member set member_mile='27500' where member_id='1';

delete from book where book_num=5100;


create table cart(
cart_no number primary key,
member_id varchar2(50) not null,
cbook_num number not null,
cbook_name varchar2(50) not null,
cbook_price number not null );

create sequence cart_seq
start with 1
increment by 1
nocache;

drop table sale;