package mx.com.ensitech.clientmodule.entity;

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
@Table(name="tbl_user")
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserAuth {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	@Column(name="user_name")
	private String username;
	@Column(name="user_password")
	private String password;
	@Column(name="user_state")
	private String state;
	@Column(name="user_login")
	private int login;
}
