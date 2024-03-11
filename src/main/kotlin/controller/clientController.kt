package controller

import entities.Cliente
import utils.Print

class clientController {
    private val printer = Print()
    private val clientList = mutableListOf<Cliente>(
        Cliente(
            "josmar mendez juarez",
            "Sm 510 Mz 58 Lt1",
            9454545692,
            "jos12345"
        )
    )

    fun registerCustomer() {
        printer.printMsg("Ingrese su nombre completo")
        val names = readln()
        printer.printMsg("Ingrese el RFC")
        val dirrecciones = readln()
        printer.printMsg("Ingrese el RFC")
        val numeroTelefono = readln().toInt()
        printer.printMsg("Ingrese la dirección")
        val address = readln()

        val addedCustomer = Cliente(names,dirrecciones, numeroTelefono,address)

        clientList.add(addedCustomer)
    }

    fun showCustomers() {
        if (clientList.isEmpty()) {
            printer.printMsg("No se encuentran clientes registrados")
        } else {
            var counter = 1
            for (customer in clientList) {
                printer.printMsg("$counter-" + customer.getCustomerData())
                counter++
            }
        }
    }

    fun getCustomerByIndex(index: Int): Cliente = clientList[index]

    fun areNotClientsRegistered(): Boolean = clientList.isEmpty()
}