package cl.praxis.ProyectoHospitalPostPandemia.service;
import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;
import cl.praxis.ProyectoHospitalPostPandemia.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteServiceImpl implements IPaciente {

   PacienteRepository patientRepository;

    public PacienteServiceImpl(PacienteRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Paciente> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Paciente findOne(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente create(Paciente patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Paciente update(Paciente p) {
        Paciente patient = findOne(p.getId());
        patient.setName(p.getName());
        patient.setLastName(p.getLastName());
        patient.setConcurrence(p.getConcurrence());

        return patientRepository.save(p);
    }

    @Override
    public  void delete(Long id) {
        patientRepository.delete(findOne(id));
    }




}
