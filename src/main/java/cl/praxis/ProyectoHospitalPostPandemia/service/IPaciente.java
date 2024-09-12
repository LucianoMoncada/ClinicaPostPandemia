package cl.praxis.ProyectoHospitalPostPandemia.service;

import cl.praxis.ProyectoHospitalPostPandemia.model.dto.Paciente;

import java.util.List;

public interface IPaciente {
    List<Paciente> findAll();
    Paciente findOne(Long id);
    Paciente create(Paciente patient);
    Paciente update(Paciente patient);
    void delete(Long id);

}
