package com.wizeprojects.ellen.orderservice.config

import com.thoughtworks.xstream.XStream
import org.springframework.context.annotation.Bean

class AxonConfig {
    @Bean
    fun xStream(): XStream? { //AGREGAR EL METODO XSTREM CON LA RUTA DE CARPETA SU PROYECTO. Ejemplo "com.app.inventario"
        val xStream = XStream()
        xStream.allowTypesByWildcard(
            arrayOf(
                "com.wizeprojects.ellen.core.**",
                "com.wizeprojects.ellen.orderservice.**",
                "com.wizeprojects.ellen.productservice.**"
            )
        )
        return xStream
    }
}