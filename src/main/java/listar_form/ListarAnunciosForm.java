package listar_form;

import java.util.List;

import com.rgelo.wallaswap5.entities.Anuncio;


public class ListarAnunciosForm {

	public List<Anuncio> listaanuncios;

	public List<Anuncio> listaanunciospropios;
	
    public List<Anuncio> getListaanuncios() {
        return listaanuncios;
    }

    public void setListaanuncios(List<Anuncio> listaanuncios) {
        this.listaanuncios = listaanuncios;
    }

	public List<Anuncio> getListaanunciospropios() {
		return listaanunciospropios;
	}

	public void setListaanunciospropios(List<Anuncio> listaanunciospropios) {
		this.listaanunciospropios = listaanunciospropios;
	}
	
	
}
