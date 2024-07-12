#INSERT INTO category (category_name) VALUES ('Doors'), ('Windows'), ('Fans');
#INSERT INTO category (category_name) VALUES ('Electrical');
#INSERT INTO category (category_name) VALUES ('Flooring');

#SELECT * FROM project;
#SELECT * FROM category;

#INSERT INTO material (project_id, material_name, num_required) VALUES (3, '3 lbs of Grout', '10'), (3, 'Pair of large kneepads', 1);
#SELECT * FROM material;

#INSERT INTO step (project_id, step_text, step_order) VALUES (3, 'tear off the old floor', 1), (3, 'lay the new tile and grout', 3), (3, 'be patient', 3);
SELECT * FROM step;

#INSERT INTO project_category (project_id, category_id) VALUES (3, 5);
#SELECT * FROM project_category;