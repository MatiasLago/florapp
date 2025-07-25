package com.flor.florapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JardinController {

    private final LocalDateTime FECHA_INICIO = LocalDateTime.of(2025, 7, 25, 0, 0); // Inicio: 23 julio, 00:00

    @GetMapping("/")
    public String mostrarJardin(Model model) {
        LocalDateTime ahora = LocalDateTime.now();
        
        long horasTranscurridas = ChronoUnit.HOURS.between(FECHA_INICIO, ahora);
        long floresTotales = Math.max(horasTranscurridas / 5, 1); // 1 flor cada 5h, mínimo 1

        // Limitar para evitar desborde visual
        long maxFlores = 100;
        floresTotales = Math.min(floresTotales, maxFlores);

        List<String> flores = new ArrayList<>();
        for (int i = 0; i < floresTotales; i++) {
            flores.add("🌸");
        }

        model.addAttribute("flores", flores);
        return "jardin";
    }
}
