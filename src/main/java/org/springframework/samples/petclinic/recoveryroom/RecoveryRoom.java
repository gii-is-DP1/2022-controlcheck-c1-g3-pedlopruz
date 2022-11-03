package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.samples.petclinic.model.NamedEntity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recorvery_rooms")
public class RecoveryRoom extends NamedEntity{
	@Column(name = "size")
	@NotNull
	@PositiveOrZero
    private double size;
	@Column(name = "secure")
	@NotNull
    private boolean secure;
	@ManyToOne
	@JoinColumn(name = "recovery_room_types_id")
    private RecoveryRoomType roomType;
}
