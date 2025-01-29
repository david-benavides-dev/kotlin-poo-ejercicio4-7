package classes

/**
 * Representa a una persona con un nombre y un DNI.
 *
 * @property nombre El nombre de la persona.
 * @property dni El DNI de la persona.
 * @property cuentasBancarias Un array de cuentas bancarias asociadas a la persona.
 */
class Persona(val nombre: String, val dni: String) {
    var cuentasBancarias = arrayOfNulls<Cuenta>(3)

    /**
     * Valida si una cuenta pertenece a la persona.
     *
     * @param persona La persona a validar.
     * @param cuentaID El ID de la cuenta a verificar.
     * @return true si la cuenta pertenece a la persona, false en caso contrario.
     */
    private fun validarCuenta(persona: Persona, cuentaID: String): Boolean {
        return persona.cuentasBancarias.any { it?.numeroCuenta == cuentaID }
    }

    /**
     * Realiza una transferencia de dinero entre dos personas.
     *
     * @param personaA La persona que envía el dinero.
     * @param personaB La persona que recibe el dinero.
     * @param idCuentaA El ID de la cuenta de la persona A.
     * @param idCuentaB El ID de la cuenta de la persona B.
     * @param cantidad La cantidad de dinero a transferir.
     * @return true si la transferencia se realizó con éxito, false en caso contrario.
     */
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

    /**
     * Comprueba si la persona tiene cuentas en morosidad.
     *
     * @return true si alguna cuenta tiene saldo negativo, false en caso contrario.
     */
    fun comprobarMorosidad(): Boolean {
        for (cuenta in this.cuentasBancarias) {
            if (cuenta != null && cuenta.saldo < 0) {
                return true // Si se encuentra una cuenta con saldo negativo, devuelve true.
            }
        }
        return false
    }

    /**
     * Devuelve una representación en forma de cadena de la persona.
     *
     * @return Una cadena que contiene el nombre, DNI y estado de morosidad de la persona.
     */
    override fun toString(): String {
        return "Nombre: ${nombre}\n" +
                "DNI: ${dni}\n" +
                "Morosidad: ${if (comprobarMorosidad()) "Si" else "No"}\n"
    }
}