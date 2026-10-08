-- estos son datos de prueba que se cargan solos cuando arranca la app,
-- quedan los barberos con id 1, 2 y 3 y las citas con id 1, 2 y 3

INSERT INTO barberos (nombre, especialidad, telefono) VALUES ('Matias Rojas', 'Fade y degradados', '+56911112222');
INSERT INTO barberos (nombre, especialidad, telefono) VALUES ('Camila Soto', 'Barba y perfilado', '+56933334444');
INSERT INTO barberos (nombre, especialidad, telefono) VALUES ('Diego Fuentes', 'Cortes clasicos', '+56955556666');

INSERT INTO citas (nombre_cliente, servicio, fecha_hora, precio, id_barbero) VALUES ('Juan Perez', 'Corte fade', '2026-12-10 10:00:00', 12000, 1);
INSERT INTO citas (nombre_cliente, servicio, fecha_hora, precio, id_barbero) VALUES ('Pedro Munoz', 'Perfilado de barba', '2026-12-10 11:00:00', 7000, 2);
INSERT INTO citas (nombre_cliente, servicio, fecha_hora, precio, id_barbero) VALUES ('Tomas Diaz', 'Corte clasico', '2026-12-11 12:00:00', 10000, 1);
