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
import mx.com.evaluacion.model.entity.PedidoProveedor;
import mx.com.evaluacion.model.service.IPedidoProveedorService;

@Controller
@SessionAttributes("pedidoProveedor")
public class PedidoProveedorController {
    //@Autowired crea una instancia de servicio para poder utilizarla, inicializarla desde un contructor
    @Autowired
    private IPedidoProveedorService service;


    @GetMapping({"/pedidoProveedor", "/pedidoProveedor/", "/pedidoProveedor/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Proveedores");
        model.addAttribute("pedidoProveedors", service.list());
        return "pedidoProveedor-list";
    }

    @GetMapping("/pedidoProveedor/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Proveedores");
        model.addAttribute("pedidoProveedor", new PedidoProveedor());
        return "pedidoProveedor-form";
    }

    @PostMapping("/pedidoProveedor/form")
    public String save(@Valid PedidoProveedor pedidoProveedor, BindingResult br, Model model){
        if (br.hasErrors()) {
            model.addAttribute("title", "Formulario de Proveedores");
            return "pedidoProveedor-form";
        }
        service.save(pedidoProveedor);
        return "redirect:/pedidoProveedor/list";
    }

    @GetMapping("/pedidoProveedor/form/{id}")
    public String update(@PathVariable Long id, Model model){
        PedidoProveedor pedidoProveedor = null;
        if (id>0) {
            pedidoProveedor = service.getById(id);
        }else{
            return "redirect:/pedidoProveedor/list";
        }
        model.addAttribute("title", "Editar Proveedor");
        model.addAttribute("pedidoProveedor", pedidoProveedor);
        return "pedidoProveedor-form";
    }

    @GetMapping("/pedidoProveedor/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/pedidoProveedor/list";
    }
}
