
DROP TABLE IF EXISTS user;


CREATE TABLE user (
    id BIGINT IDENTITY PRIMARY KEY,
    user_name VARCHAR(50),
    last_name VARCHAR(50),
    description VARCHAR(100)
);


INSERT INTO user VALUES (1, 'Adrian','adrianZubieta','asdasdasdasdasdasdbvsd');
INSERT INTO user VALUES (2, 'Ian','ianZubieta','asdasdasdasdsadasdagvsdbvsd');
INSERT INTO user VALUES (3, 'Melissa','melissaPinaya','asdasdasdassadasdagvsdbvsd');
INSERT INTO user VALUES (4, 'Ariel','arialZubieta','asdsdasdasdsadasdagvsdbvsd');