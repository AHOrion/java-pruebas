package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;

@RestController
public class SaludoController {

	@GetMapping(value="/saludo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Bienvenido a mi servicio REST";
	}
	
	@GetMapping(value="/saludo/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar(@PathVariable ("name") String n) {
		return "Bienvenido a mi servicio REST sr./sra. "+n;
	}
	@GetMapping(value="/saludo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona ficha() {
		return new Persona("profe","profe@gmail",33);
	}
	
	@PostMapping(value="/saludo", produces = MediaType.TEXT_PLAIN_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public String personalizado(@RequestBody Persona persona) {
		return "Bienvenido" + persona.getNombre() + " - " + persona.getEmail() ;
	}
	
	@DeleteMapping(value="/saludo/{name}")
	public void eliminar(@PathVariable("name") String n) {
		System.out.println("Elimina a "+n);
	}
	
	
	
	
}
