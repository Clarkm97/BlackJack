DROP DATABASE if EXISTS blackjack;
CREATE DATABASE IF NOT EXISTS blackjack;

create table cards
(
	cardId int auto_increment
		primary key,
	description varchar(60) null,
	value int null
);

create table player
(
	playerId int auto_increment
		primary key,
	playerName varchar(256) null
);

create table cards_owned_by_players
(
	playerId int null,
	cardId int null,
	constraint cards_owned_by_players_cards_cardId_fk
		foreign key (cardId) references cards (cardId),
	constraint cards_owned_by_players_player_playerId_fk
		foreign key (playerId) references player (playerId)
);

create table game
(
	gameId int auto_increment
		primary key,
	dealerId int null,
	playerId int null,
	isFinished tinyint(1) not null default 0,
	constraint game_player_playerId_fk
		foreign key (playerId) references player (playerId),
	constraint game_player_playerId_fk_2
		foreign key (dealerId) references player (playerId)
);

