-- Articles
INSERT INTO article (id, name, description) VALUES
                                                (1, 'Laptop', 'High performance laptop'),
                                                (2, 'Mouse', 'Wireless mouse'),
                                                (3, 'Keyboard', 'Mechanical keyboard');

-- Providers
INSERT INTO provider (id, name) VALUES
                                    (1, 'TechSupplier'),
                                    (2, 'GlobalHardware'),
                                    (3, 'OfficeGoods');

-- Association article/provider
INSERT INTO article_provider (article_id, provider_id) VALUES
                                                           (1,1),
                                                           (1,2),
                                                           (2,2),
                                                           (3,3);

-- Mouvements de stock
INSERT INTO mouvement (article_id, provider_id, type, quantity, date) VALUES
                                                                          (1,1,'INPUT',50,'2026-03-10 10:00:00'),
                                                                          (1,2,'INPUT',30,'2026-03-11 11:30:00'),
                                                                          (2,2,'INPUT',100,'2026-03-12 09:15:00'),
                                                                          (3,3,'INPUT',80,'2026-03-12 14:45:00'),
                                                                          (1,1,'OUTPUT',5,'2026-03-13 10:00:00'),
                                                                          (2,2,'OUTPUT',10,'2026-03-13 16:20:00');

INSERT INTO stock (article_id, provider_id, quantity, version) VALUES
                                                                   (1,1,45,0),
                                                                   (1,2,30,0),
                                                                   (2,2,90,0),
                                                                   (3,3,80,0);

INSERT INTO client (name, number_of_orders)
VALUES ('Client A', 0);

INSERT INTO client (name, number_of_orders)
VALUES ('Client B', 0);