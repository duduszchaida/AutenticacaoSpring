-- Migration V1: Create products and product_variations tables

-- Create products table
CREATE TABLE  products
(
    id BIGINT NOT NULL,
    name VARCHAR(255),
    description TEXT,
    category VARCHAR(255),
    available BOOLEAN,
    CONSTRAINT products_pkey PRIMARY KEY (id)
    );

-- Create product_variations table
CREATE TABLE product_variations
(
    id BIGINT NOT NULL,
    description VARCHAR(255),
    available BOOLEAN,
    price NUMERIC(38,2),
    product_id BIGINT,
    size_name VARCHAR(255),
    CONSTRAINT product_variation_pkey PRIMARY KEY (id),
    CONSTRAINT fk_product_id FOREIGN KEY (product_id)
    REFERENCES public.products (id)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    );


