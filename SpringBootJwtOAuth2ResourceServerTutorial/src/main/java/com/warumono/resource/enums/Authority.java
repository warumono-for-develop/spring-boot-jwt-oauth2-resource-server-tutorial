package com.warumono.resource.enums;

import java.util.Arrays;

import com.warumono.resource.enums.converters.AbstractEnumeratable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 * 사용자 USER("USR"), 
 * 관리자 STAFF("STF"), 
 * 최고관리자 ADMIN("ADM"), 
 * </pre>
 * 
 * @author warumono
 *
 */
@AllArgsConstructor
@Getter
public enum Authority implements AbstractEnumeratable<Authority>
{
	/**
	 * 사용자: USR
	 */
	USER("USR"), 
	
	/**
	 * 관리자: STF
	 */
	STAFF("STF"), 
	
	/**
	 * 최고관리자: ADM
	 */
	ADMIN("ADM");
	
	private String dbData;

	@Override
	public String getToDatabaseColumn(Authority attribute)
	{
		return dbData;
	}

	@Override
	public Authority getToEntityAttribute(String dbData)
	{
		return Arrays.stream(Authority.values()).filter(e -> e.getDbData().equals(dbData)).findFirst().orElseThrow(null);
	}
}
