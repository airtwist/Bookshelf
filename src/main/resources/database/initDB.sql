CREATE TABLE IF NOT EXISTS books
(
    id    BIGSERIAL PRIMARY KEY ,
    title  VARCHAR(200) NOT NULL ,
    author VARCHAR(254) NOT NULL ,
    cover VARCHAR(254)  NOT NULL ,
    review VARCHAR(254)  NOT NULL
    );

