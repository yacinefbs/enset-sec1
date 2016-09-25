package org.enset;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.enset.dao.EtudiantRepository;
import org.enset.entities.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EnsetSec1Application {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(EnsetSec1Application.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("safouane", "safouane", df.parse("1983-11-12")));
		etudiantRepository.save(new Etudiant("rifaat", "rifaat", df.parse("1983-11-12")));
		etudiantRepository.save(new Etudiant("sara", "sara", df.parse("1983-11-12")));
		etudiantRepository.save(new Etudiant("hamza", "hamza", df.parse("1983-11-12")));
		etudiantRepository.save(new Etudiant("driss", "driss", df.parse("1983-11-12")));
	
		List<Etudiant> etds = etudiantRepository.findAll();
		etds.forEach(e->System.out.println(e.getNom()));
		/*
		for(Etudiant e:etds){
			System.out.println(e.getNom());
		}
		*/
	}
}
