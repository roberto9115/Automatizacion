Feature: Actualizacion notas de credito

  Scenario Outline: Validar Pago Tercero
    Given Cargar Pagina Mercado Libre "<navegador>"
    And Ingreso User "<usuario>" y Password "<password>"
    When Ingresar a Menu Ofertas
    And Regresar a Pagina Inicio
    When Ingresar a Menu Historial
    When Ingresar a Menu Moda
    And  Opcion Mujer
    Then Imprimir Texto Marca

    Examples:
    |navegador|usuario|password|
    |ChromeL|roberto|celular|
#    |FirefoxL|roberto12345|celular12345|
#    |ChromeL|roberto1234|celular1234|
#    Then Valido el precio del primer Producto




