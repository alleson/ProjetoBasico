package org.br.brisabr.suite;


import org.br.brisabr.core.DriverFactory;
import org.br.brisabr.pages.LoginPO;
import org.br.brisabr.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTeste.class,
        MovimentacaoTeste.class,
        RemoverMovimentacaoContaTeste.class,
        SaldoTeste.class,
        ResumoTeste.class

})
public class SuiteGeral {

    private static LoginPO page = new LoginPO();

    @BeforeClass
    public static void inicializa(){
        page.acessarTelaInicial();
        page.setEmail("aalbuquerque.sp@gmail.com");
        page.setSenha("Spikao1533$");
        page.entrar();
    }

    @AfterClass
    public static void finaliza(){
        DriverFactory.killDriver();
    }
}
