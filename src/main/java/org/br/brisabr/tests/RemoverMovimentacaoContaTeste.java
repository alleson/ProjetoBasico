package org.br.brisabr.tests;

import org.br.brisabr.core.BaseTest;
import org.br.brisabr.pages.ContasPO;
import org.br.brisabr.pages.MenuPO;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTeste extends BaseTest {
    MenuPO menuPO = new MenuPO();
    ContasPO contasPO = new ContasPO();

    @Test
    public void testExcluirContaComMovimentacao() {
        menuPO.acessarTelaListaContas();
        contasPO.apagarConta("Conta alterada");
        Assert.assertEquals("Conta em uso na movimentações", contasPO.obterMensagemErro());
    }
}
