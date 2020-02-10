package package;

import javax.persistence.*;

/**
 * Auto-generated by:
 * org.apache.openjpa.jdbc.meta.ReverseMappingTool$AnnotatedCodeGenerator
 */
@Entity
@Table(schema="public", name="part_drawings")
public class PartDrawings {
	@Basic
	@Column(name="drawing_data", nullable=false)
	private byte[] drawingData;

	@Basic
	@Column(name="file_extension", nullable=false, length=5)
	private String fileExtension;

	@Id
	@Column(name="part_id", columnDefinition="int4")
	private int partId;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="part_id", columnDefinition="int4")
	private Parts parts;


	public PartDrawings() {
	}

	public PartDrawings(int partId) {
		this.partId = partId;
	}

	public byte[] getDrawingData() {
		return drawingData;
	}

	public void setDrawingData(byte[] drawingData) {
		this.drawingData = drawingData;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public Parts getParts() {
		return parts;
	}

	public void setParts(Parts parts) {
		this.parts = parts;
	}
}