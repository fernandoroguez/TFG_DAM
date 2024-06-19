package com.rgelo.wallaswap5.controller;

import com.rgelo.wallaswap5.entities.Anuncio;
import com.rgelo.wallaswap5.entities.Chat;
import com.rgelo.wallaswap5.entities.Usuario;
import com.rgelo.wallaswap5.service.implementatios.AnuncioServiceImpl;
import com.rgelo.wallaswap5.service.implementatios.ChatServiceImpl;
import com.rgelo.wallaswap5.service.implementatios.UsuarioServiceImpl;

import editar_form.EditarAnunciosForm;
import listar_form.ListarAnunciosForm;
import listar_form.ListarUsuariosForm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AnunciosController {

	@Autowired
	private UsuarioServiceImpl userservice;
	@Autowired
	private AnuncioServiceImpl anuncioservice;

	private static Usuario usuario = new Usuario();

	private static List<Usuario> listausuarios = null;

	@GetMapping("/")
	public String listar_ofertas(@AuthenticationPrincipal UserDetails userDetails,
			@RequestParam(required = false) String param, @ModelAttribute ListarUsuariosForm listarusuariosform,
			@ModelAttribute ListarAnunciosForm listaranunciosform, Model model) {

		String username = userDetails.getUsername();
		usuario = userservice.findByNombreUsuario(username);
		List<Anuncio> listaanuncios = anuncioservice.getanuncios(username);

		listaranunciosform = new ListarAnunciosForm();
		listaranunciosform.setListaanuncios(listaanuncios);
		listarusuariosform = new ListarUsuariosForm();
		listausuarios = userservice.lisarUsuarios();
		listarusuariosform.setListausuarios(listausuarios);
		model.addAttribute("listaanunciosform", listaranunciosform);
		model.addAttribute("listarusuariosform", listarusuariosform);
		model.addAttribute("nombreusuario", username);

		return "inicio";
	}

	@GetMapping("/detalles")
	public String mostrarDetalles(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("id") Long id,
			@ModelAttribute ListarUsuariosForm listarusuariosform, Model model) {
		Anuncio anuncio = anuncioservice.findById(id);
		String username = userDetails.getUsername();
		usuario = userservice.findByNombreUsuario(username);
		if (anuncio != null) {
			Usuario vendedor = userservice.getById(anuncio.getUsuario().getId());
			listausuarios = userservice.lisarUsuarios();
			listarusuariosform.setListausuarios(listausuarios);
			model.addAttribute("listarusuariosform", listarusuariosform);
			model.addAttribute("nombreusuario", usuario.getNombreUsuario());
			model.addAttribute("anuncio", anuncio);
			model.addAttribute("vendedor", vendedor);
			return "detalles";
		} else {
			return "inicio";
		}
	}

	@GetMapping("/verperfil")
	String VerPerfil(@AuthenticationPrincipal UserDetails userDetails,
			@ModelAttribute ListarUsuariosForm listarusuariosform,
			@ModelAttribute ListarAnunciosForm listaranunciosform, Model model) {

		String username = userDetails.getUsername();
		usuario = userservice.findByNombreUsuario(username);
		listaranunciosform.listaanunciospropios = anuncioservice.findbyuser(usuario.getNombreUsuario());
		listausuarios = userservice.lisarUsuarios();
		listarusuariosform.setListausuarios(listausuarios);
		model.addAttribute("listarusuariosform", listarusuariosform);
		model.addAttribute("nombreusuario", usuario.getNombreUsuario());
		model.addAttribute("usuario", usuario);
		model.addAttribute("listaanunciosform", listaranunciosform);

		return "perfil";
	}

	@GetMapping("/crearAnuncio")
	public String crearAnuncio(@AuthenticationPrincipal UserDetails userDetails,
			@ModelAttribute ListarUsuariosForm listarusuariosform,
			@ModelAttribute EditarAnunciosForm editaranunciosform, Model model) {

		String username = userDetails.getUsername();
		usuario = userservice.findByNombreUsuario(username);
		editaranunciosform = new EditarAnunciosForm();
		listausuarios = userservice.lisarUsuarios();
		listarusuariosform.setListausuarios(listausuarios);
		model.addAttribute("listarusuariosform", listarusuariosform);
		model.addAttribute("usuario", usuario);
		model.addAttribute("nombreusuario", usuario.getNombreUsuario());
		model.addAttribute("anuncioForm", editaranunciosform);
		return "nuevoanuncio";
	}

	@PostMapping("/guardarAnuncio")
	public String guardarAnuncio(@AuthenticationPrincipal UserDetails userDetails,
			@ModelAttribute EditarAnunciosForm anuncioForm, Model model) {
		String uploadPath = "D:\\TFG_TECH\\eclipse\\WallaSwap5\\src\\main\\webapp\\images";

		String username = userDetails.getUsername();
		usuario = userservice.findByNombreUsuario(username);
		Anuncio anuncio = new Anuncio();
		anuncio.setTitulo(anuncioForm.getTitulo());
		anuncio.setDescripcion(anuncioForm.getDescripcion());
		anuncio.setUsuario(usuario);
		List<String> fotosNombres = new ArrayList<>();
		for (MultipartFile foto : anuncioForm.getFotos()) {
			if (foto != null && !foto.isEmpty()) {
				try {
					// Obtener la extensión del archivo
					String originalFilename = foto.getOriginalFilename();
					String fileExtension = "";
					if (originalFilename != null && originalFilename.contains(".")) {
						fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
					}

					// Generar un nuevo nombre de archivo con la marca de tiempo
					String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
					String newFilename = timeStamp + fileExtension;

					// Guardar el archivo
					byte[] bytes = foto.getBytes();
					Path path = Paths.get(uploadPath + File.separator + newFilename);
					Files.write(path, bytes);
					fotosNombres.add(newFilename);
				} catch (IOException e) {
					e.printStackTrace();
					// Manejar la excepción
				}
			}
		}

		anuncio.setFotos(fotosNombres);
		anuncioservice.guardarAnuncio(anuncio);

		return "redirect:/verperfil";
	}

	@GetMapping("/chat")
	String Contactar(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("id") String nombreusu,
			@ModelAttribute ListarAnunciosForm listaranunciosform, Model model) {

		String username = userDetails.getUsername();
		usuario = userservice.findByNombreUsuario(username);

		Usuario contacto = userservice.findByNombreUsuario(nombreusu);
		model.addAttribute("usuario", contacto);

		return "contacto";
	}

}
