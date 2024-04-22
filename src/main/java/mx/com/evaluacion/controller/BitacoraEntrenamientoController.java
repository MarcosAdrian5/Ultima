package mx.com.evaluacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.com.evaluacion.model.entity.BitacoraEntrenamiento;
import mx.com.evaluacion.model.service.IBitacoraEntrenamientoService;


@Controller
@SessionAttributes("bitacoraEntrenamiento")
public class BitacoraEntrenamientoController {
    //@Autowired crea una instancia de servicio para poder utilizarla, inicializarla desde un contructor
    @Autowired
    private IBitacoraEntrenamientoService service;


    @GetMapping({"/bitacoraEntrenamiento", "/bitacoraEntrenamiento/", "/bitacoraEntrenamiento/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Bitacora");
        model.addAttribute("bitacoraEntrenamientos", service.list());
        return "bitacoraEntrenamiento-list";
    }

    @GetMapping("/bitacoraEntrenamiento/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Bitacora");
        model.addAttribute("bitacoraEntrenamiento", new BitacoraEntrenamiento());
        return "bitacoraEntrenamiento-form";
    }

    @PostMapping("/bitacoraEntrenamiento/form")
    public String save(@Valid BitacoraEntrenamiento bitacoraEntrenamiento, BindingResult br, Model model){
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Bitacora");
            return "bitacoraEntrenamiento-form";
        }
        service.save(bitacoraEntrenamiento);
        return "redirect:/bitacoraEntrenamiento/list";
    }

    @GetMapping("/bitacoraEntrenamiento/form/{id}")
    public String update(@PathVariable Long id, Model model){
        BitacoraEntrenamiento bitacoraEntrenamiento = null;
        if (id>0) {
            bitacoraEntrenamiento = service.getById(id);
        }else{
            return "redirect:/bitacoraEntrenamiento/list";
        }
        model.addAttribute("title", "Editar Bitacora");
        model.addAttribute("bitacoraEntrenamiento", bitacoraEntrenamiento);
        return "bitacoraEntrenamiento-form";
    }

    @GetMapping("/bitacoraEntrenamiento/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/bitacoraEntrenamiento/list";
    }
}
