package entities

class Cliente(
    private val nombre: String,
    private val direccion: String,
    private val numeroDeTelefono: Number,
    private val address: String,
    private val bookingList: MutableList<Reservacion> = mutableListOf(),
) {
    fun getCustomerData(): String {
        return "Nombre completo: $nombre \n Numero de telefono:$numeroDeTelefono \n contraseña: $address \n dirreccion:$direccion"
    }

    fun addBooking(booking: Reservacion) {
        bookingList.add(booking)
    }
}