package com.develop.dental_api.model.mapper;

import com.develop.dental_api.model.dto.UpdateProfileDTO;
import com.develop.dental_api.model.entity.Profile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T20:08:00-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public void updateProfileFromDto(UpdateProfileDTO dto, Profile profile) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getFirstName() != null ) {
            profile.setFirstName( dto.getFirstName() );
        }
        if ( dto.getLastName() != null ) {
            profile.setLastName( dto.getLastName() );
        }
        if ( dto.getPhone() != null ) {
            profile.setPhone( dto.getPhone() );
        }
    }
}
