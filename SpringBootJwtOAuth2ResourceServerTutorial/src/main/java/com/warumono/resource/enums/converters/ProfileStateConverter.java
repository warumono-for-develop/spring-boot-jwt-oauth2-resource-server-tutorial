package com.warumono.resource.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.warumono.resource.enums.ProfileState;

@Converter
public class ProfileStateConverter extends AbstractEnumConverter<ProfileState> implements AttributeConverter<ProfileState, String>
{
	@Override
	public String convertToDatabaseColumn(ProfileState attribute)
	{
		return toDatabaseColumn(attribute);
	}

	@Override
	public ProfileState convertToEntityAttribute(String dbData)
	{
		return toEntityAttribute(ProfileState.NORMAL, dbData);
	}
}
