DELETE FROM `product_image`;
DELETE FROM `category_brand`;
DELETE FROM `cart_product`;
DELETE FROM `purchase_payment`;
DELETE FROM `purchase_product`;
DELETE FROM `purchase`;
DELETE FROM `payment`;
DELETE FROM `product_product_type`;
DELETE FROM `product_type`;
DELETE FROM `product`;
DELETE FROM `brand`;
DELETE FROM `category`;
DELETE FROM `cart`;
DELETE FROM `member`;
DELETE FROM `outbox`;
DELETE FROM `external_prepare_payment`;

insert into member(member_id, email)
values (1, 'qordi124@gmail.com');
insert into member(member_id)
values (2);
INSERT INTO `member` (`member_id`, `account`, `ad_received`, `address`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`, `addr`, `post_code`)
VALUES (4, NULL, NULL, NULL, 'kdh7313@naver.com', NULL, '2024-11-01', NULL, '강도현', NULL, 'USER', 1, NULL, 'http://k.kakaocdn.net/dn/b7yPFA/btsKquPi0Cw/BjABLmpyNB6gbKxUAX9I40/img_640x640.jpg', 'http://k.kakaocdn.net/dn/b7yPFA/btsKquPi0Cw/BjABLmpyNB6gbKxUAX9I40/img_110x110.jpg', NULL, NULL);

insert into cart(cart_id, quantities, member_id)
values (1, 3, 1);

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

insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (1, 'CITRUS', '오렌지, 레몬 등 새콤달콤한 특성을 지닌 과일의 향', now(), 'CITRUS');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (2, 'FRUITY', '농익은 과일의 달콤한 향', now(), 'FRUITY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (3, 'GREEN', '풀, 잎, 줄기 등을 연상시키는 신선한 향', now(), 'GREEN');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (4, 'AROMATIC', '로즈메리, 라벤더 등 허브 계열을 표현한 향', now(), 'HERBAL');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (5, 'LIGHT', '프레시, 시트러스, 그린과 같이 휘발성이 높은 향으로 지속 시간이 짧다', now(), 'CITRUS');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (6, 'HEAVY', '무겁게 가라앉아 지속력이 높은 향', now(), 'WOODY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (7, 'FLORAL', '달콤한 꽃향기', now(), 'FLORAL');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (8, 'SMOKY', '그을린 듯한 향', now(), 'WOODY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (9, 'INCENSE', '인센스 스틱을 태워서 나는 듯한 향', now(), 'WOODY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (10, 'ORIENTAL', '동양적인 향으로 발삼, 레진, 스파이시, 우디, 애니멀 향 등을 표현', now(), 'SPICY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (11, 'SPICY', '톡 쏘는 듯한 자극적이고 강한 향', now(), 'SPICY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (12, 'ANIMALIC', '동물성 향료에서 유래한 것으로 희석하여 사용할 경우 따듯한 느낌을 준다', now(), 'ANIMALIC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (13, 'LEATHER', '가죽 특유의 향', now(), 'ANIMALIC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (14, 'EARTHY', '흙, 산림 등 대지에서 비롯된 향', now(), 'WOODY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (15, 'MUSK', '사향노루에서 추출한 향으로 따듯하고 포근한 느낌의 관능적인 향', now(), 'ANIMALIC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (16, 'DRY', '마른 나무, 이끼, 건초에서 느껴지는 건조한 향', now(), 'WOODY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (17, 'ABSOLUTE', '식물에서 추출한 천연 향료', now(), 'ETC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (18, 'CHYPRE', '시원한 식물 향', now(), 'GREEN');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (19, 'WATERY', '물에서 느껴지는 상쾌하고 투명한 향', now(), 'GREEN');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (20, 'MARINE', '시원한 물과 해초류에서 느껴지는 짭조름한 느낌을 표현한 향', now(), 'GREEN');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (21, 'RESINOID', '송진, 식물 등에서 추출해 담은 향', now(), 'WOODY');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (22, 'BOUQUET', '다채로운 꽃이 혼합된 꽃다발에서 느껴지는 향', now(), 'FLORAL');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (23, 'CHORD', '화음이라는 뜻으로 개별적인 향을 섞어 탄생한 새로운 형태의 향', now(), 'ETC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (24, 'BITTER', '나무뿌리, 약초, 애니멀 노트 등 서로 다른 성격의 여러 향이 복합되어 만들어낸 향', now(), 'ETC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (25, 'NUANCE', '향의 이미지를 연상시키는 향', now(), 'ETC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (26, 'HARMONY', '여러 향을 조합해 탄생한 새로운 향', now(), 'ETC');
insert into `product_type`(product_type_id, name, info, created_date, product_type_group) values (27, 'TRAIL', '향수를 뿌린 후 지속되는 향의 여운, 잔향', now(), 'ETC');

/*
-- Query: SELECT * FROM fourhwang.product
LIMIT 0, 1000

-- Date: 2024-10-25 01:08
*/
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',1,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 오드퍼퓸',1,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:19:49.213955');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',2,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 디 콜로니아 - 오포포낙스',1,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 23:06:39.396833');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('P',3,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아이리스 오드퍼퓸',1,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 06:49:37.337500');
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
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',25,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라임 바질 앤 만다린 디퓨저',151000,'2024-10-21','',165,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 11:07:57.421252');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',27,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 34번가 생제르망',300200,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:04:13.591896');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',28,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','바오밥컬렉션 토템 샌드 디퓨저',750000,'2024-10-21','',2000,0,0,10,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 22:35:25.690924');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',29,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨저 34번 생제르망',302000,'2024-10-21','bottle',100,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 05:00:15.674134');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',30,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 플레르도랑줴',279000,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 08:30:49.293098');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',31,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨져 플레르 도랑줴',279000,'2024-10-21','bottle',75,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:42:01.438291');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',32,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 베이',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:13:27.307359');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',33,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 테스트',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:39:22.217122');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',34,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 테스트테스트',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 22:45:11.158737');

insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(1, 5, 17);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(2, 12, 4);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(3, 8, 22);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(4, 19, 24);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(5, 3, 11);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(6, 26, 7);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(7, 14, 23);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(8, 10, 5);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(9, 21, 2);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(10, 1, 21);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(11, 6, 1);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(12, 18, 3);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(13, 13, 6);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(14, 9, 8);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(15, 24, 9);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(16, 2, 10);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(17, 11, 12);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(18, 15, 13);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(19, 7, 14);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(20, 27, 15);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(21, 4, 16);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(22, 23, 18);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(23, 20, 19);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(24, 16, 20);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(25, 25, 21);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(26, 22, 23);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(27, 17, 24);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(28, 3, 15);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(29, 12, 12);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(30, 8, 17);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(31, 14, 18);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(32, 19, 20);
insert into `product_product_type`(product_product_type_id, product_type_id, product_id) values(33, 9, 11);

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