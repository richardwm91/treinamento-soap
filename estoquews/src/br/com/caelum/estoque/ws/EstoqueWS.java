package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.*;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService//anotação para consumir o JAX-WS
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    @WebMethod(operationName = "todosOsItens")//muda o nome da operação exibida no xml
    @WebResult(name = "itens")//modifica o nome do "return"
    public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {

        System.out.println("Chamando todosItens()");

        List<Filtro> lista = filtros.getLista();
        List<Item> itensResultado = dao.todosItens(lista);

        return new ListaItens(itensResultado);
    }

    @WebMethod(operationName = "CadastrarItem")
    @WebResult(name = "item")
    public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
                              @WebParam(name = "item") Item item) throws AutorizacaoException {

        System.out.println("Cadastrando item "+ item + "Token" + token);

        boolean valido = new TokenDao().ehValido(token);
        if(!valido)
            throw new AutorizacaoException("Falha na autorização");

        new ItemValidador(item).validate();

        this.dao.cadastrar(item);

        return item;
    }

}