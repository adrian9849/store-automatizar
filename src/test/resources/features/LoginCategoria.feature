#language: es
@testfeature
  Característica: Validación de login y navegación de categorías en la tienda


    #Escenario Outline para login
    Esquema del escenario: Validación de login
      Dado estoy en la página de la tienda
      Y me logueo con mi usuario: "<correo>" y clave: "<clave>"
      Entonces valido que login "<resultado>"

      Ejemplos:
        | correo                 | clave        | resultado |
        | adrian9849@hotmail.com | adrian9849** | valido    |

   @testfeature2
  #Escenario normal
  Escenario: Validación de navegación por categorías
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "adrian9849@hotmail.com" y clave "adrian9849**"
    Cuando navego a la categoria "Accesorios" y subcategoria "Autos"
    Entonces valio resultado categoria "valida"
