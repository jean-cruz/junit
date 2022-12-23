package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService serviceTest;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        System.out.println("inicializar");
        this.serviceTest = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("1000.00"));
    }
    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("ANTES DE TODOS");
    }
    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("DEPOIS DE TODOS");
    }
    @AfterEach
    public void finalizar(){
        System.out.println("fim");
    }
    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuantoDesenpenhoForADesejar(){
        serviceTest.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuantoDesenpenhoForBom(){
        serviceTest.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuantoDesenpenhoForOtimo(){
        serviceTest.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuantoDesenpenhoForEspetacular(){
        serviceTest.concederReajuste(funcionario, Desempenho.ESPETACULAR);
        assertEquals(new BigDecimal("1400.00"),funcionario.getSalario());
    }
}
