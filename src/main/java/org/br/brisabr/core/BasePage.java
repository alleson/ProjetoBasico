package org.br.brisabr.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    /****************** Formulário ************************/

    public void escreve(String id_campo, String texto) {
        DriverFactory.getDriver().findElement(By.id(id_campo)).sendKeys(texto);
    }

    public void apagar(String id_campo){
        DriverFactory.getDriver().findElement(By.id(id_campo)).clear();
    }

    public String obterValorCampo(String id_campo) {
        return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicarRadio(String id) {
        DriverFactory.getDriver().findElement(By.id(id)).click();
    }

    public void clicarRadio(By by) {
        DriverFactory.getDriver().findElement(by).click();
    }

    public boolean isRadioSelected(String id) {
        return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
    }

    public void comboBoxSelect(String id, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void comboBoxSelect(By by, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(by);
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String returnComboValue(String id) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void clicarBotao(String id) {
        DriverFactory.getDriver().findElement(By.id(id)).click();
    }

    public void clicarBotao(By by) {
        DriverFactory.getDriver().findElement(by).click();
    }

    public void clicarBotaoPorTexto(String texto){
        clicarBotao(By.xpath("//button[.='"+texto+"']"));
    }

    public void clicarLink(String link) {
        DriverFactory.getDriver().findElement(By.linkText(link)).click();
    }

    public String obterTexto(String id) {
        return DriverFactory.getDriver().findElement(By.id(id)).getText();
    }

    public String obterTextoPage(By by) {
        return DriverFactory.getDriver().findElement(by).getText();
    }

    public String alertaObterTextoEAceita() {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String textAlert = alert.getText();
        alert.accept();
        return textAlert;

    }

    public int quantidadeOpcoesCombo(String id) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getOptions().size();
    }

    public boolean valorOpcaoCombo(String id, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals(valor)) {
                encontrou = true;
                break;
            }
        }
        return encontrou;
    }

    public int quantidadeSelecionada(String id) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getAllSelectedOptions().size();
    }

    public String valorDoBotao(String id) {
        WebElement botao = DriverFactory.getDriver().findElement(By.id(id));
        return botao.getAttribute("value");
    }

    public void entrarFrame(String id) {
        DriverFactory.getDriver().switchTo().frame(id);

    }

    /************************* JS **********************/

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        return js.executeScript(cmd, param);
    }

    /************************* Tabela **********************/

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTab) {

        //procurar coluna do registro
        WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='"+idTab+"']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //clicar no botao
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        return celula;
    }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTab) {
        //clicar no botao
        WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTab);
        celula.findElement(By.xpath(".//input")).click();
    }

    private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i+1;
                break;
            }
        }

        return idLinha;
    }

    private int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(coluna)) {
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }


}
