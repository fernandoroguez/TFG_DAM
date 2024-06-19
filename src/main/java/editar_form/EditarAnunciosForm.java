package editar_form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EditarAnunciosForm {
	
	private Long Id;
	
	private String Titulo;
	
	private String descripcion;
	
	private List<MultipartFile> fotos;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<MultipartFile> getFotos() {
		return fotos;
	}

	public void setFotos(List<MultipartFile> fotos) {
		this.fotos = fotos;
	}
	
	

}
