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
    l.language = 'Slovensko'
GROUP BY l.language
ORDER BY l.percentage DESC;

-- Consulta 2

SELECT 
    c.name AS Pais, COUNT(ci.id)
FROM
    countries AS c
        INNER JOIN
    cities AS ci ON c.id = ci.country_id
GROUP BY ci.country_id
ORDER BY COUNT(ci.id) DESC;


-- Consulta 3

SELECT 
    ci.name, ci.population
FROM
    cities AS ci
        INNER JOIN
    countries AS c ON ci.country_id = c.id
WHERE
    c.name = 'Mexico'
        AND ci.population > 500000
ORDER BY ci.population DESC;

-- Consulta 4