use myexample;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM class 
WHERE
    id > 0;
DELETE FROM professor 
WHERE
    id > 0;
DELETE FROM students 
WHERE
    id > 0;

INSERT INTO class (id, sala, professor_id)
VALUES 
	(1,'Sala 1',1),
	(2,'Sala 2',2);
        
INSERT INTO professor (id, name)
VALUES
	(1,'Ramiro'),
	(2,'Adrian');
    
INSERT INTO students  (name, class_id)
VALUES
	('Juan',1),
    ('Pedro',1),
    ('Felipe',1),
    ('Fernando',2),
    ('Rodrigo',2);
    
UPDATE students
SET name = 'Fernando II'
WHERE name = 'Fernando';

SELECT 
    p.name AS Profesor, COUNT(s.id) AS Alumnos
FROM
    students AS s
        INNER JOIN
    class AS c ON s.class_id = c.id
        INNER JOIN
    professor AS p ON c.professor_id = p.id
GROUP BY p.id;