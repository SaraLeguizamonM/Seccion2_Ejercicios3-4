# Seccion 2
Deben realizar el pseudocódigo, el código montado en git, el diagrama de clases y el diagrama de flujo.
1. **Jerarquía de Cuentas Bancarias.**
## Pseudocodigo
```
// Clase abstracta Cuenta
CLASE ABSTRACTA Cuenta
ATRIBUTOS PROTEGIDOS:
saldo: real
titular: texto

CONSTRUCTOR(saldo, cuenta)
this.saldo = saldo
this.titular = cuenta

MÉTODO ABSTRACTO depositar(monto: real)
MÉTODO ABSTRACTO retirar(monto: real)

MÉTODO getSaldo()
RETORNAR saldo
FIN CLASE`

//-------------------------------------------

// CLASE CuentaDeAhorros
CLASE CuentaDeAhorros HEREDA DE Cuenta
ATRIBUTOS PRIVADOS "FINAL":
interesDiario = 0.10 / 365

CONSTRUCTOR(saldo, cuenta)
this.saldo = saldo
this.titular = cuenta

MÉTODO depositar(monto)
SI monto > 0 ENTONCES
saldo = saldo + monto
interés = saldo × interesDiario
saldo = saldo + interés
FIN SI
FIN MÉTODO

MÉTODO aplicarInteresDiario()
interés = saldo × interesDiario
saldo = saldo + interés
FIN MÉTODO

MÉTODO retirar(monto)
SI monto > 0 Y monto <= saldo ENTONCES
saldo = saldo - monto
RETORNAR verdadero
SINO
MOSTRAR "Saldo insuficiente en cuenta de ahorros"
RETORNAR falso
FIN SI
FIN MÉTODO
FIN CLASE

//-------------------------------------------
// CLASE CuentaCorriente
CLASE CuentaCorriente HEREDA DE Cuenta
ATRIBUTO PRIVADO "final":
liimiteDeSobreGiro = -5000

CONSTRUCTOR(saldo, cuenta)
this.saldo = saldo
this.titular = cuenta

MÉTODO depositar(monto)
SI monto > 0 ENTONCES
saldo = saldo + monto
FIN SI
FIN MÉTODO

MÉTODO retirar(monto)
SI monto > 0 Y (saldo - monto) >= liimiteDeSobreGiro ENTONCES
saldo = saldo - monto
RETORNAR verdadero
SINO
MOSTRAR "Límite de sobregiro alcanzado (-5000)"
RETORNAR falso
FIN SI
FIN MÉTODO
FIN CLASE

//-------------------------------------------

// MAIN

PROGRAMA Principal
LEER titular
LEER montoInicial

MIENTRAS no se elija tipo de cuenta HACER
MOSTRAR "1. Cuenta de ahorros"
MOSTRAR "2. Cuenta corriente"
LEER opcion

SEGÚN opcion HACER
CASO "1":
  cuenta = NUEVA CuentaDeAhorros(montoInicial, titular)
  dias = 0
  continuar = falso

  MIENTRAS no continuar HACER
  dias = dias + 1
  MOSTRAR "Día " + dias + " - Saldo: " + saldo 

  MOSTRAR menú:
  1. Depositar (aplica interés diario)
  2. Retirar
  0. Salir

  LEER opcionMenu

  SEGÚN opcionMenu HACER
  CASO 1:
    LEER montoDeposito
    cuenta.depositar(montoDeposito)
    MOSTRAR "Depósito exitoso"

  CASO 2:
    LEER montoRetiro
    SI cuenta.retirar(montoRetiro) ENTONCES
    MOSTRAR "Retiro exitoso"
    SINO
    MOSTRAR "Operación rechazada"
    FIN SI

  CASO 0:
    continuar = verdadero
    MOSTRAR "Saldo final: " + saldo
    FIN SEGÚN
    FIN MIENTRAS
    elegir = verdadero

CASO "2":
  cuenta = NUEVA CuentaCorriente(montoInicial, titular)
  dias = 0
  continuar = falso

  MIENTRAS no continuar HACER
  dias = dias + 1
  MOSTRAR "Día " + dias + " - Saldo: " + saldo 

  MOSTRAR menú:
  1. Depositar (aplica interés diario)
  2. Retirar
  0. Salir

  LEER opcionMenu

  SEGÚN opcionMenu HACER
  CASO 1:
    LEER montoDeposito
    cuenta.depositar(montoDeposito)
    MOSTRAR "Depósito exitoso"

  CASO 2:
    LEER montoRetiro
    SI cuenta.retirar(montoRetiro) ENTONCES
    MOSTRAR "Retiro exitoso"
    SINO
    MOSTRAR "Límite de sobregiro alcanzado."
    FIN SI

  CASO 0:
    continuar = verdadero
    MOSTRAR "Saldo final: " + saldo
    FIN SEGÚN
    FIN MIENTRAS
    elegir = verdadero

OTRO CASO:
  MOSTRAR "Opción inválida"
  FIN SEGÚN
  FIN MIENTRAS

CERRAR
FIN PROGRAMA
```

2. **Sistema de Procesamiento de Pedidos.**

