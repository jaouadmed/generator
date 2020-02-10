package ma.dxc.dto;

import java.util.*;

/**
 * Auto-generated by:
 * org.apache.openjpa.jdbc.meta.ReverseMappingTool$ReverseCodeGenerator
 */
public class Vendors {
	private int vendorId;

	private String vendorName;

	private Set vendorParts = new HashSet();


	public Vendors() {
	}

	public Vendors(int vendorId) {
		this.vendorId = vendorId;
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

	public Set getVendorParts() {
		return vendorParts;
	}

	public void setVendorParts(Set vendorParts) {
		this.vendorParts = vendorParts;
	}
}