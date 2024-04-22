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
import mx.com.evaluacion.model.entity.RegistroComprasOnline;
import mx.com.evaluacion.model.service.IRegistroComprasOnlineService;

@Controller
@SessionAttributes("registroComprasOnline")
public class RegistroComprasOnlineController {
    //@Autowired crea una instancia de servicio para poder utilizarla, inicializarla desde un contructor
    @Autowired
    private IRegistroComprasOnlineService service;


    @GetMapping({"/registroComprasOnline", "/registroComprasOnline/", "/registroComprasOnline/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Compras");
        model.addAttribute("registroComprasOnlines", service.list());
        return "registroComprasOnline-list";
    }

    @GetMapping("/registroComprasOnline/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Compras");
        model.addAttribute("registroComprasOnline", new RegistroComprasOnline());
        return "registroComprasOnline-form";
    }

    @PostMapping("/registroComprasOnline/form")
    public String save(@Valid RegistroComprasOnline registroComprasOnline, BindingResult br, Model model){
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Compras");
            return "registroComprasOnline-form";
        }
        service.save(registroComprasOnline);
        return "redirect:/registroComprasOnline/list";
    }

    @GetMapping("/registroComprasOnline/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RegistroComprasOnline registroComprasOnline = null;
        if (id>0) {
            registroComprasOnline = service.getById(id);
        }else{
            return "redirect:/registroComprasOnline/list";
        }
        model.addAttribute("title", "Editar Compras");
        model.addAttribute("registroComprasOnline", registroComprasOnline);
        return "registroComprasOnline-form";
    }

    @GetMapping("/registroComprasOnline/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/registroComprasOnline/list";
    }
}
