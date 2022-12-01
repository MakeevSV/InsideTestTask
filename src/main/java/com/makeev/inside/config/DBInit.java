package com.makeev.inside.config;

import com.makeev.inside.dao.UserRepo;
import com.makeev.inside.model.Author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DBInit {

    @Bean
    CommandLineRunner commandLineRunner(UserRepo repo){
        return args -> {
           Author a1 =  new Author("Alan","$2a$04$bXOMOgeZ46j3CWpeIrfRc.ze2NeCAE0wiK2eqr8p/gDwX27C7ILX2");
           Author a2 =  new Author("Bob","$2a$04$RSmg4Lhwolxt/cC.usnLQ.0eth5tceqqmPgfGCTFkNTs1m5becEXC");
           Author a3 =  new Author("Jack","$2a$04$dEoJOsuHwqfxXV0gS.7OteworXZiCdkrPokWPYPdxqcQW8czrIvaa");

            repo.saveAll(List.of(a1,a2,a3));
        };
    }
}
