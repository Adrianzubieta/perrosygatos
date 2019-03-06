DELETE FROM city;
DELETE FROM state;
DELETE FROM country;
DELETE FROM user;
DELETE FROM refuge;
DELETE FROM kind;
DELETE FROM animal;

INSERT INTO country
  (id, name)
VALUES
  (1, 'Argentina'),
  (2, 'Brasil');

INSERT INTO state
  (id, name, country_id)
VALUES
  (1, 'Cordoba', 1),
  (2, 'Buenos Aires', 1);

INSERT INTO city
  (id, name, state_id)
VALUES
  (1, 'CABA', 1),
  (2, 'Tandil', 1);

INSERT INTO size
  (id, name)
VALUES
  (1, 'Pequeño'),
  (2, 'Mediano'),
  (3, 'Grande');

INSERT INTO gender
  (id, name)
VALUES
  (1, 'Macho'),
  (2, 'Hembra');

INSERT INTO user
(id, user_name, email, password)
VALUES
  (1, 'Adrian', 'AdrianZubieta@gmail.com', 'password-1'),
  (2, 'Ian', 'IanZubieta@gmail.com', 'password-2'),
  (3, 'Melissa','melissaPinaya@gmail.com','password-3'),
  (4, 'Ariel','arialZubieta@gmail.com','password-4');

INSERT INTO refuge
(id, name, web_site, description, phone, address, city_id)
VALUES
  (1, 'refugio_1', 'webSite_1', 'description_1', '1516161616', 'address_1', 1),
  (2, 'refugio_2', 'webSite_2', 'description_2', '1516161616', 'address_2', 1);

INSERT INTO kind
(id, name)
VALUES
  (1, 'Perro'),
  (2, 'Gato');

INSERT INTO animal
(id, name, kind_id, age, description, refuge_id, url_photo, history, city_id, size_id, gender_id)
VALUES
  (1, 'firulais', 1, 2, 'description_1', 1, 'www.imageFirulais.com', 'history_1', 1, 1, 2),
  (2, 'tom', 2, 2, 'description_2', 1, 'www.imageTom.com', 'history_2', 2, 2, 1);


