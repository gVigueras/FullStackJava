use sakila;

-- Consulta 1

SELECT 
    c.first_name AS Nombre,
    c.last_name AS Apellido,
    c.email AS Correo,
    CONCAT(a.address2, a.address) AS Dirección
FROM
    customer AS c
        INNER JOIN
    address AS a ON c.address_id = a.address_id
WHERE
    a.city_id = 312;
    
-- Consulta 2

SELECT 
    f.title AS Título,
    f.description AS Descripción,
    f.release_year AS 'Año de estreno',
    f.rating AS Calificación,
    f.special_features AS 'Características especiales',
    c.name AS Género
FROM
    film_category AS fc
        INNER JOIN
    category AS c ON fc.category_id = c.category_id
        INNER JOIN
    film AS f ON fc.film_id = f.film_id
WHERE
    c.name = 'Comedy';
    
-- Consulta 3

SELECT 
    a.actor_id AS 'ID Actor',
    CONCAT(a.first_name,' ',a.last_name) AS Nombre,
    f.title AS Título,
    f.description AS Descripción,
    f.release_year AS 'Año de lanzamiento'
FROM
    actor AS a
        INNER JOIN
    film_actor AS fa ON a.actor_id = fa.actor_id
        INNER JOIN
    film AS f ON fa.film_id = f.film_id
WHERE
    a.actor_id = 5
ORDER BY a.first_name , a.last_name;

-- Consulta 4

SELECT
    c.first_name AS Nombre,
    c.last_name AS Apellido,
    c.email AS Correo,
    cl.address AS Dirección
FROM
    customer_list AS cl
        INNER JOIN
    city AS ci ON cl.city = ci.city
        INNER JOIN
    customer AS c ON cl.ID = c.customer_id
WHERE
    ci.city_id IN (1 , 42, 312, 459);
    
-- Consulta 5

SELECT 
    f.title AS Título,
    f.description AS Descripción,
    f.release_year AS 'Año de Lanzamiento',
    fl.rating AS Calificación,
    f.special_features AS 'Funciones Especiales'
FROM
    nicer_but_slower_film_list AS fl
        INNER JOIN
    film AS f ON fl.FID = f.film_id
WHERE
    fl.rating = 'G'
        AND f.special_features LIKE '%behind the Scenes%';
        
-- Consulta 6

SELECT 
    f.film_id, f.title, a.actor_id, concat(a.first_name,' ', a.last_name) as 'Nombre y Apellido'
FROM
    actor AS a
        INNER JOIN
    film_actor AS fa ON a.actor_id = fa.actor_id
        INNER JOIN
    film AS f ON fa.film_id = f.film_id
WHERE
    f.film_id = 369;
    
-- Consulta 7

SELECT 
    f.title,
    f.description,
    f.release_year,
    f.rating,
    f.special_features,
    fl.category
FROM
    nicer_but_slower_film_list AS fl
        INNER JOIN
    film AS f ON fl.FID = f.film_id
WHERE
    fl.price = 2.99;
    
-- Consulta 8

SELECT 
    f.title,
    f.description,
    f.release_year,
    f.rating,
    f.special_features,
    fl.category,
    fl.actors
FROM
    nicer_but_slower_film_list fl
        INNER JOIN
    film AS f ON fl.FID = f.film_id
WHERE
    fl.actors LIKE '%Sandra Kilmer%'