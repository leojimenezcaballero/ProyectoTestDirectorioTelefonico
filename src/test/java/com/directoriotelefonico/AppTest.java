package com.directoriotelefonico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class AppTest {

    private Claro claro;
    private Cliente cliente;


//metodo proveedor de datos de objeto Cliente
    private static Stream<Arguments> provideClients() {

    Cliente c1 = new Cliente(50, new double[]{10.5, 20.0});
    Cliente c2 = new Cliente(75, new double[]{5.0, 7.5});
    Cliente c3 = new Cliente(83, new double[]{12.0});

    return Stream.of(
        Arguments.of(  //Para la primera iteracion
            new ArrayList<>(Arrays.asList(c1, c2)),   // clientes iniciales
            new ArrayList<>(Arrays.asList(c3))        // clientes para SetCliente
        ),
        Arguments.of(  //Para la segunda iteracion
            new ArrayList<>(),                        // lista inicial vacía
            new ArrayList<>(Arrays.asList(c1))        // uno solo en set
        )
    );
}



    // testeando la clase Claro

    @ParameterizedTest
    @MethodSource("provideClients")
    void SetGetClienteTest(ArrayList<Cliente> client,ArrayList<Cliente> clientset) {
        claro = new Claro(client, null);
        claro.SetCliente(clientset);
        assertEquals(clientset, claro.GetCliente());
    }



}
