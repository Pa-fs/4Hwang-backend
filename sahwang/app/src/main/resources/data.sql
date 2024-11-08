DELETE FROM `product_image`;
DELETE FROM `category_brand`;
DELETE FROM `cart_product`;
DELETE FROM `purchase_payment`;
DELETE FROM `favorite`;
DELETE FROM `review_image`;
DELETE FROM `review`;
DELETE FROM `purchase_product`;
DELETE FROM `purchase`;
DELETE FROM `payment`;
DELETE FROM `product_product_type`;
DELETE FROM `product_type`;
DELETE FROM `detail_image`;
DELETE FROM `product`;
DELETE FROM `brand`;
DELETE FROM `category`;
DELETE FROM `cart`;
DELETE FROM `member`;
DELETE FROM `outbox`;
DELETE FROM `external_prepare_payment`;



insert into member(member_id, email, addr, post_code, phone_num)
values (1, 'qordi124@gmail.com', '대구광역시 중구', '123-456', '010-1234-5678');
insert into member(member_id, addr, post_code, phone_num)
values (2, '대구광역시 중구', '345-678', '010-1234-5678');
INSERT INTO `member` (`member_id`, `account`, `ad_received`, `addr`, `post_code`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`)
VALUES (3, NULL, NULL, '대구광역시 중구', '234-567', 'whgpals4263@nate.com', NULL, '2024-10-31', NULL, '민이♡', '010-1234-5678', 'USER', 1, NULL, 'http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg', 'http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg');
INSERT INTO `member` (`member_id`, `account`, `ad_received`, `addr`, `post_code`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`)
VALUES (4, NULL, NULL, '대구광역시 중구', '567-988', 'kdh7313@naver.com', NULL, '2024-11-01', NULL, '강도현', '010-1234-5678', 'USER', 1, NULL, 'http://k.kakaocdn.net/dn/b7yPFA/btsKquPi0Cw/BjABLmpyNB6gbKxUAX9I40/img_640x640.jpg', 'http://k.kakaocdn.net/dn/b7yPFA/btsKquPi0Cw/BjABLmpyNB6gbKxUAX9I40/img_110x110.jpg');
INSERT INTO `member` (`member_id`, `account`, `ad_received`, `addr`, `post_code`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`)
VALUES (5, NULL, NULL, '대구광역시 중구', '999-100', 'thdghckd111@naver.com', NULL, '2024-11-01', NULL, '송호창', '010-1234-5678', 'USER', 1, NULL, 'http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg', 'http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg');

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
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',1,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 오드퍼퓸',1,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:19:49.213955', 'p_001.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',2,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 디 콜로니아 - 오포포낙스',1,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 23:06:39.396833', 'p_002.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',3,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아이리스 오드퍼퓸',1,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 06:49:37.337500', 'p_003.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',4,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','퀘르치아 오드퍼퓸',245000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 16:03:56.492204', 'p_004.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',5,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','퀘르치아 오드퍼퓸',365000,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:37:10.443718', 'p_005.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',6,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','매그놀리아 오드퍼퓸',365000,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 17:54:34.737179', 'p_006.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',7,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','비자리아 오드퍼퓸',245000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:34:48.349944', 'p_007.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',8,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','프리지아 오드코롱',140000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:03:43.533382', 'p_008.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',9,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아이스드베리레모네이드',43000,'2024-10-21','시그니처 자캔들(L)',623,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.612278', 'c_001.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',10,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라일락블라썸',37000,'2024-10-21','시그니처 자캔들(M)',369,0,0,7,35,0,0,NULL,NULL,NULL,NULL,'2024-10-22 20:59:24.456445', 'c_002.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',11,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','조이풀(자스민&가드니아)',63000,'2024-10-21','웰리빙 컬렉션(L)',552,0,0,7,90,0,0,NULL,NULL,NULL,NULL,'2024-10-24 03:42:48.440591', 'c_003.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',12,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','세이지&시트러스 (Sage&Citrus)',7000,'2024-10-21','미니캔들',37,0,0,7,7,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:44:30.828823', 'c_004.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',13,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','소프트블랭킷 (Soft Blanket)',39000,'2024-10-21','자캔들(L)',623,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-23 23:49:56.817542', 'c_005.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',14,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','쇼어브리즈 (Shore Breeze)',43000,'2024-10-21','엘리베이션(L)',552,0,0,7,65,0,0,NULL,NULL,NULL,NULL,'2024-10-23 16:49:37.596441', 'c_006.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',15,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','솔트미스트피어니 (Salt Mist Peony)',43000,'2024-10-21','엘리베이션(L)',552,0,0,7,65,0,0,NULL,NULL,NULL,NULL,'2024-10-23 15:54:05.524780', 'c_007.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',16,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','오션에어 (Ocean Air)',43000,'2024-10-21','시그니처 텀블러(L)',567,0,0,7,66,0,0,NULL,NULL,NULL,NULL,'2024-10-24 08:17:22.829777', 'c_008.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',17,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라임 바질 앤 만다린 디퓨저',151000,'2024-10-21','',165,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.569748', 'd_001.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',18,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','레드 로즈 디퓨저',151000,'2024-10-21','',165,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 14:19:45.354607', 'd_002.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',19,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 34번가 생제르망',300200,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 03:29:52.058992', 'd_003.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',20,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','바오밥컬렉션 토템 샌드 디퓨저',750000,'2024-10-21','',2000,0,0,10,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 11:01:08.226339', 'd_004.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',21,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨저 34번 생제르망',302000,'2024-10-21','bottle',100,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 19:14:14.949923', 'd_005.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',22,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 플레르도랑줴',279000,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 23:01:16.065795', 'd_006.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',23,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨져 플레르 도랑줴',279000,'2024-10-21','bottle',75,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 17:17:01.474408', 'd_007.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',24,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 베이',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:37:07.169855', 'd_008.png');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',25,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라임 바질 앤 만다린 디퓨저',151000,'2024-10-21','',165,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 11:07:57.421252');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',27,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 34번가 생제르망',300200,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:04:13.591896');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',28,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','바오밥컬렉션 토템 샌드 디퓨저',750000,'2024-10-21','',2000,0,0,10,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 22:35:25.690924');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',29,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨저 34번 생제르망',302000,'2024-10-21','bottle',100,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 05:00:15.674134');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',30,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 플레르도랑줴',279000,'2024-10-21','',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 08:30:49.293098');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',31,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아워글라스 디퓨져 플레르 도랑줴',279000,'2024-10-21','bottle',75,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:42:01.438291');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',32,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 베이',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:13:27.307359');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',33,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 테스트',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:39:22.217122');
--INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`) VALUES ('D',34,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리드 디퓨저 테스트테스트',279000,'2024-10-21','bottle',200,0,0,6,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 22:45:11.158737');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',25,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 오드퍼퓸',50,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:19:49.213955', 'p_001.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',26,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아쿠아 디 콜로니아 - 오포포낙스',100,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 23:06:39.396833', 'p_002.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',27,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아이리스 오드퍼퓸',100,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 06:49:37.337500', 'p_003.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',28,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','퀘르치아 오드퍼퓸',100,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 16:03:56.492204', 'p_004.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',29,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','퀘르치아 오드퍼퓸',100,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:37:10.443718', 'p_005.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',30,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','매그놀리아 오드퍼퓸',100,'2024-10-21','',100,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 17:54:34.737179', 'p_006.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',31,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','비자리아 오드퍼퓸',100,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:34:48.349944', 'p_007.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',32,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','프리지아 오드코롱',100,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:03:43.533382', 'p_008.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('C',33,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','아이스드베리레모네이드',25000,'2022-11-14 16:15:42.169748','시그니처 자캔들(M)',369,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.612278', 'c_001.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('D',34,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','라임 바질 앤 만다린 디퓨저',99000,'2023-12-24 16:15:42.169748','',90,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.569748', 'd_001.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',35,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','미스 디올 블루밍 부케',96000,'2024-09-14 15:15:42.169748','',30,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:19:49.213955', 'p_009.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',36,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','미스 디올 퍼퓸',133000,'2024-10-14 14:13:42.169748','',35,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 23:06:39.396833', 'p_010.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',37,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','소바쥬 오 드 뚜왈렛',100800,'2024-10-24 11:15:42.169748','',30,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 06:49:37.337500', 'p_011.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',38,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','디올 옴므 코롱',142000,'2024-01-24 21:15:42.169748','',75,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 16:03:56.492204', 'p_012.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',39,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','디올 옴므 인텐스 오 드 퍼퓸',143000,'2024-09-24 16:15:42.169748','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:37:10.443718', 'p_013.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',40,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','가브리엘 샤넬 에쌍스 오 드 빠르펭',193000,'2024-10-21','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 17:54:34.737179', 'p_014.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',41,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','레 조 드 샤넬 파리-파리 오 드 뚜왈렛 스프레이',228000,'2024-10-21','',125,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:34:48.349944', 'p_015.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',42,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 오 드 빠르펭',205000,'2024-11-04 01:15:42.169348','',50,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:03:43.533382', 'p_016.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',43,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 오 드 빠르펭',292000,'2024-10-14 12:14:42.169748','',90,0,0,9,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:03:43.533382', 'p_016.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',44,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','몽파리 오 드 뚜왈렛 루미에르',99000,'2024-10-24 06:15:41.169748','시그니처 자캔들(M)',30,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.615278', 'p_017.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',45,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','몽파리 오 드 뚜왈렛 루미에르',163000,'2024-10-24 06:15:42.269741','시그니처 자캔들(M)',50,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.712278', 'p_017.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',46,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','몽파리 오 드 뚜왈렛 루미에르',227000,'2024-10-24 06:13:42.169748','시그니처 자캔들(M)',90,0,0,7,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.112278', 'p_017.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',47,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 앱솔루트 플라틴',225000,'2024-10-25 06:15:41.169748','',50,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.119748', 'p_018.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',48,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 앱솔루트 플라틴',315000,'2024-10-21 06:15:41.269748','',90,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.224748', 'p_018.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',49,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 플라워 & 플레임',198000,'2024-10-22 06:15:41.369748','',50,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.379748', 'p_019.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',50,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 플라워 & 플레임',279000,'2024-10-23 06:15:41.469748','',90,0,0,4,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.459748', 'p_019.png');
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
	(24, 'diffuser8', 'd_008.png', 'images/file/\\d_008.png', 24),
    (25, 'perfume9', 'p_009.png', 'images/file/\\p_009.png', 35),
    (26, 'perfume10', 'p_010.png', 'images/file/\\p_010.png', 36),
    (27, 'perfume11', 'p_011.png', 'images/file/\\p_011.png', 37),
    (28, 'perfume12', 'p_012.png', 'images/file/\\p_012.png', 38),
    (29, 'perfume13', 'p_013.png', 'images/file/\\p_013.png', 39),
    (30, 'perfume14', 'p_014.png', 'images/file/\\p_014.png', 40),
    (31, 'perfume15', 'p_015.png', 'images/file/\\p_015.png', 41),
    (32, 'perfume16', 'p_016.png', 'images/file/\\p_016.png', 42),
    (33, 'perfume16', 'p_016.png', 'images/file/\\p_016.png', 43),
    (34, 'perfume17', 'p_017.png', 'images/file/\\p_017.png', 44),
    (35, 'perfume17', 'p_017.png', 'images/file/\\p_017.png', 45),
    (36, 'perfume17', 'p_017.png', 'images/file/\\p_017.png', 46),
    (37, 'perfume18', 'p_018.png', 'images/file/\\p_018.png', 47),
    (38, 'perfume18', 'p_018.png', 'images/file/\\p_018.png', 48),
    (39, 'perfume19', 'p_019.png', 'images/file/\\p_019.png', 49),
    (40, 'perfume19', 'p_019.png', 'images/file/\\p_019.png', 50),
    (41, 'perfume20', 'aqua_perfume_1.jpg', 'images/file/\\aqua_perfume_1.jpg', 1),
    (42, 'perfume21', 'aqua_perfume_2.jpg', 'images/file/\\aqua_perfume_2.jpg', 1),
    (43, 'perfume22', 'aqua_perfume_3.jpg', 'images/file/\\aqua_perfume_3.jpg', 1),
	(44, 'perfume1', 'p_001.png', 'images/file/\\p_001.png', 25),
	(45, 'perfume2', 'p_002.png', 'images/file/\\p_002.png', 26),
	(46, 'perfume3', 'p_003.png', 'images/file/\\p_003.png', 27),
	(47, 'perfume4', 'p_004.png', 'images/file/\\p_004.png', 28),
	(48, 'perfume5', 'p_005.png', 'images/file/\\p_005.png', 29),
	(49, 'perfume6', 'p_006.png', 'images/file/\\p_006.png', 30),
    (50, 'perfume7', 'p_007.png', 'images/file/\\p_007.png', 31),
    (51, 'perfume8', 'p_008.png', 'images/file/\\p_008.png', 32),
    (52, 'candle1', 'c_001.png', 'images/file/\\c_001.png', 33),
    (53, 'diffuser1', 'd_001.png', 'images/file/\\d_001.png', 34);

-- purchase
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000001, now(), 'COMPLETED', 730000, 3);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000002, now(), 'COMPLETED', 730000, 4);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000003, now(), 'COMPLETED', 730000, 5);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000004, now(), 'COMPLETED', 730000, 4);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000005, now(), 'COMPLETED', 730000, 3);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000006, now(), 'COMPLETED', 730000, 3);

-- purchase_product
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, product_id, purchase_id) VALUES (10000001, '아쿠아 오드퍼퓸', 2, now(), 1, 10000001);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, product_id, purchase_id) VALUES (10000002, '아이스드베리레모네이드', 2, now(), 9, 10000002);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, product_id, purchase_id) VALUES (10000003, '라임 바질 앤 만다린 디퓨저', 2, now(), 17, 10000003);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, product_id, purchase_id) VALUES (10000004, '아쿠아 오드퍼퓸', 2, now(), 25, 10000004);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, product_id, purchase_id) VALUES (10000005, '아이스드베리레모네이드', 2, now(), 33, 10000005);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, product_id, purchase_id) VALUES (10000006, '라임 바질 앤 만다린 디퓨저', 2, now(), 34, 10000006);

-- payment
INSERT INTO payment (payment_id,total_price, member_id) VALUES (10000001, 100000, 5);

-- purchase_payment
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000001, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000001);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000002, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000002);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000003, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000003);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000004, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000004);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000005, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000005);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000006, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000006);

INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000007, NULL, NOW() - INTERVAL 25 DAY, 10000001, 10000001);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000008, NULL, NOW() - INTERVAL 2 MONTH, 10000001, 10000002);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000009, NULL, NOW() - INTERVAL 28 DAY, 10000001, 10000003);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000010, NULL, NOW() - INTERVAL 4 MONTH, 10000001, 10000004);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000011, NULL, NOW() - INTERVAL 250 DAY, 10000001, 10000005);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000012, NULL, NOW() - INTERVAL 40 DAY, 10000001, 10000006);

INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000013, NULL, now(), 10000001, 10000001);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000014, NULL, now(), 10000001, 10000002);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000015, NULL, now(), 10000001, 10000003);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000016, NULL, now() - INTERVAL 83 DAY, 10000001, 10000004);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000017, NULL, now(), 10000001, 10000005);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id) VALUES (10000018, NULL, now(), 10000001, 10000006);


-- review
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000001, 3, 10000001, now(), 4.0, '향수가 정말 좋네요! 조금 강하지만 오래 지속되어 좋습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000002, 5, 10000001, now(), 5.0, '너무 좋아요! 향이 은은하면서도 매력적입니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000003, 4, 10000001, now(), 5.0, '상쾌하고 가벼운 향이 일상적으로 사용하기 좋아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000004, 3, 10000001, now(), 4.0, '디자인도 예쁘고 향도 꽤 좋아요. 다만 조금 더 달콤했으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000005, 5, 10000001, now(), 3.0, '향은 괜찮지만 금방 사라져서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000006, 4, 10000001, now(), 2.0, '향은 너무 강하게 느껴져서 별로였습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000007, 3, 10000001, now(), 1.0, '향이 너무 강하고 불쾌한 냄새가 나요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000008, 5, 10000001, now(), 2.0, '처음엔 괜찮았는데 시간이 지나면서 냄새가 너무 싫어졌어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000009, 4, 10000001, now(), 5.0, '이 향수는 정말 내 스타일이에요. 가볍고 부드러워서 자주 쓰게 될 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000010, 3, 10000001, now(), 4.0, '향수가 너무 진하지 않고 좋은데, 조금 더 지속성이 길었으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000011, 5, 10000001, now(), 5.0, '너무 좋은 향수예요. 제 취향에 딱 맞아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000012, 4, 10000001, now(), 5.0, '마음에 들어요. 자주 사용할 수 있을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000013, 3, 10000001, now(), 4.0, '향수는 좋지만 좀 더 달콤한 향이면 더 좋을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000014, 5, 10000001, now(), 3.0, '향은 좋은데 금방 사라지는 것 같아서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000015, 4, 10000001, now(), 2.0, '향이 너무 진하고 고급스러운 느낌이 부족해서 좀 실망스러웠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000016, 3, 10000001, now(), 1.0, '향수에서 기대했던 것보다 많이 실망했습니다. 너무 불쾌한 냄새가 나요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000017, 5, 10000001, now(), 2.0, '향수는 좋지만 지속시간이 짧아요. 다시 구매할지는 모르겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000018, 4, 10000001, now(), 5.0, '상쾌하고 청량한 느낌의 향수예요. 아주 좋아요!');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000019, 3, 10000001, now(), 4.0, '향이 정말 좋고 오래가서 만족스러워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000020, 5, 10000001, now(), 5.0, '정말 마음에 들어요. 향기가 계속 남아서 좋습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000021, 4, 10000001, now(), 5.0, '이 향수는 정말 매력적이고, 너무 강하지 않아서 일상적으로 사용하기 좋습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000022, 3, 10000001, now(), 4.0, '향은 좋지만 가격대에 비해 지속성이 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000023, 5, 10000001, now(), 3.0, '향이 괜찮긴 한데 너무 빨리 사라져서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000024, 4, 10000001, now(), 2.0, '향이 너무 강하고 부담스러워서 잘 사용하지 않게 되네요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000025, 3, 10000001, now(), 1.0, '향이 너무 강하고 싫어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000026, 5, 10000001, now(), 2.0, '처음에는 괜찮았지만 시간이 지나면서 냄새가 너무 강해졌어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000027, 4, 10000001, now(), 5.0, '상쾌하고 부드러운 향이 오래 지속돼서 좋아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000028, 3, 10000001, now(), 4.0, '달콤하고 여성스러운 향수예요. 지속력은 좋지만 너무 강한 느낌이 있습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000029, 5, 10000001, now(), 5.0, '정말 좋아요! 은은하면서도 고급스러운 느낌이에요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000030, 4, 10000001, now(), 5.0, '향수가 정말 마음에 들어요. 청량하고 상큼해서 기분 좋아져요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000031, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 1향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000032, 5, 10000001, now(), 3.0, '오드퍼퓸(100) 2향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000033, 4, 10000001, now(), 2.0, '오드퍼퓸(100) 3향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000034, 3, 10000001, now(), 1.0, '오드퍼퓸(100) 4향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000035, 5, 10000001, now(), 2.0, '오드퍼퓸(100) 5향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000036, 4, 10000001, now(), 5.0, '오드퍼퓸(100) 6향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000037, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 7향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000038, 5, 10000001, now(), 5.0, '오드퍼퓸(100) 8향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000039, 4, 10000001, now(), 5.0, '오드퍼퓸(100) 9향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000040, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 10향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000041, 5, 10000001, now(), 5.0, '오드퍼퓸(100) 11향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000042, 4, 10000001, now(), 5.0, '오드퍼퓸(100) 12향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000043, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 13향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000044, 5, 10000001, now(), 3.0, '오드퍼퓸(100) 14향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000045, 4, 10000001, now(), 2.0, '오드퍼퓸(100) 15향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000046, 3, 10000001, now(), 1.0, '오드퍼퓸(100) 16향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000047, 5, 10000001, now(), 2.0, '오드퍼퓸(100) 17향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000048, 4, 10000001, now(), 5.0, '오드퍼퓸(100) 18향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000049, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 19향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000050, 5, 10000001, now(), 5.0, '오드퍼퓸(100) 20향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000051, 4, 10000001, now(), 5.0, '오드퍼퓸(100) 21향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000052, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 22향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000053, 5, 10000001, now(), 3.0, '오드퍼퓸(100) 23향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000054, 4, 10000001, now(), 2.0, '오드퍼퓸(100) 24향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000055, 3, 10000001, now(), 1.0, '오드퍼퓸(100) 25향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000056, 5, 10000001, now(), 2.0, '오드퍼퓸(100) 26향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000057, 4, 10000001, now(), 5.0, '오드퍼퓸(100) 28향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000058, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 29향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000059, 5, 10000001, now(), 5.0, '오드퍼퓸(100) 30향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000060, 4, 10000001, now(), 5.0, '오드퍼퓸(100) 31향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000061, 3, 10000001, now(), 4.0, '오드퍼퓸(100) 32향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000062, 5, 10000001, now(), 3.0, '오드퍼퓸(100) 33향이 좋아요~~');

INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000064, 3, 10000002, now(), 4.0, '아이스(623) 향수가 정말 좋네요! 조금 강하지만 오래 지속되어 좋습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000065, 5, 10000002, now(), 5.0, '아이스(623) 너무 좋아요! 향이 은은하면서도 매력적입니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000066, 4, 10000002, now(), 5.0, '아이스(623) 상쾌하고 가벼운 향이 일상적으로 사용하기 좋아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000067, 3, 10000002, now(), 4.0, '아이스(623) 디자인도 예쁘고 향도 꽤 좋아요. 다만 조금 더 달콤했으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000068, 5, 10000002, now(), 3.0, '아이스(623) 향은 괜찮지만 금방 사라져서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000069, 4, 10000002, now(), 2.0, '아이스(623) 향은 너무 강하게 느껴져서 별로였습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000070, 3, 10000002, now(), 1.0, '아이스(623) 향이 너무 강하고 불쾌한 냄새가 나요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000071, 5, 10000002, now(), 2.0, '아이스(623) 처음엔 괜찮았는데 시간이 지나면서 냄새가 너무 싫어졌어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000072, 4, 10000002, now(), 5.0, '아이스(623) 이 향수는 정말 내 스타일이에요. 가볍고 부드러워서 자주 쓰게 될 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000073, 3, 10000002, now(), 4.0, '아이스(623) 향수가 너무 진하지 않고 좋은데, 조금 더 지속성이 길었으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000074, 5, 10000002, now(), 5.0, '아이스(623) 너무 좋은 향수예요. 제 취향에 딱 맞아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000075, 4, 10000002, now(), 5.0, '아이스(623) 마음에 들어요. 자주 사용할 수 있을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000076, 3, 10000002, now(), 4.0, '아이스(623) 향수는 좋지만 좀 더 달콤한 향이면 더 좋을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000077, 5, 10000002, now(), 3.0, '아이스(623) 향은 좋은데 금방 사라지는 것 같아서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000078, 4, 10000002, now(), 2.0, '아이스(623) 향이 너무 진하고 고급스러운 느낌이 부족해서 좀 실망스러웠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000079, 3, 10000002, now(), 1.0, '아이스(623) 향수에서 기대했던 것보다 많이 실망했습니다. 너무 불쾌한 냄새가 나요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000080, 5, 10000002, now(), 2.0, '아이스(623) 향수는 좋지만 지속시간이 짧아요. 다시 구매할지는 모르겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000081, 4, 10000002, now(), 5.0, '아이스(623) 상쾌하고 청량한 느낌의 향수예요. 아주 좋아요!');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000082, 3, 10000002, now(), 4.0, '아이스(623) 향이 정말 좋고 오래가서 만족스러워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000083, 5, 10000002, now(), 5.0, '아이스(623) 정말 마음에 들어요. 향기가 계속 남아서 좋습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000084, 4, 10000002, now(), 5.0, '아이스(623) 이 향수는 정말 매력적이고, 너무 강하지 않아서 일상적으로 사용하기 좋습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000085, 3, 10000002, now(), 4.0, '아이스(623) 향은 좋지만 가격대에 비해 지속성이 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000086, 5, 10000002, now(), 3.0, '아이스(623) 향이 괜찮긴 한데 너무 빨리 사라져서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000087, 4, 10000002, now(), 2.0, '아이스(623) 향이 너무 강하고 부담스러워서 잘 사용하지 않게 되네요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000088, 3, 10000002, now(), 1.0, '아이스(623) 향이 너무 강하고 싫어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000089, 5, 10000002, now(), 2.0, '아이스(623) 처음에는 괜찮았지만 시간이 지나면서 냄새가 너무 강해졌어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000090, 4, 10000002, now(), 5.0, '아이스(623) 상쾌하고 부드러운 향이 오래 지속돼서 좋아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000091, 3, 10000002, now(), 4.0, '아이스(623) 달콤하고 여성스러운 향수예요. 지속력은 좋지만 너무 강한 느낌이 있습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000092, 5, 10000002, now(), 5.0, '아이스(623) 정말 좋아요! 은은하면서도 고급스러운 느낌이에요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000093, 4, 10000002, now(), 5.0, '아이스(623) 향수가 정말 마음에 들어요. 청량하고 상큼해서 기분 좋아져요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000094, 3, 10000002, now(), 4.0, '아이스(623) 1향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000095, 5, 10000002, now(), 3.0, '아이스(623) 2향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000096, 4, 10000002, now(), 2.0, '아이스(623) 3향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000097, 3, 10000002, now(), 1.0, '아이스(623) 4향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000098, 5, 10000002, now(), 2.0, '아이스(623) 5향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000099, 4, 10000002, now(), 5.0, '아이스(623) 6향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000100, 3, 10000002, now(), 4.0, '아이스(623) 7향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000101, 5, 10000002, now(), 5.0, '아이스(623) 8향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000102, 4, 10000002, now(), 5.0, '아이스(623) 9향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000103, 3, 10000002, now(), 4.0, '아이스(623) 10향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000104, 5, 10000002, now(), 5.0, '아이스(623) 11향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000105, 4, 10000002, now(), 5.0, '아이스(623) 12향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000106, 3, 10000002, now(), 4.0, '아이스(623) 13향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000107, 5, 10000002, now(), 3.0, '아이스(623) 14향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000108, 4, 10000002, now(), 2.0, '아이스(623) 15향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000109, 3, 10000002, now(), 1.0, '아이스(623) 16향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000110, 5, 10000002, now(), 2.0, '아이스(623) 17향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000111, 4, 10000002, now(), 5.0, '아이스(623) 18향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000112, 3, 10000002, now(), 4.0, '아이스(623) 19향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000113, 5, 10000002, now(), 5.0, '아이스(623) 20향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000114, 4, 10000002, now(), 5.0, '아이스(623) 21향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000115, 3, 10000002, now(), 4.0, '아이스(623) 22향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000116, 5, 10000002, now(), 3.0, '아이스(623) 23향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000117, 4, 10000002, now(), 2.0, '아이스(623) 24향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000118, 3, 10000002, now(), 1.0, '아이스(623) 25향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000119, 5, 10000002, now(), 2.0, '아이스(623) 26향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000120, 4, 10000002, now(), 5.0, '아이스(623) 28향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000121, 3, 10000002, now(), 4.0, '아이스(623) 29향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000122, 5, 10000002, now(), 5.0, '아이스(623) 30향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000123, 4, 10000002, now(), 5.0, '아이스(623) 31향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000124, 3, 10000002, now(), 4.0, '아이스(623) 32향이 좋아요~~');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES(10000125, 5, 10000002, now(), 3.0, '아이스(623) 33향이 좋아요~~');

INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000126, 4, 10000003, now(), 5.0, '만다린 디퓨저(165) 이 향수 너무 좋아요! 상쾌하고 기분이 좋아집니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000127, 3, 10000003, now(), 4.0, '만다린 디퓨저(165) 향이 은은하고 너무 좋아요. 조금 더 지속됐으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000128, 5, 10000003, now(), 2.0, '만다린 디퓨저(165) 처음엔 좋았지만 점점 더 강하게 느껴져서 조금 부담스러워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000129, 4, 10000003, now(), 3.0, '만다린 디퓨저(165) 향은 괜찮지만 지속성이 너무 짧아서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000130, 3, 10000003, now(), 5.0, '만다린 디퓨저(165) 정말 마음에 드는 향이에요! 부드럽고 기분 좋습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000131, 5, 10000003, now(), 1.0, '만다린 디퓨저(165) 향이 너무 강하고 불쾌한 냄새가 나서 다시는 사용하지 않을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000132, 4, 10000003, now(), 4.0, '만다린 디퓨저(165) 상쾌하고 깔끔한 향이 좋습니다. 조금 더 달콤했으면 더 좋았을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000133, 3, 10000003, now(), 5.0, '만다린 디퓨저(165) 상큼하고 기분 좋은 향이에요. 자주 사용하고 싶습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000134, 5, 10000003, now(), 4.0, '만다린 디퓨저(165) 디자인도 예쁘고 향도 좋아요. 다만 지속력이 짧아서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000135, 4, 10000003, now(), 3.0, '만다린 디퓨저(165) 향은 좋지만 너무 빠르게 사라져서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000136, 3, 10000003, now(), 2.0, '만다린 디퓨저(165) 향이 너무 강하고 고급스럽지 않아서 별로였어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000137, 5, 10000003, now(), 1.0, '만다린 디퓨저(165) 너무 강한 향이라 불쾌하고 오래 지속되지 않아 실망했습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000138, 4, 10000003, now(), 5.0, '만다린 디퓨저(165) 이 향수는 정말 좋아요! 상쾌하고 깔끔한 향이 마음에 들어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000139, 3, 10000003, now(), 4.0, '만다린 디퓨저(165) 향이 좋아요. 다만 시간이 지나면서 조금 흐려져서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000140, 5, 10000003, now(), 3.0, '만다린 디퓨저(165) 향은 괜찮지만 너무 빨리 사라져서 아쉬운 점이 많아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000141, 4, 10000003, now(), 2.0, '만다린 디퓨저(165) 향이 너무 강하고 오래가지 않아서 실망스러웠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000142, 3, 10000003, now(), 5.0, '만다린 디퓨저(165) 향이 정말 좋고 지속력도 만족스러워요. 자주 사용할 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000143, 5, 10000003, now(), 1.0, '만다린 디퓨저(165) 향이 너무 강하고 불쾌한 냄새가 나요. 전혀 마음에 들지 않았어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000144, 4, 10000003, now(), 5.0, '만다린 디퓨저(165) 정말 상쾌하고 기분 좋아지는 향이에요. 자주 사용할 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000145, 3, 10000003, now(), 4.0, '만다린 디퓨저(165) 향이 좋긴 하지만 지속성에서 아쉬움이 있어요. 좀 더 오래갔으면 좋겠어요.');

INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000146, 4, 10000004, now(), 3.0, '오드퍼퓸(50) 상쾌한 향이라 기분 좋아요. 하지만 지속력이 짧아서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000147, 5, 10000004, now(), 4.0, '오드퍼퓸(50) 향이 정말 좋고 부드러워요. 좀 더 지속되면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000148, 3, 10000004, now(), 5.0, '오드퍼퓸(50) 이 향수 너무 좋아요! 향이 은은하고 상쾌한 느낌이라 기분이 좋아집니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000149, 4, 10000004, now(), 2.0, '오드퍼퓸(50) 향이 너무 강해서 불쾌했어요. 지속성도 짧고 다시는 사용하고 싶지 않아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000150, 5, 10000004, now(), 3.0, '오드퍼퓸(50) 향은 좋지만 너무 빨리 사라져서 조금 아쉬웠어요. 지속성이 좀 더 좋으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000151, 3, 10000004, now(), 4.0, '오드퍼퓸(50) 향이 은은하고 좋지만 지속시간이 짧아서 조금 아쉽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000152, 4, 10000004, now(), 5.0, '오드퍼퓸(50) 이 향수 정말 좋아요! 상쾌하고 기분 좋은 향이 오래 지속돼요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000153, 5, 10000004, now(), 1.0, '오드퍼퓸(50) 향이 너무 강하고 불쾌하게 느껴졌어요. 다시는 사지 않을 것 같습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000154, 3, 10000004, now(), 5.0, '오드퍼퓸(50) 상큼하고 상쾌한 향이 마음에 들어요. 자주 사용할 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000155, 4, 10000004, now(), 4.0, '오드퍼퓸(50) 향이 괜찮지만 지속력에서 아쉬움이 있어요. 조금 더 오래갔으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000156, 5, 10000004, now(), 2.0, '오드퍼퓸(50) 처음엔 좋았지만 시간이 지나면서 향이 너무 강해져서 불쾌했어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000157, 3, 10000004, now(), 3.0, '오드퍼퓸(50) 향은 좋은데, 지속력이 너무 짧아서 아쉬웠습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000158, 4, 10000004, now(), 5.0, '오드퍼퓸(50) 이 향수 정말 좋아요! 상쾌하고 부드러운 향이 기분 좋게 만들어줘요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000159, 5, 10000004, now(), 1.0, '오드퍼퓸(50) 향이 너무 강하고 불쾌해요. 다시는 사용하지 않을 것 같습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000160, 3, 10000004, now(), 4.0, '오드퍼퓸(50) 향이 은은하고 좋았지만 지속성이 너무 짧아서 아쉬웠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000161, 4, 10000004, now(), 5.0, '오드퍼퓸(50) 상쾌하고 기분 좋은 향이에요. 자주 사용하고 싶어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000162, 5, 10000004, now(), 3.0, '오드퍼퓸(50) 향이 좋은데 지속 시간이 짧아서 조금 아쉬운 느낌이 들어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000163, 3, 10000004, now(), 4.0, '오드퍼퓸(50) 향이 아주 좋아요. 다만 지속성은 조금 아쉬웠습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000164, 4, 10000004, now(), 2.0, '오드퍼퓸(50) 향이 너무 강하고 불쾌하게 느껴졌어요. 다시는 사지 않을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000165, 5, 10000004, now(), 5.0, '오드퍼퓸(50) 정말 좋은 향수예요! 기분 좋은 향이 오래 지속돼서 만족스럽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000166, 3, 10000004, now(), 3.0, '오드퍼퓸(50) 향은 좋지만 지속시간이 너무 짧아서 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000167, 4, 10000004, now(), 4.0, '오드퍼퓸(50) 상쾌하고 기분 좋은 향이지만 지속력은 조금 짧아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000168, 5, 10000004, now(), 5.0, '오드퍼퓸(50) 향이 너무 좋고 지속력도 좋아요. 기분 좋아지는 향수입니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000169, 3, 10000004, now(), 2.0, '오드퍼퓸(50) 처음엔 좋았는데 시간이 지나면서 향이 너무 강해져서 불쾌했어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000170, 4, 10000004, now(), 5.0, '오드퍼퓸(50) 상쾌하고 청량한 느낌이 좋아요. 자주 사용할 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000171, 5, 10000004, now(), 4.0, '오드퍼퓸(50) 향이 정말 좋고 은은하게 오래 지속돼요. 너무 강하지 않아서 좋습니다.');

INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000172, 4, 10000005, now(), 3.0, '아이스드베리레모네이드(369) 상쾌한 향이 마음에 들어요. 하지만 지속성이 짧아서 조금 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000173, 5, 10000005, now(), 4.0, '아이스드베리레모네이드(369) 향이 좋지만 조금 더 오래갔으면 좋겠어요. 그래도 기분이 좋아집니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000174, 3, 10000005, now(), 5.0, '아이스드베리레모네이드(369) 상큼하고 기분 좋은 향이에요. 자주 사용할 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000175, 4, 10000005, now(), 2.0, '아이스드베리레모네이드(369) 향이 너무 강하고 불쾌하게 느껴졌어요. 지속성도 짧아서 실망입니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000176, 5, 10000005, now(), 3.0, '아이스드베리레모네이드(369) 향은 좋지만 지속력이 너무 짧아서 아쉽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000177, 3, 10000005, now(), 4.0, '아이스드베리레모네이드(369) 향이 좋지만 조금 더 오래갔으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000178, 4, 10000005, now(), 5.0, '아이스드베리레모네이드(369) 정말 상쾌하고 기분 좋은 향이에요. 자주 사용할 것 같습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000179, 5, 10000005, now(), 1.0, '아이스드베리레모네이드(369) 향이 너무 강하고 불쾌해서 다시는 사용하지 않을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000180, 3, 10000005, now(), 4.0, '아이스드베리레모네이드(369) 향이 은은하고 좋아요. 다만 지속성에서 아쉬움이 있어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000181, 4, 10000005, now(), 3.0, '아이스드베리레모네이드(369) 향은 좋지만 지속시간이 짧아 조금 아쉽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000182, 5, 10000005, now(), 5.0, '아이스드베리레모네이드(369) 기분 좋은 향수예요! 상쾌하고 청량한 향이 마음에 듭니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000183, 3, 10000005, now(), 2.0, '아이스드베리레모네이드(369) 향이 너무 강하고 오래가지 않아서 실망스러웠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000184, 4, 10000005, now(), 5.0, '아이스드베리레모네이드(369) 향이 정말 좋고 오래 지속돼서 기분 좋아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000185, 5, 10000005, now(), 4.0, '아이스드베리레모네이드(369) 은은하고 기분 좋은 향이에요. 지속력이 조금 더 길면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000186, 3, 10000005, now(), 3.0, '아이스드베리레모네이드(369) 향은 좋지만 지속력이 짧아서 아쉽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000187, 4, 10000005, now(), 4.0, '아이스드베리레모네이드(369) 상쾌한 향이고 기분 좋아요. 지속성도 괜찮은 편입니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000188, 5, 10000005, now(), 5.0, '아이스드베리레모네이드(369) 향이 정말 좋고 오래 지속돼서 매우 만족합니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000189, 3, 10000005, now(), 1.0, '아이스드베리레모네이드(369) 너무 강한 향이라서 불쾌하고 지속성도 짧아서 실망이었어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000190, 4, 10000005, now(), 3.0, '아이스드베리레모네이드(369) 상쾌한 향이지만 지속력에서 아쉬움이 있어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000191, 5, 10000005, now(), 4.0, '아이스드베리레모네이드(369) 향이 은은하고 기분 좋아져요. 조금 더 지속되면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000192, 3, 10000005, now(), 2.0, '아이스드베리레모네이드(369) 향이 너무 강하고 오래가지 않아서 실망했습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000193, 4, 10000005, now(), 5.0, '아이스드베리레모네이드(369) 이 향수 정말 좋아요. 상쾌하고 기분 좋은 향이 오래 지속됩니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000194, 5, 10000005, now(), 3.0, '아이스드베리레모네이드(369) 향은 좋은데 지속시간이 짧아서 아쉬웠습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000195, 3, 10000005, now(), 4.0, '아이스드베리레모네이드(369) 향이 좋고 기분을 좋게 해줘요. 조금 더 지속됐으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000196, 4, 10000005, now(), 1.0, '아이스드베리레모네이드(369) 너무 강한 향이어서 불쾌했습니다. 다시는 사용하지 않을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000197, 5, 10000005, now(), 5.0, '아이스드베리레모네이드(369) 정말 상쾌하고 기분 좋은 향이에요. 자주 사용할 것 같아요.');

INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000198, 4, 10000006, now(), 3.0, '만다린 디퓨저(90) 상쾌한 향이 마음에 들어요. 하지만 지속성이 짧아서 조금 아쉬워요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000199, 5, 10000006, now(), 4.0, '만다린 디퓨저(90) 향이 좋지만 조금 더 오래갔으면 좋겠어요. 그래도 기분이 좋아집니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000200, 3, 10000006, now(), 5.0, '만다린 디퓨저(90) 상큼하고 기분 좋은 향이에요. 자주 사용할 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000201, 4, 10000006, now(), 2.0, '만다린 디퓨저(90) 향이 너무 강하고 불쾌하게 느껴졌어요. 지속성도 짧아서 실망입니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000202, 5, 10000006, now(), 3.0, '만다린 디퓨저(90) 향은 좋지만 지속력이 너무 짧아서 아쉽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000203, 3, 10000006, now(), 4.0, '만다린 디퓨저(90) 향이 좋지만 조금 더 오래갔으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000204, 4, 10000006, now(), 5.0, '만다린 디퓨저(90) 정말 상쾌하고 기분 좋은 향이에요. 자주 사용할 것 같습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000205, 5, 10000006, now(), 1.0, '만다린 디퓨저(90) 향이 너무 강하고 불쾌해서 다시는 사용하지 않을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000206, 3, 10000006, now(), 4.0, '만다린 디퓨저(90) 향이 은은하고 좋아요. 다만 지속성에서 아쉬움이 있어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000207, 4, 10000006, now(), 3.0, '만다린 디퓨저(90) 향은 좋지만 지속시간이 짧아 조금 아쉽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000208, 5, 10000006, now(), 5.0, '만다린 디퓨저(90) 기분 좋은 향수예요! 상쾌하고 청량한 향이 마음에 듭니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000209, 3, 10000006, now(), 2.0, '만다린 디퓨저(90) 향이 너무 강하고 오래가지 않아서 실망스러웠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000210, 4, 10000006, now(), 5.0, '만다린 디퓨저(90) 향이 정말 좋고 오래 지속돼서 기분 좋아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000211, 5, 10000006, now(), 4.0, '만다린 디퓨저(90) 은은하고 기분 좋은 향이에요. 지속력이 조금 더 길면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000212, 3, 10000006, now(), 3.0, '만다린 디퓨저(90) 향은 좋지만 지속력이 짧아서 아쉽습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000213, 4, 10000006, now(), 4.0, '만다린 디퓨저(90) 상쾌한 향이고 기분 좋아요. 지속성도 괜찮은 편입니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000214, 5, 10000006, now(), 5.0, '만다린 디퓨저(90) 향이 정말 좋고 오래 지속돼서 매우 만족합니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000215, 3, 10000006, now(), 1.0, '만다린 디퓨저(90) 너무 강한 향이라서 불쾌하고 지속성도 짧아서 실망이었어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000216, 4, 10000006, now(), 3.0, '만다린 디퓨저(90) 상쾌한 향이지만 지속력에서 아쉬움이 있어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000217, 5, 10000006, now(), 4.0, '만다린 디퓨저(90) 향이 은은하고 기분 좋아져요. 조금 더 지속되면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000218, 3, 10000006, now(), 2.0, '만다린 디퓨저(90) 향이 너무 강하고 오래가지 않아서 실망했습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000219, 4, 10000006, now(), 5.0, '만다린 디퓨저(90) 이 향수 정말 좋아요. 상쾌하고 기분 좋은 향이 오래 지속됩니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000220, 5, 10000006, now(), 3.0, '만다린 디퓨저(90) 향은 좋은데 지속시간이 짧아서 아쉬웠습니다.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000221, 3, 10000006, now(), 4.0, '만다린 디퓨저(90) 향이 좋고 기분을 좋게 해줘요. 조금 더 지속됐으면 좋겠어요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000222, 4, 10000006, now(), 1.0, '만다린 디퓨저(90) 너무 강한 향이어서 불쾌했습니다. 다시는 사용하지 않을 것 같아요.');
INSERT INTO review (review_id, member_id, purchase_product_id, review_creation_date, star, content) VALUES (10000223, 5, 10000006, now(), 5.0, '만다린 디퓨저(90) 정말 상쾌하고 기분 좋은 향이에요. 자주 사용할 것 같아요.');

-- review Image
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000001, 10000001, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000002, 10000002, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000003, 10000003, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000004, 10000004, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000005, 10000005, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000006, 10000006, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000007, 10000007, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000008, 10000008, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000009, 10000009, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000010, 10000010, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000011, 10000011, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000012, 10000012, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000013, 10000013, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000014, 10000014, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000015, 10000015, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000016, 10000016, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000017, 10000017, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000018, 10000018, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000019, 10000019, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000020, 10000020, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000021, 10000021, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000022, 10000022, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000023, 10000023, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000024, 10000024, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000025, 10000025, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000026, 10000026, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000027, 10000027, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000028, 10000028, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000029, 10000029, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000030, 10000030, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000031, 10000031, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000032, 10000032, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000033, 10000033, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000034, 10000034, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000035, 10000035, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000036, 10000036, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000037, 10000037, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000038, 10000038, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000039, 10000039, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000040, 10000040, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000041, 10000041, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000042, 10000042, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000043, 10000043, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000044, 10000044, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000045, 10000045, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000046, 10000046, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000047, 10000047, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000048, 10000048, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000049, 10000049, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000050, 10000050, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000051, 10000051, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000052, 10000052, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000053, 10000053, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000054, 10000054, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000055, 10000055, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000056, 10000056, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000057, 10000057, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000058, 10000058, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000059, 10000059, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000060, 10000060, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000061, 10000061, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000062, 10000062, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000064, 10000064, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000065, 10000065, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000066, 10000066, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000067, 10000067, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000068, 10000068, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000069, 10000069, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000070, 10000070, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000071, 10000071, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000072, 10000072, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000073, 10000073, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000074, 10000074, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000075, 10000075, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000076, 10000076, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000077, 10000077, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000078, 10000078, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000079, 10000079, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000080, 10000080, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000081, 10000081, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000082, 10000082, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000083, 10000083, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000084, 10000084, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000085, 10000085, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000086, 10000086, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000087, 10000087, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000088, 10000088, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000089, 10000089, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000090, 10000090, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000091, 10000091, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000092, 10000092, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000093, 10000093, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000094, 10000094, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000095, 10000095, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000096, 10000096, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000097, 10000097, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000098, 10000098, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000099, 10000099, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000100, 10000100, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000101, 10000101, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000102, 10000102, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000103, 10000103, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000104, 10000104, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000105, 10000105, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000106, 10000106, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000107, 10000107, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000108, 10000108, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000109, 10000109, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000110, 10000110, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000111, 10000111, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000112, 10000112, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000113, 10000113, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000114, 10000114, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000115, 10000115, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000116, 10000116, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000117, 10000117, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000118, 10000118, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000119, 10000119, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000120, 10000120, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000121, 10000121, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000122, 10000122, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000123, 10000123, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000124, 10000124, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000125, 10000125, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000126, 10000126, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000127, 10000127, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000128, 10000128, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000129, 10000129, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000130, 10000130, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000131, 10000131, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000132, 10000132, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000133, 10000133, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000134, 10000134, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000135, 10000135, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000136, 10000136, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000137, 10000137, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000138, 10000138, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000139, 10000139, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000140, 10000140, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000141, 10000141, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000142, 10000142, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000143, 10000143, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000144, 10000144, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000145, 10000145, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000146, 10000146, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000147, 10000147, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000148, 10000148, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000149, 10000149, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000150, 10000150, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000151, 10000151, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000152, 10000152, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000153, 10000153, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000154, 10000154, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000155, 10000155, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000156, 10000156, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000157, 10000157, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000158, 10000158, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000159, 10000159, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000160, 10000160, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000161, 10000161, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000162, 10000162, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000163, 10000163, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000164, 10000164, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000165, 10000165, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000166, 10000166, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000167, 10000167, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000168, 10000168, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000169, 10000169, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000170, 10000170, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000171, 10000171, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000172, 10000172, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000173, 10000173, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000174, 10000174, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000175, 10000175, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000176, 10000176, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000177, 10000177, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000178, 10000178, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000179, 10000179, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000180, 10000180, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000181, 10000181, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000182, 10000182, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000183, 10000183, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000184, 10000184, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000185, 10000185, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000186, 10000186, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000187, 10000187, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000188, 10000188, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000189, 10000189, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000190, 10000190, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000191, 10000191, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000192, 10000192, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000193, 10000193, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000194, 10000194, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000195, 10000195, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000196, 10000196, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000197, 10000197, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000198, 10000198, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000199, 10000199, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000200, 10000200, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000201, 10000201, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000202, 10000202, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000203, 10000203, 'perfume8', 'p_008.png', 'images/file/\\p_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000204, 10000204, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000205, 10000205, 'perfume3', 'p_003.png', 'images/file/\\p_003.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000206, 10000206, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000207, 10000207, 'perfume2', 'p_002.png', 'images/file/\\p_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000208, 10000208, 'perfume4', 'p_004.png', 'images/file/\\p_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000209, 10000209, 'perfume5', 'p_005.png', 'images/file/\\p_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000210, 10000210, 'perfume7', 'p_007.png', 'images/file/\\p_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000211, 10000211, 'perfume1', 'p_001.png', 'images/file/\\p_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000212, 10000212, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000213, 10000213, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000214, 10000214, 'candle4',  'c_004.png', 'images/file/\\c_004.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000215, 10000215, 'candle5',  'c_005.png', 'images/file/\\c_005.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000216, 10000216, 'candle6',  'c_006.png', 'images/file/\\c_006.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000217, 10000217, 'candle7',  'c_007.png', 'images/file/\\c_007.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000218, 10000218, 'candle8',  'c_008.png', 'images/file/\\c_008.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000219, 10000219, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000220, 10000220, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000221, 10000221, 'candle2',  'c_002.png', 'images/file/\\c_002.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000222, 10000222, 'candle1',  'c_001.png', 'images/file/\\c_001.png');
INSERT INTO review_image (review_image_id, review_id, file_desc, filename, path) VALUES (10000223, 10000223, 'candle2',  'c_002.png', 'images/file/\\c_002.png');


-- favorite
INSERT INTO favorite (member_id, review_id) VALUES(3, 10000001);
INSERT INTO favorite (member_id, review_id) VALUES(5, 10000001);
INSERT INTO favorite (member_id, review_id) VALUES(5, 10000002);