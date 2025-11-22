package com.directoriotelefonico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class AppTest {

    private Claro claro;
    private Cliente cliente;

    // metodo proveedor de datos de objeto Cliente
    private static Stream<Arguments> provideClients() {

        Cliente c1 = new Cliente(50, new double[] { 10.5, 20.0 });
        Cliente c2 = new Cliente(75, new double[] { 5.0, 7.5 });
        Cliente c3 = new Cliente(83, new double[] { 12.0 });
        Cliente c4 = new Cliente(95, null);

        return Stream.of(
                Arguments.of( // Para la primera iteracion
                        new ArrayList<>(Arrays.asList(c1, c2)), // clientes iniciales
                        new ArrayList<>(Arrays.asList(c3)) // clientes para SetCliente
                ),
                Arguments.of( // Para la segunda iteracion
                        new ArrayList<>(), // lista inicial vacía
                        new ArrayList<>(Arrays.asList(c1, c2, c3)) // uno solo en set
                ),

                Arguments.of(
                        new ArrayList<>(Arrays.asList(c2, c3)),
                        new ArrayList<>(Arrays.asList(c4))));
    }

    // testeando la clase Claro

    @ParameterizedTest
    @MethodSource("provideClients")
    void SetGetClienteTest(ArrayList<Cliente> clientprimero, ArrayList<Cliente> clientsegundo) {
        claro = new Claro(clientprimero, null);
        claro.SetCliente(clientsegundo);
        assertEquals(clientsegundo, claro.GetCliente());
    }

    // metodo proveedor de datos de ganancia mensual
    private static Stream<Arguments> provideGananciaMensual() {

        return Stream.of(
                Arguments.of(
                        new double[] { 1000.5, 2000.0 }, // valor inicial
                        new double[] { 3000.0, 4000.5 } // valor nuevo
                ),
                Arguments.of(
                        new double[] {}, // array vacío inicial
                        new double[] { 500.0 } // un solo valor
                ),
                Arguments.of(
                        new double[] { 10.0, 20.0, 30.0 },
                        new double[] {} // lo deja vacío
                ));
    }

    // testeando el metodo get y set de ganacia mensual

    @ParameterizedTest
    @MethodSource("provideGananciaMensual")
    void SetGetGananciaMensualTest(double[] valorInicial, double[] nuevoValor) {

        claro = new Claro(null, valorInicial);

        claro.SetGanaciaMensual(nuevoValor);

        assertArrayEquals(nuevoValor, claro.GetGanaciaMensual());
    }

}
