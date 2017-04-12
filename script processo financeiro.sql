create table pessoa(
	cnpj varchar(14) primary key unique,
	nome varchar(80) not null,
	dtnascimento date,
	cep varchar(8),
	logradouro varchar(20),
	numero int,
	bairro varchar(30),
	cidade varchar(50),
	uf varchar(2)
);

create table titulo(
	numero serial primary key,
	dtcriacao date not null,
	dtvencimento date not null,
	vltitulo float not null,
	txjuro float not null,
	vljuro float,
	vldesconto float,
	dtpagamento date,
	vlpago float,
	tipo varchar(1) not null,
	cnpj varchar(14) not null foreign key,
	
);