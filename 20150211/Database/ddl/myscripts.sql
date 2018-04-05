drop table JOB_DESCR cascade constraints
create table JOB_DESCR (JOB_ID number(10,0) not null, DESCR varchar2(255 char), EXPERIENCE number(10,0) not null, SKILLS varchar2(255 char), GRADE varchar2(255 char), LOCATION varchar2(255 char), primary key (JOB_ID))
alter table JOB_DESCR add constraint UK_srqsqj0lbrpt2gunmsfo59ma8  unique (DESCR)
