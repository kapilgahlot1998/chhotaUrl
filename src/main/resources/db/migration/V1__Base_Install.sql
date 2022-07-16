
CREATE TABLE user_profile (
	user_id SERIAL NOT NULL,
	user_email varchar(100) NOT NULL
);

ALTER TABLE user_profile
ADD CONSTRAINT useremail_uk UNIQUE (user_email);

ALTER TABLE user_profile
ADD CONSTRAINT userprofile_pk PRIMARY KEY (user_id);

CREATE TABLE chhota_url_details(
    hash_code varchar(7) NOT NULL,
    chhota_url varchar(200) NOT NULL,
    long_url varchar(1000) NOT NULL,
    user_id bigint
);

ALTER TABLE chhota_url_details
ADD CONSTRAINT chhotaUrlDetails_pk PRIMARY KEY (hash_code);

ALTER TABLE chhota_url_details ADD CONSTRAINT userId_fk FOREIGN KEY (user_id) REFERENCES user_profile (user_id);