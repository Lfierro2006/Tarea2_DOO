# Tarea2_DOO
Integrantes:
  -Lucas Benjamín Fierro Orellana
  -Javier Sebastián Alonso Molina Díaz
  -Joaquín Andrés Torres Zavala
  
  Cambios al Diagrama UML:
  
  -empleado ahora es una clase hijo de una clase padre abstracta llamada Persona para incluir el caso del Invitado externo a la empresa, salvo el id ahora todos los metodos y variables de empleado pertenecen a Persona
  
  -los empleados ahora tienen una variable que indica su Departamento
  
  -Asistencia hace referencia a invitable en vez de empleado porque se agregó la clase PGenerica (el invitado externo)
  
  -En Asistencia se agregó el atributo Instant horaLlegada para registrar la hora a la que llegó cada persona
  
  -Asistencia ahora tambien tiene una asociacion con Invitable para confirmar si el Invitado externo fue de hecho invitado
  
  -Retraso ya no tiene el atributo horaLlegada porque lo hereda de Asistencia ya que todos los que asisten deben tener hora de llegada
  
  -Nota se le agrega el atributo Instant hora para poder crear el informe
  
  -Persona agrega un nuevo método equals comparando correos
  
  -Reunión agrega los atributos organizador, tipo (de reunion), Lista<Invitacion>, Lista<Asistencia> y Lista<Nota>
  
  -Reunión el método obtenerAusencias retorna Lista<Invitable> en vez de Lista<Invitación> porque buscamos registrar personas, no sus invitaciones
  
  -Se agrego a Reunion el metodo de registrarAsistencias y de nuevaNota para crear notas asociadas a la reunion
  
  -Se agrego la clase Informe que tiene una asociacion con Reunion y Reunion tiene una dependencia con Informe ya que usa un metodo de Informe llamado generarInforme
  
  -A Departamento se le añadio un metodo para añadir empleados
