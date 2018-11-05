package org.jasser.service;

import org.jasser.dao.EtudiantRepository;
import org.jasser.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantRestService {
	@Autowired
	private EtudiantRepository er;
	
	@Secured(value={"ROLE_ADMIN","ROLE_SCOLARITE"})
	@RequestMapping(value="/saveEtudiant", method=RequestMethod.GET)
	public Etudiant saveEtudiant (Etudiant e) {
		return er.save(e);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_SCOLARITE","ROLE_PROF","ROLE_ETUDIANT"})
	@RequestMapping(value="/etudiants")
	public Page<Etudiant> listEtudiant (int page, int size) {
		return er.findAll(new PageRequest(page, size));
	}
}
