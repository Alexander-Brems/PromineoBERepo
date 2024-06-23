#INSERT INTO category (category_name) VALUES ('Doors'), ('Windows'), ('Fans');
#INSERT INTO category (category_name) VALUES ('Electrical');

#SELECT * FROM project;
#SELECT * FROM category;

#INSERT INTO material (project_id, material_name, num_required) VALUES (1, '6-blade ceiling fan', 1), (2, '50-foot ethernet cable', 5);
#SELECT * FROM material;

#INSERT INTO step (project_id, step_text, step_order) VALUES (1, 'Set up a mount in the attic', 1), (1, 'Attach the fan to the mount', 2), (2, 'Run ethernet cabling though the walls', 1);
#SELECT * FROM step;

INSERT INTO project_category (project_id, category_id) VALUES (1, 1), (1, 2), (2, 2);
SELECT * FROM project_category;