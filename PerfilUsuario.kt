data class PerfilUsuario(
    val iD:Int,
    val name:String,
    val lastName:String,
    val urlPhoto:String?,
    val age:Int,
    val eMail:String,
    val bio:String?,
    val state:UserState,
    val hobbies:MutableList<Hobby> = mutableListOf()
)
enum class UserState{
    Activo, Pendiente, Inactivo
}
data class Hobby (
    val hobby:String,
    val description:String,
    val urlPhoto:String?
)