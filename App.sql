CREATE TABLE "users" (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE "products" (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE "orders" (
                         id SERIAL PRIMARY KEY,
                         user_id INTEGER NOT NULL REFERENCES "users" (id),
                         product_id INTEGER NOT NULL REFERENCES "products" (id),
                         quantity INTEGER
);

INSERT INTO "users" (name, email) VALUES
                                   ('Vitaliy', 'Vit@example.org'),
                                   ('Semionne', 'S7@example.org');
INSERT INTO "products" (name, price) VALUES
                                    ('Bar', 100.00),
                                    ('Brick', 5.70);
INSERT INTO "orders" (user_id, product_id, quantity) VALUES
                                    ((SELECT id FROM users WHERE name = 'Vitaliy'), (SELECT id FROM products WHERE name = 'Bar'), 100),
                                    ((SELECT id FROM users WHERE name = 'Semionne'), (SELECT id FROM products WHERE name = 'Brick'), 50);

drop table "orders";
drop table "users";
drop table "products";