CREATE TABLE usuas(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    usualogin TEXT NOT NULL UNIQUE,
    usuasenha TEXT not null,
    perfil TEXT not null
);