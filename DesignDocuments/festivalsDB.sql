# MySQL table schema for wisconsin festivals
DROP SCHEMA IF EXISTS wisconsin_festivals_local;

create schema if not exists wisconsin_festivals_local;

use wisconsin_festivals_local;

drop table if exists Region;
drop table if exists Type;
drop table if exists Festival;

#
# TABLEs
#
CREATE TABLE Region (
                        region_id INT AUTO_INCREMENT PRIMARY KEY,
                        region_name VARCHAR(30) NOT NULL
);

CREATE TABLE Type (
                      type_id INT AUTO_INCREMENT PRIMARY KEY,
                      type VARCHAR(15) NOT NULL
);

CREATE TABLE Festival (
                          festival_id INT AUTO_INCREMENT PRIMARY KEY,
                          festival_name VARCHAR(25) NOT NULL,
                          region_id INT NOT NULL,
                          type_id INT NOT NULL,
                          festival_start_date Date NOT NULL COMMENT 'YYYY-MM-DD'
);

#
# CONSTRAINTs
#
ALTER TABLE Festival
    ADD CONSTRAINT FestivalType_fk FOREIGN KEY (type_id)
        REFERENCES Type (type_id);
ALTER TABLE Festival
    ADD CONSTRAINT FestivalRegion_fk FOREIGN KEY (region_id)
        REFERENCES Region (region_id);

#
# INDEXEs
#
create index festivalName_ix
    on Festival(festival_name);
create index festivalDate_ix
    on Festival(festival_start_date);

create index type_ix
    on Type(type);

create index regionName_ix
    on Region(region_name);


#
# INSERTs
#
insert into Region (region_name) values ('North Central');
insert into Region (region_name) values ('Northwestern');
insert into Region (region_name) values ('Fox Valley');
insert into Region (region_name) values ('Northeastern');
insert into Region (region_name) values ('South Central');
insert into Region (region_name) values ('South Eastern');
insert into Region (region_name) values ('Greater Milwaukee');

insert into Type (type) values ('music');
insert into Type (type) values ('film');
insert into Type (type) values ('food');
insert into Type (type) values ('cultural');
insert into Type (type) values ('arts');
insert into Type (type) values ('community');
insert into Type (type) values ('misc/other');

insert into Festival (festival_name, region_id, type_id, festival_start_date) values ('A Festival', 1, 3, '2025-12-04');
insert into Festival (festival_name, region_id, type_id, festival_start_date) values ('The 2nd Festival', 4, 6, '2024-02-02');
insert into Festival (festival_name, region_id, type_id, festival_start_date) values ('Free Festival', 2, 4, '2024-07-08');
insert into Festival (festival_name, region_id, type_id, festival_start_date) values ('Freshly Foods Festival', 3, 2, '2025-01-15');
