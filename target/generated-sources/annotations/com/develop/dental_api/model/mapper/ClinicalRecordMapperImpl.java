package com.develop.dental_api.model.mapper;

import com.develop.dental_api.model.dto.ClinicalRecordDTO;
import com.develop.dental_api.model.dto.ClinicalRecordRequestDTO;
import com.develop.dental_api.model.entity.ClinicalRecord;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T20:08:00-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ClinicalRecordMapperImpl implements ClinicalRecordMapper {

    @Override
    public ClinicalRecord toEntity(ClinicalRecordRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClinicalRecord clinicalRecord = new ClinicalRecord();

        clinicalRecord.setUser( map( dto.getUserId() ) );
        clinicalRecord.setAllergies( dto.getAllergies() );
        clinicalRecord.setEvolutionNotes( dto.getEvolutionNotes() );
        clinicalRecord.setFamilyHistory( dto.getFamilyHistory() );
        clinicalRecord.setMedicalHistory( dto.getMedicalHistory() );
        clinicalRecord.setTreatmentPlan( dto.getTreatmentPlan() );

        return clinicalRecord;
    }

    @Override
    public ClinicalRecordDTO toDTO(ClinicalRecord entity) {
        if ( entity == null ) {
            return null;
        }

        ClinicalRecordDTO clinicalRecordDTO = new ClinicalRecordDTO();

        clinicalRecordDTO.setAllergies( entity.getAllergies() );
        clinicalRecordDTO.setEvolutionNotes( entity.getEvolutionNotes() );
        clinicalRecordDTO.setFamilyHistory( entity.getFamilyHistory() );
        clinicalRecordDTO.setMedicalHistory( entity.getMedicalHistory() );
        clinicalRecordDTO.setTreatmentPlan( entity.getTreatmentPlan() );

        return clinicalRecordDTO;
    }
}
