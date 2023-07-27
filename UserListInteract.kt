import kotlin.IllegalArgumentException

class UserListInteract (val userList:MutableList<PerfilUsuario>){
    fun createUser(){
        println("+ + + +CREAR USUARIO NUEVO+ + + +")
        try{
            println("Ingrese un ID: ")
            val newID = readLine()?.toIntOrNull()?:
            throw IllegalArgumentException("ID debe ser un número, intente otra vez.")

            println("Ingrese su nombre: ")
            val newName = readLine()?:
            throw IllegalArgumentException("Ingrese un nombre por favor.")

            println("Ingrese su apellido: ")
            val newLastName = readLine()?:
            throw IllegalArgumentException("Ingrese un apellido por favor.")

            println("Ingrese una URL para su foto de perfil (opcional): ")
            val newURLPhoto = readLine()

            println("Ingrese su Edad: ")
            val newAge = readLine()?.toIntOrNull()?:
            throw IllegalArgumentException("La edad debe ser un número, intente otra vez.")

            println("Ingrese su correo: ")
            val newEmail= readLine()?:
            throw IllegalArgumentException("Ingrese un correo por favor.")

            println("Biografía (opcional): ")
            val newBio = readLine()

            print("Ingrese el estado del usuario (Activo, Pendiente o Inactivo): ")
            val newState = readLine()?.let{UserState.valueOf(it)}?:
            throw IllegalArgumentException("Estado inválido. Debe ser Activo, Pendiente o Inactivo.")

            val newUser = PerfilUsuario(
                newID,
                newName,
                newLastName,
                newURLPhoto,
                newAge,
                newEmail,
                newBio,
                newState
            )
            userList.add(newUser)
            println("Nuevo perfil creado")
        }
        catch (e: IllegalArgumentException){
            println("ERROR al crear perfil, por favor intente de nuevo.")
        }
    }
    fun searchUser(){
        println("+ + + +BUSCAR USUARIO+ + + +")
        println("Ingrese el nombre de usuario que desea buscar: ")
        val searchName = readLine()?: return
        try{
            val searchFind = userList.filter {
                user -> user.name.equals(searchName)
            }
            if (searchFind.isEmpty()){
                println("No se encontró el usuario que buscas, vuelve a intentarlo")
            }
            else{
                println("| | | |USUARIO ENCONTRADO| | | |")
                for (user in searchFind) {
                    println("ID: ${user.iD}")
                    println("Nombre: ${user.name}")
                    println("Apellido: ${user.lastName}")
                    println("Foto (URL): ${user.urlPhoto}")
                    println("Edad: ${user.age}")
                    println("E-mail: ${user.eMail}")
                    println("Biografía: ${user.bio?:"*Vaya! Este usuario no tiene una biografía*"}")
                    println("||Hobbies||")
                    for (hobby in user.hobbies){
                        println("   Hobby: ${hobby.hobby}")
                        println("   Descripción: ${hobby.description}")
                        println("   Foto: ${hobby.urlPhoto?: "*Foto no disponible*"}")
                    }
                    println("")
                }
            }
        }
        catch(e: Exception){
            println("ERROR al buscar usuario, por favor vuelva a intentar")
        }
    }
    fun deleteUser(){
        println("- - - -ELIMINAR USUARIO- - - -")
        println("Ingrese el nombre de usuario que desea eliminar: ")
        val searchDelete = readLine()?: return
        try{
            val searchFindDelete = userList.find {
                it.name.equals(searchDelete,ignoreCase = true)
            }
            if (searchDelete.isEmpty()){
                println("Este usuario ya fue eliminado, vuelve a intentarlo")
            }
            else{
                userList.remove(searchFindDelete)
                println("Este usuario ya no existe")
            }
        } catch(e: Exception){
            println("ERROR al eliminar usuario, por favor vuelva a intentar")
        }
    }
    fun addHobby(){
        println("Ingrese el nombre de usuario al que desea añadir un hobby:")
        val searchName = readLine()?: return
        try{
            val searchFindHobby = userList.find {
                    user -> user.iD.toString() == searchName||
                    user.name.equals(searchName, ignoreCase = true) ||
                    user.lastName.equals(searchName, ignoreCase = true)
            }
            if (searchFindHobby == null){
                println("No se encontró el usuario, vuelve a intentarlo")
            }
            println("~ ~ ~ ~AÑADIR HOBBY~ ~ ~ ~")
            println("Hobby:")
            val newHobby = readLine()?: return

            println("Ingrese la descripción del hobby:")
            val newDescription = readLine()?: return

            println("Ingrese el URL para una foto de su hobby (opcional):")
            val newPhotoHobby = readLine()

            val newUserHobby = Hobby(
                newHobby,
                newDescription,
                newPhotoHobby
            )
            if (searchFindHobby != null) {
                searchFindHobby.hobbies.add(newUserHobby)
            }
            println("Hobby agregado!")
        }
        catch(e: Exception){
            println("ERROR al buscar usuario, por favor vuelva a intentar")
        }
    }
}