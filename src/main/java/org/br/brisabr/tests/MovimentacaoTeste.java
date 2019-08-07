package org.br.brisabr.tests;
import org.br.brisabr.core.BaseTest;
import org.br.brisabr.pages.MenuPO;
import org.br.brisabr.pages.MovimentacaoPO;
import org.br.brisabr.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.br.brisabr.utils.DataUtils.obterDataFormatada;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTeste extends BaseTest {

    private MovimentacaoPO movimentacaoPO = new MovimentacaoPO();
    private MenuPO menuPO = new MenuPO();

    @Test
    public void test1_RealizarMovimentacao() {
        menuPO.acessarMovimentacao();
        movimentacaoPO.setTipoMovimentacao("Receita");
        movimentacaoPO.setDataMovimentacao("20/07/2019");
        movimentacaoPO.setDataPagamento("20/07/2019");
        movimentacaoPO.setDescricao("Teste teste");
        movimentacaoPO.setInteressado("Alleson");
        movimentacaoPO.setValor("900");
        movimentacaoPO.setConta("Conta alterada");
        movimentacaoPO.setSituacaoPago();
        movimentacaoPO.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPO.obterMensagemDeSucesso());
    }

    @Test
    public void test2_CamposObrigatorios() {
        menuPO.acessarMovimentacao();
        movimentacaoPO.salvar();
        List<String> erros = movimentacaoPO.obterMensagemErro();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
                "Descrição é obrigatório", "Interessado é obrigatório",
                "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());

    }

    @Test
    public void test3_MovimentacaoFutura(){
        menuPO.acessarMovimentacao();
        movimentacaoPO.setTipoMovimentacao("Receita");
        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
        movimentacaoPO.setDataMovimentacao(obterDataFormatada(dataFutura));
        movimentacaoPO.setDataPagamento(obterDataFormatada(dataFutura));
        movimentacaoPO.setDescricao("Teste teste");
        movimentacaoPO.setInteressado("Alleson");
        movimentacaoPO.setValor("900");
        movimentacaoPO.setConta("Conta alterada");
        movimentacaoPO.setSituacaoPago();
        movimentacaoPO.salvar();

        List<String> erros = movimentacaoPO.obterMensagemErro();
        Assert.assertTrue(erros.contains(
                "Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }


}