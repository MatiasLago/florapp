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

    private final LocalDateTime FECHA_INICIO = LocalDateTime.of(2025, 7, 25, 0, 0);
    private final long FLORES_OBJETIVO = 14;

    @GetMapping("/")
    public String mostrarJardin(Model model) {
        LocalDateTime ahora = LocalDateTime.now();

        long horasTranscurridas = ChronoUnit.HOURS.between(FECHA_INICIO, ahora);
        long floresActuales = Math.max(horasTranscurridas / 5, 1); // 1 flor cada 5 horas

        // Limitar a máximo 14
        floresActuales = Math.min(floresActuales, 14);

        List<String> flores = new ArrayList<>();
        for (int i = 0; i < floresActuales; i++) {
            flores.add("🌸");
        }

        // Agregar todos los datos al modelo
        model.addAttribute("flores", flores);
        model.addAttribute("floresActuales", floresActuales);
        model.addAttribute("totalFlores", FLORES_OBJETIVO);

        return "jardin";
    }
}
