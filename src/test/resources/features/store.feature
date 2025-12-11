Feature: Product - Store

  @loginValido
  Scenario Outline: Validación del precio de un producto con login válido
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    When navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito.

    Examples:
      | usuario                      | clave          |
      | adrian9849@hotmail.com       | adrian9849**  |

  @loginInvalido
  Scenario Outline: Login inválido no permite entrar
    Given estoy en la página de la tienda
    And me logueo con mi usuario "<usuario>" y clave "<clave>"
    Then valido que no ingreso a la página principal

    Examples:
      | usuario           | clave        |
      | incorrecto@mail.com | badpass123 |

  @categoriaInexistente
  Scenario: Categoría inexistente
    Given estoy en la página de la tienda
    And me logueo con mi usuario "adrian9849@hotmail.com" y clave "adrian9849**"
    When navego a la categoria "Autos" y subcategoria "Na"
    Then valido que no existe la categoría
