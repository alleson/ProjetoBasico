package org.br.brisabr.pages;

import org.br.brisabr.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePO extends BasePage {


    public String obterSaldo(String nome) {
        return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
    }
}