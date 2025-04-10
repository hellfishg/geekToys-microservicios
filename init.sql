CREATE TABLE IF NOT EXISTS pedidos (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL,
    items TEXT NOT NULL,
    total NUMERIC(15, 2) NOT NULL,
    direccion_envio VARCHAR(255) NOT NULL,
    metodo_pago VARCHAR(100) NOT NULL,
    canal_ventas VARCHAR(50) NOT NULL,
    estado_pedido VARCHAR(50) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    fecha_actualizacion TIMESTAMP NOT NULL
);
