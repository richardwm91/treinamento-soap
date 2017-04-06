package br.com.caelum.estoque.modelo.item;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement//import bind (JAX-B)
@XmlAccessorType(XmlAccessType.FIELD)//reconfigurar o JAX-B
public class ListaItens {

	@XmlElement(name = "item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	public ListaItens() {
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
