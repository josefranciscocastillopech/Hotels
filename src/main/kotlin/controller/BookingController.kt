package controller

import entities.Cliente
import entities.Habitacion
import entities.Reservacion
import utils.Print

class BookingController {
    private val printer = Print()
    private val bookingsList = mutableListOf<Reservacion>()

    fun createBooking(customer: Cliente, room: Habitacion) {
        printer.printMsg("Ingrese la fecha de inicio")
        val startDate = readln().toInt()
        printer.printMsg("Ingrese la fecha de salida")
        val endDate = readln().toInt()
        printer.printMsg("Ingrese el numero de noches")
        val totalNights = readln().toInt()

        val addedBooking = Reservacion(startDate,customer,endDate,room,totalNights,false)
        addedBooking.calculatePrice()
        customer.addBooking(addedBooking)
        bookingsList.add(addedBooking)
    }

    fun showBookings() {
        if (bookingsList.isEmpty()) {
            printer.printMsg("No hay habitaciones registradas")
        } else {
            var counter = 1
            for (booking in bookingsList) {
                printer.printMsg("$counter " + booking.getBookingData())
                counter++
            }
        }
    }
}