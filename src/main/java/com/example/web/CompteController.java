package com.example.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.entities.Compte;

@Controller
public class CompteController {

	private static final String get_compte="http://localhost:8080/Banque/compte/{id}";
	private static final String get_all_compte="http://localhost:8080/Banque/compte";
	private static final String verser="http://localhost:8080/Banque/verser";
	private static final String virement="http://localhost:8080/Banque/virement/{id1}/{id2}";
	RestTemplate restTemp = new RestTemplate();

@RequestMapping(value="/Banque", method=RequestMethod.GET)
public String Banque(Model model) {
	RestTemplate restTemp = new RestTemplate();
	Object objects=restTemp.getForObject(get_all_compte, Object.class);
	@SuppressWarnings("unchecked")
	List<Object> c=(List<Object>) Arrays.asList(objects).get(0);
	model.addAttribute("allCompte", c);
return "home";
}

@RequestMapping(value="/Banque/get", method=RequestMethod.GET)
public String searchAccount(Model model,Long CodeCompte) {
	return "cptview";
}

@RequestMapping(value="/getCompte", method=RequestMethod.GET)
public String getCompte(Model model,Long CodeCompte) {
	
	Map<String,String> params=new HashMap<String,String>();
	params.put("id", Long.toString(CodeCompte));
	Compte result=restTemp.getForObject(get_compte, Compte.class,params);
	model.addAttribute("compte", result);
	return "cptview";
}

@RequestMapping(value="/addCompte", method=RequestMethod.GET)
public String addCompte() {
	return "addAccount";
}

@RequestMapping(value= {"/addCompte/add"}, method=RequestMethod.POST)
public String add(Model model, @ModelAttribute("accountForm") Compte cp) {
	restTemp.postForObject(get_all_compte, cp, Compte.class);
	return Banque(model);
}

@RequestMapping(value= "/deleteUser", method=RequestMethod.GET)
public String deleteCompte(@RequestParam(name="accountid") Long CodeCompte ,Model model) {
	Map<String,String> params=new HashMap<String,String>();
	params.put("id", Long.toString(CodeCompte));
	restTemp.delete(get_compte, params);
	return Banque(model);
}

@RequestMapping(value= "/UpdateCompte", method=RequestMethod.GET)
public String updateCompte(@RequestParam(name="accountid") Long CodeCompte ,Model model) {
	Map<String,String> params=new HashMap<String,String>();
	params.put("id", Long.toString(CodeCompte));
	Compte result=restTemp.getForObject(get_compte, Compte.class,params);
	model.addAttribute("upCompte", result);
	return Banque(model);
}

@RequestMapping(value= {"/UpdateCompte/update"}, method=RequestMethod.POST)
public String Update(Model model, @ModelAttribute("accountForm") Compte cp) {
		restTemp.postForObject(get_all_compte, cp, Compte.class);
	return Banque(model);
}

@RequestMapping(value="/verser", method=RequestMethod.GET)
public String allAction(Model model) {
	RestTemplate restTemp = new RestTemplate();
	Object objects=restTemp.getForObject(verser, Object.class);
	@SuppressWarnings("unchecked")
	List<Object> action=(List<Object>) Arrays.asList(objects).get(0);
	System.out.println(action);
	model.addAttribute("allAction", action);
return "verser";
}

@RequestMapping(value="/virement")
public String Virement(Model model) {
return "virement";
}

@RequestMapping(value="/effectuerVirement", method=RequestMethod.GET)
public String effectuerVirement(Model model,@RequestParam(name="de") Long IDcp1,@RequestParam(name="a") Long IDcp2,@RequestParam(name="montant") Long montant) {
	Map<String,String> params=new HashMap<String,String>();
	params.put("id1", Long.toString(IDcp1));
	params.put("id2", Long.toString(IDcp2));
	System.out.println(params);
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity<Long> entity = new HttpEntity<Long>(montant, headers);
	restTemp.put(virement, entity,params);
//	
	return Banque(model);
}

}

