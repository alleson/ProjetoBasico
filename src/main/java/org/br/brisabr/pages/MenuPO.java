package org.br.brisabr.pages;

import org.br.brisabr.core.BasePage;

public class MenuPO extends BasePage {

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListaContas(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarResumo(){
        clicarLink("Resumo Mensal");
    }

    public void acessarHome(){
        clicarLink("Home");
    }



}
