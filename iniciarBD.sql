INSERT INTO departamento VALUES (1, 'Artigas');
INSERT INTO departamento VALUES (2, 'Canelones');
INSERT INTO departamento VALUES (3, 'Cerro Largo');
INSERT INTO departamento VALUES (4, 'Colonia');
INSERT INTO departamento VALUES (5, 'Durazno');
INSERT INTO departamento VALUES (6, 'Flores');
INSERT INTO departamento VALUES (7, 'Florida');
INSERT INTO departamento VALUES (8, 'Lavalleja');
INSERT INTO departamento VALUES (9, 'Maldonado');
INSERT INTO departamento VALUES (10, 'Montevideo');
INSERT INTO departamento VALUES (11, 'Paysandú');
INSERT INTO departamento VALUES (12, 'Río Negro');
INSERT INTO departamento VALUES (13, 'Rivera');
INSERT INTO departamento VALUES (14, 'Rocha');
INSERT INTO departamento VALUES (15, 'Salto');
INSERT INTO departamento VALUES (16, 'San José');
INSERT INTO departamento VALUES (17, 'Soriano');
INSERT INTO departamento VALUES (18, 'Tacuarembó');
INSERT INTO departamento VALUES (19, 'Treinta y Tres');

//Agregamos enfermedad para caso de uso gestion de plan de vacuna
INSERT INTO public.enfermedad(id, fechacreacion, nombre) VALUES (1, '31-10-2020', 'Enfermedad1');
INSERT INTO public.enfermedad(id, fechacreacion, nombre) VALUES (2, '20-10-1993', 'Enfermedad2');
INSERT INTO public.enfermedad(id, fechacreacion, nombre) VALUES (3, '25-3-2019', 'Enfermedad3');

//Agregamos vacunas para caso de uso gestion de plan de vacuna
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (1, 'JK1', 'LoDePepe', 'Jose P.', 1, null);
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (2, 'JK2', 'Jhosepha', 'Jose A.', 1, null);
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (3, 'JK3', 'Mac Bns', 'Jose R.', 2, null);
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (4, 'JK4', 'Herby', 'Pedro K.', 3, null);