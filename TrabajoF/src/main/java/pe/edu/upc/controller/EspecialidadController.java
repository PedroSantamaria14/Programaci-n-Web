package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Especialidad;
import pe.edu.upc.service.IEspecialidadService;

@Controller
@RequestMapping("/especialidades")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService esService;

	@GetMapping("/new")
	public String newEspecialidad(Model model) {
		model.addAttribute("especialidad", new Especialidad());
		return "especialidad/especialidad";
	}

	@PostMapping("/save")
	public String saveEspecialidad(@Valid Especialidad especialidad, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "especialidad/especialidad";
		} else {
			int rpta = esService.insert(especialidad);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/especialidad/especialidad";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listEspecialidades", esService.list());

		return "/especialidad/listEspecialidades";
	}

	@GetMapping("/list")
	public String listEspecialidades(Model model) {
		try {
			model.addAttribute("especialidad", new Especialidad());
			model.addAttribute("listEspecialidades",esService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/especialidad/listEspecialidades";
	}
	@RequestMapping("/delete")
	public String delete(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				esService.delete(id);
				model.put("mensaje", "Se eliminó correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar una especialidad");
		}
		model.put("listEspecialidades", esService.list());

//		return "redirect:/categories/list";
		return "/especialidad/listEspecialidades";
	}
}
