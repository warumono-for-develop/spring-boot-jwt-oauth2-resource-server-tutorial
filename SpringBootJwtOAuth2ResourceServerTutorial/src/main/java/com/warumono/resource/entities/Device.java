package com.warumono.resource.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.warumono.resource.enums.DeviceType;
import com.warumono.resource.enums.converters.DeviceTypeConverter;

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
//	name = "device ", 
	uniqueConstraints = 
	{
		@UniqueConstraint(name = "UNIQ_NUMBER__TYPE_IN_DEVICE ", columnNames = { "number", "type" })
	}
)
@Entity
public class Device extends AuditingEntity
{
//	@NonNull
//	@Column(nullable = false, updatable = true, columnDefinition = "INT(UNSIGNED) COMMENT '사용자 키'")
//	private Long profile_seq;
	
	@NonNull
	@Column(nullable = false, updatable = true, length = 20, columnDefinition = "VARCHAR(20) COMMENT '전화번호'")
	private String number;
	
	@NonNull
	@Convert(converter = DeviceTypeConverter.class)
	@Column(nullable = false, updatable = true, length = 5, columnDefinition = "VARCHAR(5) COMMENT 'OS 종류'")
	private DeviceType type;
	
	@Lob
	@Column(nullable = true, updatable = true, columnDefinition = "TEXT COMMENT '디바이스 토큰'")
	private String token;
	
	@Lob
	@Column(nullable = true, updatable = true, columnDefinition = "TEXT COMMENT 'AWS SNS Endpoint ARN'")
	private String endpoint;
	
	@Default
	@Column(nullable = false, updatable = true, columnDefinition = "BOOLEAN DEFAULT 1 COMMENT '유효 여부'")
	private Boolean enable = Boolean.TRUE;
	
	// -----
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(updatable = false, nullable = false, referencedColumnName = "seq", name = "profile_seq", foreignKey = @ForeignKey(name = "FKEY_PROFILE_SEQ_IN_DEVICE"))
	private Profile profile;
}
