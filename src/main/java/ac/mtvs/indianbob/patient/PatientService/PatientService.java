package ac.mtvs.indianbob.patient.PatientService;

import ac.mtvs.indianbob.patient.model.dao.PatientMapper;
import ac.mtvs.indianbob.patient.model.dto.PatientApiDTO;
import ac.mtvs.indianbob.patient.model.dto.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientMapper mapper;

    public PatientService(PatientMapper mapper) {
        this.mapper = mapper;
    }

    public List<PatientDTO> selectAllPatient(){

        List<PatientDTO> result = mapper.selectAllPatient();

        return result;
    }

    public List<PatientApiDTO> selectAllPatientApi() {

        List<PatientApiDTO> result = mapper.selectAllPatientApi();

        return result;
    }
}
