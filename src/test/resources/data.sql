DELETE FROM user;

INSERT INTO user
(id, user_name, email, password, state, address, phone, web_site, description)
VALUES
  (1, 'Adrian', 'AdrianZubieta@gmail.com', 'password-1','Buenos Aires', 'Rivadavia 1575', '1556566565', 'webSite-1', 'description-1'),
  (2, 'Ian', 'IanZubieta@gmail.com', 'password-2','Buenos Aires', 'Rivadavia 1575', '1556566565', 'webSite-2', 'description-2'),
  (3, 'Melissa','melissaPinaya@gmail.com','password-3','Buenos Aires', 'Rivadavia 1575', '1556566565', 'webSite-3', 'description-3'),
  (4, 'Ariel','arialZubieta@gmail.com','password-4','Buenos Aires', 'Rivadavia 1575', '1556566565', 'webSite-4', 'description-4')