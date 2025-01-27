import classes.Cuenta
import classes.Persona

fun main() {
    // Instancia de dos objetos utilizando la clase Cuenta.
    val cuenta1 = Cuenta("18574881921948371277",0.00)
    val cuenta2 = Cuenta("11443124319918412711",700.00)


    // Instancia de un objeto utilizando la clase Persona.
    val persona1 = Persona("Roguer","57121548Z")
    persona1.cuentasBancarias[0] = cuenta1
    persona1.cuentasBancarias[1] = cuenta2


    // ** Consultamos el saldo de las dos cuentas. **
    cuenta1.consultarSaldo()
    cuenta2.consultarSaldo()


    // ** Recibimos un cobro de 1100 en cuenta1.
    cuenta1.recibirAbono(1100.00)


    // ** Realizamos un pago de 750 con la segunda cuenta.
    cuenta2.realizarPago(750.00)


    // ** Consultamos el saldo de las dos cuentas. **
    cuenta1.consultarSaldo()
    cuenta2.consultarSaldo()


    // Comprobamos si la persona es morosa, mostrando un mensaje dependiendo del resultado boolean.
    if (persona1.comprobarMorosidad()) println("${persona1.nombre} es moroso.") else println("${persona1.nombre} no es moroso.")


    // Transferencia de una cuenta a otra (de forma que todos los saldos sean positivos) y mostrar por pantalla el estado de la persona.
    println("\n********************\n")
    persona1.realizarTransferencia(persona1,persona1,"18574881921948371277","11443124319918412711",150.00)
    println("\n********************\n")
    cuenta1.consultarSaldo()
    cuenta2.consultarSaldo()
    println(persona1)
}