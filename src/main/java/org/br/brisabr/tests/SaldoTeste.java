package org.br.brisabr.tests;

import org.br.brisabr.core.BaseTest;
import org.br.brisabr.pages.HomePO;
import org.br.brisabr.pages.MenuPO;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTeste extends BaseTest {


    HomePO homePO = new HomePO();
    MenuPO menuPO = new MenuPO();

    @Test
    public void testSaldoConta(){
        menuPO.acessarHome();
        Assert.assertEquals("900.00", homePO.obterSaldo("Conta alterada"));
    }
}
