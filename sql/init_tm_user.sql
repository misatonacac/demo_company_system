
\c testdb;
CREATE USER usermaster_user WITH PASSWORD 'pass'
INSERT INTO tm_user(user_id,user_name,bumon_id,buten_id,group_id,role01_flg)
VALUES 
('user_1','James','F1','001','001','0');


INSERT INTO tm_bumon (bumon_id,bumon_name,display_order,apply_start_date,apply_end_date,create_date,create_user,last_update_date,last_update_user)
VALUES 
('R1','リテール部門',1,'2026-09-20','2028-09-20','2026-09-15','中村','2026-09-15','中村');



