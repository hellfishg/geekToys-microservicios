package io.geektoys.inventario_service.DTO;

public class ItemsReservaDTO {
    private int productoId;
    private int Reserva;

    public ItemsReservaDTO(){}

    public ItemsReservaDTO(int productoId, int reserva) {
        this.productoId = productoId;
        this.Reserva = reserva;
    }

    // Getters and Setters:

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getReserva() {
        return Reserva;
    }

    public void setReserva(int reserva) {
        Reserva = reserva;
    }
}
