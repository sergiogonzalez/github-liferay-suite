create index IX_55C2AE4E on GHAutomatorRepository (enabled);
create index IX_EEC69414 on GHAutomatorRepository (ghRepositoryId[$COLUMN_LENGTH:75$], enabled);
create index IX_BC194D11 on GHAutomatorRepository (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D982F2B9 on GHAutomatorTask (ghRepositoryId[$COLUMN_LENGTH:75$], enabled);
create index IX_A2D61F8D on GHAutomatorTask (ghRepositoryId[$COLUMN_LENGTH:75$], ghTaskUuid[$COLUMN_LENGTH:75$]);
create index IX_B5327A7E on GHAutomatorTask (ghTaskUuid[$COLUMN_LENGTH:75$], enabled);
create index IX_BB3D7AF6 on GHAutomatorTask (uuid_[$COLUMN_LENGTH:75$]);