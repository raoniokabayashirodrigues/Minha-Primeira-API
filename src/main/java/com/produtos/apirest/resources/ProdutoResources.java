package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoReposity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Classe recebe as requisições HTTP
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")

public class ProdutoResources {

    @Autowired //criar um ponto de injeção. Utiliza os métodos para conectar no banco de dados.
    ProdutoReposity produtoReposity;

    @GetMapping("/produtos")
    @ApiOperation("Retonar uma lista de todos os produtos.")
    public List<Produto> listaProdutos(){
        return produtoReposity.findAll();
    }

    @GetMapping("/produtos/{id}")
    @ApiOperation("Retonar um produto único através do seu ID")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoReposity.findById(id);
    }

    @PostMapping("/produtos/")
    @ApiOperation("Salva um produto na lista.")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoReposity.save(produto);
    }

    @DeleteMapping("/produtos/")
    @ApiOperation("Deleta um produto na lista.")
    public void deletaProduto(@RequestBody Produto produto){
        produtoReposity.delete(produto);
    }

    @PutMapping("/produtos/")
    @ApiOperation("Atualiza um produto na lista.")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoReposity.save(produto);
    }
}
