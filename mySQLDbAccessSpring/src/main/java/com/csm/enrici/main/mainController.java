package com.csm.enrici.main;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csm.enrici.main.model.User;
import com.csm.enrici.main.model.UserRepository;


//contrôleur principal de la petite appli
@Controller
public class mainController {
	
	//TODO:on va ajouter un système de log au controller pour pouvoir tester des choses dans la console
		//cet attribut statique sera accessible depuis les méthodes du controller pour afficher des choses en console
	private static Logger log = LoggerFactory.getLogger(mainController.class);

	//on déclare un attribut qui va répertorier mes Users
	//l'annotation @Autowired va générer un objet de type UserRepository automatiquement
	//l'attribut me permettra ensuite d'appeler les méthodes de manipulation de la table
	@Autowired
	private UserRepository userRepository;
	
	//méthode qui est déclenchée par l'url /index passée en requête HTTP Get
	@GetMapping(value={"/","/index"})
	public String getIndex(Model model) {
		
		//exemple de message de log : on compte le nombre de User en BDD
		log.info("{}", userRepository.count());		
		//le log permet d'afficher des informations plus formatées que le sysout
		log.info("toto");
		//récupération et affichage en log de tous les objets User
		ArrayList<User> listeUsers = (ArrayList<User>)userRepository.findAll();
		for (User user : listeUsers) {
			log.info(user.toString());
		}
		//test de l'ajout des infos d'un User au modèle pour affichage dans la vue
		model.addAttribute("userNumber", userRepository.findById(1));
		return "index";
	}
	
	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
	
	//méthode qui gère l'inscription d'un utilisateur
	@PostMapping("/register")
	//la méthode va récupérer dans des arguments les paramètres de requête
	public String postRegister(@RequestParam(name = "username")String username, @RequestParam(name = "password")String password, Model model) {
		//on crée le bean User et on le remplit
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		//on le sauvegarde dans la BDD
		userRepository.save(u);
		//on renvoie l'username à la vue pour affichage
		model.addAttribute("username", username);
		return("welcome");
	}

}
