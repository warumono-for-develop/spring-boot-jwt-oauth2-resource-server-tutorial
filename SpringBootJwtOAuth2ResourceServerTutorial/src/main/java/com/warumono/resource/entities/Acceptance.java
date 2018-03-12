package com.warumono.resource.entities;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.BooleanUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.primitives.Booleans;
import com.warumono.resource.exceptions.ExceptionReason;
import com.warumono.resource.exceptions.RestException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@RequiredArgsConstructor(staticName = "on")
@AllArgsConstructor(staticName = "of")
@Setter
@Getter
@Builder
@Table
(
//	name = "acceptance", 
	uniqueConstraints = 
	{
		@UniqueConstraint(name = "UNIQ_TYPE__PROFILE_IN_ACCEPTANCE", columnNames = { "profile_seq", "type" })
	}
)
@Entity
public class Acceptance extends AuditingEntity
{
//	@NonNull
//	@Column(nullable = false, updatable = true, columnDefinition = "INT(UNSIGNED) COMMENT '사용자 키'")
//	private Long profile_seq;
	
	@NonNull
	// FIXME
//	@Convert(converter = XXXX.class)
	@Column(nullable = false, updatable = true, length = 5, columnDefinition = "VARCHAR(5) COMMENT '수신동의 종류'")
	private String type;
	
	@Default
	@Column(nullable = false, updatable = true, columnDefinition = "BOOLEAN DEFAULT 0 COMMENT '수신동의 여부'")
	private Boolean accepted = Boolean.FALSE;
	
	@Default
	@Column(nullable = false, updatable = true, columnDefinition = "BOOLEAN DEFAULT 0 COMMENT '필수 여부'")
	private Boolean required = Boolean.FALSE;
	
	// -----
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(updatable = false, nullable = false, referencedColumnName = "seq", name = "profile_seq", foreignKey = @ForeignKey(name = "FKEY_PROFILE_SEQ_IN_ACCEPTANCE"))
	private Profile profile;
	
	@PrePersist
	@PreUpdate
	private void required()
	{
		if(required && BooleanUtils.isFalse(accepted))
		{
			throw new RestException(ExceptionReason.REQUIRED);
		}
	}
}
