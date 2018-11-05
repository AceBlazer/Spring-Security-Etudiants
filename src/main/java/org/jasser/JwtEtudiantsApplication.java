package org.jasser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jasser.dao.EtudiantRepository;
import org.jasser.entities.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JwtEtudiantsApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(JwtEtudiantsApplication.class, args);
		EtudiantRepository er = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		er.save(new Etudiant("Khaled","Thamer",df.parse("1995-11-12")));
		er.save(new Etudiant("Abdennabi","Helmi",df.parse("1994-3-12")));
		er.save(new Etudiant("Saanoun","Jasser",df.parse("1994-11-12")));
		List<Etudiant> etds= er.findAll();
		etds.forEach(e->System.out.println(e.getNom()));
	}
}
