DELETE FROM `product_image`;
DELETE FROM `category_brand`;
DELETE FROM `product`;
DELETE FROM `brand`;
DELETE FROM `category`;
DELETE FROM `member`;

insert into member(member_id)
values (1);
insert into member(member_id)
values (2);

insert into category(category_id, name)
values (1, 'Candle');
insert into category(category_id, name)
values (2, 'Diffuser');
insert into category(category_id, name)
values (3, 'Perfume');


insert into brand(brand_id, name)
values (1, 'Ferrari');
insert into brand(brand_id, name)
values (2, 'Chanel');
insert into brand(brand_id, name)
values (3, 'Versace');
insert into brand(brand_id, name)
values (4, 'Jomalone');
insert into brand(brand_id, name)
values (5, 'Cocodor');
insert into brand(brand_id, name)
values (6, 'Diptyque');
insert into brand(brand_id, name)
values (7, 'Yankee Candle');
insert into brand(brand_id, name)
values (8, 'Woodwick');
insert into brand(brand_id, name)
values (9, 'Santa Maria Novella');
insert into brand(brand_id, name)
values (10, 'Baobab collection');

insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (1, 3, 1, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (2, 3, 2, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (3, 3, 3, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (4, 3, 6, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (5, 1, 8, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (6, 1, 4, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (7, 2, 4, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (8, 3, 4, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (9, 1, 6, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (10, 2, 6, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (11, 1, 5, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (12, 2, 5, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (13, 1, 7, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (14, 3, 9, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (15, 2, 10, now());
/*
-- Query: SELECT * FROM fourhwang.product
LIMIT 0, 1000

-- Date: 2024-10-25 01:08
*/
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',1,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 오드퍼퓸',365000,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:19:49.213955');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',2,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 디 콜로니아 - 오포포낙스',210000,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 23:06:39.396833');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',3,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아이리스 오드퍼퓸',245000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 06:49:37.337500');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',4,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','퀘르치아 오드퍼퓸',245000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 16:03:56.492204');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',5,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','퀘르치아 오드퍼퓸',365000,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:37:10.443718');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',6,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','매그놀리아 오드퍼퓸',365000,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 17:54:34.737179');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',7,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','비자리아 오드퍼퓸',245000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:34:48.349944');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',8,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','프리지아 오드코롱',140000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:03:43.533382');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',9,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아이스드베리레모네이드',43000,'2024-10-21','시그니처 자캔들(L)',623,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.612278');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',10,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라일락블라썸',37000,'2024-10-21','시그니처 자캔들(M)',369,0,0,7,35,0,0,NULL,NULL,NULL,NULL,'2024-10-22 20:59:24.456445');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',11,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','조이풀(자스민&가드니아)',63000,'2024-10-21','웰리빙 컬렉션(L)',552,0,0,7,90,0,0,NULL,NULL,NULL,NULL,'2024-10-24 03:42:48.440591');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',12,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','세이지&시트러스 (Sage&Citrus)',7000,'2024-10-21','미니캔들',37,0,0,7,7,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:44:30.828823');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',13,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','소프트블랭킷 (Soft Blanket)',39000,'2024-10-21','자캔들(L)',623,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-23 23:49:56.817542');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',14,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','쇼어브리즈 (Shore Breeze)',43000,'2024-10-21','엘리베이션(L)',552,0,0,7,65,0,0,NULL,NULL,NULL,NULL,'2024-10-23 16:49:37.596441');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',15,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','솔트미스트피어니 (Salt Mist Peony)',43000,'2024-10-21','엘리베이션(L)',552,0,0,7,65,0,0,NULL,NULL,NULL,NULL,'2024-10-23 15:54:05.524780');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('C',16,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','오션에어 (Ocean Air)',43000,'2024-10-21','시그니처 텀블러(L)',567,0,0,7,66,0,0,NULL,NULL,NULL,NULL,'2024-10-24 08:17:22.829777');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',17,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라임 바질 앤 만다린 디퓨저',151000,'2024-10-21','',165,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.569748');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',18,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','레드 로즈 디퓨저',151000,'2024-10-21','',165,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 14:19:45.354607');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',19,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 34번가 생제르망',300200,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 03:29:52.058992');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',20,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','바오밥컬렉션 토템 샌드 디퓨저',750000,'2024-10-21','',2000,0,0,10,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 11:01:08.226339');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',21,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨저 34번 생제르망',302000,'2024-10-21','bottle',100,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 19:14:14.949923');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',22,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 플레르도랑줴',279000,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 23:01:16.065795');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',23,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨져 플레르 도랑줴',279000,'2024-10-21','bottle',75,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 17:17:01.474408');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',24,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 베이',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:37:07.169855');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',25,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라임 바질 앤 만다린 디퓨저',151000,'2024-10-21','',165,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 11:07:57.421252');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',27,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 34번가 생제르망',300200,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:04:13.591896');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',28,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','바오밥컬렉션 토템 샌드 디퓨저',750000,'2024-10-21','',2000,0,0,10,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 22:35:25.690924');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',29,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨저 34번 생제르망',302000,'2024-10-21','bottle',100,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 05:00:15.674134');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',30,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 플레르도랑줴',279000,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 08:30:49.293098');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',31,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨져 플레르 도랑줴',279000,'2024-10-21','bottle',75,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:42:01.438291');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',32,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 베이',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:13:27.307359');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',33,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 테스트',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:39:22.217122');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',34,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 테스트테스트',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 22:45:11.158737');



INSERT INTO `product_image` (`product_image_id`, `file_desc`, `filename`, `path`, `product_id`) VALUES
	(1, 'perfume1', 'p_001.png', 'images/file/\\p_001.png', 1),
	(2, 'perfume2', 'p_002.png', 'images/file/\\p_002.png', 2),
	(3, 'perfume3', 'p_003.png', 'images/file/\\p_003.png', 3),
	(4, 'perfume4', 'p_004.png', 'images/file/\\p_004.png', 4),
	(5, 'perfume5', 'p_005.png', 'images/file/\\p_005.png', 5),
	(6, 'perfume6', 'p_006.png', 'images/file/\\p_006.png', 6),
	(7, 'perfume7', 'p_007.png', 'images/file/\\p_007.png', 7),
	(8, 'perfume8', 'p_008.png', 'images/file/\\p_008.png', 8),
	(9, 'candle1', 'c_001.png', 'images/file/\\c_001.png', 9),
	(10, 'candle2', 'c_002.png', 'images/file/\\c_002.png', 10),
	(11, 'candle3', 'c_003.png', 'images/file/\\c_003.png', 11),
	(12, 'candle4', 'c_004.png', 'images/file/\\c_004.png', 12),
	(13, 'candle5', 'c_005.png', 'images/file/\\c_005.png', 13),
	(14, 'candle6', 'c_006.png', 'images/file/\\c_006.png', 14),
	(15, 'candle7', 'c_007.png', 'images/file/\\c_007.png', 15),
	(16, 'candle8', 'c_008.png', 'images/file/\\c_008.png', 16),
	(17, 'diffuser1', 'd_001.png', 'images/file/\\d_001.png', 17),
	(18, 'diffuser2', 'd_002.png', 'images/file/\\d_002.png', 18),
	(19, 'diffuser3', 'd_003.png', 'images/file/\\d_003.png', 19),
	(20, 'diffuser4', 'd_004.png', 'images/file/\\d_004.png', 20),
	(21, 'diffuser5', 'd_005.png', 'images/file/\\d_005.png', 21),
	(22, 'diffuser6', 'd_006.png', 'images/file/\\d_006.png', 22),
	(23, 'diffuser7', 'd_007.png', 'images/file/\\d_007.png', 23),
	(24, 'diffuser8', 'd_008.png', 'images/file/\\d_008.png', 24);