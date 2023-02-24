Feature: Actualizacion notas de credito

#  Scenario Outline: Portal HSBC MX
#    Given Cargar Pagina HSBC MX "<navegador>"
#    When Ingresar a Menu Credito Nomina
#    And Dar Click en Transfiere tus Deudas
#    And Dar Click en Olvide mi Usuario "<user>"
#    And Selecciono Opcion Recuperar Usuario "<opcionIdentificar>"
#    And Lleno Campos Tarjeta de Debito "<cuenta>" "<tarjeta>" "<nip>"
#
#
#    Examples:
#      |navegador |user|opcionIdentificar|cuenta|tarjeta|nip|
#      |FirefoxL  |asdd|DC               |aadasd|asdasd |asdsd|

#  Scenario Outline: Portal HSBC MX
#    Given Cargar Pagina HSBC MX "<navegador>"
#    When Ingresar a Menu Credito Nomina
#    And Dar Click en Transfiere tus Deudas
#    And Dar Click en Olvide mi Usuario "<user>"
#    And Selecciono Opcion Recuperar Usuario "<opcionIdentificar>"
#    And Lleno Campos Tarjeta Credito "<cuenta>" "<nip>"
#
#
#    Examples:
#      |navegador |user|opcionIdentificar|cuenta|nip|
#      |FirefoxL  |asdd|CC               |aadasd|asdsd|

  Scenario Outline: Portal HSBC MX
    Given Cargar Pagina HSBC MX "<navegador>"
    When Ingresar a Menu Credito Nomina
    And Dar Click en Transfiere tus Deudas
    And Dar Click en Olvide mi Usuario "<user>"
    And Selecciono Opcion Recuperar Usuario "<opcionIdentificar>"
    And Lleno Campos Acceso Telefonico "<telefono>" "<nip>" <numero>
    And Dar Click en Continuar Recuperar Usuario
    And Verificar Usuario "<expecedUser>"

    Examples:
      |navegador |user|opcionIdentificar|telefono|nip|expecedUser|numero|
      |FirefoxL  |asdd|IVR              |12321312|123456|Verificar identidad|12313|






