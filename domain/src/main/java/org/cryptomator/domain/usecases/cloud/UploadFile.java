package org.cryptomator.domain.usecases.cloud;

import java.util.Date;

public class UploadFile {

	private final String fileName;

	private final DataSource dataSource;

	private final Boolean replacing;

	private final Date modifiedDate; // +++++ ADDED ++++++

	private UploadFile(Builder builder) {
		this.fileName = builder.fileName;
		this.dataSource = builder.dataSource;
		this.replacing = builder.replacing;
		this.modifiedDate = builder.modifiedDate; // +++++ ADDED ++++++
	}

	public static Builder aCopyOf(UploadFile uploadFile) {
		return new Builder() //
				.withFileName(uploadFile.getFileName()) //
				.withDataSource(uploadFile.getDataSource())
				.withModifiedDate(uploadFile.getModifiedDate()) // +++++ ADDED ++++++
				.thatIsReplacing(uploadFile.getReplacing());
	}

	public static Builder anUploadFile() {
		return new Builder();
	}

	public String getFileName() {
		return fileName;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public Date getModifiedDate(){ return modifiedDate; } // +++++ ADDED ++++++

	public Boolean getReplacing() {
		return replacing;
	}

	public static class Builder {

		private String fileName;
		private DataSource dataSource;
		private Boolean replacing;

		private Date modifiedDate; // +++++ ADDED ++++++

		public Builder() {
		}

		public Builder withDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
			return this;
		}

		public Builder withFileName(String fileName) {
			this.fileName = fileName;
			return this;
		}

		public Builder withModifiedDate(Date modifiedDate) { // +++++ ADDED - FIXME ++++++
			this.modifiedDate = modifiedDate;
			return this;
		}

		public Builder thatIsReplacing(Boolean replacing) {
			this.replacing = replacing;
			return this;
		}


		public UploadFile build() {
			return new UploadFile(this);
		}
	}
}
