create table GHAutomatorTask (
	uuid_ VARCHAR(75) null,
	ghAutomatorTaskId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	ghRepositoryId LONG,
	ghTaskUuid VARCHAR(75) null,
	enabled BOOLEAN
);