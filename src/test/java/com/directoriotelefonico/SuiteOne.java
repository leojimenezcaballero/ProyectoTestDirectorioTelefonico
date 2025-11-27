package com.directoriotelefonico;

import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    AppTest.class
})
@Tag("cliente")
@ExcludeTags("gananciaMensual")
public class SuiteOne {
    //NO SE DEFINE Ningun METODO NI ATRIBUTO
}
