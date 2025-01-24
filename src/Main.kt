import classes.Cuenta

fun main() {
    // Instancia de dos objetos utilizando la clase Cuenta.
    val cuenta1 = Cuenta(83712341,1000.00)
    val cuenta2 = Cuenta(18644243,1500.00)


    cuenta1.consultarSaldo()
    cuenta2.consultarSaldo()
}