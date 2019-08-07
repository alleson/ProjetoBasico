package org.br.brisabr.pages;

import org.br.brisabr.core.BasePage;
import org.br.brisabr.core.DriverFactory;
import org.openqa.selenium.By;
import org.br.brisabr.core.DriverFactory;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.br.brisabr.core.DriverFactory.getDriver;

public class MovimentacaoPO extends BasePage {

    public void setTipoMovimentacao(String tipo){
        comboBoxSelect(By.xpath("//select[@id='tipo']"), tipo);
    }

    public void setDataMovimentacao(String data){
        escreve("data_transacao", data);
    }

    public void setDataPagamento(String data){
        escreve("data_pagamento", data);
    }

    public void setDescricao(String descricao){
        escreve("descricao", descricao);
    }

    public void setInteressado(String interessado){
        escreve("interessado", interessado);
    }

    public void setValor (String valor){
        escreve("valor", valor);
    }

    public void setConta(String tipoConta){
        comboBoxSelect("conta", tipoConta);
    }

    public void setSituacaoPago(){
        clicarRadio("status_pago");
    }

    public void setSituacaoPendente(){
        clicarRadio("status_pendente");
    }

    public void salvar(){
        clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemDeSucesso(){
        return obterTextoPage(By.xpath("//div[@class='alert alert-success']"));
    }

    public List<String> obterMensagemErro(){
       List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
       List<String> retorno = new ArrayList<String>();
        for (WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
