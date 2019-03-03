DELETE FROM user;
DELETE FROM refuge;
DELETE FROM kind;
DELETE FROM animal;

INSERT INTO user
(id, user_name, email, password)
VALUES
  (1, 'Adrian', 'AdrianZubieta@gmail.com', 'password-1'),
  (2, 'Ian', 'IanZubieta@gmail.com', 'password-2'),
  (3, 'Melissa','melissaPinaya@gmail.com','password-3'),
  (4, 'Ariel','arialZubieta@gmail.com','password-4')

INSERT INTO refuge
(id, name, web_site, description, phone, address)
VALUES
  (1, 'refugio_1', 'webSite_1', 'description_1', '1516161616', 'address_1'),
  (2, 'refugio_2', 'webSite_2', 'description_2', '1516161616', 'address_2')

INSERT INTO kind
(id, name)
VALUES
  (1, 'Perro'),
  (2, 'Gato')

INSERT INTO animal
(id, name, kind_id, age, description, refuge_id, url_photo)
VALUES
  (1, 'firulais', 1, 2, 'description_1', 1, 'www.imageFirulais.com'),
  (2, 'tom', 2, 2, 'description_2', 1, 'www.imageTom.com')
