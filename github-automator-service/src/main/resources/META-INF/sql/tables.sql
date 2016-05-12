create table GHAutomatorTask (
	uuid_ VARCHAR(75) null,
	ghAutomatorTaskId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	ghRepositoryId VARCHAR(75) null,
	ghTaskUuid VARCHAR(75) null,
	enabled BOOLEAN
);