DELETE FROM `product_image`;
DELETE FROM `category_brand`;
DELETE FROM `cart_used_product`;
DELETE FROM `purchase_payment`;
DELETE FROM `favorite`;
DELETE FROM `review_image`;
DELETE FROM `review`;
DELETE FROM `delivery_purchase`;
DELETE FROM `purchase_product`;
DELETE FROM `sale_payment`;
DELETE FROM `purchase`;
DELETE FROM `payment`;
DELETE FROM `product_product_type`;
DELETE FROM `product_type`;
DELETE FROM `detail_image`;
DELETE FROM `wish_product`;
DELETE FROM `wish_category`;
DELETE FROM `wish_product`;
DELETE FROM `used_product`;
DELETE FROM `user_sale_image`;
DELETE FROM `verified_sale_image`;
DELETE FROM `verified_sale`;
DELETE FROM `sale_grade`;
DELETE FROM `rejection_reason`;
DELETE FROM `pending_sale`;
DELETE FROM `product`;
DELETE FROM `brand`;
DELETE FROM `category`;
DELETE FROM `cart`;
DELETE FROM `member`;
DELETE FROM `outbox`;
DELETE FROM `external_prepare_payment`;



INSERT INTO `member` (`member_id`, `account`, `ad_received`, `addr`, `post_code`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`, `warn_count`)
values (1, NULL, NULL, '대구광역시 중구', '123-456', 'qordi124@gmail.com', NULL, '2024-10-24', NULL, '태영', '010-1234-5678', 'USER', 1, NULL, '', '',0);
insert into member(member_id, addr, post_code, phone_num, `warn_count`)
values (2, '대구광역시 중구', '345-678', '010-1234-5678', 0);
INSERT INTO `member` (`member_id`, `account`, `ad_received`, `addr`, `post_code`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`, `warn_count`)
VALUES (3, NULL, NULL, '대구광역시 중구', '234-567', 'whgpals4263@nate.com', NULL, '2024-10-31', NULL, '민이♡', '010-1234-5678', 'USER', 1, NULL, 'http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg', 'http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg', 0);
INSERT INTO `member` (`member_id`, `account`, `ad_received`, `addr`, `post_code`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`, `warn_count`)
VALUES (4, NULL, NULL, '대구광역시 중구', '567-988', 'kdh7313@naver.com', NULL, '2024-11-01', NULL, '강도현', '010-1234-5678', 'USER', 1, NULL, 'http://k.kakaocdn.net/dn/b7yPFA/btsKquPi0Cw/BjABLmpyNB6gbKxUAX9I40/img_640x640.jpg', 'http://k.kakaocdn.net/dn/b7yPFA/btsKquPi0Cw/BjABLmpyNB6gbKxUAX9I40/img_110x110.jpg', 0);
INSERT INTO `member` (`member_id`, `account`, `ad_received`, `addr`, `post_code`, `email`, `is_deleted`, `join_date`, `name`, `nick_name`, `phone_num`, `role`, `sns_type`, `withdraw_date`, `profile_image`, `thumbnail_image`, `warn_count`)
VALUES (5, NULL, NULL, '대구광역시 중구', '999-100', 'thdghckd111@naver.com', NULL, '2024-11-01', NULL, '송호창', '010-1234-5678', 'USER', 1, NULL, 'http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg', 'http://img1.kakaocdn.net/thumb/R110x110.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg', 0);

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
insert into brand(brand_id, name)
values (11, 'Tom Ford');
insert into brand(brand_id, name)
values (12, 'Comme Des Garcons Parfum');
insert into brand(brand_id, name)
values (13, 'Officine Universelle Buly');
insert into brand(brand_id, name)
values (14, 'Annunziata');
insert into brand(brand_id, name)
values (15, 'Fragonard');
insert into brand(brand_id, name)
values (16, 'Dolce & Gabbana');
insert into brand(brand_id, name)
values (17, 'Saint Laurent');
insert into brand(brand_id, name)
values (18, 'Chanel');
insert into brand(brand_id, name)
values (19, 'Dior');

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
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (16, 3, 17, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (17, 3, 18, now());
insert into category_brand(category_brand_id, category_id, brand_id, created_date)
values (18, 3, 19, now());

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
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',35,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','미스 디올 블루밍 부케',96000,'2024-09-14 15:15:42.169748','',30,0,0,19,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 21:19:49.213955', 'p_009.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',36,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','미스 디올 퍼퓸',133000,'2024-10-14 14:13:42.169748','',35,0,0,19,0,0,0,NULL,NULL,NULL,NULL,'2024-10-22 23:06:39.396833', 'p_010.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',37,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','소바쥬 오 드 뚜왈렛',100800,'2024-10-24 11:15:42.169748','',30,0,0,19,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 06:49:37.337500', 'p_011.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',38,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','디올 옴므 코롱',142000,'2024-01-24 21:15:42.169748','',75,0,0,19,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 16:03:56.492204', 'p_012.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',39,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','디올 옴므 인텐스 오 드 퍼퓸',143000,'2024-09-24 16:15:42.169748','',50,0,0,19,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:37:10.443718', 'p_013.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',40,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','가브리엘 샤넬 에쌍스 오 드 빠르펭',193000,'2024-10-21','',50,0,0,18,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 17:54:34.737179', 'p_014.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',41,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','레 조 드 샤넬 파리-파리 오 드 뚜왈렛 스프레이',228000,'2024-10-21','',125,0,0,18,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 20:34:48.349944', 'p_015.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',42,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 오 드 빠르펭',205000,'2024-11-04 01:15:42.169348','',50,0,0,17,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:03:43.533382', 'p_016.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',43,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 오 드 빠르펭',292000,'2024-10-14 12:14:42.169748','',90,0,0,17,0,0,0,NULL,NULL,NULL,NULL,'2024-10-23 09:03:43.533382', 'p_016.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',44,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','몽파리 오 드 뚜왈렛 루미에르',99000,'2024-10-24 06:15:41.169748','시그니처 자캔들(M)',30,0,0,17,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.615278', 'p_017.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',45,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','몽파리 오 드 뚜왈렛 루미에르',163000,'2024-10-24 06:15:42.269741','시그니처 자캔들(M)',50,0,0,17,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.712278', 'p_017.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',46,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','몽파리 오 드 뚜왈렛 루미에르',227000,'2024-10-24 06:13:42.169748','시그니처 자캔들(M)',90,0,0,17,110,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:12:22.112278', 'p_017.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',47,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 앱솔루트 플라틴',225000,'2024-10-25 06:15:41.169748','',50,0,0,17,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.119748', 'p_018.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',48,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 앱솔루트 플라틴',315000,'2024-10-21 06:15:41.269748','',90,0,0,17,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.224748', 'p_018.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',49,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 플라워 & 플레임',198000,'2024-10-22 06:15:41.369748','',50,0,0,17,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.379748', 'p_019.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`) VALUES ('P',50,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21','2024-10-21','리브르 플라워 & 플레임',279000,'2024-10-23 06:15:41.469748','',90,0,0,17,0,0,0,NULL,NULL,NULL,NULL,'2024-10-24 06:15:41.459748', 'p_019.png');
INSERT INTO `product` (`dtype`,`product_id`,`content`,`expiration_period`,`member_buy_date`,`name`,`price`,`production_date`,`purpose`,`size`,`used_or_not`,`volume`,`brand_id`,`burning_time`,`scent_time`,`duration_time`,`gender`,`type`,`accessory`,`modify_date`,`register_date`, `main_image`)
VALUES
('P',51,'플로럴한 하트 노트, 이를 감싸주는 베이스 노트가 조화를 이루며 밝고 투명한 탑 노트로 움직이는 물의 상쾌함과 생명력을 포착합니다','2024-10-21', '2024-10-21', '롬브로단로 오 드 뚜왈렛', 176000, '2024-10-23 06:15:41.469748', '', 75, 0, 0, 6, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p001.png'),
('P',52,'우아한 장미의 향을 입은 오 드 뚜왈렛. 사랑스러움과 신비로움을 동시에 선사하는 향기로, 다채로운 꽃과 과일이 어우러집니다.','2024-10-21', '2024-10-21', '오 로즈 오 드 뚜왈렛', 141800, '2024-10-23 06:15:41.469748', '', 75, 0, 0, 6, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p002.png'),
('P',53,'베티버와 꽃향기가 섞인 스파이시한 느낌이 매력적인 오 드 뚜왈렛. 우아하면서도 신비로운 매력을 선사합니다.','2024-10-21', '2024-10-21', '베티베리오 오 드 뚜왈렛', 141800, '2024-10-23 06:15:41.469748', '', 75, 0, 0, 6, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p003.png'),
('P',54,'딥하고 세련된 향을 가진 오 드 퍼퓸으로, 고급스러운 나무향과 꽃향기가 어우러진 독특한 향을 자랑합니다.','2024-10-21', '2024-10-21', '오듀엘르 오 드 퍼퓸', 219800, '2024-10-23 06:15:41.469748', '', 75, 0, 0, 6, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p004.png'),
('P',55,'기품 있는 레더와 아로마틱한 향이 어우러져 품격 있는 분위기를 자아내는 오 드 퍼퓸. 고급스러운 분위기를 원할 때 추천합니다.','2024-10-21', '2024-10-21', '투스칸 레더 오 드 퍼퓸', 300000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p005.png'),
('P',56,'우디하고 스파이시한 향이 조화를 이루며 깊이 있는 느낌을 주는 오 드 퍼퓸. 클래식하면서도 현대적인 매력을 갖추고 있습니다.','2024-10-21', '2024-10-21', '오드우드 오 드 퍼퓸', 249000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p006.png'),
('P',57,'부드럽고 세련된 스웨이드와 플로럴 향이 조화를 이루는 고급스러운 오 드 퍼퓸. 우아함을 강조한 완벽한 향입니다.','2024-10-21', '2024-10-21', '화이트 스웨이드 오 드 퍼퓸', 295000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p007.png'),
('P',58,'달콤하고 새콤한 체리 향이 가득한 오 드 퍼퓸. 지나치지 않게 강렬하고 부드러운 느낌을 줍니다.','2024-10-21', '2024-10-21', '로스트 체리 오 드 퍼퓸', 370000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p008.png'),
('P',59,'상쾌하고 맑은 시트러스 향이 특징적인 오 드 퍼퓸. 포르토피노의 바다를 연상시키는 프레쉬한 향입니다.','2024-10-21', '2024-10-21', '플뢰르 드 포르토피노 오드퍼퓸', 305000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p009.png'),
('P',60,'따뜻한 여름 햇살처럼 부드럽고 온화한 향을 가진 오 드 퍼퓸. 여유롭고 상쾌한 분위기를 연출합니다.','2024-10-21', '2024-10-21', '솔레이네쥬 오 드 퍼퓸', 287000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p010.png'),
('P',61,'섬세하고 우아한 꽃향기와 달콤한 과일향이 어우러지는 오 드 퍼퓸. 깊고 풍부한 향기가 매력적인 제품입니다.','2024-10-21', '2024-10-21', '패뷸러스 오 드 퍼퓸', 405000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p011.png'),
('P',62,'신선하고 스파이시한 향기가 어우러지는 베티버 향의 오 드 퍼퓸. 고급스러운 느낌과 함께 깊은 여운을 남깁니다.','2024-10-21', '2024-10-21', '그레이 베티버 오 드 퍼퓸', 165000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p012.png'),
('P',63,'섬세한 꽃향기와 고급스러운 오키드 향이 어우러진 오 드 퍼퓸. 특별한 순간을 위한 완벽한 선택입니다.','2024-10-21', '2024-10-21', '블랙 오키드 오 드 퍼퓸', 150000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p013.png'),
('P',64,'이탈리아의 아름다운 해변을 연상시키는 상쾌하고 우아한 향을 가진 오 드 퍼퓸. 시원한 느낌과 함께 여유로운 분위기를 선사합니다.','2024-10-21', '2024-10-21', '코스타 아주라 오 드 퍼퓸', 180000, '2024-10-23 06:15:41.469748', '', 50, 0, 0, 11, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p014.png'),
('P',65,'달콤하면서도 시원한 느낌의 오 드 퍼퓸. 따뜻하고 부드러운 나무향과 과일향이 어우러진 고급스러운 제품입니다.','2024-10-21', '2024-10-21', '원더우드 오 드 퍼퓸', 162000, '2024-10-23 06:15:41.469748', '', 60, 0, 0, 12, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p015.png'),
('P',66,'이국적인 향과 화려한 꽃향기가 어우러진 오 드 퍼퓸. 따뜻하면서도 강렬한 인상을 남깁니다.','2024-10-21', '2024-10-21', '플로리엔탈 오 드 퍼퓸', 163000, '2024-10-23 06:15:41.469748', '', 60, 0, 0, 12, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p016.png'),
('P',67,'아름다운 튜베로즈 꽃의 향을 강조한 오 드 퍼퓸. 깊고 관능적인 향이 기분 좋은 여운을 남깁니다.','2024-10-21', '2024-10-21', '오 트리플 멕시크 튜베로즈', 194000, '2024-10-23 06:15:41.469748', '', 75, 0, 0, 13, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p017.png'),
('P',68,'풍부한 꽃향기와 함께 신비로운 느낌의 오 드 퍼퓸. 마시멜로처럼 부드럽고 포근한 느낌을 줍니다.','2024-10-21', '2024-10-21', '이리 드 말트', 224800, '2024-10-23 06:15:41.469748', '', 75, 0, 0, 13, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p018.png'),
('P',69,'세련된 다마스크 로즈와 달콤한 향기가 어우러진 바디로션. 부드럽고 풍부한 향이 기분을 좋게 해줍니다.','2024-10-21', '2024-10-21', '클래식 데 비지날 바디로션 다마스크 로즈', 72800, '2024-10-23 06:15:41.469748', '', 190, 0, 0, 13, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p019.png'),
('P',70,'페루 헬리오트로프 꽃의 달콤하고 따뜻한 향을 강조한 바디로션. 기분 좋게 몸을 감싸는 향이 일품입니다.','2024-10-21', '2024-10-21', '클래식 데 비지날 바디로션 페루 헬리오트로프', 72800, '2024-10-23 06:15:41.469748', '', 190, 0, 0, 13, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'p020.png'),
('D',71,'상쾌하고 깔끔한 시트러스 향을 풍성하게 퍼뜨리는 디퓨저. 방 안에 상쾌한 분위기를 만들어줍니다.','2024-10-21', '2024-10-21', '세타 디퓨저', 119000, '2024-10-23 06:15:41.469748', '', 100, 0, 0, 14, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd001.png'),
('D',72,'달콤하고 꽃향기가 가득한 디퓨저로, 방 안에 향긋한 분위기를 만들어주는 제품입니다.','2024-10-21', '2024-10-21', '라나 디퓨저', 119000, '2024-10-23 06:15:41.469748', '', 100, 0, 0, 14, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd002.png'),
('D',73,'스파이시하고 우디한 향기가 독특하게 어우러진 디퓨저. 세련되면서도 강렬한 분위기를 연출합니다.','2024-10-21', '2024-10-21', '파브리 디퓨저', 119000, '2024-10-23 06:15:41.469748', '', 100, 0, 0, 14, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd003.png'),
('D',74,'편안하고 부드러운 꽃향기와 나무 향이 어우러져 집 안의 분위기를 따뜻하게 만들어주는 디퓨저입니다.','2024-10-21', '2024-10-21', '캄비오 디퓨저', 119000, '2024-10-23 06:15:41.469748', '', 100, 0, 0, 14, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd004.png'),
('D',75,'상쾌하고 신선한 향이 특징인 디퓨저. 집 안에 자연을 느끼게 해주는 향을 제공합니다.','2024-10-21', '2024-10-21', '포르나이 디퓨저', 119000, '2024-10-23 06:15:41.469748', '', 100, 0, 0, 14, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd005.png'),
('D',76,'부드럽고 달콤한 향기가 공간을 채우는 디퓨저. 집 안을 포근하고 아늑하게 만들어줍니다.','2024-10-21', '2024-10-21', '칼촐라이 디퓨저', 119000, '2024-10-23 06:15:41.469748', '', 100, 0, 0, 14, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd006.png'),
('D',77,'상쾌하고 시원한 허브향과 꽃향기가 어우러져 방 안에 상쾌한 느낌을 주는 디퓨저입니다.','2024-10-21', '2024-10-21', '버베인 디퓨저', 79200, '2024-10-23 06:15:41.469748', '', 200, 0, 0, 15, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd007.png'),
('D',78,'깔끔하고 맑은 시트러스 향으로 상쾌한 기운을 주는 디퓨저. 방 안을 맑고 깨끗하게 만들어줍니다.','2024-10-21', '2024-10-21', '네펠리 디퓨저', 90400, '2024-10-23 06:15:41.469748', '', 200, 0, 0, 15, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'd008.png'),
('C',79,'고급스러운 레오파드 프린트 디자인과 함께 향이 가득 퍼지는 캔들. 세련된 분위기를 제공합니다.','2024-10-21', '2024-10-21', '레오파드 프린트 캔들', 170000, '2024-10-23 06:15:41.469748', '', 250, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c001.png'),
('C',80,'우아한 카레토 디자인의 캔들로, 은은한 향이 방안을 고급스럽게 채워줍니다.','2024-10-21', '2024-10-21', '카레토 프린트 캔들', 170000, '2024-10-23 06:15:41.469748', '', 250, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c002.png'),
('C',81,'신비로운 향을 담은 고급스러운 디자인의 인센소 캔들. 우아한 분위기를 연출합니다.','2024-10-21', '2024-10-21', '인센소 캔들', 220000, '2024-10-23 06:15:41.469748', '', 250, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c003.png'),
('C',82,'섬세한 꽃향기와 아름다운 디자인이 어우러진 플로럴 프린트 캔들. 기분 좋은 향기를 제공합니다.','2024-10-21', '2024-10-21', '플로럴 프린트 캔들', 134000, '2024-10-23 06:15:41.469748', '', 250, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c004.png'),
('C',83,'고급스러운 향초 캔들로 방 안에 따뜻한 분위기를 만들어주는 제품입니다.','2024-10-21', '2024-10-21', '향초 캔들', 169000, '2024-10-23 06:15:41.469748', '', 250, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c005.png'),
('C',84,'상큼한 시칠리아 오렌지 향을 담은 플로럴 프린트 캔들. 기분 좋은 향기를 집 안에 퍼지게 해줍니다.','2024-10-21', '2024-10-21', '시칠리아 오렌지 플로럴 프린트 캔들', 134000, '2024-10-23 06:15:41.469748', '', 250, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c006.png'),
('C',85,'상쾌하고 신선한 레몬 향이 가득 담긴 레몬 그래픽 프린트 캔들. 방 안을 깨끗하게 밝혀줍니다.','2024-10-21', '2024-10-21', '레몬 그래픽 프린트 캔들', 132000, '2024-10-23 06:15:41.469748', '', 250, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c007.png'),
('C',86,'고급스러운 디자인과 은은한 향이 특징인 카레토 프린트 캔들. 집 안을 우아하게 꾸며줍니다.','2024-10-21', '2024-10-21', '카레토 프린트 캔들', 490000, '2024-10-23 06:15:41.469748', '', 340, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c008.png'),
('C',87,'카레토 디자인의 캔들로, 긴 시간 동안 향을 제공하는 고급스러운 캔들입니다.','2024-10-21', '2024-10-21', '카레토 캔들', 486000, '2024-10-23 06:15:41.469748', '', 340, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c009.png'),
('C',88,'아름다운 예술적인 디자인과 함께 고급스러운 향기를 전하는 아트 프린트 캔들입니다.','2024-10-21', '2024-10-21', '아트 프린트 캔들', 486000, '2024-10-23 06:15:41.469748', '', 340, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c010.png'),
('C',89,'고급스러운 포셀린 디자인과 섬세한 향이 돋보이는 포셀린 캔들입니다.','2024-10-21', '2024-10-21', '포셀린 캔들', 540000, '2024-10-23 06:15:41.469748', '', 340, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c011.png'),
('C',90,'고급스러운 레오파드 프린트 디자인과 함께 향이 가득 퍼지는 캔들. 고급스러움을 제공합니다.','2024-10-21', '2024-10-21', '레오파드 프린트 캔들', 490000, '2024-10-23 06:15:41.469748', '', 340, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c012.png'),
('C',91,'고급스러운 지브라 프린트 디자인과 함께 강렬한 향기를 자랑하는 지브라 프린트 캔들입니다.','2024-10-21', '2024-10-21', '지브라 프린트 캔들', 540000, '2024-10-23 06:15:41.469748', '', 340, 0, 0, 16, 0, 0, 0, NULL, NULL, NULL, NULL, '2024-10-24 06:15:41.459748', 'c013.png');
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
    (53, 'diffuser1', 'd_001.png', 'images/file/\\d_001.png', 34),
    (54, 'newPerfume1', 'p001.png', 'images/file/\\p001.png', 51),
    (55, 'newPerfume2', 'p002.png', 'images/file/\\p002.png', 52),
    (56, 'newPerfume3', 'p003.png', 'images/file/\\p003.png', 53),
    (57, 'newPerfume4', 'p004.png', 'images/file/\\p004.png', 54),
    (58, 'newPerfume5', 'p005.png', 'images/file/\\p005.png', 55),
    (59, 'newPerfume6', 'p006.png', 'images/file/\\p006.png', 56),
    (60, 'newPerfume7', 'p007.png', 'images/file/\\p007.png', 57),
    (61, 'newPerfume8', 'p008.png', 'images/file/\\p008.png', 58),
    (62, 'newPerfume9', 'p009.png', 'images/file/\\p009.png', 59),
    (63, 'newPerfume10', 'p010.png', 'images/file/\\p010.png', 60),
    (64, 'newPerfume11', 'p011.png', 'images/file/\\p011.png', 61),
    (65, 'newPerfume12', 'p012.png', 'images/file/\\p012.png', 62),
    (66, 'newPerfume13', 'p013.png', 'images/file/\\p013.png', 63),
    (67, 'newPerfume14', 'p014.png', 'images/file/\\p014.png', 64),
    (68, 'newPerfume15', 'p015.png', 'images/file/\\p015.png', 65),
    (69, 'newPerfume16', 'p016.png', 'images/file/\\p016.png', 66),
    (70, 'newPerfume17', 'p017.png', 'images/file/\\p017.png', 67),
    (71, 'newPerfume18', 'p018.png', 'images/file/\\p018.png', 68),
    (72, 'newPerfume19', 'p019.png', 'images/file/\\p019.png', 69),
    (73, 'newPerfume20', 'p020.png', 'images/file/\\p020.png', 70),
    (74, 'newDiffuser1', 'd001.png', 'images/file/\\d001.png', 71),
    (75, 'newDiffuser2', 'd002.png', 'images/file/\\d002.png', 72),
    (76, 'newDiffuser3', 'd003.png', 'images/file/\\d003.png', 73),
    (77, 'newDiffuser4', 'd004.png', 'images/file/\\d004.png', 74),
    (78, 'newDiffuser5', 'd005.png', 'images/file/\\d005.png', 75),
    (79, 'newDiffuser6', 'd006.png', 'images/file/\\d006.png', 76),
    (80, 'newDiffuser7', 'd007.png', 'images/file/\\d007.png', 77),
    (81, 'newDiffuser8', 'd008.png', 'images/file/\\d008.png', 78),
    (82, 'newCandle1', 'c001.png', 'images/file/\\c001.png',   79),
    (83, 'newCandle2', 'c002.png', 'images/file/\\c002.png',   80),
    (84, 'newCandle3', 'c003.png', 'images/file/\\c003.png',   81),
    (85, 'newCandle4', 'c004.png', 'images/file/\\c004.png',   82),
    (86, 'newCandle5', 'c005.png', 'images/file/\\c005.png',   83),
    (87, 'newCandle6', 'c006.png', 'images/file/\\c006.png',   84),
    (88, 'newCandle7', 'c007.png', 'images/file/\\c007.png',   85),
    (89, 'newCandle8', 'c008.png', 'images/file/\\c008.png',   86),
    (90, 'newCandle9', 'c009.png', 'images/file/\\c009.png',   87),
    (91, 'newCandle10', 'c010.png', 'images/file/\\c010.png',  88),
    (92, 'newCandle11', 'c011.png', 'images/file/\\c011.png',  89),
    (93, 'newCandle12', 'c012.png', 'images/file/\\c012.png',  90),
    (94, 'newCandle13', 'c013.png', 'images/file/\\c013.png',  91);

-- pending_sale
INSERT INTO pending_sale (member_id, product_id, pending_sale_id, category_name, brand_name, product_name, product_description,
                          product_size, inspection_status, excepted_selling_price, used_or_not, rejected_reason, created_date, updated_date)
VALUES
(1, 1, 40, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 50ml, 새 제품, 박스 포함', 48, 'ACCEPTED', 145000, FALSE, NULL, NOW(), NOW()),
(1, 9, 41, 'Diffuser', 'Yankee Candle', '라벤더 디퓨저', 'Yankee Candle 라벤더 향 디퓨저, 새 제품', 100, 'ACCEPTED', 30000, FALSE, NULL, NOW(), NOW()),
(3, 17, 42, 'Candle', 'Bath & Body Works', '시나몬 스틱 캔들', 'Bath & Body Works 시나몬 스틱 캔들, 사용한 흔적 있음, 90% 남음', 200, 'ACCEPTED', 25000, TRUE, NULL, NOW(), NOW()),
(1, 1, 43, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 45ml, 중고 제품', 45, 'ACCEPTED', 130000, FALSE, NULL, NOW(), NOW()),
(1, 17, 44, 'Candle', 'IKEA', '레드 캔들', 'IKEA 레드 향초, 새 제품', 150, 'REJECTED', 15000, FALSE, NULL, NOW(), NOW()),
(1, 1, 45, 'Perfume', 'Santa Maria', '오드퍼퓸', '오드퍼퓸 향수 중고', 70, 'SOLD', 98000, TRUE, NULL, NOW(), NOW()),
(1, 1, 46, 'Perfume', 'Santa Maria', '오드 퍼퓸', '오드퍼퓸 향수 중고', 80, 'ACCEPTED', 126600, TRUE, NULL, NOW(), NOW()),
(1, 1, 47, 'Perfume', 'Santa Maria', '오드퍼퓸 ', '오드퍼퓸 향수 중고', 55, 'ACCEPTED', 150000, TRUE, NULL, NOW(), NOW()),
(1, 1, 48, 'Perfume', 'Santa Maria', '오드퍼퓸', '오드퍼퓸 향수 중고', 90, 'ACCEPTED', 150000, TRUE, NULL, NOW(), NOW()),
(1, 1, 49, 'Perfume', 'Santa Maria', '오드퍼퓸', '오드퍼퓸 중고', 75, 'ACCEPTED', 120000, TRUE, NULL, NOW(), NOW()),
(1, 1, 50, 'Perfume', 'Santa Maria', '모름', '오드퍼퓸', 55, 'REJECTED', 50000, TRUE, NULL, NOW(), NOW());

INSERT INTO user_sale_image(user_sale_image_id, file_desc, filename, path, pending_sale_id, is_used)
VALUES
(1, 'image-1', 'p_001.png', 'images/file/\\p_001.jpg', 40, true),
(2, 'image-2', 'p_002.png', 'images/file/\\p_002.jpg', 40, false),
(3, 'image-3', 'p_003.png', 'images/file/\\p_003.jpg', 40, true),
(4, 'image-1', 'p_004.png', 'images/file/\\p_004.jpg', 41, true),
(5, 'image-2', 'p_005.png', 'images/file/\\p_005.jpg', 41, true),
(6, 'image-3', 'p_006.png', 'images/file/\\p_006.jpg', 41, true),
(7, 'image-1', 'p_007.png', 'images/file/\\p_007.jpg', 42, true),
(8, 'image-1', 'p_001.png', 'images/file/\\p_001.jpg', 43, true),
(9, 'image-1', 'p_009.png', 'images/file/\\p_009.jpg', 44, true),
(10, 'image-1', 'p_001_01.jpg', 'images/file/\\p_001_01.jpg', 45, true),
(11, 'image-1', 'p_001_02.jpg', 'images/file/\\p_001_02.jpg', 46, true),
(12, 'image-1', 'p_001_03.jpg', 'images/file/\\p_001_03.jpg', 47, true),
(13, 'image-1', 'p_001_04.jpg', 'images/file/\\p_001_04.jpg', 48, true),
(14, 'image-1', 'p_001_05.jpg', 'images/file/\\p_001_05.jpg', 49, true),
(15, 'image-1', 'p_001_06.jpg', 'images/file/\\p_001_06.jpg', 50, true);

-- sale_grade
INSERT INTO sale_grade (sale_grade_id, grade_description, grade_type)
VALUES
  (1, '새상품과 거의 동일한 상태', 'A'),
  (2, '새상품이나 박스가 훼손된 상태', 'B'),
  (3, '사용한 흔적이 있거나 상품에 흠집이나 스크래치가 있는 상태', 'C'),
  (4, '사용한 흔적이 많고 상품에 흠집이나 스크래치, 약간의 파손이 있는 상태', 'D'),
  (5, '사용한 흔적이 많고 상품에 흠집이나 스크래치, 파손, 훼손이 있지만 사용하기엔 문제가 없는 상태', 'E');

-- rejection_reason
INSERT INTO rejection_reason (rejection_reason_id, reason)
VALUES
  (1, '파손 또는 훼손이 심해 판매할 수 없는 상태입니다.'),
  (2, '정품이 아닙니다.'),
  (3, '유통기한이 지났습니다.'),
  (4, '유통기한은 문제가 없으나 내용물 변질이 일어났습니다.'),
  (5, '판매 기준 용량 미달입니다.'),
  (6, '향수, 캔들, 디퓨저에 해당하지 않는 제품입니다.');

-- verified_sale
INSERT INTO verified_sale(
verified_sale_id, category_name, brand_name, product_name, inspection_description,
product_size, inspection_result, verified_selling_price,
pending_sale_id, rejected_sale_id, sale_grade_id, created_date, posted, used_or_not)
values
    (1, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 100ml, 새 제품, 박스 포함', 100, 1, 210000, 40, NULL, 1, NOW(), 0, 0),
    (2, 'Diffuser', 'Yankee Candle', '라벤더 디퓨저', 'Yankee Candle 라벤더 향 디퓨저, 새 제품', 100, 1, 40000, 41, NULL, 1, NOW(), 0, 0),
    (3, 'Candle', 'Bath & Body Works', '시나몬 스틱 캔들', 'Bath & Body Works 시나몬 스틱 캔들, 사용한 흔적 있음, 90% 남음', 185, 1, 25000, 42, NULL, 2, NOW(), 0, 1),
    (4, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸, 75ml, 중고 제품', 100, 1, 99000, 43, NULL, 3, NOW(), 0, 1),
    (5, 'Candle', 'IKEA', '레드 캔들', 'IKEA 레드 향초, 결과참조바람 test1', 150, 0, 0, 44, 4, NULL, NOW(), 0, 1),
    (6, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 70ml, 중고 제품, 박스 포함', 70, 1, 110000, 45, NULL, 3, NOW(), 0, 1),
    (7, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 85ml, 중고 제품, 박스 포함', 85, 1, 130000, 46, NULL, 2, NOW(), 0, 1),
    (8, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 90ml, 중고 제품, 박스 포함', 90, 1, 150000, 47, NULL, 2, NOW(), 0, 1),
    (9, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 65ml, 중고 제품, 박스 포함', 65, 1, 90000, 48, NULL, 3, NOW(), 0, 1),
    (10, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 55ml, 중고 제품, 박스 포함', 55, 1, 50000, 49, NULL, 4, NOW(), 0, 1),
    (11, 'Perfume', 'Santa Maria Novella', '아쿠아 오드퍼퓸', '아쿠아 오드퍼퓸 향수, 45ml, 중고 제품, 박스 포함', 45, 1, 50000, 50, 5, NULL, NOW(), 0, 1);

-- verified_sale_image
INSERT INTO verified_sale_image(verified_sale_image_id, filename, path, verified_image_type, verified_sale_id)
VALUES
(1, 'p_001.png', 'images/file/\\p_001.png', 'VERIFIED_ACCEPT', 1);

-- used_product
INSERT INTO used_product(used_product_id, created_date, used_product_type, verified_sale_id, sold_out)
values
    (1, now(), 'USER_ACCEPT', 1, false),
    (2, now(), 'USER_ACCEPT', 2, false),
    (3, now(), 'USER_ACCEPT', 3, false),
    (4, now(), 'USER_ACCEPT', 4, false),
    (5, now(), 'USER_REJECT', 5, false),
    (6, now(), 'USER_ACCEPT', 6, true),
    (7, now(), 'USER_ACCEPT', 7, true),
    (8, now(), 'USER_ACCEPT', 8, true),
    (9, now(), 'USER_ACCEPT', 9, true),
    (10, now(), 'USER_ACCEPT', 10, true),
    (11, now(), 'USER_REJECT', 11, true);

-- purchase
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000001, now(), 'COMPLETED', 730000, 3);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000002, now(), 'COMPLETED', 730000, 4);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000003, now(), 'COMPLETED', 730000, 5);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000004, now(), 'COMPLETED', 730000, 4);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000005, now(), 'COMPLETED', 730000, 3);
INSERT INTO purchase (purchase_id, purchase_date, purchase_status, total_price, member_id) VALUES (10000006, now(), 'COMPLETED', 730000, 3);

-- purchase_product
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, used_product_id, purchase_id) VALUES (10000001, '아쿠아 오드퍼퓸', 2, now(), 1, 10000001);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, used_product_id, purchase_id) VALUES (10000002, '아이스드베리레모네이드', 2, now(), 2, 10000002);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, used_product_id, purchase_id) VALUES (10000003, '라임 바질 앤 만다린 디퓨저', 2, now(), 3, 10000003);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, used_product_id, purchase_id) VALUES (10000004, '아쿠아 오드퍼퓸', 2, now(), 4, 10000004);
INSERT INTO purchase_product (purchase_product_id, product_name, product_quantity, purchase_creation_date, used_product_id, purchase_id) VALUES (10000005, '아이스드베리레모네이드', 2, now(), 5, 10000005);

-- payment
INSERT INTO payment (payment_id,total_price, member_id) VALUES (10000001, 100000, 5);

-- purchase_payment
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000001, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000001, 	    100000, 95);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000002, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000002, 	    20000, 599);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000003, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000003, 	   100000, 154);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000004, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000004, 	     50000, 44);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000005, NULL, NOW() - INTERVAL 6 MONTH, 10000001, 10000005, 	    10000, 349);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000008, NULL, NOW() - INTERVAL 2 MONTH, 10000001, 10000002  , 	    21000, 610                 );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000009, NULL, NOW() - INTERVAL 28 DAY, 10000001, 10000003   , 	   105000, 151                 );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000010, NULL, NOW() - INTERVAL 4 MONTH, 10000001, 10000004  , 	     50000, 45                 );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000011, NULL, NOW() - INTERVAL 250 DAY, 10000001, 10000005  , 	    10000, 350                 );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000013, NULL, now(), 10000001, 10000001                      , 	    90000, 92                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000014, NULL, now(), 10000001, 10000002                      , 	    20000, 599                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000015, NULL, now(), 10000001, 10000003                      , 	   100000, 154                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000016, NULL, now() - INTERVAL 83 DAY, 10000001, 10000004    , 	     50000, 44                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000017, NULL, now(), 10000001, 10000005                      , 	    10000, 349                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000019, NULL, NOW() - INTERVAL 7 MONTH, 10000001, 10000001   , 	    100000, 95                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000020, NULL, NOW() - INTERVAL 7 MONTH, 10000001, 10000002   , 	    20000, 599                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000021, NULL, NOW() - INTERVAL 7 MONTH, 10000001, 10000003   , 	   100000, 154                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000022, NULL, NOW() - INTERVAL 7 MONTH, 10000001, 10000004   , 	     50000, 44                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000023, NULL, NOW() - INTERVAL 7 MONTH, 10000001, 10000005   , 	    10000, 349                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000025, NULL, NOW() - INTERVAL 8 MONTH, 10000001, 10000001   , 	    100000, 95                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000026, NULL, NOW() - INTERVAL 8 MONTH, 10000001, 10000002   , 	    20000, 599                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000027, NULL, NOW() - INTERVAL 8 MONTH, 10000001, 10000003   , 	   100000, 154                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000028, NULL, NOW() - INTERVAL 8 MONTH, 10000001, 10000004   , 	     50000, 44                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000029, NULL, NOW() - INTERVAL 8 MONTH, 10000001, 10000005   , 	    10000, 349                );
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000031, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 13 DAY, 10000001,  10000001, 	    100000, 95);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000032, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 13 DAY, 10000001,  10000002, 	    20000, 599);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000033, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 13 DAY, 10000001,  10000003, 	   100000, 154);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000034, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 13 DAY, 10000001,  10000004, 	     50000, 44);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000035, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 13 DAY, 10000001,  10000005, 	    10000, 349);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000037, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 23 DAY, 10000001,  10000001, 	    100000, 95);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000038, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 23 DAY, 10000001,  10000002, 	    20000, 599);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000039, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 23 DAY, 10000001,  10000003, 	   100000, 154);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000040, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 23 DAY, 10000001,  10000004, 	     50000, 44);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000041, NULL, NOW() - INTERVAL 8 MONTH - INTERVAL 23 DAY, 10000001,  10000005, 	    10000, 349);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000043, NULL, NOW() - INTERVAL 9 MONTH, 10000001, 10000001	                  , 	    95000, 97);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000044, NULL, NOW() - INTERVAL 9 MONTH, 10000001, 10000002			          , 	    35000, 623);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000045, NULL, NOW() - INTERVAL 9 MONTH, 10000001, 10000003			          , 	   110000, 160);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000046, NULL, NOW() - INTERVAL 9 MONTH, 10000001, 10000004			          , 	     55000, 46);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000047, NULL, NOW() - INTERVAL 9 MONTH, 10000001, 10000005			          , 	    10000, 349);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000049, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 13 DAY, 10000001,  10000001, 	    100000, 95);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000050, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 13 DAY, 10000001,  10000002, 	    20000, 599);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000051, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 13 DAY, 10000001,  10000003, 	   100000, 154);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000052, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 13 DAY, 10000001,  10000004, 	     50000, 44);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000053, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 13 DAY, 10000001,  10000005, 	    10000, 349);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000055, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 23 DAY, 10000001,  10000001, 	    100000, 95);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000056, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 23 DAY, 10000001,  10000002, 	    20000, 599);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000057, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 23 DAY, 10000001,  10000003, 	   100000, 154);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000058, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 23 DAY, 10000001,  10000004, 	     50000, 44);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000059, NULL, NOW() - INTERVAL 9 MONTH - INTERVAL 23 DAY, 10000001,  10000005, 	    10000, 349);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000061, NULL, NOW() - INTERVAL 10 MONTH - INTERVAL 8 DAY, 10000001,  10000001, 	    100000, 95);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000062, NULL, NOW() - INTERVAL 10 MONTH - INTERVAL 12 DAY, 10000001, 10000001, 	   100000, 95);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000063, NULL, NOW() - INTERVAL 10 MONTH - INTERVAL 4 DAY, 10000001,  10000001, 	   110000, 96);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000064, NULL, NOW() - INTERVAL 10 MONTH - INTERVAL 21 DAY, 10000001, 10000001, 	   90000, 91);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000065, NULL, NOW() - INTERVAL 10 MONTH - INTERVAL 23 DAY, 10000001, 10000001, 	   150000, 100);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000066, NULL, NOW() - INTERVAL 10 MONTH - INTERVAL 17 DAY, 10000001, 10000001, 	    100000, 91);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000067, NULL, NOW() - INTERVAL 11 MONTH - INTERVAL 8 DAY, 10000001,  10000001, 	   110000, 96);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000068, NULL, NOW() - INTERVAL 11 MONTH - INTERVAL 12 DAY, 10000001, 10000001, 	    100000, 96);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000069, NULL, NOW() - INTERVAL 11 MONTH - INTERVAL 4 DAY, 10000001,  10000001, 	   120000, 96);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000070, NULL, NOW() - INTERVAL 11 MONTH - INTERVAL 21 DAY, 10000001, 10000001, 	     110000, 97);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000071, NULL, NOW() - INTERVAL 11 MONTH - INTERVAL 23 DAY, 10000001, 10000001, 	    100000, 92);
INSERT INTO purchase_payment (purchase_payment_id, cancelled_date, created_date, payment_id, purchase_product_id, trade_price, trade_size) VALUES (10000072, NULL, NOW() - INTERVAL 11 MONTH - INTERVAL 17 DAY, 10000001, 10000001, 	   100000, 96);

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

-- favorite
INSERT INTO favorite (member_id, review_id) VALUES(3, 10000001);
INSERT INTO favorite (member_id, review_id) VALUES(5, 10000001);
INSERT INTO favorite (member_id, review_id) VALUES(5, 10000002);