package entities

class Habitacion(
    private val numHabitaciones: Int,
    private val tipo: String,
    private val capacidad: Int,
    val precio: Int,
    val isAvailable: Boolean = true
) {
    fun getRoomType() : String{
        return "numero de habitacion: $numHabitaciones \n tipo de habitacion:$tipo \n capacidad:$capacidad \n precio por noche:$precio \n Disponible: ${if (isAvailable) "Si" else "No"} "
    }
}

