@echo off

mysql -h localhost -u root -p -D mysql  < database/create_tables.sql
mysql -h localhost -u root -p -D mysql < database/insert_data.sql
echo Database setup complete