package controller

import utils.Print

class MenuController {
    private val printer = Print()
    private val bookingsController = BookingController()
    private val customersController = clientController()
    private val roomsController = RoomsController()

    fun showMenu() {
        printer.apply {
            printMsg("Ingrese una opción")
            printMsg("1 - Registrar habitación")
            printMsg("2 - Registrar Cliente")
            printMsg("3 - Crear reserva ")
            printMsg("4 - Mostrar habitaciones")
            printMsg("5 - Mostrar Clientes")
            printMsg("6 - Mostrar reservas")

            val selectedOption = readln().toInt()
            validateOptions(selectedOption)
        }
    }

    private fun validateOptions(selectedOption: Int) {
        when (selectedOption) {
            1 -> {
                roomsController.registerRoom()
                showMenu()
            }

            2 -> {
                customersController.registerCustomer()
                showMenu()
            }

            3 -> {
                selectCustomerAndClient()
                showMenu()
            }

            4 -> {
                roomsController.showRooms()
                showMenu()
            }

            5 -> {
                customersController.showCustomers()
                showMenu()
            }

            6 -> {
                bookingsController.showBookings()
                showMenu()
            }
        }
    }

    private fun selectCustomerAndClient() {

        if (customersController.areNotClientsRegistered()) {
            printer.printMsg("No se encuentran clientes registrados")
            showMenu()
            return
        }

        if (roomsController.areNotRoomsRegistered()) {
            printer.printMsg("No se encuentran habitaciones registradas")
            showMenu()
            return
        }

        printer.printMsg("Seleccione un cliente")
        customersController.showCustomers()

        val selectedCustomerIndex = readln().toInt()
        val customer = customersController.getCustomerByIndex(selectedCustomerIndex - 1)

        printer.printMsg("Seleccione una habitacion")
        roomsController.showRooms()
        val selectedRoomIndex = readln().toInt()
        val room = roomsController.getRoomByIndex(selectedRoomIndex - 1)
        bookingsController.createBooking(customer, room)
    }
}