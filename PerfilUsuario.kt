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
fun main(){
    val userList = mutableListOf(PerfilUsuario(
        0,
        "Alam",
        "Brito",
        "https://Pic.com/Photo_01",
        23,
        "Alam.Brito@gmail.com",
        null,
        UserState.Pendiente,
        mutableListOf(Hobby("Ver TV","Ver The Walking Dead",null))
    ),PerfilUsuario(1,"Ruby",
        "Rose",
        "https://RWBY.com/Red_Like_Roses",
        18,
        "Ruby.R0s3@gmail.com",
        null,
        UserState.Activo,
        mutableListOf(Hobby("Hornear","Hornear galletas","https://Baking.com/Chocolate_Chip_Cookies"))
        ),PerfilUsuario(2,
        "Miorine",
        "Mercury-Rembran",
        null,
        20,
        "Miorine.MercuryR@gmail.com",
        "De vacaciones con mi familia!",
        UserState.Inactivo,
        mutableListOf(Hobby("Jardinería","Cultivo diversas plantas, especialidad en tomates",null),
            Hobby("Jugar videojuegos","Juegos de peleas o shooters",null))
        ))
    val UserListInteract = UserListInteract(userList)
}