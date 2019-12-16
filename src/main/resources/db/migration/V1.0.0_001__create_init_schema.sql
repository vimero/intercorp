CREATE TABLE `customer`(
  `id` VARCHAR(36) PRIMARY KEY,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `age` SMALLINT UNSIGNED NOT NULL,
  `date_birthday` datetime NOT NULL,
  `date_death` datetime NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime
) ENGINE=InnoDB DEFAULT CHARSET=utf8;