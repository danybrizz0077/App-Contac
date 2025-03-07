-- Tabla UsuarioVendedor
CREATE TABLE UsuarioVendedor (
    ID_UsuarioVendedor INT PRIMARY KEY,
    Nombre_Ven VARCHAR2(200),
    Correo_Ven VARCHAR2(100) UNIQUE,
    Contrasena VARCHAR2(100)
);

-- Tabla UsuarioProduccion
CREATE TABLE UsuarioProduccion (
    ID_UsuarioProduccion INT PRIMARY KEY,
    Nombre_pro VARCHAR2(200),
    Correo_pro VARCHAR2(100) UNIQUE,
    Contrasena VARCHAR2(100)
);



-- Tabla Cliente
CREATE TABLE Cliente (
    ID_Cliente INT PRIMARY KEY,
    Nombre_Clie VARCHAR2(200)
);

-- Tabla EstadoTrabajo
CREATE TABLE EstadoTrabajo (
    ID_Estado INT PRIMARY KEY,
    Estado VARCHAR2(30)
);

-- Tabla Trabajos (con claves foráneas)
CREATE TABLE Trabajos (
    ID_Trabajos INT PRIMARY KEY,
    FechaInicio DATE,
    Maquina VARCHAR2(6),
    Cantidad INT NOT NULL,
    Producto VARCHAR2(200),
    ID_Cliente INT NOT NULL,
    ID_UsuarioVendedor INT NOT NULL,
    ID_Estado INT NOT NULL,
    FechaFinalizado DATE,

    -- Relaciones (FOREIGN KEYS)
    CONSTRAINT fk_ID_Cliente FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente),
    CONSTRAINT fk_ID_UsuarioVendedor FOREIGN KEY (ID_UsuarioVendedor) REFERENCES UsuarioVendedor(ID_UsuarioVendedor),
    CONSTRAINT fk_ID_Estado FOREIGN KEY (ID_Estado) REFERENCES EstadoTrabajo(ID_Estado)
);



-- Secuencia para UsuarioVendedor
CREATE SEQUENCE seq_usuario_vendedor START WITH 1 INCREMENT BY 1;

-- Secuencia para UsuarioProduccion
CREATE SEQUENCE seq_usuario_produccion START WITH 1 INCREMENT BY 1;

-- Secuencia para Cliente
CREATE SEQUENCE seq_cliente START WITH 1 INCREMENT BY 1;

-- Secuencia para EstadoTrabajo
CREATE SEQUENCE seq_estado_trabajo START WITH 1 INCREMENT BY 1





--------------------------------------------------------
--------------------------------------------------------
--------------------------------------------------------

select * from UsuarioProduccion;

TRUNCATE TABLE UsuarioProduccion;
