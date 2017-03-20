CREATE TABLE domain (
  id VARCHAR PRIMARY KEY,
  name VARCHAR NOT NULL
);

CREATE TABLE concept (
  id VARCHAR PRIMARY KEY,
  name VARCHAR NOT NULL
);

CREATE TABLE archetype (
  id VARCHAR PRIMARY KEY,
  name VARCHAR NOT NULL,
  description VARCHAR NOT NULL
);

CREATE TABLE concept_archetype (
  concept_id VARCHAR NOT NULL,
  archetype_id VARCHAR NOT NULL,
  PRIMARY KEY (concept_id, archetype_id),
  FOREIGN KEY (concept_id) REFERENCES concept(id),
  FOREIGN KEY (archetype_id) REFERENCES archetype(id)
);

CREATE TABLE actor ();

CREATE TABLE actor_role ();

CREATE TABLE player ();
