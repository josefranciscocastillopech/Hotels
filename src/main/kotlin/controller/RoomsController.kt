package controller

import entities.Habitacion
import utils.Print
import utils.DataReader
class RoomsController {
    private val roomsList: MutableList<Habitacion> = mutableListOf()
    private val dataReader = DataReader()
    private val printer = Print()

    fun registerRoom() {

        printer.apply {
            printMsg("ingresa el numero de habitacion")
            val numHabitaciones = dataReader.readInt()
            printMsg("tio de habitacion")
            val tipo = dataReader.readString()
            printMsg("numero de personas")
            val capacidad = dataReader.readInt()
            printMsg("numero de personas")
            val precio = dataReader.readInt()
            val addedRoom = Habitacion(numHabitaciones, tipo, capacidad, precio)
            roomsList.add(addedRoom)
        }
    }
    fun getRoomByIndex(index: Int): Habitacion {
        return roomsList[index]
    }
        fun showRooms() {
            println("cuartos de habitacion disponible:")
            var counter = 1
            for (rooms in roomsList) {
                println("$counter " + rooms.getRoomType())
                counter++
            }
        }
        fun delateRoom(index: Int) {
            roomsList.removeAt(index)
        }
        fun areNotRoomsRegistered(): Boolean = roomsList.isEmpty()
}