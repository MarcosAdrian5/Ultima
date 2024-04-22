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
import mx.com.evaluacion.model.entity.ClienteVip;
import mx.com.evaluacion.model.service.IClienteVipService;

@Controller
@SessionAttributes("clienteVip")
public class ClienteVipController {
    //@Autowired crea una instancia de servicio para poder utilizarla, inicializarla desde un contructor
    @Autowired
    private IClienteVipService service;


    @GetMapping({"/clienteVip", "/clienteVip/", "/clienteVip/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Clientes");
        model.addAttribute("clienteVips", service.list());
        return "clienteVip-list";
    }

    @GetMapping("/clienteVip/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Clientes");
        model.addAttribute("clienteVip", new ClienteVip());
        return "clienteVip-form";
    }

    @PostMapping("/clienteVip/form")
    public String save(@Valid ClienteVip clienteVip, BindingResult br, Model model){
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Proveedores");
            return "clienteVip-form";
        }
        service.save(clienteVip);
        return "redirect:/clienteVip/list";
    }

    @GetMapping("/clienteVip/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ClienteVip clienteVip = null;
        if (id>0) {
            clienteVip = service.getById(id);
        }else{
            return "redirect:/clienteVip/list";
        }
        model.addAttribute("title", "Editar Cliente");
        model.addAttribute("clienteVip", clienteVip);
        return "clienteVip-form";
    }

    @GetMapping("/clienteVip/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/clienteVip/list";
    }
}
