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

--Agregamos enfermedad para caso de uso gestion de plan de vacuna
INSERT INTO public.enfermedad(id, fechacreacion, nombre) VALUES (1, '31-10-2020', 'Enfermedad1');
INSERT INTO public.enfermedad(id, fechacreacion, nombre) VALUES (2, '20-10-1993', 'Enfermedad2');
INSERT INTO public.enfermedad(id, fechacreacion, nombre) VALUES (3, '25-3-2019', 'Enfermedad3');

--Agregamos vacunas para caso de uso gestion de plan de vacuna
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (1, 'JK1', 'LoDePepe', 'Jose P.', 1, null);
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (2, 'JK2', 'Jhosepha', 'Jose A.', 1, null);
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (3, 'JK3', 'Mac Bns', 'Jose R.', 2, null);
INSERT INTO public.vacuna(id, codigo, laboratorio, nombre, enfermedad_id, proveedor_id) VALUES (4, 'JK4', 'Herby', 'Pedro K.', 3, null);




-- Agregamos ubicaciones para vincularlos a los departamentos

INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (1, 'Sur de artigas ', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (2, 'Norte de artigas ', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (3, 'Este de artigas ', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (4, 'Oeste de artigas ', null);


-- Vinculamos la Tabla departamentos de Artigas con la ubicacion

INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (1, 1);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (1, 2);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (1, 3);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (1, 4);

-- Agregamos ubicaciones para vincularlos a los departamentos

INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (5, 'Sur de Florida', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (6, 'Norte de Florida ', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (7, 'Este de Florida ', null);

-- Vinculamos la Tabla departamentos de Florida con la ubicacion

INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (7, 5);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (7, 6);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (7, 7);


--Ubicaciones de Canelones

INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (8, 'Sur de Canelones', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (9, 'Norte de Canelones', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (10, 'Este de Canelones', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (11, 'Oeste de Canelones', null);

--Ubicaciones de Cerro Largo

INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (12, 'Sur de Cerro Largo', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (13, 'Norte de Cerro Largo', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (14, 'Este de Cerro Largo', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (15, 'Oeste de Cerro Largo', null);

--Ubicaciones de Colonia

INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (16, 'Sur de Colonia', null);
INSERT INTO public.ubicacion(id, descripcion, vacunatorio_id) VALUES (17, 'Norte de Colonia', null);

--Vinculamos las ubicaciones al departamentos Canelones

INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (2, 8);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (2, 9);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (2, 10);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (2, 11);

--Vinculamos las ubicaciones al departamentos Cerro Largo

INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (3, 12);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (3, 13);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (3, 14);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (3, 15);

--Vinculamos las ubicaciones al departamentos Colonia

INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (4, 16);
INSERT INTO public.departamento_ubicacion(departamento_id, ubicaciones_id) VALUES (4, 17);

--Agregamos planes de vacunacion

INSERT INTO public.planvacunacion(id, edadmaxima, edadminima, nombre, poblacionobjetivo, enfermedad_id)
    VALUES (1, 30, 10, 'Plan COVID', 'Jóvenes', 1);
INSERT INTO public.planvacunacion(id, edadmaxima, edadminima, nombre, poblacionobjetivo, enfermedad_id)
    VALUES (2, 50, 30, 'Plan GRIPE', 'Adultos', 2);
INSERT INTO public.planvacunacion(id, edadmaxima, edadminima, nombre, poblacionobjetivo, enfermedad_id)
    VALUES (3, 80, 50, 'Plan COVID', 'Adultos mayores', 2);

--Agregamos vacunatorios

INSERT INTO public.vacunatorio(id, codigo, nombre)
    VALUES (1000, 'V-ART', 'Vacunatorio Artigas');
INSERT INTO public.vacunatorio(id, codigo, nombre)
    VALUES (1001, 'V-FLO', 'Vacunatorio Florida');
INSERT INTO public.vacunatorio(id, codigo, nombre)
    VALUES (1002, 'V-CAN', 'Vacunatorio Canelones');
    
--Agregamos vacunatorios a las ubicaciones
update ubicacion set vacunatorio_id = 1000 where id = 1
update ubicacion set vacunatorio_id = 1000 where id = 2
update ubicacion set vacunatorio_id = 1000 where id = 3

--Agregamos agendas
INSERT INTO public.agenda(id, fin, horafin, horainicio, inicio, vacunatorio_id)
    VALUES (1124, '2020-01-01', '2000', '0800', '2020-02-10', 1000);
INSERT INTO public.agenda(id, fin, horafin, horainicio, inicio, vacunatorio_id)
    VALUES (1123, '2022-01-01', '2000', '0800', '2023-06-11', 1000);
INSERT INTO public.agenda(id, fin, horafin, horainicio, inicio, vacunatorio_id)
    VALUES (1125, '2021-05-01', '2000', '0800', '2021-10-01', 1000);
    
--Agregamos ciudadanos
INSERT INTO public.usuario(tipo, ci, email, primerapellido, primernombre, segundoapellido, segundonombre, telefono, contrasenia)
    VALUES ('ciudadano', 12345678, 'juan@gmail.com', 'Perez', 'Juan', 'Perez', 'Juan', 099654123, null);
	INSERT INTO public.usuario(tipo, ci, email, primerapellido, primernombre, segundoapellido, segundonombre, telefono, contrasenia)
    VALUES ('ciudadano', 12345679, 'juana@gmail.com', 'Lopez', 'Juana', 'Perez', 'Juana', 099654123, null);
