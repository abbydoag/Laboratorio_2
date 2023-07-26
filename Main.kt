import java.util.Scanner
fun main(args:Array<String>) {
    val usersList = mutableListOf<PerfilUsuario>()
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