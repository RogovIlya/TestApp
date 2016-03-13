package ru.rogov.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="RIGHTS")
public class Rights implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1736029340601476094L;

	@Id 
	@Column(name = "ID")
	private Long id;
	
    @Column(name="NAME", nullable=false)
	private String nameRight;
	
	@Column(name = "ID_RIGHT")
	private Integer id_right;

    @ManyToOne()
    @JoinColumn(name = "ID_RIGHT", referencedColumnName = "ID",insertable = false, updatable = false)
    private Role role;
	
	@Override
	public String toString()
	{
		return "Rights [id=" + id + ", nameRight=" + nameRight + ", id_right=" + id_right + "]";
	}

	public Rights()
	{

	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNameRight()
	{
		return nameRight;
	}

	public void setNameRight(String nameRight)
	{
		this.nameRight = nameRight;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public Rights(String nameRight)
	{
		super();
		this.nameRight = nameRight;
	}

}
