package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotaTest {

    @Test
    void DistintasNotas() {
        Nota n = new Nota("Hola");
        Nota n1 = new Nota("Hola");

        assertEquals(n.toString(),n1.toString());
    }
}