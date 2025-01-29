package classes

/**
 * Representa el número de cuenta y el saldo que tiene una persona.
 * @property numeroCuenta El número de cuenta.
 * @property saldo El saldo disponible en la cuenta.
 */
class Cuenta(val numeroCuenta: String, var saldo: Double) {

    /**
     * Consulta y muestra el saldo disponible en la cuenta.
     */
    fun consultarSaldo(){
        println("Saldo disponible: $saldo€.")
    }

    /**
     * Recibe un abono en la cuenta.
     *
     * @param dinero La cantidad de dinero a abonar.
     * @return true si el abono fue exitoso, false si la cantidad es negativa.
     */
    fun recibirAbono(dinero: Double): Boolean {
        if (dinero < 0) {
            return false
        } else {
            saldo += dinero
            return true
        }
    }

    /**
     * Realiza un pago desde la cuenta.
     *
     * @param dinero La cantidad de dinero a pagar.
     * @return true si el pago fue exitoso, false si la cantidad es negativa.
     */
    fun realizarPago(dinero: Double): Boolean {
        if (dinero < 0) {
            println("Error >> No tienes esa cantidad de dinero disponible en tu cuenta.")
            return false
        } else {
            saldo -= dinero
            return true
        }
    }
}