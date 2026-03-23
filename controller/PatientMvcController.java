package springboot.poject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.poject.dto.PatientDto;
import springboot.poject.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientMvcController {

	@Autowired
    private PatientService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("patients", service.getAllPatients());
        return "patient-list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("patient", new PatientDto());
        model.addAttribute("pageTitle", "Create Patient");
        return "patient-form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("patient", service.getPatientById(id));
        model.addAttribute("pageTitle", "Edit Patient");
        return "patient-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PatientDto dto) {
        try {
            service.updatePatient(dto.getId(), dto);
        } catch (Exception e) {
            service.savePatient(dto);
        }
        return "redirect:/patients/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deletePatient(id);
        return "redirect:/patients/list";
    }
}
