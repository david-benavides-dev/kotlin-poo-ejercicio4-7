package classes

/**
 * Representa el número de cuenta y el saldo que tiene una persona.
 * @property numeroCuenta El número de cuenta.
 * @property saldo El saldo disponible en la cuenta.
 */
class Cuenta(val numeroCuenta: Int, var saldo: Double) {
    /**
     *
     */
    fun consultarSaldo(){
        println("Saldo disponible: $saldo€.")
    }


    /**
     *
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
     *
     */
    fun realizarPago(dinero: Double): Boolean {
        // Condicional para validar que el saldo no es negativo después de realizar un pago.
        if (saldo - dinero < 0 || dinero < 0) {
            println("ERROR FATAL")
            return false
        } else {
            saldo -= dinero
            return true
        }
    }
}