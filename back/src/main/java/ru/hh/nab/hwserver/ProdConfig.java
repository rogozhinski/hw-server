package ru.hh.nab.hwserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.starter.NabProdConfig;

@Configuration
@Import(NabProdConfig.class)
    public class ProdConfig {
}
