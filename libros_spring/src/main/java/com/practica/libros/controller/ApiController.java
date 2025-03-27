package com.practica.libros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.libros.model.Libro;
import com.practica.libros.repo.LibroRepo;


@RestController
public class ApiController {

	@Autowired
	private LibroRepo libroRepo;
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Bienvenido a la biblioteca!!";
	}

	@GetMapping(value = "/libros")
	public List<Libro> getLibros() {
		return libroRepo.findAll();
	}

	@PostMapping(value = "/guardar")
	public String saveLibro(@RequestBody Libro libro) {
		libroRepo.save(libro);
		return "Libro añadido";
	}

	@PutMapping(value = "/actualizar/{id}")
	public String updateLibro(@PathVariable long id, @RequestBody Libro libro) {
		Libro updatedLibro = libroRepo.findById(id).get();
		updatedLibro.setAutor(libro.getAutor());
		updatedLibro.setTitulo(libro.getTitulo());
		updatedLibro.setFechaPublicacion(libro.getFechaPublicacion());
		
		libroRepo.save(updatedLibro);

		return "Libro actualizado";
	}

	@DeleteMapping(value = "/borrar/{id}")
	public String deleteLibro(@PathVariable long id) {
		Libro libroDeleted = libroRepo.findById(id).get();
		libroRepo.delete(libroDeleted);

		return "Libro eliminado";

	}

	
}
