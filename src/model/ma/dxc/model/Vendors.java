package ma.dxc.model;

import java.util.*;
import javax.persistence.*;

/**
 * Auto-generated by:
 * org.apache.openjpa.jdbc.meta.ReverseMappingTool$AnnotatedCodeGenerator
 */
@Entity
@Table(schema="public", name="vendors")
public class Vendors {
	@ManyToMany(targetEntity=ma.dxc.model.Parts.class, mappedBy="vendors", cascade=CascadeType.MERGE)
	private Set<Parts> parts = new HashSet<Parts>();

	@Id
	@Column(name="vendor_id", columnDefinition="serial")
	private int vendorId;

	@Basic
	@Column(name="vendor_name", nullable=false)
	private String vendorName;


	public Vendors() {
	}

	public Vendors(int vendorId) {
		this.vendorId = vendorId;
	}

	public Set<Parts> getParts() {
		return parts;
	}

	public void setParts(Set<Parts> parts) {
		this.parts = parts;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
}