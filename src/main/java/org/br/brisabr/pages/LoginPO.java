package org.br.brisabr.pages;

import org.br.brisabr.core.BasePage;
import org.br.brisabr.core.DriverFactory;

public class LoginPO extends BasePage {

    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
    }

    public void setEmail(String email){
        escreve("email", email);
    }

    public void setSenha(String senha){
        escreve("senha", senha);
    }

    public void entrar(){
        clicarBotaoPorTexto("Entrar");
    }


}
