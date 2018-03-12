package com.warumono.resource.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Sets;
import com.warumono.resource.enums.Gender;
import com.warumono.resource.enums.ProfileState;
import com.warumono.resource.enums.Provider;
import com.warumono.resource.enums.converters.GenderConverter;
import com.warumono.resource.enums.converters.ProfileStateConverter;
import com.warumono.resource.enums.converters.ProviderConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor(staticName = "on")
@AllArgsConstructor(staticName = "of")
@Setter
@Getter
@Builder
@Table
(
//	name = "profile", 
	uniqueConstraints = 
	{
		@UniqueConstraint(name = "UNIQ_USERNAME__PROVIDER_ID_IN_PROFILE", columnNames = { "username", "providerId" }), 
		@UniqueConstraint(name = "UNIQ_PROVIDER_ID__PROVIDER_USER_ID_IN_PROFILE", columnNames = { "providerId", "providerUserId" })
	}
)
@Entity
public class Profile extends AuditingEntity
{
	@NonNull
	@Column(nullable = false, updatable = false, length = 255, columnDefinition = "VARCHAR(255) COMMENT '아이디'")
	private String username;
	
	@NonNull
	@Convert(converter = ProviderConverter.class)
	@Column(nullable = false, updatable = true, length = 5, columnDefinition = "VARCHAR(5) COMMENT '제공처 아이디'")
	private Provider providerId;
	
	@NonNull
	@Column(nullable = false, updatable = true, length = 255, columnDefinition = "VARCHAR(255) COMMENT '제공처 사용자 아이디'")
	private String providerUserId;
	
	@NonNull
	@Column(nullable = false, updatable = true, length = 20, columnDefinition = "VARCHAR(20) COMMENT '이름'")
	private String name;
	
	@NonNull
	@Column(nullable = false, updatable = true, columnDefinition = "VARCHAR(20) COMMENT '닉네임'")
	private String nickname;

	@Default
	@Convert(converter = ProfileStateConverter.class)
	@Column(nullable = false, updatable = true, length = 5, columnDefinition = "VARCHAR(5) DEFAULT 'NML' COMMENT '상태'")
	private ProfileState state = ProfileState.NORMAL;
	
	@Default
	@Column(nullable = false, updatable = true, columnDefinition = "VARCHAR(5) DEFAULT 'GNR' COMMENT '등급'")
	private String grade = "GNR";
	
	@Column(nullable = true, updatable = true, length = 50, columnDefinition = "VARCHAR(50) COMMENT '이메일'")
	private String email;

	@Convert(converter = GenderConverter.class)
	@Column(nullable = true, updatable = true, length = 5, columnDefinition = "VARCHAR(5) COMMENT '성별'")
	private Gender gender;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(nullable = true, updatable = true, columnDefinition = "DATE COMMENT '생년월일'")
	private Date birthday;
	
	@Column(nullable = true, updatable = true, length = 255, columnDefinition = "VARCHAR(255) COMMENT '원본 이미지 URL'")
	private String profileUrl;
	
	@Column(nullable = true, updatable = true, length = 255, columnDefinition = "VARCHAR(255) COMMENT '썸네일 이미지 URL'")
	private String thumbnailUrl;
	
	// -----
	
	@JsonManagedReference
	@Default
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "profile")
	private Collection<Device> devices = Sets.newHashSet();
	
	@JsonManagedReference
	@Default
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "profile")
	private Collection<Acceptance> acceptances = Sets.newHashSet();

	public void bind(Device device)
	{
		devices.add(device);
		device.setProfile(this);
	}
	
	public void bind(Acceptance acceptance)
	{
		acceptances.add(acceptance);
		acceptance.setProfile(this);
	}
}
