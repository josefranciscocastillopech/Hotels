package entities

import entities.Habitacion
import entities.Cliente

class Reservacion(
    private val fechaInicio: Int,
    val cliente: Cliente,
    private val finReserva: Int,
    private val habitacion: Habitacion,
    private var nochesTotales: Int,
    private var isCancelado: Boolean
) {
    private var totalPrice = 0.0

    fun calculatePrice() {
        totalPrice = (habitacion.precio * nochesTotales).toDouble()
    }

    fun cancelBooking() {
        isCancelado = true
    }

    fun updateNights(totalNights: Int) {
        this.nochesTotales = totalNights
    }

    fun getTotal(): Double = totalPrice

    fun getBookingData(): String {
        return "Nombre cliente ${cliente.getCustomerData()}" + "Total de noches: $nochesTotales" +
                "Fecha inicio :  $fechaInicio" +
                "Fecha final :  $finReserva" +
                "Total : $totalPrice"
    }
}