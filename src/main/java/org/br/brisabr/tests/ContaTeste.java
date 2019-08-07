package org.br.brisabr.tests;

import org.br.brisabr.core.BaseTest;
import org.br.brisabr.pages.ContasPO;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.br.brisabr.pages.MenuPO;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTeste extends BaseTest {

    MenuPO menuPO = new MenuPO();
    ContasPO contasPO = new ContasPO();

    @Test
    public void test1_InserirConta() {
        menuPO.acessarTelaInserirConta();
        contasPO.setNome("Conta teste");
        contasPO.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPO.obterMensagemSucesso());
    }

    @Test
    public void test2_AlterarConta() {
        menuPO.acessarTelaListaContas();
        contasPO.alterarConta("Conta teste");
        contasPO.apagar();
        contasPO.setNome("Conta alterada");
        contasPO.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPO.obterMensagemSucesso());
    }

    /*@Test
    public void testExcluirConta(){
        menuPO.acessarTelaListaContas();
        contasPO.apagarConta("Conta alterada");
        Assert.assertEquals("Conta removida com sucesso!", contasPO.obterMensagemSucesso());
    }*/

    @Test
    public void test3_InserirContaMesmoNome() {
        menuPO.acessarTelaInserirConta();
        contasPO.setNome("Conta alterada");
        contasPO.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPO.obterMensagemErro());
    }


}
