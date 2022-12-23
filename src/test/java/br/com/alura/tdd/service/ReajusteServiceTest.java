package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuantoDesenpenhoForADesejar(){
        ReajusteService serviceTest = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("1000.00"));
        serviceTest.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuantoDesenpenhoForBom(){
        ReajusteService serviceTest = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("1000.00"));
        serviceTest.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuantoDesenpenhoForOtimo(){
        ReajusteService serviceTest = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("1000.00"));
        serviceTest.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuantoDesenpenhoForEspetacular(){
        ReajusteService serviceTest = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("1000.00"));
        serviceTest.concederReajuste(funcionario, Desempenho.ESPETACULAR);
        assertEquals(new BigDecimal("1400.00"),funcionario.getSalario());
    }
}
