-- Comenzamos con CRUD (create, read, update, delete)
-- Listar los estudiantes (read)
-- SELECT * FROM estudiantes2022;
-- insertar un estudiante
-- INSERT INTO estudiantes2022 (nombre, apellido, teléfono, email) VALUES ("Juan", "Perez", "2345678", "jperez@mail.com");
-- Update (modificar)
-- update estudiantes2022 set nombre="Miguel",apellido="García",teléfono="234543",email="mgarcia@mail.com" where idestudiantes2022=2;
-- delete (borrar)
-- delete from estudiantes2022 where idestudiantes2022=23;
-- Para modificar el id de estudiantes2022 y que comience en 1:
alter table estudiantes2022 auto_increment=1;
