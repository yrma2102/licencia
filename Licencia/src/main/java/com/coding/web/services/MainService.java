package com.coding.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.web.models.License;
import com.coding.web.models.Person;
import com.coding.web.repositories.ILincenseRepository;
import com.coding.web.repositories.IPersonRepository;
@Service
public class MainService {
	@Autowired
	private IPersonRepository personaRepo;
	@Autowired
	private ILincenseRepository licenseRepo;
	
	
	/// CRUD Personas
	public Person getPersona(Long id) {
		return personaRepo.findById(id).orElse(null);
	}
	
	public Person crearPersona(Person persona) {
		return personaRepo.save(persona);
	}
	
	public List<Person> todosUsuario(){
		return personaRepo.findAll();
	}
	// OBTENER NO LICENCIADOS
	public List<Person> obtenerNoLicenciados(){
		return personaRepo.findByNoLicense();
	}
	public List<Person> obtenerNoLicenciadosJPA(){
		return personaRepo.findByLicenseIdIsNull();
	}
	
	
	
	//CRUD Licencias
	public License crearLicencia(License licencia) {
//		System.out.println(this.generarNumeroLic());
		licencia.setNumber(this.generarNumeroLic());
		return licenseRepo.save(licencia);
	}
	
	public int generarNumeroLic() {
		License lic = licenseRepo.findTopByOrderByNumberDesc();
//		if(lic.getNumero() == null)
		if(lic == null ) {
			return 1;
		}
		int numeroMayor = lic.getNumber();
		numeroMayor++;

		return numeroMayor;
	}
}
