package org.br.brisabr.pages;
import org.br.brisabr.core.BasePage;
import org.openqa.selenium.By;

public class ResumoPO extends BasePage {

    public void excluirMovimentacao(String valor){
        obterCelula("Descrição", valor, "Ações", "tabelaExtrato")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }

    public String obterMensagemSucesso(){
        return obterTextoPage(By.xpath("//div[@class='alert alert-success']"));
    }


}
