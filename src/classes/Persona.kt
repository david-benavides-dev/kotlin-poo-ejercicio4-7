package classes

/**
 *
 */
class Persona(val nombre: String, val dni: String) {
    var cuentasBancarias = arrayOfNulls<Cuenta>(3)


    // Validar si una cuenta pertenece a una persona
    private fun validarCuenta(persona: Persona, cuentaID: String): Boolean {
        return persona.cuentasBancarias.any { it?.numeroCuenta == cuentaID }
    }


    fun realizarTransferencia(personaA: Persona, personaB: Persona, idCuentaA: String, idCuentaB: String, cantidad: Double): Boolean {
        if (validarCuenta(personaA, idCuentaA) && validarCuenta(personaB, idCuentaB)) {

            val cuentaA = personaA.cuentasBancarias.find { it?.numeroCuenta == idCuentaA }
            val cuentaB = personaB.cuentasBancarias.find { it?.numeroCuenta == idCuentaB }

            if (cuentaA != null && cuentaB != null) {
                if (cuentaA.saldo >= cantidad) {
                    cuentaA.saldo -= cantidad
                    cuentaB.saldo += cantidad
                    println("Transferencia realizada con éxito.")
                    return true
                } else {
                    println("Saldo insuficiente en la cuenta origen.")
                    return false
                }
            }
        }
        return false
    }


    fun comprobarMorosidad(): Boolean {
        for (cuenta in this.cuentasBancarias) {
            if (cuenta != null && cuenta.saldo < 0) {
                return true // Si se encuentra una cuenta con saldo negativo, devuelve true.
            }
        }
        return false
    }


    override fun toString(): String {
        return "Nombre: ${nombre}\n" +
                "DNI: ${dni}\n" +
                "Morosidad: ${if (comprobarMorosidad()) "Si" else "No"}\n"
    }
}