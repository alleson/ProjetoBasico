package org.br.brisabr.pages;

import org.br.brisabr.core.BasePage;
import org.openqa.selenium.By;

public class ContasPO extends BasePage {

    public void setNome(String nome){
        escreve("nome", nome);
    }

    public void apagar(){
        apagar("nome");
    }

    public void salvar(){
        clicarBotaoPorTexto("Salvar");
    }
    public String obterMensagemSucesso(){
        return obterTextoPage(By.xpath("//div[@class='alert alert-success']"));
    }


    public void alterarConta(String valor){
        obterCelula("Conta",valor, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void apagarConta(String valor){
        obterCelula("Conta",valor, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }

    public String obterMensagemErro(){
        return obterTextoPage(By.xpath("//div[@class='alert alert-danger']"));
    }


}
