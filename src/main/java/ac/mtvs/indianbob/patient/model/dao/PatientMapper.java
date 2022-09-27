package ac.mtvs.indianbob.patient.model.dao;

import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {

    List<PatientDTO> selectAllPatient();

    PatientDTO selectPatientByPatientCode(int patientCode);
}
