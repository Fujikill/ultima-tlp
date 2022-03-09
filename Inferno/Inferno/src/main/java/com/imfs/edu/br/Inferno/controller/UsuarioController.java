package com.imfs.edu.br.Inferno.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imfs.edu.br.Inferno.orm.Usuario;
import com.imfs.edu.br.Inferno.repository.UsuarioRepository;



@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	 
	@RequestMapping("/")
	public String listarUsuario(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		
		return "usuarios";		
	}
	 
	@GetMapping("/adicionar")
	public String adicionarUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formularioUsuario";
	}
	
	@PostMapping("/salvar")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return "formularioUsuario";
		}
		usuarioRepository.save(usuario);
		return "redirect:/";
	}
}
