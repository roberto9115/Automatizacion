Feature: Actualizacion notas de credito

  Scenario Outline: HSBC MX
    Given Cargar Pagina HSBC MX "<navegadorHSBC>"
    #When Ingreso a Opcion Cuentas y Planes
    When Ingreso a Menu Cambia Nomina
    And Doy Click en Dejanos tus Datos
    And Valido Alerta Llevar a Sitio Externo "<opcionAlerta>"
    Examples:
      |navegadorHSBC|opcionAlerta|
      |FirefoxL |aceptar|
      |FirefoxL |cancelar|


