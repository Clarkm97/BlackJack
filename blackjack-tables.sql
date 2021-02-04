DROP DATABASE if EXISTS blackjack;
CREATE DATABASE IF NOT EXISTS blackjack;

use blackjack;

create table card(
	cardID int auto_increment primary key,
	cardName varchar(5),
    primaryPoints int,
    altPoints int
	
);

create table game(
	gameID int auto_increment,
    win boolean,
    primary key(gameID)
);

create table playerHand(
	playerHandid int ,
    cardID int,
    gameID int,
    FOREIGN KEY (gameID) REFERENCES game(gameID),
    FOREIGN KEY (cardID) REFERENCES card(cardID)
    
);
create table dealerHand(
	dealerHandid int ,
     cardID int,
    gameID int,
    FOREIGN KEY (gameID) REFERENCES game(gameID),
    FOREIGN KEY (cardID) REFERENCES card(cardID)
);