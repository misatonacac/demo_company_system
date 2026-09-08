
\c testdb;
CREATE USER usermaster_user WITH PASSWORD 'pass'
INSERT INTO tm_user(user_id,user_name,bumon_id,buten_id,group_id,role01_flg)
VALUES 
('user_1','James','F1','001','001','0');