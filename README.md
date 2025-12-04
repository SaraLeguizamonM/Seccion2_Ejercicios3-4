# Seccion 2
Deben realizar el pseudocodigo, el codigo montado en git, el diagrama de clases y el diagrama de flujo.
1. **Jerarquia de Cuentas Bancarias.**
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

METODO ABSTRACTO depositar(monto: real)
METODO ABSTRACTO retirar(monto: real)

METODO getSaldo()
RETORNAR saldo
FIN CLASE

//-------------------------------------------

// CLASE CuentaDeAhorros
CLASE CuentaDeAhorros HEREDA DE Cuenta
ATRIBUTOS PRIVADOS "FINAL":
interesDiario = 0.10 / 365

CONSTRUCTOR(saldo, cuenta)
this.saldo = saldo
this.titular = cuenta

METODO depositar(monto)
SI monto > 0 ENTONCES
saldo = saldo + monto
interes = saldo × interesDiario
saldo = saldo + interes
FIN SI
FIN METODO

METODO aplicarInteresDiario()
interes = saldo × interesDiario
saldo = saldo + interEs
FIN METODO

METODO retirar(monto)
SI monto > 0 Y monto <= saldo ENTONCES
saldo = saldo - monto
RETORNAR verdadero
SINO
MOSTRAR "Saldo insuficiente en cuenta de ahorros"
RETORNAR falso
FIN SI
FIN METODO
FIN CLASE

//-------------------------------------------
// CLASE CuentaCorriente
CLASE CuentaCorriente HEREDA DE Cuenta
ATRIBUTO PRIVADO "final":
liimiteDeSobreGiro = -50000

CONSTRUCTOR(saldo, cuenta)
this.saldo = saldo
this.titular = cuenta

METODO depositar(monto)
SI monto > 0 ENTONCES
saldo = saldo + monto
FIN SI
FIN METODO

METODO retirar(monto)
SI monto > 0 Y (saldo - monto) >= liimiteDeSobreGiro ENTONCES
saldo = saldo - monto
RETORNAR verdadero
SINO
MOSTRAR "Limite de sobregiro alcanzado (-50000)"
RETORNAR falso
FIN SI
FIN METODO
FIN CLASE

//-------------------------------------------

// MAIN

PROGRAMA Principal
LEER titular
LEER monto

MIENTRAS no se elija tipo de cuenta HACER
MOSTRAR "1. Cuenta de ahorros"
MOSTRAR "2. Cuenta corriente"
LEER opcion

SEGuN opcion HACER
CASO "1":
  cuenta = NUEVA CuentaDeAhorros(monto, titular)
  dias = 0
  continuar = falso

  MIENTRAS no continuar HACER
  dias = dias + 1
  MOSTRAR "Dia " + dias + " - Saldo: " + saldo 

  MOSTRAR menu:
  1. Depositar (aplica interes diario)
  2. Retirar
  0. Salir

  LEER opcionMenu

  SEGUN opcionMenu HACER
  CASO 1:
    LEER montoDeposito
    cuenta.depositar(montoDeposito)
    MOSTRAR "Deposito exitoso"

  CASO 2:
    LEER montoRetiro
    SI cuenta.retirar(montoRetiro) ENTONCES
    MOSTRAR "Retiro exitoso"
    SINO
    MOSTRAR "Operacion rechazada"
    FIN SI

  CASO 0:
    continuar = verdadero
    MOSTRAR "Saldo final: " + saldo
    FIN SEGUN
    FIN MIENTRAS
    elegir = verdadero

CASO "2":
  cuenta = NUEVA CuentaCorriente(monto, titular)
  dias = 0
  continuar = falso

  MIENTRAS no continuar HACER
  dias = dias + 1
  MOSTRAR "Dia " + dias + " - Saldo: " + saldo 

  MOSTRAR menu:
  1. Depositar (aplica interes diario)
  2. Retirar
  0. Salir

  LEER opcionMenu

  SEGUN opcionMenu HACER
  CASO 1:
    LEER montoDeposito
    cuenta.depositar(montoDeposito)
    MOSTRAR "Deposito exitoso"

  CASO 2:
    LEER montoRetiro
    SI cuenta.retirar(montoRetiro) ENTONCES
    MOSTRAR "Retiro exitoso"
    SINO
    MOSTRAR "Limite de sobregiro alcanzado."
    FIN SI

  CASO 0:
    continuar = verdadero
    MOSTRAR "Saldo final: " + saldo
    FIN SEGUN
    FIN MIENTRAS
    elegir = verdadero

OTRO CASO:
  MOSTRAR "Opcion invalida"
  FIN SEGUN
  FIN MIENTRAS

CERRAR
FIN PROGRAMA
```

2. **Sistema de Procesamiento de Pedidos.**

