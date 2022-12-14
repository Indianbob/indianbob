package ac.mtvs.indianbob.patient.model.dao;

import ac.mtvs.indianbob.patient.model.dto.PatientApiDTO;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {

    List<PatientDTO> selectAllPatient();

    PatientDTO selectPatientByPatientCode(int patientCode);

    List<PatientApiDTO> selectAllPatientApi();

    int insertPatient(PatientDTO patient);
}
