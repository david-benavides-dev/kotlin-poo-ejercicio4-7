import classes.Cuenta
import classes.Persona

fun main() {
    // Instancia de dos objetos utilizando la clase Cuenta.
    val cuenta1 = Cuenta("18574881921948371277",-500.00)
    val cuenta2 = Cuenta("11443124319918412711",1500.00)


    // Instancia de un objeto utilizando la clase Persona.
    val persona1 = Persona("David","57121548Z")
    persona1.cuentasBancarias[0] = cuenta1
    persona1.cuentasBancarias[1] = cuenta2


    // ** Consultamos el saldo de las dos cuentas. **
    cuenta1.consultarSaldo()
    cuenta2.consultarSaldo()


    // ** Realizamos un pago de cuenta1 a cuenta2 y verificamos que funciona correctamente.
    cuenta1.realizarPago(500.00, cuenta2)

    cuenta1.consultarSaldo()
    cuenta2.consultarSaldo()


    // Comprobamos si la persona es morosa y mostrmaos un mensaje dependiendo del resultado boolean.
    if (persona1.comprobarMorosidad()) println("${persona1.nombre} es moroso.") else println("${persona1.nombre} no es moroso.")
}