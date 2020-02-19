
use amigos;

-- Consulta 1

SELECT 
    u2.first_name, u2.last_name
FROM
    users AS u
        INNER JOIN
    friendships AS f ON u.id = f.user_id
        INNER JOIN
    users AS u2 ON f.friend_id = u2.id
WHERE
    u.first_name = 'Lermit' 
UNION SELECT 
    u.first_name, u.last_name
FROM
    users AS u
        INNER JOIN
    friendships AS f ON u.id = f.user_id
        INNER JOIN
    users AS u2 ON f.friend_id = u2.id
WHERE
    u2.first_name = 'Kermit';
        
-- Consulta 2

SELECT count(id) as 'Amistades Totales'
FROM friendships;

-- Consulta 3

SELECT 
    u.first_name, u.last_name, COUNT(u2.id) AS friends
FROM
    users AS u
        INNER JOIN
    friendships AS f ON u.id = f.user_id
        INNER JOIN
    users AS u2 ON f.friend_id = u2.id
GROUP BY u.id
ORDER BY COUNT(u2.id) DESC;

-- Consulta 4

INSERT INTO users (first_name, last_name) VALUES ('Alan', 'Brito');
INSERT INTO friendships (user_id, friend_id)
VALUES
	(6, 2),
	(6, 4),
	(6, 5);
    
-- Consulta 5

SELECT 
    u2.first_name, u2.last_name
FROM
    users AS u
        INNER JOIN
    friendships AS f ON u.id = f.user_id
        INNER JOIN
    users AS u2 ON f.friend_id = u2.id
WHERE
    u.first_name = 'Eli' 
UNION SELECT 
    u.first_name, u.last_name
FROM
    users AS u
        INNER JOIN
    friendships AS f ON u.id = f.user_id
        INNER JOIN
    users AS u2 ON f.friend_id = u2.id
WHERE
    u2.first_name = 'Eli';
    
-- Consulta 6

DELETE FROM friendships 
WHERE
    (user_id = 5 AND friend_id = 2)
    OR (user_id = 2 AND friend_id = 5);
    
-- Consulta 7

SELECT 
    u.first_name, u.last_name, u2.first_name, u.last_name
FROM
    users AS u
        INNER JOIN
    friendships AS f ON u.id = f.user_id
        INNER JOIN
    users AS u2 ON f.friend_id = u2.id;