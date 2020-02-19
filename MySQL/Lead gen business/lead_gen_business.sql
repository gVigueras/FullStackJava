use lead_gen_business;
-- Consulta 1

SELECT sum(amount)
FROM billing
WHERE month(charged_datetime) = 3 AND year(charged_datetime) = 2012;

-- Consulta 2

SELECT sum(amount)
FROM billing
WHERE client_id = 2;

-- Consulta 3

SELECT domain_name
FROM sites
WHERE client_id = 10;

-- Consulta 4

SELECT 
    c.client_id,
    COUNT(s.site_id) as created_sites,
    MONTHNAME(s.created_datetime),
    YEAR(s.created_datetime)
FROM
    clients AS c
        INNER JOIN
    sites AS s ON c.client_id = s.client_id
WHERE
    c.client_id IN (1 , 20)
GROUP BY s.client_id , MONTH(s.created_datetime) , YEAR(s.created_datetime);

-- Consulta 5

SELECT 
    s.domain_name,
    COUNT(leads_id) AS leads,
    MONTHNAME(registered_datetime),
    YEAR(registered_datetime)
FROM
    leads AS l
        INNER JOIN
    sites AS s ON l.site_id = s.site_id
WHERE
    YEAR(registered_datetime) = 2011
GROUP BY l.site_id
ORDER BY registered_datetime;

-- Consulta 6

SELECT 
    CONCAT(c.first_name, ' ', c.last_name) AS Nombre,
    COUNT(l.leads_id)
FROM
    clients AS c
        INNER JOIN
    sites AS s ON c.client_id = s.client_id
        INNER JOIN
    leads AS l ON s.site_id = l.site_id
GROUP BY c.client_id
ORDER BY COUNT(l.leads_id) DESC;

-- Consulta 7

SELECT 
    COUNT(l.leads_id) AS Potenciales,
    s.domain_name,
    CONCAT(c.first_name, ' ', c.last_name) AS Dueño,
    MONTHNAME(l.registered_datetime) AS Mes
FROM
    clients AS c
        INNER JOIN
    sites AS s ON c.client_id = s.client_id
        INNER JOIN
    leads AS l ON s.site_id = l.site_id
WHERE
    MONTH(l.registered_datetime) BETWEEN 1 AND 6
GROUP BY c.client_id , MONTH(l.registered_datetime)
ORDER BY c.client_id , MONTH(l.registered_datetime);

-- Consulta 8-a

SELECT 
    COUNT(l.leads_id) AS Potenciales,
    CONCAT(c.first_name, ' ', c.last_name) AS Dueño
FROM
    clients AS c
        INNER JOIN
    sites AS s ON c.client_id = s.client_id
        INNER JOIN
    leads AS l ON s.site_id = l.site_id
WHERE
    YEAR(l.registered_datetime) = 2011
GROUP BY c.client_id;

-- Consulta 8-b 

SELECT 
    COUNT(l.leads_id) AS Potenciales,
    CONCAT(c.first_name, ' ', c.last_name) AS Dueño
FROM
    clients AS c
        INNER JOIN
    sites AS s ON c.client_id = s.client_id
        INNER JOIN
    leads AS l ON s.site_id = l.site_id
GROUP BY c.client_id;

-- Consulta 9

SELECT 
    CONCAT(c.first_name, ' ', c.last_name) AS Cliente,
    MONTHNAME(b.charged_datetime) AS Mes,
    SUM(b.amount) AS Monto
FROM
    billing AS b
        INNER JOIN
    clients AS c ON b.client_id = c.client_id
GROUP BY c.client_id , MONTH(b.charged_datetime);

-- Consulta 10

SELECT 
    CONCAT(c.first_name, ' ', c.last_name) AS Cliente,
    GROUP_CONCAT(' ', s.domain_name) as Sitios
FROM
    clients AS c
        INNER JOIN
    sites AS s ON c.client_id = s.client_id
GROUP BY c.client_id;