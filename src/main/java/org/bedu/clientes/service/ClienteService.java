package org.bedu.clientes.service;

import java.util.List;
import java.util.Optional;

import org.bedu.clientes.entity.Cliente;
import org.bedu.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

   /**
    * 
    * inyeccion de dependencia le pide la Spring para que instancie de alguna
    * clase.
    * 
    * Capas de un proyecto de Spring
    * 1. Controller: Se encarga de recibir y responder las peticiones
    * El controllador sabe como obtener la info de las peticiones.
    * 
    * 2. Service: Se encarga de ejecutar validaciones, lógica de negocio
    * y puede invocar al repositorio.
    * 
    * 3. Repository: Se encarga de realizar consultas a base de datos.
    * 
    * Peticion <-> Controller <-> Service <-> Repository
    */
   @Autowired
   private ClienteRepository repository;

   public List<Cliente> obtenerClientes() {
      return repository.findAll();
   }

   public Optional<Cliente> obtenerCliente(int id) {
      return repository.findById(id);
   }

   public Cliente crearCliente(Cliente nuevo) {
      return repository.save(nuevo);
   }

   public void eliminarCliente(int id) {
      repository.deleteById(id);
   }

   public void actualizarCliente(int id, Cliente nuevo) {
      // 1. Buscar al cliente
      Optional<Cliente> busqueda = repository.findById(id);

      if (busqueda.isEmpty()) {
         // Normalmente se arroja una exception
         System.out.println("El cliente " + id + " no existe");
         return;
      }

      // 2. Cambiar sus valores
      Cliente viejo = busqueda.get();

      if (nuevo.getNombre() != null) {
         viejo.setNombre(nuevo.getNombre());
      }

      if (nuevo.getApellido() != null) {
         viejo.setApellido(nuevo.getApellido());
      }

      // 3. Actualizar
      repository.save(viejo);
   }

}
