package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ListaItens;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

//anotação para consumir o JAX-WS
@WebService
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    //muda o nome da operação exibida no xml
    @WebMethod(operationName = "todosOsItens")
    //modifica o nome do "return"
    @WebResult(name = "itens")
    public ListaItens getItens(){

        System.out.println("Chamando getItens()");
        List<Item> lista = dao.todosItens();

        return new ListaItens(lista);
    }

}
