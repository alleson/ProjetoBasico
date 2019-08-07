package org.br.brisabr.tests;

import org.br.brisabr.core.BaseTest;
import org.br.brisabr.core.DriverFactory;
import org.br.brisabr.pages.MenuPO;
import org.br.brisabr.pages.ResumoPO;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.br.brisabr.core.DriverFactory.getDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTeste extends BaseTest {

    MenuPO menuPO = new MenuPO();
    ResumoPO resumoPO = new ResumoPO();

    @Test
    public void test1_ExcluirMovimentacao(){
        menuPO.acessarResumo();
        resumoPO.excluirMovimentacao("Teste teste");
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPO.obterMensagemSucesso());
    }

    @Test
    public void test2_ResumoMensalTitulo(){
        menuPO.acessarResumo();
        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
    }

}
