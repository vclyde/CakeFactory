/**
 * Author:  cvelasquez
 * Created: Oct 20, 2021
 */

DROP TABLE IF EXISTS catalog; 
CREATE TABLE catalog (
    sku VARCHAR(32) NOT NULL PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    price DECIMAL  NOT NULL);