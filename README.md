Demo City Product

Aplicación para agregar/modificar/eliminar tareas pendientes.

Se agregao un pequeño plus en el cual el usuario tambien puede agregar categorias.

Estructura de la aplicació:

La aplicacion fue hecha con Clean Architecture y MVVM , donde el ViewModel se centra en la presentacion a la vista, otras tecnologias utilizadas fueron:

Hilt , usada para la injeccion de dependecias para separar de manera modular. Room , para guardar la base de datos local.

La aplicacion consta de las siguientes secciones:

Home: 

![Captura de pantalla 2023-05-17 a la(s) 23 35 06](https://github.com/Picazo/demo_city_products/assets/17649817/ae1deacc-ae90-405e-bb3d-01a1dc0f5501)

Obtiene la informacion de un servicio que regresa el listado de productos, y posteriormente muestra el detalle del mismo:


![Captura de pantalla 2023-05-17 a la(s) 23 35 14](https://github.com/Picazo/demo_city_products/assets/17649817/b1b1b45a-1385-44d4-86b4-e277e7067a7a)


Se utilizo Glide para pintar las imagenes, asi mismo la particularidad de esta vista esta en que son 2 FrameLayout en una misma activity, y la vista se muestra tanto en flujo como en experiencia muy natural.
