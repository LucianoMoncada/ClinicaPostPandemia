package cl.praxis.ProyectoHospitalPostPandemia.controller;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;
import cl.praxis.ProyectoHospitalPostPandemia.service.IPaciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacientesController {


    //@Autowired
    private IPaciente service;

        public PacientesController(IPaciente service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("patients", service.findAll());
        return "patientList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") Long id, Model model){
        model.addAttribute("patient", service.findOne(id));

        return "patientDetail";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
            model.addAttribute("patient", service.findOne(id));
            return "patientEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Paciente patient){
        Paciente result = service.update(patient);

        return "redirect:/pacientes";
    }

    @GetMapping("/new")
    public String newPatient(){
        return "newPatient";
    }

    @PostMapping("/new")
    public String createPatient(@ModelAttribute Paciente patient){
         service.create(patient);

        return "redirect:/pacientes";
    }
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id){
        service.delete(id);

        return "redirect:/pacientes";
    }


}
