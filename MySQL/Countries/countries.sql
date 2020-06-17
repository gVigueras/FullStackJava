-- Consulta 1

SELECT 
    c.name AS Pais,
    l.language AS Idioma,
    l.percentage AS Porcentaje
FROM
    languages AS l
        INNER JOIN
    countries AS c ON l.country_id = c.id
 WHERE
    l.language = 'Slovene'
GROUP BY l.language
ORDER BY l.percentage DESC;

-- Consulta 2

SELECT 
    c.name AS Pais, COUNT(ci.id) as Poblacion
FROM
    countries AS c
        INNER JOIN
    cities AS ci ON c.id = ci.country_id
GROUP BY ci.country_id
ORDER BY COUNT(ci.id) DESC;


-- Consulta 3

SELECT 
    ci.name as Ciudad, ci.population as Poblacion
FROM
    cities AS ci
        INNER JOIN
    countries AS c ON ci.country_id = c.id
WHERE
    c.name = 'Mexico'
        AND ci.population > 500000
ORDER BY ci.population DESC;

-- Consulta 4

SELECT 
    c.name AS Pais,
    l.language AS Idioma,
    l.percentage AS Porcentaje
FROM
    languages AS l
        INNER JOIN
    countries AS c ON l.country_id = c.id
 WHERE
    l.percentage > 89
GROUP BY l.language
ORDER BY l.percentage DESC;

-- Consulta 5

SELECT 
    c.name AS Pais,
    c.population AS Poblacion,
    c.surface_area AS Superficie
FROM
    countries AS c
WHERE
    surface_area < 501
        AND population > 100000;
        
-- Consulta 6

SELECT 
    name AS Pais,
    government_form AS 'Forma de gobierno',
    capital,
    life_expectancy AS 'Esperanza de vida'
FROM
    countries
WHERE
    government_form LIKE 'Constitutional Monarchy%'
        AND capital > 200
        AND life_expectancy > 75
ORDER BY name;

-- Consulta 7

SELECT 
    c.name AS Pais,
    ci.name AS Ciudad,
    ci.district AS Distrito,
    ci.population AS Poblacion
FROM
    cities AS ci
        INNER JOIN
    countries AS c ON ci.country_id = c.id
WHERE
    ci.district = 'Buenos Aires'
        AND ci.population > 500000;
    
-- Consulta 8

SELECT 
    region AS Región, COUNT(id) AS 'Número de paises'
FROM
    countries
GROUP BY region
ORDER BY COUNT(id) DESC;