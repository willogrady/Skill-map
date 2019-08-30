USE svccompanyrolesdb
DROP TABLE IF EXISTS  [role_skill_map];
CREATE TABLE role_skill_map (
  [role_skill_map_id] INT NOT NULL IDENTITY,
  [role_id] INT NOT NULL,
  [skillcode] VARCHAR(45) NULL,
  [competency_id] INT NULL,
  [company_skill_id] INT NULL,
  [level] INT NOT NULL,
  [required] SMALLINT NOT NULL DEFAULT 1,
  [version_id] INT NOT NULL,
  PRIMARY KEY ([role_skill_map_id]),
  CONSTRAINT [role_skill_map_id_UNIQUE] UNIQUE  ([role_skill_map_id] ASC));
DROP TABLE IF EXISTS  [role];
CREATE TABLE role (
  [role_id] INT NOT NULL IDENTITY,
  [role_title] VARCHAR(45) NOT NULL,
  [role_grade] VARCHAR(45) NULL,
  [version_id] INT NOT NULL DEFAULT 1,
  [role_summary] VARCHAR(45) NULL,
  [role_group_id] INT NOT NULL,
  PRIMARY KEY ([role_id]),
  CONSTRAINT [role_id_UNIQUE] UNIQUE  ([role_id] ASC),
  CONSTRAINT [role_title_UNIQUE] UNIQUE  ([role_title] ASC));
DROP TABLE IF EXISTS  [role_group];
CREATE TABLE role_group (
  [role_group_id] INT NOT NULL IDENTITY,
  [role_group] VARCHAR(45) NOT NULL,
  [version_id] VARCHAR(45) NOT NULL,
  PRIMARY KEY ([role_group_id]),
  CONSTRAINT [role_group_idUNIQUE] UNIQUE  ([role_group_id] ASC));
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Technical Architect',1);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Solution Architect',1);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Data Architect',1);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Cheif Architect',1);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Chief Architect',1);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Senior Technical Architect',1);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Senior Solution Architect',1);
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Senior Business Analyst',2,'G6');
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Junior Business Analyst',2,'G4');
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Principal Business Analyst',2,'G5');
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Business Analyst',2,'G5');
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Project Manager',4);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Software Engineer',5);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Human Resources Business Partner',7);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Test Architect - Non-Functional',9);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Associate Test Architect- Non-Functional',9);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Senior Test Architect - Functional',9);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Associate Test Architect - Functional',9);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Senior Test Engineer',9);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Test Engineer',9);
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Senior Test Architect - Non-functional',9);
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Senior Test Manager',9,'G12');
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Test Lead',9,'G8');
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Test Architect - Functional',9);
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Test Analyst',9,'G5');
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Graduate/Trainee Test Engineer',9,'T2');
INSERT INTO role ([role_title],[role_group_id]) VALUES ('Test Manager',9);
INSERT INTO role ([role_title],[role_group_id],[role_grade]) VALUES ('Group Manager/Geographical Head of Testing',9,'G14');
INSERT INTO role_group ([role_group]) VALUES ('Architecture');
INSERT INTO role_group ([role_group]) VALUES ('Business Analysis');
INSERT INTO role_group ([role_group]) VALUES ('Consulting');
INSERT INTO role_group ([role_group]) VALUES ('Delivery Management');
INSERT INTO role_group ([role_group]) VALUES ('Engineering');
INSERT INTO role_group ([role_group]) VALUES ('Finance');
INSERT INTO role_group ([role_group]) VALUES ('Human Resources');
INSERT INTO role_group ([role_group]) VALUES ('Support & Operations');
INSERT INTO role_group ([role_group]) VALUES ('Testing');
ALTER TABLE [role_skill_map] ADD CONSTRAINT [fkroleid]
FOREIGN KEY ([role_id])
REFERENCES role ([role_id]);
ALTER TABLE [role_skill_map] ADD CONSTRAINT [fkcompetencyid]
FOREIGN KEY ([competency_id])
REFERENCES competency ([competency_id]);
ALTER TABLE [role] ADD CONSTRAINT [rolesibfk_1] 
FOREIGN KEY ([role_group_id]) 
REFERENCES role_group ([role_group_id]);
ALTER TABLE [role_skill_map] ADD CONSTRAINT [company_skill_id]
FOREIGN KEY ([company_skill_id]) 
REFERENCES company_skill ([company_skill_id]);
ALTER TABLE [role_skill_map] ADD CONSTRAINT [skillcode]
FOREIGN KEY ([skillcode])
REFERENCES sfia_skill ([skillcode]);