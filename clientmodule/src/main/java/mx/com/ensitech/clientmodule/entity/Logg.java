package mx.com.ensitech.clientmodule.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_logg")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Logg {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="logg_id")
	private Long loggId;
	@Column(name="username")
	private String username;
	@Column(name="logg_path")
	private String loggPath;
	@Column(name="logg_date")
	private Date loggDate;
}
