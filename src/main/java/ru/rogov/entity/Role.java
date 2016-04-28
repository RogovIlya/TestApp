package ru.rogov.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Role implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6555566199101606218L;

	@Id
	@Column(name = "ID")
	private Long id;
	
    @Column(name="ROLE", nullable=false)
	private String	name;
		
	@Column(name = "RIGHTS")
	private Integer rigths;

	@OneToMany(mappedBy = "role")
	private Set<User> users;

	@OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
	private Set<Rights>	rights;
	
	public Role()
	{
		super();
	}

	public Role(Long id, String name, Set<Rights> rights)
	{
		super();
		this.id = id;
		this.name = name;
		this.rights = rights;
	}
	
	public Integer getrigths()
	{
		return rigths;
	}

	public void setId_rigths(Integer rigths)
	{
		this.rigths = rigths;
	}

	
	public Set<User> getUsers()
	{
		return users;
	}

	public void setUsers(Set<User> users)
	{
		this.users = users;
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Set<Rights> getRights()
	{
		return rights;
	}

	public void setRights(Set<Rights> rights)
	{
		this.rights = rights;
	}
	
	@Override
	public String toString()
	{
		return "Role [id=" + id + ", name=" + name + ", rights=" + rights + "]";
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rights == null) ? 0 : rights.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rights == null)
		{
			if (other.rights != null)
				return false;
		} else if (!rights.equals(other.rights))
			return false;
		return true;
	}

}
