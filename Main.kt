import java.util.Scanner
fun main(args:Array<String>) {
    val usersList = mutableListOf(
        PerfilUsuario(
            0,
            "Alam",
            "Brito",
            "https://Pic.com/Photo_01",
            23,
            "Alam.Brito@gmail.com",
            null,
            UserState.Pendiente,
            mutableListOf(Hobby("Ver TV", "Ver The Walking Dead", null))
        ), PerfilUsuario(
            1, "Ruby",
            "Rose",
            "https://RWBY.com/Red_Like_Roses",
            18,
            "Ruby.R0s3@gmail.com",
            null,
            UserState.Activo,
            mutableListOf(Hobby("Hornear", "Hornear galletas", "https://Baking.com/Chocolate_Chip_Cookies"))
        ), PerfilUsuario(
            2,
            "Miorine",
            "Mercury-Rembran",
            null,
            20,
            "Miorine.MercuryR@gmail.com",
            "De vacaciones con mi familia!",
            UserState.Inactivo,
            mutableListOf(
                Hobby("Jardinería", "Cultivo diversas plantas, especialidad en tomates", null),
                Hobby("Jugar videojuegos", "Juegos de peleas o shooters", null)
            )
        )
    )

    val profileManager = UserListInteract(usersList)

    while (true){
        println("{ { { {BIENVENIDO} } } }")
        println("1- Crear perfil")
        println("2- Buscar perfil")
        println("3- Eliminar perfil")
        println("4- Agregar Hobby")
        println("5- Salir")
        println("Ingrese una opción (1-5): ")
        when (readLine()?.toIntOrNull()){
            1 -> profileManager.createUser()
            2 -> profileManager.searchUser()
            3 -> profileManager.deleteUser()
            4 -> profileManager.addHobby()
            5 -> return
            else -> println("Opción no válida, por favor ingrese un número del 1 al 5")
        }
    }
}