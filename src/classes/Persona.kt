package classes
//La Persona puede tener asociada hasta 3 cuentas bancarias, y debe tener un métod que permita
// añadir cuentas (hasta 3 el máximo permitido). Las cuentas se almacenarán en un array/vector. No usar una lista.
//
//Métodos de clase:
//
//Debe contener un métod que devuelva si la persona es morosa (si tienen alguna
// cuenta con saldo negativo). Recibirá como parámetro el objeto Persona y devolverá un booleano.
//Debe contener un métod que realice una transferencia entre dos cuentas.
// Recibirá como parámetro dos objetos PersonaB, dos identificacdors de cuentas y la cantidad a transferir. Devolverá un booleano indicando si se ha podido realizar o no la operación.
//En el programa principal, instanciar un objeto Persona con un DNI cualquiera,
// así como dos objetos cuenta, una sin saldo inicial y otra con 700 euros. La persona recibe la nómina mensual, por lo que ingresa 1100 euros en la primera cuenta, pero tiene que pagar el alquiler de 750 euros con la segunda. Imprimir por pantalla si la persona es morosa.
//
//Posteriormente hacer una transferencia de una cuenta a otra (de forma que todos los saldos sean positivos) y mostrar por pantalla el estado de la persona.

class Persona(val nombre: String, val dni: String) {
    var cuentasBancarias = arrayOfNulls<Cuenta>(3)


    fun realizarTransferencia(personaA: Persona, personaB: Persona, idCuentaA: String, idCuentaB: String, cantidad: Double) : Boolean {
    return true
    }


    fun comprobarMorosidad(): Boolean {
        for (cuenta in this.cuentasBancarias) {
            if (cuenta != null && cuenta.saldo < 0) {
                return true // Si se encuentra una cuenta con saldo negativo, devuelve true
            }
        }
        return false
    }

}