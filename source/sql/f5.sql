/* ユーザーテーブル*/
CREATE TABLE users (
user_id INT AUTO_INCREMENT PRIMARY KEY,
password VARCHAR(20) NOT NULL,
nickname VARCHAR(20) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
photo LONGBLOB,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP


INSERT INTO users VALUES (0,'#SEplus2025SEplus','dojouser1','dojouser1@plusdojo.jp',null,null,null);
INSERT INTO users VALUES (0,'#SEplus2025SEplus','dojouser2','dojouser2@plusdojo.jp',null,null,null);
INSERT INTO users VALUES (0,'#SEplus2025SEplus','dojouser3','dojouser3@plusdojo.jp',null,null,null);
INSERT INTO users VALUES (0,'#SEplus2025SEplus','dojouser4','dojouser4@plusdojo.jp',null,null,null);
INSERT INTO users VALUES (0,'#SEplus2025SEplus','dojouser5','dojouser5@plusdojo.jp',null,null,null);
/*洗濯表示カテゴリー*/						
CREATE TABLE laundry_category_mst (							
laundry_category_id INT AUTO_INCREMENT PRIMARY KEY,							
laundry_category_name VARCHAR(20)							
);
							
INSERT INTO laundry_category_mst (laundry_category_name) VALUES ('家庭洗濯');
INSERT INTO laundry_category_mst (laundry_category_name) VALUES ('漂白');
INSERT INTO laundry_category_mst (laundry_category_name) VALUES ('タンブル乾燥');
INSERT INTO laundry_category_mst (laundry_category_name) VALUES ('自然乾燥');
INSERT INTO laundry_category_mst (laundry_category_name) VALUES ('アイロン');
INSERT INTO laundry_category_mst (laundry_category_name) VALUES ('クリーニング');

/*カテゴリーテーブル*/
CREATE TABLE category_mst (
category_id INT AUTO_INCREMENT PRIMARY KEY,　
category_name VARCHAR(20) NOT NULL);					
);

INSERT INTO category_mst (category_name) VALUES ('トップス');
INSERT INTO category_mst (category_name) VALUES ('ボトムス');
INSERT INTO category_mst (category_name) VALUES ('アウター');
INSERT INTO category_mst (category_name) VALUES ('ワンピース');
INSERT INTO category_mst (category_name) VALUES ('スーツ');
INSERT INTO category_mst (category_name) VALUES ('その他');
INSERT INTO category_mst (category_name) VALUES ('ファブリック');

/*ログテーブル*/
CREATE TABLE log (
log_id INT AUTO_INCREMENT PRIMARY KEY,
log_info VARCHAR(50) NOT NULL,
user_id INT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users (user_id)
);

/*洗濯表示テーブル*/
CREATE TABLE washing_mark_mst (
washing_mark_id INT AUTO_INCREMENT PRIMARY KEY,
washing_mark_icon LONGBLOB NOT NULL,
washing_mark_info VARCHAR(100) NOT NULL,
laundry_category_id INT NOT NULL,
washing_mark_number INT NOT NULL,
FOREIGN KEY (laundry_category_id) REFERENCES laundry_category_mst (laundry_category_id)
);

/*洗濯物テーブル*/
CREATE TABLE clothes (
clothes_id INT AUTO_INCREMENT PRIMARY KEY,
clothes_img LONGBLOB,
category_id INT,
remarks VARCHAR(100),
user_id INT,
favorite BOOLEAN,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (category_id) REFERENCES category_mst (category_id),
FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE clothes_mark(
clothes_id INT,
washing_mark_id INT,
PRIMARY KEY (clothes_id, washing_mark_id),
FOREIGN KEY (clothes_id) REFERENCES clothes (clothes_id) ON DELETE CASCADE,
FOREIGN KEY (washing_mark_id) REFERENCES washing_mark_mst (washing_mark_id) ON DELETE CASCADE
);