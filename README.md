# Seccion 2
Deben realizar el pseudocódigo, el código montado en git, el diagrama de clases y el diagrama de flujo.
1. **Jerarquía de Cuentas Bancarias.**
2. **Sistema de Procesamiento de Pedidos.**

## Pseudocodigo
<details>
  <summary><strong>Ejercicio 3</strong></summary>
  
```
// Clase abstracta Cuenta

ATRIBUTOS PROTEGIDOS:
saldo: real
titular: texto

CONSTRUCTOR(saldo, cuenta)
this.saldo = saldo
this.titular = cuenta

MÉTODO ABSTRACTO depositar(monto: real)
MÉTODO ABSTRACTO retirar(monto: real)

MÉTODO CONCRETO getSaldo()
RETORNAR saldo
FIN CLASE

//-------------------------------------------

// Clase CuentaDeAhorros hereda de Cuenta

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

// Clase CuentaCorriente hereda de Cuenta

ATRIBUTO PRIVADO "final":
liimiteDeSobreGiro = -50000

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
MOSTRAR "Límite de sobregiro alcanzado (-50000)"
RETORNAR falso
FIN SI
FIN MÉTODO
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

SEGÚN opcion HACER
CASO "1":
  cuenta = NUEVA CuentaDeAhorros(monto, titular)
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
  cuenta = NUEVA CuentaCorriente(monto, titular)
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

</details>
<details>
  <summary><strong>Ejercicio 4</strong></summary>
  
```
// Clase abstracta ProcesadorDePedido

MÉTODO ABSTRACTO procesar()

MÉTODO CONCRETO validarPedido()
FIN CLASE

//-------------------------------------------

// Clase ProcesadorDePedidoFisico hereda de ProcesadorDePedido
CLASE CuentaDeAhorros HEREDA DE Cuenta
MÉTODO procesar() SOBREESCRITO
items = lista vacía de texto
continuarAgregando = verdadero

MIENTRAS continuarAgregando HACER
MOSTRAR catálogo físico:
1125. PlayStation
3025. Xbox
3011. Nintendo Switch
2025. Nintendo Wii
LEER codigo

SEGÚN codigo HACER
CASO "1125": items.agregar("PlayStation")
CASO "3025": items.agregar("Xbox")
CASO "3011": items.agregar("Nintendo Switch")
CASO "2025": items.agregar("Reserva - Wii") 
OTRO: MOSTRAR "Código inválido"
FIN SEGÚN

LEER "¿Quieres agregar otro item? (si/no)"
SI respuesta = "no" ENTONCES
continuarAgregando = falso
FIN MIENTRAS

MOSTRAR ciudades disponibles
LEER opcionCiudad
SEGÚN opcionCiudad
CASO "1": ciudad = "Medellín", costoEnvio = 12000
CASO "2": ciudad = "Bogotá", costoEnvio = 15000
FIN SEGÚN

LEER dirección completa

MOSTRAR resumen del pedido:
Items: items
Ciudad: ciudad
Dirección: dirección
Costo de envío: costoEnvio
FIN MÉTODO
FIN CLASE

//-------------------------------------------

// Clase ProcesadorDePedidoDigital hereda de ProcesadorDePedidoCLASE CuentaCorriente
MÉTODO procesar() SOBREESCRITO
itemsDigitales = lista vacía de texto
continuarAgregando = verdadero

MIENTRAS continuarAgregando HACER
MOSTRAR catálogo digital:
11. Steam-Biblioteca +1000
25. EpicGames-Biblioteca +2000
30. Tlanucher +50 Mods
20. Piratas-Biblioteca +50 CajaBOX

LEER codigo
SEGÚN codigo HACER
CASO "11": itemsDigitales.agregar("Steam-Biblioteca")
CASO "25": itemsDigitales.agregar("EpicGames-Biblioteca")
CASO "30": itemsDigitales.agregar("Tlanucher")
CASO "20": itemsDigitales.agregar("Virus...")
OTRO: MOSTRAR "Código inválido"
FIN SEGÚN

LEER "¿Quieres agregar otro item? (si/no)"
SI respuesta = "no" ENTONCES
continuarAgregando = falso
FIN MIENTRAS

LEER correo electrónico

MOSTRAR correo simulado:
Para: correo
Asunto: Has comprado los siguientes items!
PARA cada item en itemsDigitales HACER
MOSTRAR item + " - Clave: " + númeroAleatorio(100000,999999)
FIN PARA
MOSTRAR "¡Gracias por tu compra!"
FIN MÉTODO
FIN CLASE

//-------------------------------------------

// MAIN
MOSTRAR bienvenida al sistema de pedidos
MOSTRAR opciones:
1. Pedido físico
2. Pedido digital

opcionValida = falso
MIENTRAS no opcionValida HACER
LEER opcion
SEGÚN opcion HACER
CASO "1":
procesador = NUEVO ProcesadorPedidoFisico
procesador.validarPedido()
procesador.procesar()    
opcionValida = verdadero
CASO "2":
procesador = NUEVO ProcesadorPedidoDigital
procesador.validarPedido()
procesador.procesar()
opcionValida = verdadero
OTRO:
MOSTRAR "Opción inválida, intente de nuevo"
FIN SEGÚN
FIN MIENTRAS

FIN PROGRAMA
```
</details>
