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
import mx.com.evaluacion.model.entity.PlanEstudio;
import mx.com.evaluacion.model.service.IPlanEstudioService;

@Controller
@SessionAttributes("planEstudio")
public class PlanEstudioController {
    //@Autowired crea una instancia de servicio para poder utilizarla, inicializarla desde un contructor
    @Autowired
    private IPlanEstudioService service;


    @GetMapping({"/planEstudio", "/planEstudio/", "/planEstudio/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Plan");
        model.addAttribute("planEstudios", service.list());
        return "planEstudio-list";
    }

    @GetMapping("/planEstudio/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Plan");
        model.addAttribute("planEstudio", new PlanEstudio());
        return "planEstudio-form";
    }

    @PostMapping("/planEstudio/form")
    public String save(@Valid PlanEstudio planEstudio, BindingResult br, Model model){
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Plan");
            return "planEstudio-form";
        }
        service.save(planEstudio);
        return "redirect:/planEstudio/list";
    }

    @GetMapping("/planEstudio/form/{id}")
    public String update(@PathVariable Long id, Model model){
        PlanEstudio planEstudio = null;
        if (id>0) {
            planEstudio = service.getById(id);
        }else{
            return "redirect:/planEstudio/list";
        }
        model.addAttribute("title", "Editar Plan");
        model.addAttribute("planEstudio", planEstudio);
        return "planEstudio-form";
    }

    @GetMapping("/planEstudio/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/planEstudio/list";
    }
}
