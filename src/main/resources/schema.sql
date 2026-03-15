DROP TABLE IF EXISTS mouvement;
DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS article_provider;
DROP TABLE IF EXISTS provider;
DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS order_line;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS client;

CREATE TABLE article (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT
);

CREATE TABLE provider (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);

-- table de jointure many-to-many
CREATE TABLE article_provider (
                                  article_id BIGINT NOT NULL,
                                  provider_id BIGINT NOT NULL,
                                  PRIMARY KEY (article_id, provider_id),
                                  CONSTRAINT fk_article_provider_article
                                      FOREIGN KEY (article_id)
                                          REFERENCES article(id)
                                          ON DELETE CASCADE,
                                  CONSTRAINT fk_article_provider_provider
                                      FOREIGN KEY (provider_id)
                                          REFERENCES provider(id)
                                          ON DELETE CASCADE
);

CREATE TABLE mouvement (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           article_id BIGINT NOT NULL,
                           provider_id BIGINT NOT NULL,
                           type ENUM('INPUT','OUTPUT') NOT NULL,
                           quantity INT NOT NULL,
                           date DATETIME NOT NULL,

                           CONSTRAINT fk_mouvement_article
                               FOREIGN KEY (article_id)
                                   REFERENCES article(id),

                           CONSTRAINT fk_mouvement_provider
                               FOREIGN KEY (provider_id)
                                   REFERENCES provider(id)
);

CREATE TABLE stock (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       article_id BIGINT NOT NULL,
                       provider_id BIGINT NOT NULL,
                       quantity INT NOT NULL,
                       version BIGINT NOT NULL,

                       CONSTRAINT uq_stock_article_provider
                           UNIQUE (article_id, provider_id),

                       CONSTRAINT fk_stock_article
                           FOREIGN KEY (article_id)
                               REFERENCES article(id)
                               ON DELETE CASCADE,

                       CONSTRAINT fk_stock_provider
                           FOREIGN KEY (provider_id)
                               REFERENCES provider(id)
                               ON DELETE CASCADE
);

CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255),
                        number_of_orders INT NOT NULL
);

CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        client_id BIGINT NOT NULL,

                        CONSTRAINT fk_orders_client
                            FOREIGN KEY (client_id)
                                REFERENCES client(id)
                                ON DELETE CASCADE
);

CREATE TABLE order_line (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            order_id BIGINT NOT NULL,
                            article_id BIGINT NOT NULL,
                            quantity INT NOT NULL,

                            CONSTRAINT fk_order_line_order
                                FOREIGN KEY (order_id)
                                    REFERENCES orders(id)
                                    ON DELETE CASCADE,

                            CONSTRAINT fk_order_line_article
                                FOREIGN KEY (article_id)
                                    REFERENCES article(id)
);