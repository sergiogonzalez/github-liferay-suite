create index IX_D982F2B9 on GHAutomatorTask (ghRepositoryId, enabled);
create index IX_A2D61F8D on GHAutomatorTask (ghRepositoryId, ghTaskUuid[$COLUMN_LENGTH:75$]);
create index IX_B5327A7E on GHAutomatorTask (ghTaskUuid[$COLUMN_LENGTH:75$], enabled);
create index IX_BB3D7AF6 on GHAutomatorTask (uuid_[$COLUMN_LENGTH:75$]);